package Model;

public class IfStmt implements IStm {
    private IStm ifTrue;
    private IStm ifFalse;
    private IExpression expr;

    public IfStmt(IStm ifTrue, IStm ifFalse, IExpression expr) {
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
        this.expr = expr;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        if (this.expr.eval(state.getSymTable(),state.getHeap()) == 0)
            state.getExeStack().push(ifFalse);
        else
            state.getExeStack().push(ifTrue);

        return state;
    }

    @Override
    public String toString() {
        return "if(" + expr.toString() + ") then " + ifTrue.toString() + " else " + ifFalse.toString() + " end";
    }
}
