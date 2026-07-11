package sis;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import sis.Runner;
import sis.Student;

public class studentNames {
    public static void main(String[] args) {}
    public static void loadStudentsFromFile() {
        File myObj = new File("StudentInfo.txt");

        try (Scanner myReader = new Scanner(myObj)) {
            while (myReader.hasNextLine()) {
                String line = myReader.nextLine().trim();
                if (line.isEmpty()) continue;

                String[] parts = line.split("\\s+");
                if (parts.length < 8) {
                    System.out.println("Invalid entry: " + line);
                    continue;
                }

                String firstName = parts[0];
                String lastName = parts[1];
                String classOne = parts[2];
                String gradeOne = parts[3];
                String classTwo = parts[4];
                String gradeTwo = parts[5];
                String classThree = parts[6];
                String gradeThree = parts[7];

                // AUTO-ASSIGN VALUE: masterList grows → assign sequential IDs
                int assign = Runner.masterList.size();

                Student st = new Student(
                        firstName, lastName,
                        classOne, gradeOne,
                        classTwo, gradeTwo,
                        classThree, gradeThree,
                        assign
                );

                Runner.masterList.add(st);
            }

            System.out.println("All students loaded into masterList.");
        } catch (FileNotFoundException e) {
            System.out.println("Could not open StudentInfo.txt");
            e.printStackTrace();
        }
    }
}