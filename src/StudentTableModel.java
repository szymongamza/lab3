import javax.swing.table.AbstractTableModel;

class StudentTableModel extends AbstractTableModel {
    private String[] cols = {"Name", "Surname", "Points"};
    StudentManager studentManager;

    public StudentTableModel() {
        studentManager = new StudentManager();
        studentManager.addStudent("a","a",1.0);
    }

    public Object getValueAt(int r, int c) {
        if (c == 0) {
            return studentManager.getStudentName(r);
        } else if (c == 1) {
            return studentManager.getStudentSurname(r);
        } else if (c == 2) {
            return studentManager.getStudentPoint(r);
        }
        return null;
    }

    public int getColumnCount() {
        return 3;
    }

    public int getRowCount() {
        return studentManager.size();
    }

    public String getColumnName(int c) {
        return cols[c];
    }

    public void setValueAt(Object value, int r, int c) {
        if (c == 0) {
            studentManager.setStudentName(r, (String) value);
        } else if (c == 1) {
            studentManager.setStudentSurname(r, (String) value);
        } else if (c == 2) {
            studentManager.setStudentPoints(r, (Double) value);
        }
        fireTableCellUpdated(r, c);
    }
    public boolean isCellEditable(int r,int c){
        return true;
    }

    public void newStudent(){
        studentManager.addStudent("Name Here", "Surname Here", 10.0);
        fireTableDataChanged();
    }
    public void deleteStudent(int index){
        studentManager.deleteStudent(index);
        fireTableDataChanged();
    }

    public void updateTable(StudentManager s){
        studentManager = s;
        fireTableDataChanged();
    }
}
