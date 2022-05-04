package Students;

import java.util.*;

public class ClassContainer {
    public Map<String, Classes> classesMap = new TreeMap<>();


    public void addClass(String s, int i) {
        classesMap.put(s, new Classes(s,i));
    }

    public void removeClass(String s) {
        classesMap.remove(s);
    }

    public List<Classes> findEmpty() {
        Set<Map.Entry<String, Classes>> entries = classesMap.entrySet();
        Iterator<Map.Entry<String, Classes>> entryIterator = entries.iterator();
        List<Classes> classesList = new ArrayList<>();
        while (entryIterator.hasNext()) {
            Map.Entry<String, Classes> entry = entryIterator.next();
            Classes c = entry.getValue();
            int i = c.getActualSize();
            if (i == 0) {
                classesList.add(c);
            }
        }
        return classesList;
    }
    public void summary(){
        Set<Map.Entry<String, Classes>> entries = classesMap.entrySet();
        for (Map.Entry<String, Classes> entry : entries) {
            Classes c = entry.getValue();
            double i = c.getActualSize();
            double j = c.getMaxNumberOfStudents();
            System.out.println("Name: " + c.getName() + " | Status: " + (i / j) * 100 + "%");
        }
    }
}
