import model.InstructionMemory;
import model.ProgramCounter;
import pipeline.Pipeline;
import util.Compile;

public class Main {
    public static void main(String[] args) {
        Compile compile = new Compile();
        compile.fetch();
        try{
            while(true){
                new Pipeline().run();
            }
        }catch (Exception e){
            System.exit(0);
        }
    }
}