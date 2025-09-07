import java.util.Scanner;

public class TypingSpeedTest {
public static void main(String[] args) {
String sentence = "The quick brown fox jumps over the lazy dog.";
Scanner scanner = new Scanner(System.in);

System.out.println("Type this sentence:");
System.out.println(sentence);
System.out.println("Press Enter when ready...");
        scanner.nextLine();

long startTime = System.currentTimeMillis();
System.out.println("\nStart typing here:");
String userInput = scanner.nextLine();
long endTime = System.currentTimeMillis();

        // Time taken
double timeTaken = (endTime - startTime) / 1000.0;
double timeInMinutes = timeTaken / 60.0;

        // Words per minute
int wordCount = sentence.split(" ").length;
double wpm = wordCount / timeInMinutes;

        // Accuracy
int correctChars = 0;
for (int index = 0; index < Math.min(userInput.length(), sentence.length()); index++) {
if (userInput.charAt(index) == sentence.charAt(index)) {
                correctChars++;
}
}
        double accuracy = ((double) correctChars / sentence.length()) * 100;

        // Results
System.out.printf("\n--- Results ---\n");
System.out.printf("Time taken: %.2f seconds\n", timeTaken);
System.out.printf("Words per minute: %.2f\n", wpm);
System.out.printf("Accuracy: %.2f%%\n", accuracy);

       
}
}