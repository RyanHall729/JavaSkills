package sis;

import java.util.Scanner;
import java.util.ArrayList;
import sis.Student;
import sis.studentNames;

public class Runner {
    static ArrayList<Student> masterList = new ArrayList<Student>();
    public static void main(String[] args)
    {
        menu();
    }
    public static void menu()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do?");
        System.out.println("Add or Delete Student (Press 1)");
        System.out.println("Change Student Grades/Schedule (Press 2)");
        System.out.println("Sort Students (Press 3)");

        int choice = sc.nextInt();

        if(choice == 1)
        {
            addDeleteStudent();
        }
        else if(choice == 2)
        {
            changeGradeSchedule();
        }
        else if(choice == 3)
        {
            sortStudents();
        }
    }
    public void thisMethodDoesNothing(Student st)
    {
        System.out.println("Name:" + " " + st.getFirstName() + " " + st.getLastName() +
                "\nFirst Period:" + " " + st.getFirstPeriod() + " " + st.getFirstPeriodGrade() +
                "\nSecond Period:" + " " + st.getSecondPeriod() + " " + st.getSecondPeriodGrade() +
                "\nThird Period:" + " " + st.getThirdPeriod() + " " + st.getThirdPeriodGrade());
    }
    public static void addDeleteStudent()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("You are Adding or Deleting a Student. What would you like to do now?");
        System.out.println("Add a Student (Press 1)");
        System.out.println("Delete a Student (Press 2)");
        System.out.println("Go Back (Press 3)");

        int choice = sc.nextInt();

        if(choice == 1)
        {
            addStudent();
        }
        else if(choice == 2)
        {
            deleteStudent();
        }
        else if(choice == 3)
        {
            menu();
        }
    }
    public static void changeGradeSchedule()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("You are changing a grade or a schedule. What would you like to do now?");
        System.out.println("Change Grade (Press 1)");
        System.out.println("Swtich Classes (Press 2)");
        System.out.println("Go Back (Press 3)");

        int choice = sc.nextInt();

        if(choice == 1)
        {
            changeGrade();
        }
        else if(choice == 2)
        {
            switchClass();
        }
        else if(choice == 3)
        {
            menu();
        }
    }
    public static void sortStudents()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("You are Sorting Students. How would you like to sort?");
        System.out.println("Sort by Last Name (Press 1)");
        System.out.println("Sort by GPA (Press 2)");
        System.out.println("Sort by Period (Press 3)");
        System.out.println("Go Back (Press 4)");

        int choice = sc.nextInt();

        if(choice == 1)
        {
            sortLastName();
        }
        else if(choice == 2)
        {
            sortGPA();
        }
        else if(choice == 3)
        {
            sortPeriod();
        }
        else if (choice == 4)
        {
            menu();
        }
    }
    public static void addStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter: first last p1 g1 p2 g2 p3 g3 assign");
        System.out.println("Or type FILE to import all students from StudentInfo.txt");

        String input = sc.nextLine().trim();

        // ---------------------------------------------------------
        // OPTION 1 — LOAD ALL STUDENTS FROM FILE
        // ---------------------------------------------------------
        if (input.equalsIgnoreCase("FILE")) {
            studentNames.loadStudentsFromFile();
            menu();
            return;
        }

        // ---------------------------------------------------------
        // OPTION 2 — ADD A SINGLE STUDENT FROM MANUAL INPUT
        // ---------------------------------------------------------
        String[] parts = input.split("\\s+");

        String firstName = parts[0];
        String lastName = parts[1];
        String classOne = parts[2];
        String gradeOne = parts[3];
        String classTwo = parts[4];
        String gradeTwo = parts[5];
        String classThree = parts[6];
        String gradeThree = parts[7];
        int assign = Integer.parseInt(parts[8]);

        Student st = new Student(
                firstName, lastName,
                classOne, gradeOne,
                classTwo, gradeTwo,
                classThree, gradeThree,
                assign
        );

        masterList.add(st);
        menu();
    }
    public static void deleteStudent()
    {
        // Display all last names
        for (int i = 0; i < masterList.size(); i++)
        {
            System.out.println(masterList.get(i).getAssign());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Delete from List");
        System.out.println("Value");
        int assign = sc.nextInt();

        // Search manually
        int indexNumber = -1;

        for (int i = 0; i < masterList.size(); i++) {
            if (masterList.get(i).getAssign() == assign) {
                indexNumber = i;
                break;
            }
        }

        if(indexNumber == -1)
        {
            System.out.println("Student Not Found");
            menu();
            return;
        }

        masterList.remove(indexNumber);
        System.out.println("Student Removed.");
        menu();
    }
    public static void changeGrade() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student's assign number:");
        int assign = sc.nextInt();
        sc.nextLine(); // clear buffer

        Student st = null;

        for (Student s : masterList) {
            if (s.getAssign() == assign) {
                st = s;
                break;
            }
        }

        if (st == null) {
            System.out.println("Student not found.");
            menu();
            return;
        }

        System.out.println("Which period grade would you like to change?");
        System.out.println("1 = First Period");
        System.out.println("2 = Second Period");
        System.out.println("3 = Third Period");

        int option = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter new grade:");
        String newGrade = sc.nextLine().trim();

        switch(option) {
            case 1: st.setFirstPeriodGrade(newGrade); break;
            case 2: st.setSecondPeriodGrade(newGrade); break;
            case 3: st.setThirdPeriodGrade(newGrade); break;
            default:
                System.out.println("Invalid selection.");
                menu();
                return;
        }

        System.out.println("Grade updated.");
        menu();
    }
    public static void switchClass() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the student's assign number:");
        int assign = sc.nextInt();
        sc.nextLine();

        Student st = null;

        for (Student s : masterList) {
            if (s.getAssign() == assign) {
                st = s;
                break;
            }
        }

        if (st == null) {
            System.out.println("Student not found.");
            menu();
            return;
        }

        System.out.println("Which class do you want to change?");
        System.out.println("1 = First Period");
        System.out.println("2 = Second Period");
        System.out.println("3 = Third Period");

        int choice = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter NEW class name:");
        String newClass = sc.nextLine().trim();

        switch(choice) {
            case 1: st.setFirstPeriod(newClass); break;
            case 2: st.setSecondPeriod(newClass); break;
            case 3: st.setThirdPeriod(newClass); break;
            default:
                System.out.println("Invalid selection.");
                menu();
                return;
        }

        System.out.println("Class updated.");
        menu();
    }
    public static void sortLastName() {
        masterList.sort((a, b) -> a.getLastName().compareToIgnoreCase(b.getLastName()));

        System.out.println("Students sorted by last name:\n");
        for (Student st : masterList) {
            System.out.println(st.getLastName() + ", " + st.getFirstName() +
                    "  (Assign: " + st.getAssign() + ")");
        }

        menu();
    }
    private static double letterToValue(String g) {
        g = g.toUpperCase();
        switch(g) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            case "F": return 0.0;
            default: return 0.0;
        }
    }

    public static void sortGPA() {
        masterList.sort((a, b) -> {
            double gpaA =
                    (letterToValue(a.getFirstPeriodGrade()) +
                            letterToValue(a.getSecondPeriodGrade()) +
                            letterToValue(a.getThirdPeriodGrade())) / 3.0;

            double gpaB =
                    (letterToValue(b.getFirstPeriodGrade()) +
                            letterToValue(b.getSecondPeriodGrade()) +
                            letterToValue(b.getThirdPeriodGrade())) / 3.0;

            return Double.compare(gpaB, gpaA); // descending
        });

        System.out.println("Students sorted by GPA:\n");
        for (Student st : masterList) {
            double gpa =
                    (letterToValue(st.getFirstPeriodGrade()) +
                            letterToValue(st.getSecondPeriodGrade()) +
                            letterToValue(st.getThirdPeriodGrade())) / 3.0;

            System.out.printf("%s %s  GPA: %.2f  (Assign: %d)\n",
                    st.getFirstName(), st.getLastName(), gpa, st.getAssign());
        }

        menu();
    }
    public static void sortPeriod() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Sort by which period?");
        System.out.println("1 = First Period");
        System.out.println("2 = Second Period");
        System.out.println("3 = Third Period");

        int option = sc.nextInt();

        switch(option) {
            case 1:
                masterList.sort((a, b) -> a.getFirstPeriod().compareToIgnoreCase(b.getFirstPeriod()));
                break;
            case 2:
                masterList.sort((a, b) -> a.getSecondPeriod().compareToIgnoreCase(b.getSecondPeriod()));
                break;
            case 3:
                masterList.sort((a, b) -> a.getThirdPeriod().compareToIgnoreCase(b.getThirdPeriod()));
                break;
            default:
                System.out.println("Invalid period.");
                menu();
                return;
        }

        System.out.println("Sorted student list:\n");
        for (Student st : masterList) {
            System.out.println(st.getAssign() + " - " + st.getLastName() + " " + st.getFirstName());
        }

        menu();
    }
}