import java.util.*;

public class VectorDemo {

    public static void main(String[] args) {

        Vector<String> v1 = new Vector<>();
        Vector<String> v2 = new Vector<>(10);
        Vector<String> v3 = new Vector<>(10, 5);
        Vector<String> v4 = new Vector<>(v1);

        v1.add("A");
        v1.add("B");
        v1.addElement("C");
        v1.insertElementAt("D", 1);

        System.out.println(v1.size());
        System.out.println(v1.capacity());
        System.out.println(v1.firstElement());
        System.out.println(v1.lastElement());
        System.out.println(v1.contains("B"));

        v1.remove("A");
        v1.removeElementAt(1);
        v1.setElementAt("Z", 0);

        Enumeration<String> e = v1.elements();
        while (e.hasMoreElements())
            System.out.println(e.nextElement());

        v1.clear();
    }
}
