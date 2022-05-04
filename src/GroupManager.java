import java.util.ArrayList;

class GroupManager {
    private ArrayList<String> names;
    private ArrayList<Integer> numbersOfStudents;
    private ArrayList<Integer> maxesNumberOfStudents;


    public GroupManager() {
        names = new ArrayList();
        numbersOfStudents = new ArrayList();
        maxesNumberOfStudents = new ArrayList();
    }

    public void setGroupName(int index, String name) {
        names.remove(index);
        names.add(index, name);
    }


    public void setNumberOfStudents(int index, Integer number) {
        numbersOfStudents.remove(index);
        numbersOfStudents.add(index, number);
    }

    public void setMaxNumberOfStudents(int index, Integer maxNumber) {
        maxesNumberOfStudents.remove(index);
        maxesNumberOfStudents.add(index, maxNumber);
    }

    public void addGroup(String name, Integer number, Integer maxNumber) {
        names.add(name);
        numbersOfStudents.add(number);
        maxesNumberOfStudents.add(maxNumber);

    }

    public void deleteGroup(int index) {
        names.remove(index);
        numbersOfStudents.remove(index);
        maxesNumberOfStudents.remove(index);

    }

    public String getGroupName(int index) {
        return names.get(index);

    }
    public Integer getNumberOfStudents(int index) {
        return numbersOfStudents.get(index);

    }
    public Integer getMaxNumberOfStudents(int index) {
        return maxesNumberOfStudents.get(index);

    }

    public int size(){
        return names.size();
    }

}