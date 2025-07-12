


import java.io.*;
import java.util.*;

public class Merger {
    public static void mergeChunks(List<CompressorThread> compressors, String outputFile) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        for (CompressorThread ct : compressors) {
            writer.write(ct.getCompressedResult());
        }
        writer.close();
    }
}
