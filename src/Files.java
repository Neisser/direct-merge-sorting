import java.io.*;
import java.util.Random;

public class Files {
    public static BufferedReader reader(String path) throws IOException {
        return new BufferedReader(new FileReader(path));
    }

    public static BufferedWriter writer(String path) throws IOException {
        return new BufferedWriter(new FileWriter(path));
    }

    public static void createOutput(String inputF, String outputF) throws IOException {
        BufferedReader input = reader(inputF);
        BufferedWriter output = writer(outputF);

        String line;

        while ((line = input.readLine()) != null) {
            output.write(line);

            output.newLine();
        }

        output.flush();

        output.close();

        input.close();
    }

    public static boolean writeGroup(BufferedReader reader, BufferedWriter writer, int groupSize) throws IOException {
        for (int i = 0; i < groupSize; i++) {
            String line = reader.readLine();

            if (line == null) {
                return false;
            }

            writer.write(line);

            writer.newLine();
        }

        return true;
    }

    public static void deleteChunks() {
        File chunk1 = new File("./files/chunk1");

        File chunk2 = new File("./files/chunk2");

        if (chunk1.exists()) chunk1.delete();

        if (chunk2.exists()) chunk2.delete();
    }

    public static void printFile(String filePath, String desc) throws IOException {
        File file = new File(filePath);

        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;


                System.out.println(desc);

                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
        } else {
            System.err.println("File not found: " + filePath);
        }
    }

    public static void generateWorstScenarioFile(String inputFile, int lines) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));

        for (int i = 0; i < lines; i++) {
            int value = lines - i;

            writer.write(Integer.toString(value));

            writer.newLine();
        }

        writer.close();
    }

    public static void generateRandomNumberFile(String inputFile, int lines, int maxNumber) throws IOException {
        Random random = new Random();

        BufferedWriter writer = new BufferedWriter(new FileWriter(inputFile));

        for (int i = 0; i < lines; i++) {
            int value = random.nextInt();

            writer.write(Integer.toString(value));

            writer.newLine();
        }

        writer.close();
    }
}
