package String;

public class StringBuilderTest {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello World");
        StringBuilder sb2 = sb.append(" KangCHan");

        System.out.println(sb == sb2);
        System.out.println(sb.equals(sb2));
    }
}
