package Model;

public class HeapAllocation implements IStm {
    private String var_name;
    private IExpression expr;

    public HeapAllocation(String var_name, IExpression expr) {
        this.var_name = var_name;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIDictionary<String,Integer> symTable= state.getSymTable();
        IHeap<Integer> heap = state.getHeap();
        int value = expr.eval(symTable,heap);
        Integer address = heap.newFreeAllocation(value);

        symTable.add(var_name,address);
        return null;
    }

    @Override
    public String toString() {
        return "new(" + var_name + ", " + expr.toString() + ")";
    }
}
