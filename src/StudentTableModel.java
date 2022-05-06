import Students.StudentCondition;

import javax.swing.table.AbstractTableModel;

class StudentTableModel extends AbstractTableModel {
    private String[] cols = {"Name", "Surname", "Condition", "Points"};
    StudentManager studentManager;

    public StudentTableModel() {
        studentManager = new StudentManager();
    }

    public Object getValueAt(int r, int c) {
        if (c == 0) {
            return studentManager.getStudentName(r);
        } else if (c == 1) {
            return studentManager.getStudentSurname(r);
        } else if (c == 2) {
            return studentManager.getStudentCondition(r);
        } else if (c == 3) {
            return studentManager.getStudentPoint(r);
        }
        return null;
    }

    public int getColumnCount() {
        return 4;
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
            studentManager.setStudentCondition(r, (StudentCondition) value);
        } else if (c == 3) {
            studentManager.setStudentPoints(r, (Double) value);
        }
        fireTableCellUpdated(r, c);
    }

    public boolean isCellEditable(int r, int c) {
        return false;
    }

    public void newStudent(String name, String surname, StudentCondition condition, Double points) {
        studentManager.addStudent(name, surname, condition, points);
        fireTableDataChanged();
    }

    public void deleteStudent(int index) {
        studentManager.deleteStudent(index);
        fireTableDataChanged();
    }

    public void updateTable(StudentManager s) {
        studentManager = s;
        fireTableDataChanged();
    }
}
