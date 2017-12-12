package Controller;

import Model.*;
import Repository.IRepository;
import com.sun.istack.internal.NotNull;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class Controller {
    private IRepository repo;
    private ExecutorService executor;

    public Controller(IRepository repo) {
        this.repo = repo;
    }



    public void allStep(String key) {
        int index = Integer.parseInt(key) - 1;
        PrgState prg = repo.getCtrlPrg(index);

        MyIStack<IStm> stack = prg.getExeStack();
        while (!stack.isEmpty()) {
            try {
//                oneStep(prg);
                prg.getHeap().setContent(conservativeGarbageCollector(prg.getSymTable().get().values(), prg.getHeap().get()));
                repo.logPrgStateExec(prg);
            } catch (MyException e) {
                e.printStackTrace();
            }
        }

        closeFiles(prg.getFileTable().get());
        try{
            repo.logPrgStateExec(prg);
       } catch (MyException ex){System.out.print(ex.getMessage());}
    }

    private Map<Integer, Integer> conservativeGarbageCollector(Collection<Integer> symTableValues, Map<Integer, Integer> heap) {
        return heap.entrySet().stream()
                .filter(e -> symTableValues.contains(e.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @NotNull
    private void closeFiles(Map<Integer, MyTuple> fileTable){
        new HashMap<>(fileTable).entrySet()
                .forEach(e -> {
                    try {
                        e.getValue().getFileDescriptor().close();
                        fileTable.remove(e.getKey());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                });
    }

    private List<PrgState> removeCompletedPrg(List<PrgState> inPrgList) {
        return inPrgList.stream()
                .filter(p->p.isNotCompleted())
                .collect(Collectors.toList());
    }
}
