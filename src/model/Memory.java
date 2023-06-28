package model;

public class Memory {
    private static final int MEMORY_SIZE = 1001;
    private static final int WORD_SIZE = 32;

    private static Memory instance;
    private int[] memory;

    private Memory() {
        memory = new int[MEMORY_SIZE];
    }

    public static Memory getInstance() {
        if (instance == null) {
            instance = new Memory();
        }
        return instance;
    }

    public int readWord(int address) {
        if (address >= 0 && address < MEMORY_SIZE) {
            return memory[address];
        }
        throw new IllegalArgumentException("Invalid memory address");
    }

    public void writeWord(int address, int data) {
        if (address >= 0 && address < MEMORY_SIZE) {
            memory[address] = data;
        } else {
            throw new IllegalArgumentException("Invalid memory address");
        }
    }

    public int getMemorySize() {
        return MEMORY_SIZE;
    }

    public int getWordSize() {
        return WORD_SIZE;
    }
}
