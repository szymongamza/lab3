import Students.StudentCondition;

import java.util.ArrayList;

class StudentManager {
    private ArrayList<String> names;
    private ArrayList<String> surnames;
    private ArrayList<StudentCondition> conditions;
    private ArrayList<Double> points;

    public StudentManager() {
        names = new ArrayList();
        surnames = new ArrayList();
        conditions = new ArrayList();
        points = new ArrayList();
    }

    public void setStudentName(int index, String name) {
        names.remove(index);
        names.add(index, name);
    }

    public void setStudentSurname(int index, String surname) {
        surnames.remove(index);
        surnames.add(index, surname);
    }

    public void setStudentCondition(int index, StudentCondition studentCondition) {
        conditions.remove(index);
        conditions.add(index, studentCondition);
    }

    public void setStudentPoints(int index, Double point) {
        points.remove(index);
        points.add(index, point);
    }

    public void addStudent(String name, String surname, StudentCondition condition, Double point) {
        names.add(name);
        surnames.add(surname);
        conditions.add(condition);
        points.add(point);

    }

    public void deleteStudent(int index) {
        names.remove(index);
        surnames.remove(index);
        conditions.remove(index);
        points.remove(index);

    }

    public String getStudentName(int index) {
        return names.get(index);

    }

    public String getStudentSurname(int index) {
        return surnames.get(index);

    }

    public StudentCondition getStudentCondition(int index) {
        return conditions.get(index);

    }

    public Double getStudentPoint(int index) {
        return points.get(index);

    }

    public int size() {
        return names.size();
    }

}