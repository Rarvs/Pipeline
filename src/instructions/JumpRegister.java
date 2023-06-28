package instructions;

import model.Instruction;
import model.ProgramCounter;
import util.BinaryConverter;

public class JumpRegister extends Instruction {

    //    JumpRegister(rs);
    ProgramCounter programCounter;
    public JumpRegister(int rs) {
        super(rs,0, 0, 0, 0,0, "000000");
        programCounter = ProgramCounter.getInstance();
    }


    @Override
    public void decode() {
        setRsValue(registerFile.getRegisterValue(getRs()));
    }

    @Override
    public void execute() {
        programCounter.setPC(getRsValue());
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
