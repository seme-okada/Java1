public class Main
{
    // Задание 1. Создание метода main.
    public static void main(String[] args)
    {
        // Задание 2. Объявление и инициализация переменных пройденных типов.
        byte  vByte  = 127;
        short vShort = 32767;
        int   vInt   = 2147483647;
        long  vLong  = 9223372036854775807L;

        float  vFloat  = 123456789012345678901234567890123456789.321123321f;
        double vDouble = 12345678901234567890123456789012345678901234567890.321123321;

        char vChar = 'Q';

        boolean vBoolean = true;

        String vString = "Qwerty";

        System.out.println("Задание 2. Вывод проинициализированных переменных.");
        System.out.println(vByte
                 +  "; " + vShort
                 +  "; " + vInt
                 +  "; " + vLong
                 +  "; " + vFloat
                 +  "; " + vDouble
                 +  "; " + vChar
                 +  "; " + vBoolean
                 +  "; " + vString
        );

        System.out.println();
        System.out.println("Задание 3. Вычисление выражения a * (b + (c / d)).");
        System.out.println(calcExpr(-1, 35, 16800.122f, 0));

        System.out.println();
        System.out.println("Задание 4. Проверка вхождения суммы в диапазон значений.");
        System.out.println(isSumInRange(21, -5));

        System.out.println();
        System.out.println("Задание 5. Проверка положительности/отрицательности числа.");
        checkNumSign(0);

        System.out.println();
        System.out.println("Задание 6. Проверка отрицательности числа.");
        System.out.println(isNegativeNum(5));

        System.out.println();
        System.out.println("Задание 7. Вывод имени.");
        printName("Семён");

        System.out.println();
        System.out.println("Задание 8. Является ли год високосным.");
        isLeapYear(0);
    }

    // Задание 3. Вычисление выражения a * (b + (c / d)).
    public static float calcExpr(float a, float b, float c, float d)
    {
        System.out.println("a = " + a
                       + "; b = " + b
                       + "; c = " + c
                       + "; d = " + d);
        return a * (b + (c / d));
    }

    // Задание 4. Проверка вхождения суммы в диапазон значений.
    public static boolean isSumInRange(int aNum1, int aNum2)
    {
        System.out.println("aNum1 = " + aNum1
                       + "; aNum2 = " + aNum2);
        return 10 < (aNum1 + aNum2) && (aNum1 + aNum2) <= 20;
    }

    // Задание 5. Проверка положительности/отрицательности числа.
    public static void checkNumSign(int aNum)
    {
        if (aNum >= 0)
        {
            System.out.println(aNum + ": число положительное");
        }
        else
        {
            System.out.println(aNum + ": число отрицательное");
        }
    }

    // Задание 6. Проверка отрицательности числа.
    public static boolean isNegativeNum(int aNum)
    {
        System.out.println("aNum = " + aNum);
        return aNum < 0;
    }

    // Задание 7. Вывод имени.
    public static void printName(String aName)
    {
        System.out.println("Привет, " + aName + "!");
    }

    // Задание 8. Является ли год високосным.
    public static void isLeapYear(int aYear)
    {
        boolean yearIs0th   = aYear == 0;
        boolean yearIs4th   = !yearIs0th && aYear %   4 == 0;
        boolean yearIs100th = !yearIs0th && aYear % 100 == 0;
        boolean yearIs400th = !yearIs0th && aYear % 400 == 0;

        if ((yearIs4th && !yearIs100th) || yearIs400th)
        {
            System.out.println(aYear + ": год високосный");
        }
        else
        {
            System.out.println(aYear + ": год не високосный");
        }
    }
}
