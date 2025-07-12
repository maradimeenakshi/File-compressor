


public class CompressorThread implements Runnable {
    private String chunk;
    private int threadId;
    private String compressedResult = "";

    public CompressorThread(String chunk, int threadId) {
        this.chunk = chunk;
        this.threadId = threadId;
    }

    @Override
    public void run() {
        compressedResult = compress(chunk);
        System.out.println("Thread " + threadId + " done.");
    }

    public String getCompressedResult() {
        return compressedResult;
    }

    private String compress(String input) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i) == input.charAt(i - 1)) {
                count++;
            } else {
                sb.append(count).append(input.charAt(i - 1));
                count = 1;
            }
        }
        if (!input.isEmpty()) {
            sb.append(count).append(input.charAt(input.length() - 1));
        }
        return sb.toString();
    }
}
