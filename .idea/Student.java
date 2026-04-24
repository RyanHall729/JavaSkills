package sis;

public class Student {
    String firstName;
    String lastName;
    String firstPeriod;
    String firstPeriodGrade;
    String secondPeriod;
    String secondPeriodGrade;
    String thirdPeriod;
    String thirdPeriodGrade;

    public Student(String firstName,
                   String lastName,
                   String firstPeriod,
                   String firstPeriodGrade,
                   String secondPeriod,
                   String secondPeriodGrade,
                   String thirdPeriod,
                   String thirdPeriodGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstPeriod = firstPeriod;
        this.firstPeriodGrade = firstPeriodGrade;
        this.secondPeriod = secondPeriod;
        this.secondPeriodGrade = secondPeriodGrade;
        this.thirdPeriod = thirdPeriod;
        this.thirdPeriodGrade = thirdPeriodGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstPeriod() {
        return firstPeriod;
    }

    public void setFirstPeriod(String firstPeriod) {
        this.firstPeriod = firstPeriod;
    }

    public String getFirstPeriodGrade() {
        return firstPeriodGrade;
    }

    public void setFirstPeriodGrade(String firstPeriodGrade) {
        this.firstPeriodGrade = firstPeriodGrade;
    }

    public String getSecondPeriod() {
        return secondPeriod;
    }

    public void setSecondPeriod(String secondPeriod) {
        this.secondPeriod = secondPeriod;
    }

    public String getSecondPeriodGrade() {
        return secondPeriodGrade;
    }

    public void setSecondPeriodGrade(String secondPeriodGrade) {
        this.secondPeriodGrade = secondPeriodGrade;
    }

    public String getThirdPeriod() {
        return thirdPeriod;
    }

    public void setThirdPeriod(String thirdPeriod) {
        this.thirdPeriod = thirdPeriod;
    }

    public String getThirdPeriodGrade() {
        return thirdPeriodGrade;
    }

    public void setThirdPeriodGrade(String thirdPeriodGrade) {
        this.thirdPeriodGrade = thirdPeriodGrade;
    }


}
