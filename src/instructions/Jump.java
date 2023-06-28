package instructions;

import model.Instruction;
import model.ProgramCounter;
import util.BinaryConverter;

public class Jump extends Instruction {
    ProgramCounter programCounter;
//    Jump(address);
    public Jump(int address) {
        super(0, 0, 0, 0, address, 0, "000010");
        programCounter = ProgramCounter.getInstance();
    }

    @Override
    public void decode() {

    }

    @Override
    public void execute() {
        programCounter.setPC(getAddress());
    }

    @Override
    public void memory() {

    }

    @Override
    public void writeBack() {

    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getAddress(), 26)+"\n";
    }
}
