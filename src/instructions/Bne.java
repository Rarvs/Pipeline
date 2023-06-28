package instructions;

import model.Instruction;
import model.ProgramCounter;
import util.BinaryConverter;

public class Bne extends Instruction {
    ProgramCounter programCounter;
    public Bne(int rs, int rt, int offset) {
        super(rs, rt, 0, 0, 0, offset, "000101");
        programCounter = ProgramCounter.getInstance();
    }


    @Override
    public void decode() {
        setRsValue(registerFile.getRegisterValue(getRs()));
        setRtValue(registerFile.getRegisterValue(getRt()));
        setImmediate(getOffset());
    }

    @Override
    public void execute() {
        int rsValue = getRsValue();
        int rtValue = getRtValue();
        if(rsValue != rtValue){
            programCounter.setPC(getImmediate());
        }
    }

    @Override
    public void memory() {

    }

    @Override
    public void writeBack() {

    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getRs(), 5) + BinaryConverter.convertToBinary(getRt(), 5) + BinaryConverter.convertToBinary(getImmediate(), 16)+"\n";
    }
}
