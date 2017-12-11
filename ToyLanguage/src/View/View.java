package View;

import Controller.Controller;
import Model.*;
import Model.PrgState;
import Repository.IRepository;
import Repository.Repository;

//import java.util.Scanner;

public class View {

    public static void main(String[] args) {

        IStm ex1= new CompStmt(new AssignStmt("v",new ArithmExpression('+',new ConstExpression(3),new ConstExpression(5))), new PrintStmt(new
                VarExpression("v")));

        String var_f = "f";
        String var_c = "c";
        IStm ex2 = new CompStmt(
                    new OpenRFile(var_f,"test.in"),
                    new CompStmt(
                            new CompStmt(
                                new ReadFileStm(new VarExpression(var_f),var_c),
                                new CompStmt(
                                    new PrintStmt(new VarExpression(var_c)),
                                    new IfStmt(new CompStmt(
                                            new ReadFileStm(new VarExpression(var_f),var_c),
                                            new PrintStmt(new VarExpression(var_c))),
                                    new PrintStmt(new ConstExpression(0)),
                                    new VarExpression(var_c)))),
                    new CloseRFileStm(new VarExpression(var_f))));

        IStm ex3 = new CompStmt(
                        new AssignStmt("v",new ConstExpression(10)),
                            new CompStmt(
                                     new HeapAllocation("v",new ConstExpression(20)),
                                     new CompStmt(
                                             new HeapAllocation("a",new ConstExpression(22)),
                                             new PrintStmt(new VarExpression("v"))
                                     )
                            )
                    );

        IStm ex4 = new CompStmt(
                    new AssignStmt("v",new ConstExpression(10)),
                    new CompStmt(
                        new HeapAllocation("v",new ConstExpression(20)),
                        new CompStmt(
                                new HeapAllocation("a",new ConstExpression(22)),
                                new CompStmt(
                                    new HeapWritingStm("a",new ConstExpression(30)),
                                    new CompStmt(
                                        new PrintStmt(new VarExpression("a")),
                                        new PrintStmt(new HeapReadingExpression("a"))
                                    )
                                )
                        )
                )
        );

        IStm ex5 = new CompStmt(
                new AssignStmt("v",new ConstExpression(10)),
                new CompStmt(
                        new HeapAllocation("v",new ConstExpression(20)),
                        new CompStmt(
                                new HeapAllocation("a",new ConstExpression(22)),
                                new CompStmt(
                                        new HeapWritingStm("a",new ConstExpression(30)),
                                        new CompStmt(
                                                new PrintStmt(new VarExpression("a")),
                                                new CompStmt(
                                                    new PrintStmt(new HeapReadingExpression("a")),
                                                    new AssignStmt("a",new ConstExpression(0))
                                                )
                                        )
                                )
                        )
                )
        );

        IStm ex6 = new CompStmt(
                        new AssignStmt("v",new ConstExpression(6)),
                        new CompStmt(
                                new WhileStatement(
                                        new ArithmExpression('-',new VarExpression("v"),new ConstExpression(4)),
                                        new CompStmt(
                                            new PrintStmt(new VarExpression("v")),
                                                new AssignStmt("v",new ArithmExpression('-',new VarExpression("v"),new ConstExpression(1)))
                                        )
                                ),
                                new PrintStmt(new VarExpression("v"))

                        )
        );

        IStm ex7 = new CompStmt(
                new OpenRFile("f", "test.in"),
                new CompStmt(
                        new ReadFileStm(new VarExpression("f"), "c"),
                        new CompStmt(
                                new PrintStmt(new VarExpression("c")),
                                new IfStmt(
                                        new CompStmt(
                                                new ReadFileStm(new VarExpression("f"), "c"),
                                                new PrintStmt(new VarExpression("c"))),
                                        new PrintStmt(new ConstExpression(0)),
                                        new VarExpression("c"))
                        )
                )
        );

//        System.out.print("Give the file name: ");
//        Scanner s = new Scanner(System.in);
//        String filename = s.nextLine();


        PrgState state1 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex1);
        PrgState state2 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex2);
        PrgState state3 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex3);
        PrgState state4 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex4);
        PrgState state5 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex5);
        PrgState state6 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex6);
        PrgState state7 = new PrgState(new MyStack<>(),new MyDictionary<>(),new MyList<>(),new MyDictionary<>(),new MyHeap(),ex7);

        IRepository r = new Repository("test.out");
        r.addPrgState(state1);
        r.addPrgState(state2);
        r.addPrgState(state3);
        r.addPrgState(state4);
        r.addPrgState(state5);
        r.addPrgState(state6);
        r.addPrgState(state7);
        Controller c = new Controller(r);

        TextMenu menu = new TextMenu();
        menu.addCommand(new ExitCommand("0", "exit"));
        menu.addCommand(new RunExample("1",ex1.toString(),c));
        menu.addCommand(new RunExample("2",ex2.toString(),c));
        menu.addCommand(new RunExample("3",ex3.toString(),c));
        menu.addCommand(new RunExample("4",ex4.toString(),c));
        menu.addCommand(new RunExample("5",ex5.toString(),c));
        menu.addCommand(new RunExample("6",ex6.toString(),c));
        menu.addCommand(new RunExample("7",ex7.toString(),c));
        menu.show();

    }
}
