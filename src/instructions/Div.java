package instructions;

import model.Instruction;
import model.InstructionMemory;
import model.ProgramCounter;
import util.BinaryConverter;

public class Div extends Instruction {
    public Div(int rd, int rs, int rt) {
        super(rs, rt, rd, 0,0,0, "000000");
    }

    @Override
    public void decode() {
        setRsValue(registerFile.getRegisterValue(getRs()));
        setRtValue(registerFile.getRegisterValue(getRt()));
    }

    @Override
    public void execute() {
        if(getRtValue() != 0){
            setHi(getRsValue() % getRtValue());
            setLo(getRsValue() / getRtValue());
        }
        ProgramCounter.getInstance().setPC(InstructionMemory.getInstance().getInstructionSize());
    }

    @Override
    public void memory() {

    }

    @Override
    public void writeBack() {
        registerFile.setRegisterValue(getHi(), 32);
        registerFile.setRegisterValue(getLo(), 33);
        addWbRegister(getHi());
        addWbRegister(getLo());
    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getRs(), 5) + BinaryConverter.convertToBinary(getRt(), 5) + BinaryConverter.convertToBinary(getRd(), 5) + "00000"+"011010\n";
    }
}
