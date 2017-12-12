package Model;

public class PrintStmt implements IStm {
    private IExpression expr;

    public PrintStmt(IExpression expr) {
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIList<Integer> l = state.getOut();
        l.add(expr.eval(state.getSymTable(),state.getHeap()));
        return null;
    }

    @Override
    public String toString() {
        return "print(" + expr + ")";
    }
}
