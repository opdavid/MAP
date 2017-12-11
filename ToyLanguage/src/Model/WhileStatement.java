package Model;

public class WhileStatement implements IStm {
    private IExpression expr;
    private IStm statement;

    public WhileStatement(IExpression expr, IStm statement) {
        this.expr = expr;
        this.statement = statement;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        MyIStack<IStm> stk = state.getExeStack();
        if (expr.eval(state.getSymTable(),state.getHeap()) != 0) {
            stk.push(this);
            stk.push(statement);
        }
        return null;
    }

    @Override
    public String toString() {
        return " while(" + expr.toString()+") { " + statement.toString() + " }" ;
    }
}
