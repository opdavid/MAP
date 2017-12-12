package Repository;

import Model.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Repository implements IRepository {
    private List<PrgState> prgStates;
    private String filename;

    public Repository(String filename) {
        this.prgStates = new ArrayList<>();
        this.filename = filename;
    }

    @Override
    public void addPrgState(PrgState p) {
        this.prgStates.add(p);
    }

    @Override
    public PrgState getCtrlPrg(int index) {
        return prgStates.get(index);
    }

    @Override
    public List<PrgState> getPrgList() {
        return prgStates;
    }

    @Override
    public void setPrgList(List<PrgState> prgList) {
        this.prgStates = prgList;
    }

    @Override
    public void logPrgStateExec(PrgState prg) throws MyException{
        try(PrintWriter logFile = new PrintWriter(new BufferedWriter(new FileWriter(filename, true))))
        {
            MyIStack<IStm> exe = prg.getExeStack();
            MyIDictionary<String,Integer> st = prg.getSymTable();
            MyIList<Integer> out=prg.getOut();
            MyIDictionary<Integer,MyTuple> ft = prg.getFileTable();
            IHeap<Integer> heap = prg.getHeap();

            logFile.println("**** id: " + prg.getId()+ "******");

            logFile.println("ExeStack:");
            for(IStm stmt: exe.getAll())
                logFile.println(stmt.toString());

            logFile.println("SymTable:");
            for(Map.Entry<String, Integer> entry : st.getAll())
                logFile.println(entry.toString());

            logFile.println("Output:");
            for(Integer v:out.getAll())
                logFile.println(v.toString());

            logFile.println("FileTable:");
            for(Map.Entry<Integer, MyTuple> entry: ft.getAll())
                logFile.println(entry.toString());

            logFile.println("Heap:");
            for(Map.Entry<Integer,Integer> entry: heap.getAll())
                logFile.println(entry.toString());

            logFile.println("*************");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
