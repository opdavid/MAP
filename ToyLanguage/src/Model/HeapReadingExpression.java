package Model;

public class HeapReadingExpression implements IExpression {
    private String var_name;

    public HeapReadingExpression(String var_name) {
        this.var_name = var_name;
    }

    @Override
    public int eval(MyIDictionary<String, Integer> symTable, IHeap<Integer> heap) throws MyException {
        if(!symTable.hasKey(var_name))
            throw new MyException("Undeclared variable name");
        Integer address = symTable.getValue(var_name);
        if(!heap.hasKey(address))
            throw new MyException("Undeclared variable name");

        if(heap.getValue(address) != null)
            return heap.getValue(address);
        return address;
    }

    @Override
    public String toString() {
        return "rH("+ var_name +")";
    }
}
