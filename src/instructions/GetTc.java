package instructions;

import model.Instruction;
import model.Memory;
import util.BinaryConverter;


import java.util.Scanner;

public class GetTc extends Instruction {
    Memory memory;
    public GetTc(int address) {
        super(0, 0, 0, 0, address, 0, "010101");
        memory = Memory.getInstance();
    }


    @Override
    public void decode() {

    }

    @Override
    public void execute() {

    }

    @Override
    public void memory() {
        Scanner scanner = new Scanner(System.in);
        setImmediate(getAddress());
        memory.writeWord(getImmediate(), scanner.nextInt());
        setHasMemory(true);
    }

    @Override
    public void writeBack() {

    }

    @Override
    public String toString() {
        return super.toString() + BinaryConverter.convertToBinary(getAddress(), 26)+"\n";
    }
}
