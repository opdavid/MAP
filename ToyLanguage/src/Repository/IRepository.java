package Repository;

import Model.MyException;
import Model.PrgState;

import java.util.List;


public interface IRepository {
    void addPrgState(PrgState p);
    PrgState getCtrlPrg(int index);
    void logPrgStateExec(PrgState prg) throws MyException;
    List<PrgState> getPrgList();
    void setPrgList(List<PrgState> prgList);
}
