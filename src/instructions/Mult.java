package instructions;

import model.Instruction;
import util.BinaryConverter;

public class Mult extends Instruction {

    public Mult(int rd, int rs, int rt) {
        super( rs, rt, rd, 0,0,0, "000000");
    }

    @Override
    public void decode() {
        setRsValue(registerFile.getRegisterValue(getRs()));
        setRtValue(registerFile.getRegisterValue(getRt()));
    }

    @Override
    public void execute() {
        setHi(getRsValue() * getRtValue());
    }

    @Override
    public void memory() {

    }

    @Override
    public void writeBack() {
        registerFile.setRegisterValue(getHi(), 32);
        registerFile.setRegisterValue(getHi(), 33);
        addWbRegister(getHi());
    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getRs(), 5) + BinaryConverter.convertToBinary(getRt(), 5) + BinaryConverter.convertToBinary(getRd(), 5) + "00000"+"011000\n";
    }
}
