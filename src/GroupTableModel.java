import javax.swing.table.AbstractTableModel;

class GroupTableModel extends AbstractTableModel {
    private String[] cols = {"Group name", "students", "max"};
    GroupManager groupManager;

    public GroupTableModel() {
        groupManager = new GroupManager();
        groupManager.addGroup("Pierwsza", 10);
    }

    public Object getValueAt(int r, int c) {
        if (c == 0) {
            return groupManager.getGroupName(r);
        } else if (c == 1) {
            return groupManager.getNumberOfStudents(r);
        } else if (c == 2) {
            return groupManager.getMaxNumberOfStudents(r);
        }
        return null;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return groupManager.size();
    }

    public String getColumnName(int c) {
        return cols[c];
    }

    public boolean isCellEditable(int r,int c){
        return false;
    }

    public void newGroup(){
        groupManager.addGroup("Name Here", 2);
        fireTableDataChanged();
    }
    public void deleteGroup(int index){
        groupManager.deleteGroup(index);
        fireTableDataChanged();
    }
    public StudentManager getGroup(int index){
        return groupManager.getListOfStudents(index);
    }
}
