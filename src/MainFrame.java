import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MainFrame extends JFrame implements ActionListener {
    private JFrame jFrame;
    private StudentTableModel studentTableModel;
    private GroupTableModel groupTableModel;
    private JTable studentTable, groupTable;
    private JScrollPane studentPane,groupPane;
    private JButton jButtonNew, jButtonDelete, jButtonEdit;

    public MainFrame() {
        jFrame = new JFrame("StudentTable");
        jFrame.setPreferredSize((new Dimension(700,400)));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout());

        groupTableModel = new GroupTableModel();
        groupTable = new JTable(groupTableModel);
        groupTable.setPreferredScrollableViewportSize(new Dimension(300,300));
        groupPane = new JScrollPane(groupTable);

        studentTableModel = new StudentTableModel();
        studentTable = new JTable(studentTableModel);
        studentTable.setPreferredScrollableViewportSize(new Dimension(300,300));
        studentPane = new JScrollPane(studentTable);

        jButtonNew = new JButton("New Student");
        jButtonNew.addActionListener(this);

        jButtonEdit = new JButton("Edit Student");
        jButtonEdit.addActionListener(this);

        jButtonDelete = new JButton("Delete Student");
        jButtonDelete.addActionListener(this);

        jFrame.getContentPane().add(groupPane);
        jFrame.getContentPane().add(studentPane);


        jFrame.getContentPane().add(jButtonNew);
        jFrame.getContentPane().add(jButtonEdit);
        jFrame.getContentPane().add(jButtonDelete);

        jFrame.setVisible(true);
        jFrame.pack();


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals(("New Student"))){
            studentTableModel.newStudent();
        }else if (e.getActionCommand().equals("Delete Student")){
            studentTableModel.deleteStudent(studentTable.getSelectedRow());
        }
    }
}




