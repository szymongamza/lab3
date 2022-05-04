import javax.swing.table.AbstractTableModel;

class GroupTableModel extends AbstractTableModel {
    private String[] cols = {"Group name", "students", "max"};
    GroupManager groupManager;

    public GroupTableModel() {
        groupManager = new GroupManager();
        groupManager.addGroup("1", 0, 1);
    }

    public Object getValueAt(int r, int c) {
        if (c == 0) {
            return groupManager.getGroupName(r);
        } else if (c == 1) {
            return groupManager.getNumberOfStudents(r);
        } else if (c == 2) {
            return groupManager.getNumberOfStudents(r);
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

    public void setValueAt(Object value, int r, int c) {
        if (c == 0) {
            groupManager.setGroupName(r, (String) value);
        } else if (c == 1) {
            groupManager.setNumberOfStudents(r, (Integer) value);
        } else if (c == 2) {
            groupManager.setMaxNumberOfStudents(r, (Integer) value);
        }
        fireTableCellUpdated(r, c);
    }
    public boolean isCellEditable(int r,int c){
        return true;
    }

    public void newGroup(){
        groupManager.addGroup("Name Here", 0, 2);
        fireTableDataChanged();
    }
    public void deleteGroup(int index){
        groupManager.deleteGroup(index);
        fireTableDataChanged();
    }
}
