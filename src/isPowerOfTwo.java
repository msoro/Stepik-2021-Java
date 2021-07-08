import java.util.Scanner;

public class isPowerOfTwo {
    public static void main(String[] args) {
        System.out.print("Input digit:");

        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println("The number is power if 2");
        System.out.println(isPowerOfTwoCheck(a));
    }
    public static boolean isPowerOfTwoCheck(int value) {
        if (value == 0) {
            return false;
        }
        else {
            int res = Math.abs(value);
            return (res & (res - 1)) == 0;
        }
    }

}


/*
 * Checks if given <code>value</code> is a power of two.
 *
 * @param value any number
 * @return <code>true</code> when <code>value</code> is power of two, <code>false</code> otherwise
*/
/*
 Побитовые операции и операции битового сдвига в Java и не только
http://www.pvsm.ru/java/39711
 */
