import java.util.Scanner;

public class Main
{

    public static void main(String[] args)
    {
        keepCats();
    }

    public static void keepCats()
    {
        Cat[] vCats  = createCats();
        feedCats(vCats);
    }

    public static void feedCats(Cat[] aCats)
    {
        Plate vPlate = new Plate();
        do
        {
            vPlate.addFood();
            letCatsEat(aCats, vPlate);
            viewFeedingResults(aCats);
        } while (isNeedAddFeeding());
    }

    public static Cat[] createCats()
    {
        Cat[] vCats = new Cat[5];

        vCats[0] = new Cat("Коля", 5 );
        vCats[1] = new Cat("Боря", 10);
        vCats[2] = new Cat("Толя", 13);
        vCats[3] = new Cat("Вася", 7 );
        vCats[4] = new Cat("Соня", 3 );

        return vCats;
    }

    public static void letCatsEat(Cat[] aCats, Plate aPlate)
    {
        for (int i = 0; i < aCats.length; i++)
        {
            System.out.println();
            aCats[i].eat(aPlate);
            aPlate.printInfo();
        }
    }

    public static void viewFeedingResults(Cat[] aCats)
    {
        System.out.println();
        System.out.println("Результат кормления котов:");
        for (int i = 0; i < aCats.length; i++)
        {
            aCats[i].printSatiety();
        }
    }

    public static boolean isNeedAddFeeding()
    {
        Scanner vScanner = new Scanner(System.in);
        String  vRes;
        boolean vIsCorrect;

        System.out.println();
        do
        {
            System.out.print("Желаете добавить еды? (y/n): ");
            vRes = vScanner.nextLine();
            vIsCorrect = vRes.equalsIgnoreCase("y")
                      || vRes.equalsIgnoreCase("n");
        } while (!vIsCorrect);

        return vRes.equalsIgnoreCase("y");
    }
}
