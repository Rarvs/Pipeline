package instructions;

import model.*;
import util.BinaryConverter;

public class Noop extends Instruction {
    ProgramCounter programCounter;
    public Noop() {
        super(0,0,0,0,0,0, "111111");
        programCounter = ProgramCounter.getInstance();
    }


    @Override
    public void decode() {

    }

    @Override
    public void execute() {
        programCounter.setPC(InstructionMemory.getInstance().getInstructionSize());
    }

    @Override
    public void memory() {

    }

    @Override
    public void writeBack() {

    }

    @Override
    public String toString() {
        return super.toString() + "11111111111111111111111111\n";
    }
}
