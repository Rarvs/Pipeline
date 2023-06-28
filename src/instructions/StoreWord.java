package instructions;

import model.Instruction;
import model.Memory;
import util.BinaryConverter;


public class StoreWord extends Instruction {

//    StoreWord(rt, rs, offset);
    public StoreWord(int rt, int rs, int offset) {
        super( rs, rt, 0, 0, 0, offset, "101011");
    }

    @Override
    public void decode() {
        setRsValue(registerFile.getRegisterValue(getRs()));
        setRtValue(registerFile.getRegisterValue(getRt()));
        setImmediate(getRsValue() + getOffset());
    }

    @Override
    public void execute() {

    }

    @Override
    public void memory() {
        Memory.getInstance().writeWord(getImmediate(), getRtValue());
        setHasMemory(true);
    }

    @Override
    public void writeBack() {
    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getRs(), 5) + BinaryConverter.convertToBinary(getRt(), 5) + BinaryConverter.convertToBinary(getImmediate(), 16)+"\n";
    }
}
