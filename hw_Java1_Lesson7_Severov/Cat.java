public class Cat
{
    private String  fName;
    private int     fAppetite;
    private boolean fIsFull = false;

    public Cat(String aName, int aAppetite)
    {
        fName     = aName;
        fAppetite = aAppetite;
    }

    public void eat(Plate aPlate)
    {
        if (!fIsFull)
        {
            if (aPlate.decreaseFood(fAppetite))
            {
                System.out.println(String.format("Кот %s поел.", fName));
                fIsFull = true;
            }
            else
            {
                System.out.println(String.format("Коту %s не хватило еды.", fName));
            }
        }
        else
            System.out.println(String.format("Кот %s не голоден.", fName));
    }

    public void printSatiety()
    {
        System.out.println(String.format("Кот %s %s", fName, fIsFull ? "сыт" : "голоден"));
    }

    public String getName() { return fName; }
    public void   setName(String aName) { fName = aName; }

    public int  getAppetite() { return fAppetite; }
    public void setAppetite(int aAppetite) { fAppetite = aAppetite; }
}
