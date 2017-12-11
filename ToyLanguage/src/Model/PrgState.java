package Model;

public class PrgState {
    private MyIStack<IStm> exeStack;
    private MyIDictionary<String, Integer> symTable;
    private MyIList<Integer> out;
    private MyIDictionary<Integer,MyTuple> fileTable;
    private IHeap<Integer> heap;
    private IStm originalProgam;

    public PrgState(MyIStack<IStm> stk, MyDictionary<String, Integer> table, MyIList<Integer> ou, MyIDictionary<Integer,MyTuple> fileTable,IHeap<Integer> heap, IStm prg) {
        this.exeStack = stk;
        this.symTable = table;
        this.out = ou;
        this.fileTable = fileTable;
        this.heap = heap;
        this.originalProgam = prg;
        stk.push(prg);
    }

    public MyIStack<IStm> getExeStack() {
        return exeStack;
    }

    public MyIDictionary<String, Integer> getSymTable() {
        return symTable;
    }

    public MyIList<Integer> getOut() {
        return out;
    }

    public MyIDictionary<Integer, MyTuple> getFileTable() {
        return fileTable;
    }

    public IHeap<Integer> getHeap() {
        return heap;
    }

    public void setHeap(IHeap<Integer> heap) {
        this.heap = heap;
    }

    public Boolean isNotCompleted() {return !exeStack.isEmpty();}

    @Override
    public String toString() {
        String s = "";
        s = s + " stmt -> " + originalProgam.toString() + '\n'+ " exeS -> " + exeStack.toString() +'\n'+ " symT -> "
                + symTable.toString() +'\n'+" out -> " + out.toString()+'\n'+ "File Table -> "+ fileTable.toString()+'\n'
                +"heap -> " + heap.toString()+"\n****************";
        return s;
    }
}
