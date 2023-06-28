package instructions;

import model.Instruction;
import model.ProgramCounter;
import util.BinaryConverter;

public class Bltz extends Instruction {
    public Bltz(int rs, int rt, int offset) {
        super(rs, rt, 0, 0, 0, offset, "000001");
    }

    @Override
    public void decode() {
        setRtValue(0);
        setRsValue(registerFile.getRegisterValue(getRs()));
        setImmediate(getOffset());
    }

    @Override
    public void execute() {
        int rsValue = getRsValue();
        int rtValue = getRtValue();
        if(rsValue < rtValue){
            ProgramCounter.getInstance().setPC(getImmediate());
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
