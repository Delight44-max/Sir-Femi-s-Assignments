const prompt = require('prompt-sync')();



const sentence = "The quick brown fox jumps over the lazy dog.";
console.log("Type this sentence:");
console.log(sentence);
prompt("Press Enter when ready...");

const startTime = Date.now();
const userInput = prompt("\nStart typing here:\n");
const endTime = Date.now();

// Time taken
const timeTaken = (endTime - startTime) / 1000;
const timeInMinutes = timeTaken / 60;

// Words per minute
const wordCount = sentence.split(" ").length;
const wpm = wordCount / timeInMinutes;

// Accuracy
let correctChars = 0;
for (let index = 0; index < Math.min(userInput.length, sentence.length); index++) {
if (userInput[index] === sentence[index]) {
        correctChars++;
}
}
const accuracy = (correctChars / sentence.length) * 100;

// Results
console.log("\n--- Results ---");
console.log(`Time taken: ${timeTaken.toFixed(2)} seconds`);
console.log(`Words per minute:" ${wpm.toFixed(2)}`);
console.log(`Accuracy: ${accuracy.toFixed(2)}%`);