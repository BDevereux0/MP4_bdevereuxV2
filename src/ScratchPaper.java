import java.util.Stack;

public class ScratchPaper {
    static int x =0;
    public int returnInt(){
        x++;
        return x;
    }

    public void printInt(){
        for (int i = 0; i < 6; i++) {
            int value = returnInt();
            if (value == 4) {
                return;
            } else
                System.out.println(value);
        }
    }
    public static void main(String[] args) {
        String x = "*";
        System.out.println(x);
        /*for (int i = 0; i < 10; i++) {
            x = x + "*";
            System.out.println(x);
        }*/
        ScratchPaper sp = new ScratchPaper();
        sp.printInt();

        int charValue = 'a';
        int charValue1 = 't';

        System.out.println(charValue);
        System.out.println(charValue1);

    }
}
