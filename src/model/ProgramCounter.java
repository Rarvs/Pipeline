package model;

public class ProgramCounter {
    private static ProgramCounter instance;
    private int pc;

    private ProgramCounter() {
        pc = 0;
    }

    public static ProgramCounter getInstance() {
        if (instance == null) {
            instance = new ProgramCounter();
        }
        return instance;
    }

    public int getPC() {
        return pc;
    }

    public void setPC(int value) {
        pc = value;
    }

    public void incrementPC() {
        pc++;
    }

    public void resetPC() {
        pc = 0;
    }
}
