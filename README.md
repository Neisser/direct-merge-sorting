# Direct Merge Sort Project

This project is a Java application that allows you to sort data from an input file and save the results to an output file specified by the user.

## Requirements

- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 11 or higher)
- [IntelliJ IDEA](https://www.jetbrains.com/idea/download/) or another editor compatible with Java projects

## Execution Instructions

1. **Clone or download the project:**

    - You can clone the repository or download the project files to your local machine.

    ```bash
    git clone git@github.com:Neisser/direct-merge-sorting.git
   ```

2. **Open the project in IntelliJ IDEA:**

    - Open IntelliJ IDEA.
    - Select `File > Open` and navigate to the folder where you downloaded the project.
    - Select the project folder and click `OK` to open it in IntelliJ.

3. **Run the project:**

    - In the IntelliJ IDEA window, ensure that the `Main.java` file is selected as the main class to run.
    - Click the run button (the "play" icon) at the top of IntelliJ or press `Shift + F10` to run the project.

4. **Interact with the console:**

    - After running the project, a console will open in IntelliJ.
    - The console will prompt you to enter the input file path:
        - Type the full path of the input file and press `Enter`.
    - Next, you will be prompted to enter the output file path:
        - Type the full path where you want the output file to be saved and press `Enter`.
    - Finally, you will be asked to enter the estimated size of the input file (in the number of lines):
        - Enter the number of lines and press `Enter`.

5. **Output file generation:**

    - Once the above steps are completed, the program will process the data and generate the output file at the specified path.
    - The output file will contain the sorted data based on the input provided.

## Additional Notes

- Ensure that the file paths are correct and accessible from your operating system.
- If you encounter any errors, verify that you have entered the data correctly in the console and that the input files exist at the specified paths.

## Example Usage

```bash
Enter the input file path: ./files/input.txt
Enter the output file path: ./files/output.txt
Enter the estimated size of the input file (number of lines): 16
```