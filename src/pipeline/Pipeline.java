package pipeline;

import model.Instruction;

public class Pipeline {
    FetchStage fetchStage;
    DecodeStage decodeStage;
    ExecuteStage executeStage;
    MemoryStage memoryStage;
    WritebackStage writebackStage;

    public Pipeline(){
        fetchStage = new FetchStage();
        decodeStage = new DecodeStage();
        executeStage = new ExecuteStage();
        memoryStage = new MemoryStage();
        writebackStage = new WritebackStage();
    }

    Instruction[] inst = new Instruction[5];

    private void internalRun(int index){

        int current = index;
        Instruction ins;

        switch (index){
            case 4:
                ins = inst[index];
                inst[index--] = writebackStage.writeBack(ins);
            case 3:
                ins = inst[index];
                inst[index--] = memoryStage.memory(ins);
            case 2:
                ins = inst[index];
                inst[index--] = executeStage.execute(ins);
            case 1:
                ins = inst[index];
                inst[index--] = decodeStage.decode(ins);
            case 0:
                inst[index] = fetchStage.fetch();
        }
        moveFile();

        if (current < 4)
            current++;

        internalRun(current);
    }

    private void moveFile(){
        for (int i = inst.length - 1; i > 0; i--) {
            inst[i] = inst[i-1];
        }
        inst[0] = null;
    }

    public void run(){
        writebackStage.writeBack(memoryStage.memory(executeStage.execute(decodeStage.decode(fetchStage.fetch()))));
//        internalRun(0);
    }


}
