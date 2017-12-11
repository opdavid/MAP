package Model;

public class ArithmExpression implements IExpression {
    private IExpression expr1;
    private IExpression expr2;
    private static final int ADD = 1;
    private static final int SUBTRACT = 2;
    private static final int MULTIPLY = 3;
    private static final int DIVIDE = 4;
    private int op;

    public ArithmExpression(char op, IExpression expr1, IExpression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
        if(op == '+')
            this.op = ADD;
        else if(op == '-')
            this.op = SUBTRACT;
        else if(op == '*')
            this.op = MULTIPLY;
        else if(op == '/')
            this.op = DIVIDE;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> d, IHeap<Integer> heap) throws MyException{
        int res = 0;
        int res1 = this.expr1.eval(d, heap);
        int res2 = this.expr2.eval(d, heap);
        if (op == ADD) {
            res = res1 + res2;
        } else if (op == SUBTRACT) {
            res = res1 - res2;
        } else if (op == MULTIPLY) {
            res = res1 * res2;
        } else if (op == DIVIDE) {
            if (res2 == 0) {
                throw new MyException("Division By 0");
            }
            res = res1 / res2;
        }
        return res;
    }

    @Override
    public String toString() {
        String ret = this.expr1.toString();
        if(op == ADD)
            ret += " + ";
        else if(op == SUBTRACT)
            ret += " - ";
        else if(op == MULTIPLY)
            ret += " * ";
        else if(op == DIVIDE)
            ret += " / ";
        ret += this.expr2.toString();
        return ret;
    }
}
