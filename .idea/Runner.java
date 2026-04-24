package sis;

import java.util.Scanner;
import java.util.ArrayList;

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
    public static void addStudent()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Add First Name");
        String firstName = sc.nextLine();
        System.out.println("Add Last Name");
        String lastName = sc.nextLine();
        System.out.println("Add Period 1 & Grade");
        String period1Raw = sc.nextLine();
        String[] period1Dual = period1Raw.split(" ");
        String classOne = period1Dual[0];
        String gradeOne = period1Dual[1];
        System.out.println("Add Period 2 & Grade");
        String period2Raw = sc.nextLine();
        String[] period2Dual = period2Raw.split(" ");
        String classTwo = period2Dual[0];
        String gradeTwo = period2Dual[1];
        System.out.println("Add Period 3 & Grade");
        String period3Raw = sc.nextLine();
        String[] period3Dual = period3Raw.split(" ");
        String classThree = period3Dual[0];
        String gradeThree = period3Dual[1];
        Student st = new Student(firstName, lastName, classOne, gradeOne, classTwo, gradeTwo, classThree, gradeThree);
        masterList.add(st);
        menu();
    }
    public static void deleteStudent()
    {
        // Display all last names
        for (int i = 0; i < masterList.size(); i++)
        {
            System.out.println(masterList.get(i).getLastName());
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Delete from List");
        System.out.println("Last Name");
        String lastName = sc.nextLine();

        // Search manually
        int indexNumber = -1;
        for(int i = 0; i < masterList.size(); i++)
        {
            if(masterList.get(i).getLastName().equalsIgnoreCase(lastName))
            {
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
    public static void changeGrade() {}
    public static void switchClass() {}
    public static void sortLastName() {}
    public static void sortGPA() {}
    public static void sortPeriod() {}
}
