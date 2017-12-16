package Model;

public class ForkStm implements IStm {
    private IStm stm;

    public ForkStm(IStm stm) {
        this.stm = stm;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
//        MyDictionary<String,Integer> symTable = (MyDictionary) state.getSymTable().clone();
        MyDictionary<String,Integer> newSymTable = state.getSymTable().clone();

        PrgState prgState = new PrgState(new MyStack<>(),newSymTable,state.getOut(),state.getFileTable(),state.getHeap(),stm);
        prgState.setId(state.getId()*10);
        return prgState;
    }

    @Override
    public String toString() {
        return "fork(  " + stm.toString() + "  )";
    }
}
