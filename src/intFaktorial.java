
import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.*;

public class intFaktorial
{
    public static BigInteger faktorial(int n)
    {
        BigInteger res = BigInteger.valueOf(1);
        for (int i = 2; i <= n; i++){
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        System.out.println(faktorial(n).toString());
    }


}


/*
Реализуйте метод, вычисляющий факториал заданного натурального числа.
Факториал N вычисляется как 1?2?...?N.
Поскольку это очень быстро растущая функция, то даже для небольших N вместимости типов int и long очень скоро не хватит. Поэтому будем использовать BigInteger.
Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и обработку ввода-вывода добавит проверяющая система.
*/

