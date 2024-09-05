import java.io.*;

public class DirectMerge {
    public static void sort(String input, String output, int inputSize) throws IOException {
        String pChunk1 = "./files/chunk1";

        String pChunk2 = "./files/chunk2";

        int maxGroupSize = getMaxGroupSize(inputSize);

        Files.createOutput(input, output);

        for (int i = 1; i <= maxGroupSize; i *= 2) {
            DirectMerge.splitFile(
                    Files.reader(output),
                    Files.writer(pChunk1),
                    Files.writer(pChunk2),
                    i
            );

            DirectMerge.mergeChunks(
                    Files.writer(output),
                    Files.reader(pChunk1),
                    Files.reader(pChunk2),
                    i
            );
        }
    }

    private static int getMaxGroupSize(int inputSize){
        int power = (int) (Math.log(inputSize) / Math.log(2));

        return (int) Math.pow(2, power - 1);
    }


    public static void splitFile(
            BufferedReader input,
            BufferedWriter chunk1,
            BufferedWriter chunk2,
            int groupSize
    ) throws IOException {
        boolean hasMoreLines = true;

        while (hasMoreLines) {
            hasMoreLines = Files.writeGroup(input, chunk1, groupSize);

            if(!hasMoreLines) break;

            hasMoreLines = Files.writeGroup(input, chunk2, groupSize);
        }

        input.close();

        chunk1.flush();

        chunk1.close();

        chunk2.flush();

        chunk2.close();
    }



    public static void mergeChunks(
            BufferedWriter output,
            BufferedReader chunk1,
            BufferedReader chunk2,
            int group
    ) throws IOException {
        String line1 = chunk1.readLine();

        String line2 = chunk2.readLine();

        while (line1 != null || line2 != null) {
            int counter1 = 0, counter2 = 0;

            if (line1 == null) {
                output.write(line2);

                output.newLine();

                line2 = chunk2.readLine();

                continue;
            } else if (line2 == null) {
                output.write(line1);

                output.newLine();

                line1 = chunk1.readLine();

                continue;
            }


            for (int i = 1; i <= group * 2; i++) {

                if(counter1 == group && counter2 == group){
                    break;
                }

                if(counter1 < group && counter2 == group) {
                    output.write(line1);

                    output.newLine();

                    line1 = chunk1.readLine();

                    counter1++;

                    continue;
                }

                if(counter2 < group && counter1 == group) {
                    output.write(line2);

                    output.newLine();

                    line2 = chunk2.readLine();

                    counter2++;

                    continue;
                }


                if (Integer.parseInt(line1) <= Integer.parseInt(line2)) {
                    output.write(line1);

                    output.newLine();

                    line1 = chunk1.readLine();

                    counter1++;
                } else if(Integer.parseInt(line2) <= Integer.parseInt(line1)) {
                    output.write(line2);

                    output.newLine();

                    line2 = chunk2.readLine();

                    counter2++;
                }
            }
        }

        output.flush();

        output.close();

        chunk1.close();

        chunk2.close();

        Files.deleteChunks();
    }
}