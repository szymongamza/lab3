import javax.swing.*;

public class Main {

    public static void main(String[] args) {
/*        Student student1 = new Student("Bzymon","gamza", StudentCondition.PRESENT, 1997,8);
        Student student2 = new Student("szymon","gamza", StudentCondition.PRESENT, 1997,10);
        Student student3 = new Student("Cymon","damza", StudentCondition.PRESENT, 1997,7);
        Student student4 = new Student("Azymon","samze", StudentCondition.PRESENT, 1997,5);
        Classes firstClass = new Classes("FirstClass",3);
        firstClass.addStudent(student1);
        //firstClass.addStudent(student2); //Add student, that already is added
        firstClass.addStudent(student3);
        firstClass.addStudent(student4);
        System.out.println(firstClass.search("gamza")); // Find student with exact surname
        System.out.println(firstClass.searchPartial("szym")); // Find students that name/surname contains arg String
        System.out.println(firstClass.countByCondition(StudentCondition.PRESENT)); // Count students by condition
        //firstClass.removePoints(student3,10);
        firstClass.getStudent(student3);
        firstClass.summary();
        System.out.println(student3);
        System.out.println(firstClass.sortByName());
        System.out.println(firstClass.sortByPoints());
        System.out.println(firstClass.findStudentWithBiggestAmountOfPoints());

        ClassContainer container = new ClassContainer();
        container.addClass("SecondClass",10);
        Classes classes = container.classesMap.get("SecondClass");
        classes.addStudent(new Student("Daniel","Kubik", StudentCondition.ABSENT,1995, 25));
        classes.addStudent(new Student("Saniel","Aubik", StudentCondition.ABSENT,1995, 25));
        container.summary();

        container.addClass("ThirdClass", 10);
        classes = container.classesMap.get("ThirdClass");
        System.out.println(container.findEmpty());
        */
        //SWING
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainFrame();
            }
        });

    }
}
