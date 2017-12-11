package Model;

public interface IStm {
    PrgState execute(PrgState state) throws  MyException;
}
