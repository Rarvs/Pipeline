package pipeline;

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

    public void run(){
        writebackStage.writeBack(memoryStage.memory(executeStage.execute(decodeStage.decode(fetchStage.fetch()))));
    }
}
