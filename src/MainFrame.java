import Students.StudentCondition;

import javax.swing.*;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    private final JFrame jFrame;
    private final StudentTableModel studentTableModel;
    private final GroupTableModel groupTableModel;
    private final JTable studentTable;
    private final JTable groupTable;
    private final JScrollPane studentPane;
    private final JScrollPane groupPane;
    private final JButton jButtonNewStudent;
    private final JButton jButtonDeleteStudent;
    private final JButton jButtonEditStudent;
    private final JButton jButtonNewGroup;
    private final JButton jButtonDeleteGroup;
    private final JButton jButtonEditGroup;
    private final JButton jButtonSort;
    private final TableRowSorter tableRowSorter;
    private final JTextField jtextField;
    private final JComboBox jComboBox;

    public MainFrame() {
        jFrame = new JFrame("StudentTable");

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();


        groupTableModel = new GroupTableModel();
        groupTable = new JTable(groupTableModel);
        groupTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable) e.getSource();
                int row = target.getSelectedRow();
                studentTableModel.updateTable(groupTableModel.getGroup(row));
            }
        });


        groupTable.setAutoCreateRowSorter(true);
        groupPane = new JScrollPane(groupTable);

        studentTableModel = new StudentTableModel();
        studentTable = new JTable(studentTableModel);


        studentPane = new JScrollPane(studentTable);

        tableRowSorter = new TableRowSorter<StudentTableModel>(studentTableModel);
        studentTable.setRowSorter(tableRowSorter);

        jButtonNewGroup = new JButton("New Group");
        jButtonNewGroup.addActionListener(this);

        jButtonEditGroup = new JButton("Edit Group");
        jButtonEditGroup.addActionListener(this);

        jButtonDeleteGroup = new JButton("Delete Group");
        jButtonDeleteGroup.addActionListener(this);

        jButtonSort = new JButton("Sort");
        jButtonSort.addActionListener(this);

        jButtonNewStudent = new JButton("New Student");
        jButtonNewStudent.addActionListener(this);

        jButtonEditStudent = new JButton("Edit Student");
        jButtonEditStudent.addActionListener(this);

        jButtonDeleteStudent = new JButton("Delete Student");
        jButtonDeleteStudent.addActionListener(this);

        jtextField = new JTextField();
        jtextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    String query = jtextField.getText();
                    filter(query);
                }
            }
        });

        jComboBox = new JComboBox<StudentCondition>(StudentCondition.values());
        jComboBox.insertItemAt("", 0);
        jComboBox.setSelectedIndex(0);
        jComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getItem() != "") {
                    filter(String.valueOf(e.getItem()));
                } else {
                    filter("");
                }

            }
        });

        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5, 5, 5, 5);
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.5;
        c.weighty = 0.9;
        jFrame.getContentPane().add(groupPane, c);

        c.gridwidth = 3;
        c.gridx = 4;
        c.gridy = 0;
        jFrame.getContentPane().add(studentPane, c);


        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.9;
        c.weighty = 0.01;
        c.gridwidth = 6;
        c.gridx = 0;
        c.gridy = 1;
        jFrame.getContentPane().add(jtextField, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.1;
        c.weighty = 0.01;
        c.gridwidth = 1;
        c.gridx = 6;
        c.gridy = 1;
        jFrame.getContentPane().add(jComboBox, c);


        c.anchor = GridBagConstraints.PAGE_END;
        c.weighty = 0.01;
        c.weightx = 0.1;
        c.gridwidth = 1;
        c.gridx = 0;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonNewGroup, c);

        c.gridx = 1;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonEditGroup, c);

        c.gridx = 2;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonDeleteGroup, c);

        c.gridx = 3;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonSort, c);

        c.gridx = 4;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonNewStudent, c);

        c.gridx = 5;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonEditStudent, c);

        c.gridx = 6;
        c.gridy = 2;
        jFrame.getContentPane().add(jButtonDeleteStudent, c);

        jFrame.setVisible(true);
        jFrame.pack();


    }

    private void filter(String query) {
        tableRowSorter.setRowFilter(RowFilter.regexFilter(query));
    }

    private double inputPoints() {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(jFrame, "Enter Student Points:");
                double a = Double.parseDouble(input);
                return a;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Input must be a number");
            }
        }
    }

    private int inputMaxStudents() {

        while (true) {
            try {
                String input = JOptionPane.showInputDialog(jFrame, "Enter max number of students in group:");
                int a = Integer.parseInt(input);
                if (a <= 0) {
                    throw new IncorrectNumberException("Incorrect number!");
                }
                return a;
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "Input must be a number!");
            } catch (IncorrectNumberException ine) {
                JOptionPane.showMessageDialog(null, "Input must be a number higher than 0!");
            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        try {
        if (e.getActionCommand().equals(("New Student"))) {
            try {
                int max = Integer.parseInt((groupTableModel.getValueAt(groupTable.getSelectedRow(), 2)).toString());
                int students = Integer.parseInt((groupTableModel.getValueAt(groupTable.getSelectedRow(), 1)).toString());
                if (students < max) {
                    String studentName = JOptionPane.showInputDialog(jFrame, "Enter Student Name:");
                    String studentSurname = JOptionPane.showInputDialog(jFrame, "Enter Student Surname:");
                    double studentPoints = inputPoints();
                    StudentCondition[] choices = StudentCondition.values();
                    String studentCondition = JOptionPane.showInputDialog(jFrame, "Choose Condition", null, JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]).toString();
                    studentTableModel.newStudent(studentName, studentSurname, StudentCondition.valueOf(studentCondition), studentPoints);
                }
            }catch(IndexOutOfBoundsException ioobe){
                JOptionPane.showMessageDialog(null, "You must select group first!");
            }

        } else if (e.getActionCommand().equals("Delete Student")) {
            if(studentTable.getSelectedRow() >= 0) {
                studentTableModel.deleteStudent(studentTable.getSelectedRow());
            }else{
                JOptionPane.showMessageDialog(null, "You have to select student to delete him");
            }

        } else if (e.getActionCommand().equals("Edit Student")) {
            if(studentTable.getSelectedRow() >= 0) {
                String studentName = JOptionPane.showInputDialog(jFrame, "Enter Student Name:");
                String studentSurname = JOptionPane.showInputDialog(jFrame, "Enter Student Surname:");
                double studentPoints = inputPoints();
                StudentCondition[] choices = StudentCondition.values();
                String studentCondition = JOptionPane.showInputDialog(jFrame, "Choose Condition", null, JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]).toString();
                studentTableModel.setValueAt(studentName, studentTable.getSelectedRow(), 0);
                studentTableModel.setValueAt(studentSurname, studentTable.getSelectedRow(), 1);
                studentTableModel.setValueAt(StudentCondition.valueOf(studentCondition), studentTable.getSelectedRow(), 2);
                studentTableModel.setValueAt(studentPoints, studentTable.getSelectedRow(), 3);
            }else{
                JOptionPane.showMessageDialog(null, "You have to select student to edit him");
            }

        } else if (e.getActionCommand().equals("New Group")) {
            String groupName = JOptionPane.showInputDialog(jFrame, "Enter Group Name:");
            int groupMaxStudents = inputMaxStudents();
            groupTableModel.newGroup(groupName, groupMaxStudents);

        } else if (e.getActionCommand().equals("Delete Group")) {
            if(groupTable.getSelectedRow() >= 0) {
                groupTableModel.deleteGroup(groupTable.getSelectedRow());
            }else{
                JOptionPane.showMessageDialog(null, "You have to select group to delete it");
            }

        } else if (e.getActionCommand().equals("Edit Group")) {
            if(groupTable.getSelectedRow() >= 0) {
                String groupName = JOptionPane.showInputDialog(jFrame, "Enter Group Name:");
                int groupMaxStudents = inputMaxStudents();
                groupTableModel.setValueAt(groupName, groupTable.getSelectedRow(), 0);
                groupTableModel.setValueAt(groupMaxStudents, groupTable.getSelectedRow(), 2);
            }else{
                JOptionPane.showMessageDialog(null, "You have to select group to edit it");
            }

        } else if (e.getActionCommand().equals("Sort")) {
            studentTable.getRowSorter().toggleSortOrder(3);
        }
    }catch(IndexOutOfBoundsException indexOutOfBoundsException){
        JOptionPane.showMessageDialog(null, "Something went wrong ;)");
    }
    }
}




