package pipeline;

import model.Instruction;

public class WritebackStage {
    public Instruction writeBack(Instruction instruction){
        instruction.writeBack();
        if(!instruction.getWbRegister().isEmpty()){
            System.out.println("WB:");
            for(int r: instruction.getWbRegister()){
                System.out.println(r);
            }
        }
        return instruction;
    }
}
