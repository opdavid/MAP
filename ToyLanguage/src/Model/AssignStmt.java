package Model;

public class AssignStmt implements IStm {
    private String symbol;
    private IExpression expr;

    public AssignStmt(String symbol, IExpression expr) {
        this.symbol = symbol;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws  MyException{
        MyIDictionary<String, Integer> d = state.getSymTable();
        IHeap<Integer> heap = state.getHeap();
        d.add(this.symbol,this.expr.eval(d,heap));
        return state;
    }

    @Override
    public String toString() {
        return this.symbol + " = "+ this.expr.toString();
    }
}
