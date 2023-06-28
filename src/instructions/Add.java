package instructions;

import model.Instruction;
import util.BinaryConverter;

public class Add extends Instruction {

//    Add(rd, rs, rt);


    public Add(int rd, int rs, int rt) {
        super(rs, rt, rd, 0, 0, 0, "000000");
    }

    @Override
    public void decode(){
        setRtValue(registerFile.getRegisterValue(getRt()));
        setRsValue(registerFile.getRegisterValue(getRs()));
    }

    @Override
    public void memory() {
    }

    @Override
    public void execute() {
        setResult(getRsValue() + getRtValue());
    }

    @Override
    public void writeBack(){
        registerFile.setRegisterValue(getRd(), getResult());
        addWbRegister(getRd());
    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getRs(), 5) + BinaryConverter.convertToBinary(getRt(), 5) + BinaryConverter.convertToBinary(getRd(), 5) + "00000"+"100000\n";
    }
}
