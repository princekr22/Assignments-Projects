import java.util.*;

public class HashtableDemo {

    public static void main(String[] args) {

        Hashtable<Integer, String> ht1 = new Hashtable<>();
        Hashtable<Integer, String> ht2 = new Hashtable<>(10);
        Hashtable<Integer, String> ht3 = new Hashtable<>(10, 0.75f);
        Hashtable<Integer, String> ht4 = new Hashtable<>(ht1);

        ht1.put(1, "One");
        ht1.put(2, "Two");
        ht1.put(3, "Three");

        System.out.println(ht1.get(2));
        System.out.println(ht1.containsKey(1));
        System.out.println(ht1.containsValue("Three"));
        System.out.println(ht1.size());

        ht1.remove(3);
        ht1.replace(2, "Z");

        Enumeration<Integer> keys = ht1.keys();
        while (keys.hasMoreElements())
            System.out.println(keys.nextElement());

        System.out.println(ht1.keySet());
        System.out.println(ht1.values());
        System.out.println(ht1.entrySet());

        ht1.clear();
    }
}
