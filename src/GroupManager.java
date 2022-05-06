import java.util.ArrayList;

class GroupManager {
    private ArrayList<String> names;
    private ArrayList<StudentManager> studentsList;
    private ArrayList<Integer> maxesNumberOfStudents;


    public GroupManager() {
        names = new ArrayList();
        studentsList = new ArrayList();
        maxesNumberOfStudents = new ArrayList();
    }

    public void setGroupName(int index, String name) {
        names.remove(index);
        names.add(index, name);
    }

    public void setMaxNumberOfStudents(int index, Integer maxNumber) {
        maxesNumberOfStudents.remove(index);
        maxesNumberOfStudents.add(index, maxNumber);
    }

    public void addGroup(String name, Integer maxNumber) {
        names.add(name);
        studentsList.add(new StudentManager());
        maxesNumberOfStudents.add(maxNumber);

    }

    public void deleteGroup(int index) {
        names.remove(index);
        maxesNumberOfStudents.remove(index);

    }

    public String getGroupName(int index) {
        return names.get(index);

    }

    public StudentManager getListOfStudents(int index) {
        return studentsList.get(index);
    }

    public int getNumberOfStudents(int index) {
        StudentManager a = getListOfStudents(index);
        return a.size();
    }

    public Integer getMaxNumberOfStudents(int index) {
        return maxesNumberOfStudents.get(index);

    }

    public int size() {
        return names.size();
    }

}