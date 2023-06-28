package instructions;

import model.Instruction;
import model.Memory;
import util.BinaryConverter;

public class LoadWord extends Instruction {

    Memory memory;

//    LoadWord(rt, rs, offset);

    public LoadWord(int rt, int rs, int offset) {
        super(rs, rt, 0, 0, 0, offset, "100011");
        memory = Memory.getInstance();
    }


    @Override
    public void decode() {
        setRsValue(registerFile.getRegisterValue(getRs()));
        setImmediate(getRsValue() + getOffset());
    }

    @Override
    public void execute() {

    }

    @Override
    public void memory() {
        setRtValue(memory.readWord(getImmediate()));
        setHasMemory(true);
    }

    @Override
    public void writeBack() {
        registerFile.setRegisterValue(getRt(), getRtValue());
        addWbRegister(getRt());
    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getRs(), 5) + BinaryConverter.convertToBinary(getRt(), 5) + BinaryConverter.convertToBinary(getImmediate(), 16)+"\n";
    }
}
