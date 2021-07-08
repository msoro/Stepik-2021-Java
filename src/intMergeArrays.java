
import java.util.Arrays;

/**
 * Реализуйте метод, сливающий два отсортированных по неубыванию массива
 * чисел в один отсортированный в том же порядке массив. Массивы могут быть
 * любой длины, в том числе нулевой.Предполагается, что вы реализуете алгоритм
 * слияния, который будет идти по двум исходным массивам и сразу формировать
 * отсортированный результирующий массив. Так, чтобы сортировка полученного
 * массива при помощи Arrays.sort() уже не требовалась. К сожалению, автоматически
 * это не проверить, так что это остается на вашей совести :)
 *
 * Воспользуйтесь предоставленным шаблоном. Декларацию класса, метод main и
 * обработку ввода-вывода добавит проверяющая система.
 */
public class intMergeArrays {
    public static int[] mergeArrays(int[] m1, int[] m2)
    {
        int[] result = new int [m1.length + m2.length];

        System.arraycopy(m1, 0, result, 0, m1.length);
        System.arraycopy(m2, 0, result, m1.length, m2.length);
        Arrays.sort(result);
        return result;
    }

    public static int[] mergeArrays2(int[] m1, int[] m2)
    {
        int[] result = new int [m1.length + m2.length];
        int idxOne = 0;
        int idxTwo = 0;

        for (int i = 0; i < result.length; i++)
        {
            if (idxTwo >= m2.length || idxOne < m1.length && m1[idxOne] < m2[idxTwo]) {
                result[i] = m1[idxOne];
                idxOne++;
            } else {
                result[i] = m2[idxTwo];
                idxTwo++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // тестовые данные
        System.out.println(Arrays.toString(mergeArrays(new int[]{4,7,9,3}, new int[]{2,9,8,6})));
        //System.out.println(Arrays.toString(mergeArrays2(new int[]{4,7,9,3}, new int[]{2,9,8,6})));
    }
}