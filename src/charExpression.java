/*
  Реализуйте метод, который возвращает букву, стоящую в таблице UNICODE после символа "\"
  (обратный слэш) на расстоянии a.

  Stepik code:

   public static char charExpression(int a) {
    int ch = '\\';
    int x = ch + a;
    char unicode = (char)x;
    return unicode;
}
 */

import java.util.Scanner;

public class charExpression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        System.out.println(a);
        int ch = '\\';
        int x = ch + a;
        char unicode = (char)x;
        System.out.println(unicode);
    }
}

