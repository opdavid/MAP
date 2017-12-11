package Model;

public class CompStmt implements IStm {
    private IStm first;
    private IStm snd;

    public CompStmt(IStm first, IStm snd) {
        this.first = first;
        this.snd = snd;
    }


    @Override
    public String toString() {
        return first.toString() + ";" + snd.toString();
    }

    @Override
    public PrgState execute(PrgState state) {
        MyIStack<IStm> stack = state.getExeStack();
        stack.push(snd);
        stack.push(first);
        return null;
    }
}
