package ru.itmo.java;

public class Task3 {

    /**
     * Напишите функцию, которая принимает массив целых чисел и циклически сдвигает элементы этого массива вправо:
     * A[0] -> A[1], A[1] -> A[2] .. A[length - 1] -> A[0].
     * Если инпут равен null - вернуть пустой массив
     */
    int[] getShiftedArray(int[] inputArray) {
        if ((inputArray == null) || (inputArray.length == 0))
            return new int[]{};
        else
        {
            int t = inputArray[inputArray.length - 1];
            for(int i = inputArray.length - 1; i > 0; i--)
                inputArray[i] = inputArray[i - 1];
            inputArray[0] = t;
            return inputArray;
        }
    }

    /**
     * Напишите функцию, которая принимает массив целых чисел и возвращает максимальное значение произведения двух его элементов.
     * Если массив состоит из одного элемента, то функция возвращает этот элемент.
     *
     * Если входной массив пуст или равен null - вернуть 0
     *
     * Пример: 2 4 6 -> 24
     */
    int getMaxProduct(int[] inputArray) {
        if ((inputArray == null) || (inputArray.length == 0))
            return 0;
        else if (inputArray.length == 1)
            return inputArray[0];
        else
        {
            int m1 = inputArray[0];
            int m2 = inputArray[1];

            for (int i = 2; i < inputArray.length; i++)
            {
                if(inputArray[i] > m1)
                {
                    m2 = m1;
                    m1 = inputArray[i];
                }
                else if (inputArray[i] > m2)
                    m2 = inputArray[i];
            }
            return m1 * m2;
        }
    }

    /**
     * Напишите функцию, которая вычисляет процент символов 'A' и 'B' (латиница) во входной строке.
     * Функция не должна быть чувствительна к регистру символов.
     * Результат округляйте путем отбрасывания дробной части.
     *
     * Пример: acbr -> 50
     */
    int getABpercentage(String input) {
        if ((input == null) || (input.length() == 0))
            return 0;
        else
        {
            double k = 0, L = input.length();
            for (int i = 0; i < L; i++)
            {
                if ((input.charAt(i) == 'a') || (input.charAt(i) == 'A') || (input.charAt(i) == 'b') || (input.charAt(i) == 'B'))
                    k++;
            }

            return (int) (k / L * 100);
        }
    }

    /**
     * Напишите функцию, которая определяет, является ли входная строка палиндромом
     */
    boolean isPalindrome(String input) {
        if (input == null)
            return false;
        else
        {
            for (int i = 0; i < input.length() / 2; i++)
                if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                    return false;
            return true;
        }
    }

    /**
     * Напишите функцию, которая принимает строку вида "bbcaaaak" и кодирует ее в формат вида "b2c1a4k1",
     * где группы одинаковых символов заменены на один символ и кол-во этих символов идущих подряд в строке
     */
    String getEncodedString(String input) {
        if ((input == null) || (input.length() == 0))
            return new String();
        else
        {
            String S = new String();
            int k = 1;
            for (int i = 0; i < input.length() - 1; i++)
            {
                if (input.charAt(i) == input.charAt(i + 1))
                {
                    k++;
                }
                else
                {
                    S += input.charAt(i);
                    S += k;
                    k = 1;
                }
            }
            S += input.charAt(input.length() - 1);
            S += k;
            return S;
        }
    }

    /**
     * Напишите функцию, которая принимает две строки, и возвращает true, если одна может быть перестановкой (пермутатсией) другой.
     * Строкой является последовательность символов длинной N, где N > 0
     * Примеры:
     * isPermutation("abc", "cba") == true;
     * isPermutation("abc", "Abc") == false;
     */
    boolean isPermutation(String one, String two) {
        if ((one == null) || (two == null) || (one.length() == 0) || (two.length() == 0))
            return false;
        else
        {
            int[] a1 = new int[70000];
            int[] a2 = new int[70000];
            for (int i = 0; i < one.length(); i++)
                a1[one.charAt(i)]++;
            for (int i = 0; i < two.length(); i++)
                a2[two.charAt(i)]++;
            for (int i = 0; i < 70000; i++)
                if (a1[i] != a2[i])
                    return false;
            return true;
        }
    }

    /**
     * Напишите функцию, которая принимает строку и возвращает true, если она состоит из уникальных символов.
     * Из дополнительной памяти (кроме примитивных переменных) можно использовать один массив.
     * Строкой является последовательность символов длинной N, где N > 0
     */
    boolean isUniqueString(String s) {
        if ((s == null) || (s.length() == 0))
            return false;
        else
        {
            int[] a1 = new int[70000];
            for (int i = 0; i < s.length(); i++)
                a1[s.charAt(i)]++;
            for (int i = 0; i < 70000; i++)
                if (a1[i] > 1)
                    return false;
            return true;
        }
    }

    /**
     * Напишите функцию, которая транспонирует матрицу. Только квадратные могут быть на входе.
     *
     * Если входной массив == null - вернуть пустой массив
     */
    int[][] matrixTranspose(int[][] m) {
        if (m == null)
            return new int[][]{{}, {}};
        else
        {
            for (int i = 0; i < m.length; i++)
                for (int j = i; j < m.length; j++)
                {
                    int t = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = t;
                }
            return m;
        }
    }

    /**
     * Напиишите функцию, принимающую массив строк и символ-разделитель,
     * а возвращает одну строку состоящую из строк, разделенных сепаратором.
     *
     * Запрещается пользоваться функций join
     *
     * Если сепаратор == null - считайте, что он равен ' '
     * Если исходный массив == null -  вернуть пустую строку
     */
    String concatWithSeparator(String[] inputStrings, Character separator) {
        if ((inputStrings == null) || (inputStrings.length == 0))
            return new String();
        else if (separator == null)
            separator = ' ';
        String S = new String();
        S += inputStrings[0];
        for (int i = 1; i < inputStrings.length; i++)
        {
            S += separator;
            S += inputStrings[i];
        }
        return S;
    }

    /**
     * Напишите функцию, принимающую массив строк и строку-перфикс и возвращающую кол-во строк массива с данным префиксом
     */
    int getStringsStartWithPrefix(String[] inputStrings, String prefix) {
        if ((inputStrings == null) || (inputStrings.length == 0) || (prefix == null))
            return 0;
        else
        {
            int k = 0;
            for (int i = 0; i < inputStrings.length; i++)
                if (inputStrings[i].startsWith(prefix))
                    k++;
            return k;
        }
    }
}
