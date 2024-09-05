import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the input file path: ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter the output file path: ");
        String outputFile = scanner.nextLine();

        System.out.print("Enter the estimated size of the input file (number of lines): ");
        int inputSize = scanner.nextInt();

        DirectMerge.sort(inputFile, outputFile, inputSize);

        scanner.close();
    }
}