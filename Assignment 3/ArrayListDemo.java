import java.util.*;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>(20);
        ArrayList<Integer> list3 = new ArrayList<>(list1);

        list1.add(10);
        list1.add(20);
        list1.add(30);
        list1.add(1, 15);
        list1.addAll(list2);

        System.out.println(list1.size());
        System.out.println(list1.get(2));
        System.out.println(list1.contains(20));
        System.out.println(list1.indexOf(30));
        System.out.println(list1.isEmpty());

        list1.set(0, 5);
        list1.remove(1);
        list1.remove(Integer.valueOf(30));

        Object[] arr = list1.toArray();
        System.out.println(Arrays.toString(arr));

        list1.clear();
        System.out.println(list1.isEmpty());
    }
}
