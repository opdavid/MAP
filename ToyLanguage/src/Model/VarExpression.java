package Model;

public class VarExpression implements IExpression {
    private String variable;

    public VarExpression(String variable) {
        this.variable = variable;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> d, IHeap<Integer> heap) throws MyException {
        Integer val = d.getValue(this.variable);
        if(val == null)
            throw new MyException("Unknown Variable Exception at: " + this.toString() + "\nThere is no such " + this.variable + " variable");
        return d.getValue(variable);
    }

    @Override
    public String toString() {
        return variable;
    }
}
