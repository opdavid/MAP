package Model;

public class ForkStm implements IStm {
    private IStm stm;

    public ForkStm(IStm stm) {
        this.stm = stm;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
//        MyDictionary<String,Integer> symTable = (MyDictionary) state.getSymTable().clone();

        PrgState prgState = new PrgState(new MyStack<>(),symTable,new MyList<>(),new MyDictionary<>(),new MyHeap(),stm);
        prgState.setId(state.getId()*10);
        return prgState;
    }
}
