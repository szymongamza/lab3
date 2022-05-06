import Students.StudentCondition;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    private JFrame jFrame;
    private StudentTableModel studentTableModel;
    private GroupTableModel groupTableModel;
    private JTable studentTable, groupTable;
    private JScrollPane studentPane, groupPane;
    private JButton jButtonNewStudent, jButtonDeleteStudent, jButtonEditStudent, jButtonNewGroup, jButtonDeleteGroup, jButtonEditGroup, jButtonSort;
    private TableRowSorter tableRowSorter;
    private JTextField jtextField;

    public MainFrame() {
        jFrame = new JFrame("StudentTable");
        //jFrame.setPreferredSize((new Dimension(1100, 600)));
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

        //groupTable.setPreferredScrollableViewportSize(new Dimension(450, 300));
        groupTable.setAutoCreateRowSorter(true);
        groupPane = new JScrollPane(groupTable);

        studentTableModel = new StudentTableModel();
        studentTable = new JTable(studentTableModel);

        //studentTable.setPreferredScrollableViewportSize(new Dimension(450, 300));
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
        //jtextField.setPreferredSize(new Dimension(800,25));
        jtextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    String query = jtextField.getText();
                    filter(query);
                }
            }
        });
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(5,5,5,5);
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
        c.weightx = 1;
        c.weighty = 0.01;
        c.gridwidth = 7;
        c.gridx = 0;
        c.gridy = 1;
        jFrame.getContentPane().add(jtextField,c);


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
    private void filter(String query){
        tableRowSorter.setRowFilter(RowFilter.regexFilter(query));
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(("New Student"))) {
            int max = Integer.parseInt((groupTableModel.getValueAt(groupTable.getSelectedRow(), 2)).toString());
            int students = Integer.parseInt((groupTableModel.getValueAt(groupTable.getSelectedRow(), 1)).toString());
            if (students < max) {
                String studentName = JOptionPane.showInputDialog(jFrame, "Enter Student Name:");
                String studentSurname = JOptionPane.showInputDialog(jFrame, "Enter Student Surname:");
                String studentPoints = JOptionPane.showInputDialog(jFrame, "Enter Student Points:");
                StudentCondition[] choices = StudentCondition.values();
                String studentCondition = JOptionPane.showInputDialog(jFrame, "Choose Condition", null, JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]).toString();
                studentTableModel.newStudent(studentName, studentSurname, StudentCondition.valueOf(studentCondition), Double.parseDouble(studentPoints));
            }
        } else if (e.getActionCommand().equals("Delete Student")) {
            studentTableModel.deleteStudent(studentTable.getSelectedRow());
        } else if (e.getActionCommand().equals("Edit Student")) {
            String studentName = JOptionPane.showInputDialog(jFrame, "Enter Student Name:");
            String studentSurname = JOptionPane.showInputDialog(jFrame, "Enter Student Surname:");
            String studentPoints = JOptionPane.showInputDialog(jFrame, "Enter Student Points:");
            StudentCondition[] choices = StudentCondition.values();
            String studentCondition = JOptionPane.showInputDialog(jFrame, "Choose Condition", null, JOptionPane.QUESTION_MESSAGE, null, choices, choices[1]).toString();
            studentTableModel.setValueAt(studentName, studentTable.getSelectedRow(), 0);
            studentTableModel.setValueAt(studentSurname, studentTable.getSelectedRow(), 1);
            studentTableModel.setValueAt(StudentCondition.valueOf(studentCondition), studentTable.getSelectedRow(), 2);
            studentTableModel.setValueAt(Double.parseDouble(studentPoints), studentTable.getSelectedRow(), 3);
        } else if (e.getActionCommand().equals("New Group")) {
            String groupName = JOptionPane.showInputDialog(jFrame, "Enter Group Name:");
            String groupMaxStudents = JOptionPane.showInputDialog(jFrame, "Enter max number of students in group:");
            groupTableModel.newGroup(groupName, Integer.parseInt(groupMaxStudents));
        } else if (e.getActionCommand().equals("Delete Group")) {
            groupTableModel.deleteGroup(groupTable.getSelectedRow());
        } else if (e.getActionCommand().equals("Edit Group")) {
            String groupName = JOptionPane.showInputDialog(jFrame, "Enter Group Name:");
            String groupMaxStudents = JOptionPane.showInputDialog(jFrame, "Enter max number of students in group:");
            groupTableModel.setValueAt(groupName, groupTable.getSelectedRow(), 0);
            groupTableModel.setValueAt(Integer.parseInt(groupMaxStudents), groupTable.getSelectedRow(), 2);
        } else if (e.getActionCommand().equals("Sort")) {
            studentTable.getRowSorter().toggleSortOrder(3);
        }
    }
}




