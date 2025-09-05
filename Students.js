const prompt = require('prompt-sync')();

class Student {
  constructor(username, name, age, city, zip, courses) {
    this.username = username;
    this.name = name;
    this.age = age;
    this.city = city;
    this.zip = zip;
    this.courses = courses;
}
}

const students = [];
const coursesOffered = [
  "Math", "Physics", "Computer Science", "Biology", "Chemistry",
  "Statistics", "English", "Economics", "History", "Philosophy",
  "Sociology", "Political Science", "Geography", "Psychology", "Art",
  "Music", "Engineering", "Law", "Medicine", "Business"
];

function addStudent() {
  const username = prompt("Enter username: ");
  const name = prompt("Enter name: ");
  const age = parseInt(prompt("Enter age: "));
  const city = prompt("Enter city: ");
  const zip = prompt("Enter zip code: ");
  const courseInput = prompt("Enter courses (comma-separated): ");
  const courses = courseInput.split(",").map(c => c.trim());
  const newStudent = new Student(username, name, age, city, zip, courses);
  students.push(newStudent);
  console.log("Student added successfully!");
}

function findStudent(username) {
  return students.find(student => student.username === username);
}

function displayStudent() {
  const username = prompt("Enter username to display: ");
  const student = findStudent(username);
  if (student) {
    console.log(`Name: ${student.name}, Age: ${student.age}, City: ${student.city}, Zip: ${student.zip}, Courses: ${student.courses.join(", ")}`);
} else {
    console.log("Student not found.");
}
}

function addCourse() {
  const username = prompt("Enter username: ");
  const course = prompt("Enter course to add: ");
  const student = findStudent(username);
  if (student) {
    if (!coursesOffered.includes(course)) {
      console.log("Course not offered.");
} else if (student.courses.includes(course)) {
      console.log("Course already exists.");
} else {
      student.courses.push(course);
      console.log(`${course} added successfully!`);
}
} else {
    console.log("Student not found.");
}
}

function updateCourse() {
  const username = prompt("Enter username: ");
  const oldCourse = prompt("Enter course to replace: ");
  const newCourse = prompt("Enter new course: ");
  const student = findStudent(username);
  if (student) {
    const index = student.courses.indexOf(oldCourse);
    if (index !== -1 && coursesOffered.includes(newCourse)) {
      student.courses[index] = newCourse;
      console.log(`${oldCourse} updated to ${newCourse}`);
} else {
      console.log("Invalid course update.");
}
} else {
    console.log("Student not found.");
}
}

function updateStudent() {
  const username = prompt("Enter username: ");
  const student = findStudent(username);
  if (student) {
    const name = prompt("Enter new name (or leave blank): ");
    const ageInput = prompt("Enter new age (or leave blank): ");
    const city = prompt("Enter new city (or leave blank): ");
    const zip = prompt("Enter new zip (or leave blank): ");

    if (name) student.name = name;
    if (ageInput) student.age = parseInt(ageInput);
    if (city) student.city = city;
    if (zip) student.zip = zip;

    console.log("Student updated!");
} else {
    console.log("Student not found.");
}
}

function totalStudents() {
  console.log(`Total students: ${students.length}`);
}


while (true) {
  console.log("\n--- Student Management System ---");
  console.log("1. Add Student");
  console.log("2. Display Student");
  console.log("3. Add Course");
  console.log("4. Update Course");
  console.log("5. Update Student");
  console.log("6. Total Students");
  console.log("7. Exit");

  const choice = prompt("Choose an option: ");
  switch (choice) {
    case "1": addStudent(); break;
    case "2": displayStudent(); break;
    case "3": addCourse(); break;
    case "4": updateCourse(); break;
    case "5": updateStudent(); break;
    case "6": totalStudents(); break;
    case "7": console.log("Goodbye!"); process.exit();
    default: console.log("Invalid choice.");
}
}
