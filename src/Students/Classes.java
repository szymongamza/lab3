package Students;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Classes {
    public List<Student> getStudentList() {
        return studentList;
    }

    private final String name;
    private final List<Student> studentList = new ArrayList();
    private final int maxNumberOfStudents;

    public String getName() {
        return name;
    }

    public int getMaxNumberOfStudents() {
        return maxNumberOfStudents;
    }

    public Classes(String name, int maxNumberOfStudents) {
        this.name = name;
        this.maxNumberOfStudents = maxNumberOfStudents;

    }
    public Classes(String name, int maxNumberOfStudents, Student student) {
        this.name = name;
        this.maxNumberOfStudents = maxNumberOfStudents;
        this.studentList.add(student);

    }

    public void addStudent(Student student){
        int result = 1;
        if(maxNumberOfStudents > studentList.size()){
            for (Student x:studentList) {
                result = student.compareTo(x);
                if(result == 0){
                    System.err.println("Student is already in this group");
                    break;
                }
            }
            if (result!=0) {
                studentList.add(student);
            }
        }else{
         System.out.println("Too much students in group");
        }
    }
    public void addPoints(Student student, double points){
        double tempPoints = student.getPoints();
        tempPoints +=points;
        student.setPoints(tempPoints);
    }
    public void getStudent(Student student){
        if(student.getPoints() <= 0){
            studentList.remove(student);
        }
    }
    public void changeCondition(Student student,StudentCondition studentCondition){
        student.setStudentCondition(studentCondition);
    }
    public void removePoints(Student student, double points){
        double tempPoints = student.getPoints();
        tempPoints -=points;
        if(tempPoints < 0){
            tempPoints = 0;
        }
        student.setPoints(tempPoints);
    }
    public Student search(String surname){
        int result;
        for (Student x:studentList) {
            result = surname.compareTo(x.getSurname());
            if(result == 0){
                return x;
            }
        }
        return null;
    }
    public List<Student> searchPartial(String arg){
        List<Student> tempList = new ArrayList();
        boolean resultSurname;
        boolean resultName;
            for (Student x:studentList) {
                resultSurname = x.getSurname().contains(arg);
                resultName= x.getName().contains(arg);
                if(resultSurname || resultName ){
                    tempList.add(x);
                }
            }
            return tempList;
    }
    public int countByCondition(StudentCondition studentCondition){
        boolean result;
        int count=0;
        for (Student x:studentList) {
            result = x.getStudentCondition().equals(studentCondition);
            if(result){
                count++;
            }
        }
        return count;
    }
    public void summary(){
        for (Student x:studentList) {
            System.out.println(x);
        }
    }
    public List<Student> sortByName(){
        List<Student> tempList = studentList;
        Collections.sort(tempList);
        return tempList;
    }
    public List<Student> sortByPoints(){
        List<Student> tempList = studentList;
        Collections.sort(tempList, new PointsComparator().reversed());
        return tempList;
    }
    public Student findStudentWithBiggestAmountOfPoints(){
        Student o;
        o = Collections.max(studentList, new PointsComparator());
        return o;
    }

    public int getActualSize(){
        return studentList.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
