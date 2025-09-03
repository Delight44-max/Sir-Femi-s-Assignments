import java.util.Scanner;
import java.util.ArrayList;

public class Election {

public static ArrayList<String> candidates = new ArrayList<>();
public static ArrayList<String> voters = new ArrayList<>();
public static ArrayList<String> votes = new ArrayList<>();
public static ArrayList<String> regions = new ArrayList<>();

public static ArrayList<String> registerCandidates() {
Scanner input = new Scanner(System.in);

System.out.println("Welcome to the Voting System");
System.out.println("Enter candidate names (type 'Exit' to finish):");

while (true) {
System.out.print("Candidate Name: ");
String name = input.nextLine();

if (name.equalsIgnoreCase("Exit")) {
                break;
}

if (name.isEmpty()) {
System.out.println("Name cannot be empty. Try again.");
                continue;
}

if (candidates.contains(name)) {
System.out.println("Name already exists. YOU CAN'T REGISTER TWICE!");
} else {
candidates.add(name);
System.out.println("Candidate registered successfully.\n");
}
}

        return candidates;
}

public static ArrayList<String> registerVoters() {
Scanner input = new Scanner(System.in);

System.out.println("\nKindly vote wisely");
System.out.println("Enter voter details (type 'Exit' to finish):");

while (true) {
System.out.print("Voter Name: ");
String name = input.nextLine();

if (name.equalsIgnoreCase("Exit")) {
                break;
}

if (name.isEmpty()) {
System.out.println("Name cannot be empty. Try again.");
                continue;
}

if (voters.contains(name)) {
System.out.println("Name already exists. YOU CAN'T REGISTER TWICE!");
                continue;
}

System.out.print("Voter Age: ");
String ageInput = input.nextLine();

boolean isNumeric = ageInput.matches("\\d+");
if (!isNumeric) {
System.out.println("Invalid age input. Please enter a number.\n");
                continue;
}

int age = Integer.parseInt(ageInput);
if (age < 18) {
System.out.println("Invalid age. Please leave the site.\n");
                continue;
}

System.out.print("Your region (e.g., Lagos, Abuja): ");
String region = input.nextLine();

System.out.println("Caste your vote by typing the name of the candidate you want to vote for:");
String userinput = input.nextLine();

if (candidates.contains(userinput)) {
voters.add(name);
votes.add(userinput);
regions.add(region);
System.out.println("Vote cast successfully for " + userinput + " from " + region + "\n");
} else {
System.out.println("Invalid candidate name. Vote not recorded.\n");
}
}

        return voters;
}

public static void displayResults() {
System.out.println("\nVote Results:");
int[] voteCounts = new int[candidates.size()];
String[] topRegion = new String[candidates.size()];
int[] topRegionCount = new int[candidates.size()];

for (int count = 0; count < candidates.size(); count++) {
String candidate = candidates.get(count);
for (int counter = 0; counter < votes.size(); counter++) {
if (votes.get(counter).equalsIgnoreCase(candidate)) {
voteCounts[count]++;
String region = regions.get(counter);
int regionCounter = 0;
for (int index = 0; index < votes.size(); index++) {
if (votes.get(index).equalsIgnoreCase(candidate) && regions.get(index).equalsIgnoreCase(region)) {
                            regionCounter++;
}
}
if (count > topRegionCount[count]) {
topRegionCount[count] = count;
topRegion[count] = region;
}
}
}
}

int maxVotes = 0;
String winner = "";

for (int index = 0; index < candidates.size(); index++) {
System.out.println(candidates.get(index) + ": " + voteCounts[index] + " vote(s)");
if (voteCounts[index] > maxVotes) {
maxVotes = voteCounts[index];
winner = candidates.get(index);
}
}

System.out.println("\nWinner: " + winner + " with " + maxVotes + " vote(s)");
for (int count = 0; count < candidates.size(); count++) {
if (candidates.get(count).equalsIgnoreCase(winner)) {
System.out.println("Region with highest votes for " + winner + ": " + topRegion[count] + " (" + topRegionCount[count] + " vote(s))");
}
}
}

public static void main(String[] args) {
        registerCandidates();

System.out.println("\nRegistered Candidates:");
for (String candidate : candidates) {
System.out.println("- " + candidate);
}

  registerVoters();

System.out.println("\nRegistered Voters:");
for (String voter : voters) {
System.out.println("- " + voter);
}

displayResults();
}
}