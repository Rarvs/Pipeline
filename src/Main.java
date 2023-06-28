import model.InstructionMemory;
import model.ProgramCounter;
import pipeline.Pipeline;
import util.Compile;

public class Main {
    public static void main(String[] args) {
        Compile compile = new Compile();
        compile.fetch();
        try{
            int i = 1;
            while(true){
                new Pipeline().run();
                System.out.println("Clock:" + i++);
            }
        }catch (Exception e){
            System.exit(0);
        }
    }
}