public class StringOperations {

    public static void main(String[] args) {

        String text = "  Hello Java World  ";
        String sample = "Java";
        String empty = "";

        System.out.println(text.length());
        System.out.println(empty.isEmpty());
        System.out.println(text.charAt(2));
        System.out.println(text.toString());
        System.out.println(text.equals(sample));
        System.out.println(text.compareTo(sample));
        System.out.println(text.contains(sample));
        System.out.println(text.indexOf('a'));
        System.out.println(text.lastIndexOf('a'));
        System.out.println(text.startsWith("  He"));
        System.out.println(text.endsWith("  "));
        System.out.println(sample.matches("Java"));
        System.out.println(text.substring(2, 7));
        System.out.println(text.toLowerCase());
        System.out.println(text.trim());
        System.out.println(text.replace("Java", "Python"));

        String[] parts = text.trim().split(" ");
        for (String s : parts) {
            System.out.println(s);
        }

        String joined = String.join("-", parts);
        System.out.println(joined);

        int number = 100;
        String value = String.valueOf(number);
        System.out.println(value);
    }
}
