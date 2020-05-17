import java.util.Arrays;

public class Main
{

    public static void main(String[] args)
    {
        System.out.println("Задание 1. Замена 0 на 1, 1 на 0 в массиве.");
        int[] vArrZerosOnes = {1, 0, 0, 0, 1, 1, 0, 1};
        System.out.println("Массив до изменения   : " + Arrays.toString(vArrZerosOnes));
        System.out.println("Массив после изменения: " + Arrays.toString(invertArray(vArrZerosOnes)));

        System.out.println();
        System.out.println("Задание 2. Заполнение массива в цикле.");
        int[] vArr2Fill = new int[8];
        System.out.println("vArr2Fill = " + Arrays.toString(fillArray(vArr2Fill)));

        System.out.println();
        System.out.println("Задание 3. Умножение элементов массива в соответствии с условием.");
        int[] vArr2Multiply = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("Массив до изменения   : " + Arrays.toString(vArr2Multiply));
        System.out.println("Массив после изменения: " + Arrays.toString(multiplyArray(vArr2Multiply)));

        System.out.println();
        System.out.println("Задание 4. Заполнение двумерного массива по диагоналям.");
        int[][] vArrSquare = new int[8][8];
        System.out.println("vArrSquare:");
        for (int[] arrRow : fillArrayDiagonals(vArrSquare))
        {
            System.out.println(Arrays.toString(arrRow));
        }

        System.out.println();
        System.out.println("Задание 5. Поиск минимального, максимального элементов массива.");
        int[] vArr2FindMinMax = {-5, 3, 0, -18, 10, 23, 6, 22, 4};
        findMinMaxElements(vArr2FindMinMax);

        System.out.println();
        System.out.println("Задание 6. Поиск равенства суммы левой и правой частей массива.");
        int[] vArr2SumParts = {5, 10, 3, 4, 17, 3, 2};
        System.out.println("Массив: " + Arrays.toString(vArr2SumParts));
        System.out.println("В массиве есть две части с равными суммами: "
                           + arrayHasEqualPartsSum(vArr2SumParts));

        System.out.println();
        System.out.println("Задание 7. Смещение элементов массива.");
        int[] vArr2Offset = {0, 1, 2, 3, 4, 5};
        System.out.println("Массив до изменения   : "
                           + Arrays.toString(vArr2Offset));
        System.out.println("Массив после изменения: "
                           + Arrays.toString(offsetArray(vArr2Offset, -2)));
    }

    // Задание 1. Замена 0 на 1, 1 на 0 в массиве.
    public static int[] invertArray (int[] aArr)
    {
        for (int i = 0; i < aArr.length; i++)
        {
            if (aArr[i] == 0)
            {
                aArr[i] = 1;
            }
            else if (aArr[i] == 1)
            {
                aArr[i] = 0;
            }
        }
        return aArr;
    }

    // Задание 2. Заполнение массива в цикле.
    public static int[] fillArray(int[] aArr)
    {
        for (int i = 0, j = 0; i < aArr.length; i++, j += 3)
        {
            aArr[i] = j;
        }
        return aArr;
    }

    // Задание 3. Умножение элементов массива в соответствии с условием.
    public static int[] multiplyArray(int[] aArr)
    {
        for (int i = 0; i < aArr.length; i++)
        {
            if (aArr[i] < 6)
            {
                aArr[i] *= 2;
            }
        }
        return aArr;
    }

    // Задание 4. Заполнение двумерного массива по диагоналям.
    public static int[][] fillArrayDiagonals(int[][] aArr)
    {
        for (int i = 0; i < aArr.length; i++)
        {
            for (int j = 0; j < aArr[i].length; j++)
            {
                if ((i == j) || (i + j == aArr[i].length - 1))
                {
                    aArr[i][j] = 1;
                }
            }
        }
        return aArr;
    }

    // Задание 5. Поиск минимального, максимального элементов массива.
    public static void findMinMaxElements(int[] aArr)
    {
        int minVal = aArr[0];
        int maxVal = aArr[0];
        for (int i = 1; i < aArr.length; i++)
        {
            if (aArr[i] < minVal) { minVal = aArr[i]; }
            if (aArr[i] > maxVal) { maxVal = aArr[i]; }
        }
        System.out.println("Массив: " + Arrays.toString(aArr));
        System.out.println("min: " + minVal);
        System.out.println("max: " + maxVal);
    }

    // Задание 6. Поиск равенства суммы левой и правой частей массива.
    public static boolean arrayHasEqualPartsSum(int[] aArr)
    {
        int vSumPart1 = 0;
        for (int i = 0; i < aArr.length - 1; i++)
        {
            vSumPart1 += aArr[i];

            int vSumPart2 = 0;
            for (int j = i + 1; j < aArr.length; j++)
            {
                vSumPart2 += aArr[j];
            }

            if (vSumPart1 == vSumPart2) { return true; }
        }
        return false;
    }

    // Задание 7. Смещение элементов массива.
    public static int[] offsetArray(int[] aArr, int aOffset)
    {
        System.out.println("aOffset = " + aOffset);

        if(aOffset >= 0)
        {
            for (int i = 1; i <= aOffset; i++)
            {
                aArr = moveArr2RightByOne(aArr);
            }
        }
        else
        {
            for (int i = -1; i >= aOffset; i--)
            {
                aArr = moveArr2LeftByOne(aArr);
            }
        }

        return aArr;
    }

    public static int[] moveArr2RightByOne(int[] aArr)
    {
        int vLastElem = aArr[aArr.length - 1];
        for (int j = aArr.length - 1; j > 0; j--)
        {
            aArr[j] = aArr[j - 1];
        }
        aArr[0] = vLastElem;

        return aArr;
    }
    public static int[] moveArr2LeftByOne(int[] aArr)
    {
        int vFirstElem = aArr[0];
        for (int j = 0; j < aArr.length - 1; j++)
        {
            aArr[j] = aArr[j + 1];
        }
        aArr[aArr.length - 1] = vFirstElem;

        return aArr;
    }
}
