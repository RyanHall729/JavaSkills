package analyzer;

import java.util.ArrayList;
import java.util.Collections;

public class Analyzer
{
    static ArrayList<Integer> grade = new ArrayList<>();

    public static ArrayList<Integer> getGrade() {
        grade.add(85);
        grade.add(92);
        grade.add(47);
        grade.add(63);
        grade.add(78);
        grade.add(91);
        grade.add(55);
        grade.add(100);
        return grade;
    }

    public static void main(String[] args)
    {
        double sum = 0;
        for (int num : grade)
        {
            sum += num;
        }
        double average = sum / grade.size();

        int max = Collections.max(grade);
        int min = Collections.min(grade);

    }
}