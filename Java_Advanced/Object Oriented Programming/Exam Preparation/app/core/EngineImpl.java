package app.core;

import app.contracts.Battlefield;
import app.contracts.Engine;
import app.contracts.Reader;
import app.contracts.Writer;

import java.io.IOException;
import java.util.Arrays;

public class EngineImpl implements Engine {
    private Writer writer;
    private Reader reader;
    private Battlefield battlefield;

    public EngineImpl(Writer writer, Reader reader, Battlefield battlefield) {
        this.writer = writer;
        this.reader = reader;
        this.battlefield = battlefield;
    }

    @Override
    public void run() throws IOException {
        String line = reader.readLine();
        while (!line.equals("Peace")){
            String[] lineTokens = line.split("\\s+");

            switch (lineTokens[0].toLowerCase()){
                case "createparticipant" :
                    this.battlefield.createParticipant(lineTokens[1], lineTokens[2]);
                    break;
                case "createaction" :
                    this.battlefield.createAction(lineTokens[1],
                            Arrays.copyOf(Arrays.stream(lineTokens).skip(2).toArray(),
                                    Arrays.stream(lineTokens).skip(2).toArray().length,
                                    String[].class));
                    break;
                default:
                    System.out.println("Invalid command");
                    break;
            }

            line = reader.readLine();
        }
    }
}
