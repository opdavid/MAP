package Model;

import java.io.BufferedReader;
import java.io.IOException;

public class CloseRFileStm implements IStm {
    private IExpression exp_file_id;

    public CloseRFileStm(IExpression exp_file_id) {
        this.exp_file_id = exp_file_id;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        int value = exp_file_id.eval(state.getSymTable(),state.getHeap());
        MyTuple t = state.getFileTable().getValue(value);
        if(t == null)
            throw new MyException("No pair found");

        BufferedReader bf = t.getFileDescriptor();
        if(bf == null)
            throw new MyException("No file descriptor found");

        try{
            bf.close();
        } catch (IOException e) {
            throw new MyException(e.getMessage());
        }
        state.getFileTable().remove(value);
        return state;
    }

    @Override
    public String toString() {
        return "CloseRFile("+exp_file_id+")\n";
    }
}
