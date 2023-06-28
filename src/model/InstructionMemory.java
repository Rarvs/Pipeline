package model;

import java.util.ArrayList;
import java.util.List;

public class InstructionMemory {
    private List<Instruction> instructions;
    private static InstructionMemory instance;

    private InstructionMemory() {
        instructions = new ArrayList<>();
    }

    public static InstructionMemory getInstance() {
        if (instance == null) {
            instance = new InstructionMemory();
        }
        return instance;
    }

    public void loadInstructions(List<Instruction> instructionList) {
        instructions.clear();
        instructions.addAll(instructionList);
    }

    public int getInstructionSize(){
        return instructions.size();
    }
    public Instruction fetchInstruction(int address) {
        if (address >= 0 && address < instructions.size()) {
            return instructions.get(address);
        }
        return null;
    }

    public void setInstruction(int address, Instruction instruction){
        instructions.add(address, instruction);
    }
}
