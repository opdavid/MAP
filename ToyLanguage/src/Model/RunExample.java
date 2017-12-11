package Model;

import Controller.Controller;

public class RunExample extends Command {
    private Controller ctr;
    public RunExample(String key, String desc,Controller ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute(String key) {
        try{
            ctr.allStep(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
