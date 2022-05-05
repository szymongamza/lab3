import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    private JFrame jFrame;
    private StudentTableModel studentTableModel;
    private GroupTableModel groupTableModel;
    private JTable studentTable, groupTable;
    private JScrollPane studentPane,groupPane;
    private JButton jButtonNewStudent, jButtonDeleteStudent, jButtonEditStudent, jButtonNewGroup, jButtonDeleteGroup, jButtonEditGroup;

    public MainFrame() {
        jFrame = new JFrame("StudentTable");
        jFrame.setPreferredSize((new Dimension(700,400)));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        groupTableModel = new GroupTableModel();
        groupTable = new JTable(groupTableModel);
        groupTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JTable target = (JTable)e.getSource();
                int row = target.getSelectedRow();
                studentTableModel.updateTable(groupTableModel.getGroup(row));
            }
        });

        groupTable.setPreferredScrollableViewportSize(new Dimension(300,300));
        groupPane = new JScrollPane(groupTable);

        studentTableModel = new StudentTableModel();
        studentTable = new JTable(studentTableModel);

        studentTable.setPreferredScrollableViewportSize(new Dimension(300,300));
        studentPane = new JScrollPane(studentTable);

        jButtonNewGroup = new JButton("New Group");
        jButtonNewGroup.addActionListener(this);

        jButtonEditGroup = new JButton("Edit Group");
        jButtonEditGroup.addActionListener(this);

        jButtonDeleteGroup = new JButton("Delete Group");
        jButtonDeleteGroup.addActionListener(this);

        jButtonNewStudent = new JButton("New Student");
        jButtonNewStudent.addActionListener(this);

        jButtonEditStudent = new JButton("Edit Student");
        jButtonEditStudent.addActionListener(this);

        jButtonDeleteStudent = new JButton("Delete Student");
        jButtonDeleteStudent.addActionListener(this);

        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 0;
        jFrame.getContentPane().add(groupPane,c);

        c.gridwidth = 3;
        c.gridx=3;
        c.gridy=0;
        jFrame.getContentPane().add(studentPane,c);

        c.gridwidth = 1;
        c.gridx=0;
        c.gridy=1;
        jFrame.getContentPane().add(jButtonNewGroup,c);

        c.gridx=1;
        c.gridy=1;
        jFrame.getContentPane().add(jButtonEditGroup,c);

        c.gridx=2;
        c.gridy=1;
        jFrame.getContentPane().add(jButtonDeleteGroup,c);

        c.gridx=3;
        c.gridy=1;
        jFrame.getContentPane().add(jButtonNewStudent,c);

        c.gridx=4;
        c.gridy=1;
        jFrame.getContentPane().add(jButtonEditStudent,c);

        c.gridx=5;
        c.gridy=1;
        jFrame.getContentPane().add(jButtonDeleteStudent,c);

        jFrame.setVisible(true);
        jFrame.pack();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(("New Student"))) {
            studentTableModel.newStudent();
        } else if (e.getActionCommand().equals("Delete Student")) {
            studentTableModel.deleteStudent(studentTable.getSelectedRow());
        }
        System.out.println("DEBUG");
    }
}




