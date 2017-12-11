package Model;

public class BooleanExpression implements IExpression {
    private IExpression firstExpr;
    private String operator;
    private IExpression secondExpr;

    public BooleanExpression(IExpression firstExpr, String operator, IExpression secondExpr) {
        this.firstExpr = firstExpr;
        this.operator = operator;
        this.secondExpr = secondExpr;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, IHeap<Integer> heap) throws MyException {
        int firstEvaluation = firstExpr.eval(symTable,heap);
        int secondEvaluation = secondExpr.eval(symTable, heap);
        switch (operator){
            case "<":
                return firstEvaluation < secondEvaluation? 1: 0;
            case ">":
                return firstEvaluation > secondEvaluation? 1: 0;
            case "<=":
                return firstEvaluation <= secondEvaluation? 1: 0;
            case ">=":
                return firstEvaluation >= secondEvaluation? 1: 0;
            case "==":
                return firstEvaluation == secondEvaluation? 1: 0;
            case "!=":
                return firstEvaluation != secondEvaluation? 1: 0;
            default:
                throw new MyException("Invalid operator");
        }
    }

    @Override
    public String toString() {
        return "(" + firstExpr.toString() + operator + secondExpr.toString() + ")";
    }
}
