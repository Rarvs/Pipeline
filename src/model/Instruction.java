package model;

import java.util.ArrayList;
import java.util.List;

public abstract class Instruction {

    protected RegisterFile registerFile;
    private int rs;
    private int rsValue;
    private int rt;
    private int rtValue;
    private final int rd;
    private int immediate;
    private final int address;
    private final int offset;
    private int result;

    private int lo;

    private int hi;

    private final String code;

    private boolean hasMemory = false;

    private List<Integer> wbRegister;

    public Instruction(int rs, int rt, int rd, int immediate, int address, int offset, String code) {
        registerFile = RegisterFile.getInstance();
        this.rs = rs;
        this.rt = rt;
        this.rd = rd;
        this.immediate = immediate;
        this.address = address;
        this.offset = offset;
        this.code = code;
        wbRegister = new ArrayList<>();
    }

    public void addWbRegister(int register){
        wbRegister.add(register);
    }

    public List<Integer> getWbRegister() {
        return wbRegister;
    }

    public boolean isHasMemory() {
        return hasMemory;
    }

    public void setHasMemory(boolean hasMemory) {
        this.hasMemory = hasMemory;
    }

    public int getLo() {
        return lo;
    }

    public void setLo(int lo) {
        this.lo = lo;
    }

    public int getHi() {
        return hi;
    }

    public void setHi(int hi) {
        this.hi = hi;
    }

    public int getRsValue() {
        return rsValue;
    }

    public void setRsValue(int rsValue) {
        this.rsValue = rsValue;
    }

    public int getRtValue() {
        return rtValue;
    }

    public void setRtValue(int rtValue) {
        this.rtValue = rtValue;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public void setRs(int rs) {
        this.rs = rs;
    }

    public void setRt(int rt) {
        this.rt = rt;
    }

    public void setImmediate(int immediate) {
        this.immediate = immediate;
    }

    public int getOffset() {
        return offset;
    }

    public abstract void decode();

    public abstract void execute();


    public abstract void memory();

    public abstract void writeBack();

    public int getRs() {
        return rs;
    }

    public int getRt() {
        return rt;
    }

    public int getRd() {
        return rd;
    }

    public int getImmediate() {
        return immediate;
    }

    public int getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Instruction: "+ code;
    }
}
