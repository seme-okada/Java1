import java.util.Scanner;

public class Plate
{
    private int fFood;

    public boolean decreaseFood(int aCnt)
    {
        if (fFood >= aCnt)
        {
            fFood -= aCnt;
            System.out.println("Еда: -" + aCnt);
            return true;
        }

        return false;
    }

    public void addFood()
    {
        Scanner vScanner = new Scanner(System.in);

        printInfo();
        System.out.print("Задайте количество еды для добавления: ");
        fFood += vScanner.nextInt();
        printInfo();
    }

    public void printInfo()
    {
        System.out.println("Количество еды в тарелке: " + fFood);
    }
}
