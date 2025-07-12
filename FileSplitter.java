import java.util.*;
import java.io.*;

public class FileSplitter {
    public static List<String> splitFile(String filename, int parts) throws IOException {
        String content = new String(java.nio.file.Files.readAllBytes(new File(filename).toPath()));
        int length = content.length();
        int chunkSize = length / parts;

        List<String> chunks = new ArrayList<>();
        for (int i = 0; i < parts; i++) {
            int start = i * chunkSize;
            int end = (i == parts - 1) ? length : (i + 1) * chunkSize;
            chunks.add(content.substring(start, end));
        }
        return chunks;
    }
}
