import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        // Задание 2. Игра "Отгадай слово".
        playGuessTheWord();
    }

    public static void playGuessTheWord()
    {
        String   vControlWord = generateWord();
        String   vTestedWord;
        String[] vWordEqualityResultArr;
        Boolean  vIsNeedExit;
        do
        {
            vTestedWord            = requestWord();
            vWordEqualityResultArr = checkWordEquality(vControlWord, vTestedWord);
            vIsNeedExit            = checkNeedExit(vTestedWord, vWordEqualityResultArr);

            showResultMessage(vControlWord, vWordEqualityResultArr, vIsNeedExit);
        } while (!vIsNeedExit);
    }

    public static String[] createSourceArray()
    {
        return new String[]
            {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot"
           , "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom"
           , "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
    }

    public static String generateWord()
    {
        String[] vWordsOptionsArr = createSourceArray();
        Random   vWordNumRand     = new Random();

        System.out.println("Слово загадано.");
        return vWordsOptionsArr[vWordNumRand.nextInt(vWordsOptionsArr.length)];
    }

    public static String requestWord()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите свой вариант слова (для выхода введите \"exit\")...");

        return scanner.nextLine();
    }

    public static String[] checkWordEquality(String aControlWord, String aTestedWord)
    {
        // vResArray[0] - результат
        // vResArray[1] - сообщение
        String[] vResArray = new String[2];
        if (aControlWord.equals(aTestedWord))
        {
            vResArray[0] = Boolean.toString(true);
            vResArray[1] = "Поздравляем, Вы угадали слово!";
        }
        else
        {
            vResArray[0] = Boolean.toString(false);
            vResArray[1] = String.format("Слово не угадано. \n%s"
                                       , checkMatchingLetters(aControlWord, aTestedWord));
        }

        return vResArray;
    }

    public static String checkMatchingLetters(String aControlWord, String aTestedWord)
    {
        String vMessage        = "Совпадения букв отсутствуют: ";
        String vMatchedLetters = "";
        for (int i = 0; i <= 15; i++)
        {

            if (   (aControlWord.length() > i)
                && (aTestedWord .length() > i)
                && (aControlWord.charAt(i) == aTestedWord.charAt(i))
                )
            {
                vMessage        = "Найдены совпадения букв: ";
                vMatchedLetters = String.format("%s%s", vMatchedLetters, aControlWord.charAt(i));
            }
            else
            {
                vMatchedLetters = String.format("%s%s", vMatchedLetters, '#');
            }
        }

        return vMessage + vMatchedLetters;
    }

    public static Boolean checkNeedExit(String aCommand, String[] aArrEqualityResult)
    {
        // Выходим, если:
        // - угадали слово
        // - или ввели команду "exit"
        return  Boolean.parseBoolean(aArrEqualityResult[0]) || aCommand.equals("exit");
    }

    public static void showResultMessage(String   aControlWord
                                       , String[] aArrEqualityResult
                                       , Boolean  aIsNeedExit)
    {
        String vExitMessage;

        // Если слово было угадано,
        // то в выходном сообщении выводим поздравления,
        // иначе в выходном сообщении выводим загаданное слово.
        if (Boolean.parseBoolean(aArrEqualityResult[0]))
            vExitMessage = aArrEqualityResult[1];
        else
            vExitMessage = "Было загадано слово: " + aControlWord;

        if (!aIsNeedExit)
        {
            System.out.println(aArrEqualityResult[1]);
        }
        else
        {
            System.out.println(vExitMessage);
            System.out.println("Для выхода нажмите \"Enter\"");
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine();
        }
    }
}
