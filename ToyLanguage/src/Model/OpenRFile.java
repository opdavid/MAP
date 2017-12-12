package Model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class OpenRFile implements IStm {
    private static int fd = 1;
    private String var_file_id;
    private String filename;

    public OpenRFile(String var_file_id, String filename) {
        this.var_file_id = var_file_id;
        this.filename = filename;
    }

    public String getVar_file() {
        return var_file_id;
    }

    public void setVar_file(String var_file_id) {
        this.var_file_id = var_file_id;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    @Override
    public PrgState execute(PrgState state) throws MyException {
        for(MyTuple t: state.getFileTable().values()) {
            if (t.getFilename().equals(filename))
                throw new MyException("the filename already exists");
        }
        try {
            BufferedReader bf = new BufferedReader(new FileReader(filename));
            state.getFileTable().add(fd,new MyTuple(filename,bf));
            state.getSymTable().add(var_file_id,fd);
            fd++;

        } catch (IOException e) {
            throw new MyException(e.getMessage());
        }
        return null;
    }

    @Override
    public String toString() {
        return "OpenFile("+var_file_id+"; "+filename+")";
    }
}
