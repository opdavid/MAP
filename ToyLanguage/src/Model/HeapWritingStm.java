package Model;

public class HeapWritingStm implements IStm {
    private String var_name;
    private IExpression expr;

    public HeapWritingStm(String var_name, IExpression expr) {
        this.var_name = var_name;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String,Integer> symTable = state.getSymTable();
        IHeap<Integer> heap = state.getHeap();
        Integer value = expr.eval(symTable,heap);
        Integer address = symTable.getValue(var_name);
        if( !heap.hasKey(address))
            throw new MyException("Undeclared variable name");

        heap.add(address, value);
        return state;
    }

    @Override
    public String toString() {
        return "wH("+ var_name+", " + expr.toString() + ")";
    }
}
