import javax.swing.table.AbstractTableModel;

class GroupTableModel extends AbstractTableModel {
    private String[] cols = {"Group name", "students", "max"};
    GroupManager groupManager;

    public GroupTableModel() {
        groupManager = new GroupManager();
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

    public void setValueAt(Object value, int r, int c) {
        if (c == 0) {
            groupManager.setGroupName(r, (String) value);
        } else if (c == 2) {
            groupManager.setMaxNumberOfStudents(r, (Integer) value);
        }
        fireTableCellUpdated(r, c);
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

    public boolean isCellEditable(int r, int c) {
        return false;
    }

    public void newGroup(String name, int max) {
        groupManager.addGroup(name, max);
        fireTableDataChanged();
    }

    public void deleteGroup(int index) {
        groupManager.deleteGroup(index);
        fireTableDataChanged();
    }

    public StudentManager getGroup(int index) {
        return groupManager.getListOfStudents(index);
    }
}
