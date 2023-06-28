package pipeline;

import model.Instruction;

public class ExecuteStage {
    public Instruction execute(Instruction instruction){
        instruction.execute();
        System.out.print("EX: "+instruction);
        return instruction;
    }
}
