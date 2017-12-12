package Model;

import java.io.BufferedReader;
import java.io.IOException;

public class ReadFileStm implements IStm {
    private IExpression exp_file_id;
    private String var_name;

    public ReadFileStm(IExpression exp_file_id, String var_name) {
        this.exp_file_id = exp_file_id;
        this.var_name = var_name;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        int value = exp_file_id.eval(state.getSymTable(),state.getHeap());
        MyTuple t = state.getFileTable().getValue(value);
        if(t == null) {
            throw new MyException("NO pair");
        }
        BufferedReader bf = t.getFileDescriptor();
        if(bf == null) {
            throw new MyException("No file descriptor");
        }
        try {
            String line = bf.readLine();
            int nextValue;
            if(line == null)
                nextValue = 0;
            else
                nextValue = Integer.parseInt(line);
            state.getSymTable().add(var_name,nextValue);
        } catch (IOException e) {
            throw new MyException(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "ReadFile("+exp_file_id+"; "+var_name+")";
    }
}
