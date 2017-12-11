package Model;

public class ConstExpression implements IExpression {
    private int value;

    public ConstExpression(int value) {
        this.value = value;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> d, IHeap<Integer> heap) throws MyException {
        return this.value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
