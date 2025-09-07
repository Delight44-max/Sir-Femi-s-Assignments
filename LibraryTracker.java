import java.util.Scanner;

public class LibraryTracker {
public static void main(String[] args) {
String[] books = {"Java Programming", "Python Basics", "JavaScript Guide"};
boolean[] borrowed = new boolean[books.length];
Scanner scanner = new Scanner(System.in);

while (true) {
System.out.println("\nLibrary Menu:");
System.out.println("1. View all books");
System.out.println("2. Borrow a book");
System.out.println("3. Return a book");
System.out.println("4. Exit");
System.out.print("Choose an option: ");
int choice = scanner.nextInt();

switch (choice) {
case 1:
for (int index = 0; index < books.length; index++) {
System.out.println((index + 1) + ". " + books[index] + " - " + (borrowed[index] ? "Borrowed" : "Available"));
                                                      
}
break;
case 2:


System.out.print("Enter book number to borrow: ");
int borrowIndex = scanner.nextInt() - 1;
if (!borrowed[borrowIndex]) {
borrowed[borrowIndex] = true;
System.out.println("You borrowed: " + books[borrowIndex]);
} else {
System.out.println("Book already borrowed!");
}
break;


case 3:
System.out.print("Enter book number to return: ");
int returnIndex = scanner.nextInt() - 1;
if (borrowed[returnIndex]) {
borrowed[returnIndex] = false;
System.out.println("You returned: " + books[returnIndex]);
} else {
System.out.println("Book was not borrowed.");
}
break;
                

case 4:
System.out.println("Exiting...");
scanner.close();
return;
default:
System.out.println("Invalid option.");
}
}
}
}