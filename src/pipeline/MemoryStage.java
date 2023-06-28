package pipeline;

import model.Instruction;
import model.Memory;

public class MemoryStage {
    public Instruction memory(Instruction instruction){
        instruction.memory();
        if(instruction.isHasMemory()){
            System.out.println("MEM: " + instruction.getImmediate());
        }
        return instruction;
    }
}
