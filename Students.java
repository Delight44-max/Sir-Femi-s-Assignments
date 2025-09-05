import java.util.Arrays;

class Student {
String username;
String name;
int age;
String city;
String zip;
String[] courses;
}

public class Students{
static Student[] students = new Student[100];
static int totalStudents = 0;

static String[] coursesOffered = {
        "Math","Physics","Computer Science","Biology","Chemistry",
        "Statistics","English","Economics","History","Philosophy",
        "Sociology","Political Science","Geography","Psychology","Art",
        "Music","Engineering","Law","Medicine","Business"
};

public static void addStudent(String username, String name, int age, String city, String zip, String[] courses) {
        Student newStudent = new Student();
        newStudent.username = username;
        newStudent.name = name;
        newStudent.age = age;
        newStudent.city = city;
        newStudent.zip = zip;
        newStudent.courses = courses;
        students[totalStudents] = newStudent;
        totalStudents++;
    }

public static Student findStudent(String username) {
for (int counter = 0; counter < totalStudents; counter++) {
if (students[counter].username.equals(username)) {
                return students[counter];
}
}
        return null;
}

public static void displayStudent(String username) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
System.out.println("Name: " + studentRecord.name +
                               ", Age: " + studentRecord.age +
                               ", City: " + studentRecord.city +
                               ", Zip: " + studentRecord.zip +
                               ", Courses: " + Arrays.toString(studentRecord.courses));
}
}

public static void displayCourses(String username) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
System.out.println(Arrays.toString(studentRecord.courses));
}
}

public static void displayZip(String username) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
System.out.println(studentRecord.zip);
}
}

public static void displayCity(String username) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
System.out.println(studentRecord.city);
}
}

public static void addCourse(String username, String course) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
boolean offered = false;
for (int counter = 0; counter < coursesOffered.length; counter++) {
if (coursesOffered[counter].equals(course)) {
                    offered = true;
}
}
boolean exists = false;
for (int counter = 0; counter < studentRecord.courses.length; counter++) {
if (studentRecord.courses[counter].equals(course)) {
                    exists = true;
}
}
if (offered && !exists) {
String[] updatedCourses = Arrays.copyOf(studentRecord.courses, studentRecord.courses.length + 1);
updatedCourses[studentRecord.courses.length] = course;
studentRecord.courses = updatedCourses;
System.out.println(course + " added successfully!");
} else {
System.out.println("Invalid or duplicate course!");
}
}
}

public static void updateCourse(String username, String oldCourse, String newCourse) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
for (int counter = 0; counter < studentRecord.courses.length; counter++) {
if (studentRecord.courses[counter].equals(oldCourse)) {
boolean offered = false;
for (int index = 0; index < coursesOffered.length; index++) {
if (coursesOffered[index].equals(newCourse)) {
                   offered = true;
}
}
if (offered) {
studentRecord.courses[counter] = newCourse;
System.out.println(oldCourse + " updated to " + newCourse);
} else {
System.out.println("New course not offered!");
}
        return;
}
}
System.out.println("Old course not found!");
}
}

public static void updateStudent(String username, String name, Integer age, String city, String zip) {
Student studentRecord = findStudent(username);
if (studentRecord != null) {
if (name != null) studentRecord.name = name;
if (age != null) studentRecord.age = age;
if (city != null) studentRecord.city = city;
if (zip != null) studentRecord.zip = zip;
System.out.println("Student updated!");
}
}

public static void totalStudents() {
System.out.println("Total students: " + totalStudents);
}

public static void main(String[] args) {
        addStudent("john22", "John Paul", 22, "Lagos", "101001", new String[]{"Math", "Physics"});
        displayStudent("john22");
        displayCourses("john22");
        displayZip("john22");
        displayCity("john22");
        addCourse("john22", "Computer Science");
        updateCourse("john22", "Math", "Biology");
        updateStudent("john22", null, 23, "Abuja", null);
        totalStudents();
}
}