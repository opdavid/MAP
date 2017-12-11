package Model;

public interface IExpression {
    int eval(MyIDictionary<String, Integer> symTable, IHeap<Integer> heap) throws  MyException;
}
