package etc;

import static java.lang.System.identityHashCode;

public class CallByValue {
    public static void main(String[] args) {
        int a = 10;
        int b = 10;
        int c = a;
        int hashA = identityHashCode(a);
        int hashB = identityHashCode(b);
        int hashC = identityHashCode(c);
        System.out.println("hashA = " + hashA);
        System.out.println("hashB = " + hashB);
        System.out.println("hashC = " + hashC);

        CallByValue me = new CallByValue();
        CallByValue you = new CallByValue();
        int hash1 = identityHashCode(me);
        int hash2 = identityHashCode(you);
        System.out.println("hash1 = " + hash1);
        System.out.println("hash2 = " + hash2);
    }

}
