package Students;

public class Student implements Comparable<Student> {
    private String name;
    private String surname;
    private StudentCondition studentCondition;
    private int yearOfBirth;
    private double points;

    public Student(String name, String surname, StudentCondition studentCondition, int yearOfBirth, double points) {
        this.name = name;
        this.surname = surname;
        this.studentCondition = studentCondition;
        this.yearOfBirth = yearOfBirth;
        this.points = points;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public StudentCondition getStudentCondition() {
        return studentCondition;
    }

    public void setStudentCondition(StudentCondition studentCondition) {
        this.studentCondition = studentCondition;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }



    @Override
    public String toString() {
        return name + " " + surname +" "+ studentCondition +" "+ yearOfBirth + " " + points;
    }

    @Override
    public int compareTo(Student o) {
        return o.surname.compareTo(surname);
    }
}

