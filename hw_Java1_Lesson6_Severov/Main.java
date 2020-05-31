public class Main {

    public static void main(String[] args)
    {
        workingWithAnimals();
    }

    public static void workingWithAnimals()
    {
        Dog[] vArrDogs = createDogs();
        Cat[] vArrCats = createCats();

        viewAnimalsInfo(vArrDogs);
        viewAnimalsInfo(vArrCats);

        holdRunningTournament(vArrDogs);
        holdRunningTournament(vArrCats);

        holdSwimmingTournament(vArrDogs);
        holdSwimmingTournament(vArrCats);

        holdJumpingTournament(vArrDogs);
        holdJumpingTournament(vArrCats);
    }

    public static Dog[] createDogs()
    {
        Dog[] vArrDogs = new Dog[3];

        vArrDogs[0] = new Dog("Лесси", 19.3f, 2 );
        vArrDogs[1] = new Dog("Арчи" , 32.9f, 12);
        vArrDogs[2] = new Dog("Рома" , 4.5f , 4 );

        vArrDogs[0].setActionLimits(1038.6f, 280.8f, 1.8f);
        vArrDogs[1].setActionLimits(780.3f , 46.1f , 1.1f);
        vArrDogs[2].setActionLimits(340.5f , 73.2f , 0.6f);

        return vArrDogs;
    }

    public static Cat[] createCats()
    {
        Cat[] vArrCats = new Cat[3];

        vArrCats[0] = new Cat("Кузя"   , 5.6f, 3);
        vArrCats[1] = new Cat("Маша"   , 4.3f, 1);
        vArrCats[2] = new Cat("Мурзик" , 6.1f, 7);

        vArrCats[0].setActionLimits(350.7f, 0f, 2.1f);
        vArrCats[1].setActionLimits(195.8f, 0f, 1.4f);
        vArrCats[2].setActionLimits(86.5f , 0f, 0.7f);

        return vArrCats;
    }

    public static void viewAnimalsInfo(Dog[] aArrDogs)
    {
        for (int i = 0; i < aArrDogs.length; i ++)
        {
            aArrDogs[i].printInfo();
            System.out.println();
        }
    }

    public static void viewAnimalsInfo(Cat[] aArrCats)
    {
        for (int i = 0; i < aArrCats.length; i ++)
        {
            aArrCats[i].printInfo();
            System.out.println();
        }
    }

    public static void holdRunningTournament(Dog[] aArrDogs)
    {
        runs(aArrDogs, 100f );
        runs(aArrDogs, 500f );
        runs(aArrDogs, 1000f);
    }

    public static void holdRunningTournament(Cat[] aArrCats)
    {
        runs(aArrCats, 50f );
        runs(aArrCats, 100f);
        runs(aArrCats, 200f);
    }

    public static void runs(Dog[] aArrDogs, float aLength)
    {
        System.out.println(String.format("Забег собак на %s метров", aLength));
        for (int i = 0; i < aArrDogs.length; i++)
        {
            aArrDogs[i].run(aLength);
        }
        System.out.println();
    }

    public static void runs(Cat[] aArrCats, float aLength)
    {
        System.out.println(String.format("Забег кошек на %s метров", aLength));
        for (int i = 0; i < aArrCats.length; i++)
        {
            aArrCats[i].run(aLength);
        }
        System.out.println();
    }

    public static void holdSwimmingTournament(Dog[] aArrDogs)
    {
        swims(aArrDogs, 10f );
        swims(aArrDogs, 50f );
        swims(aArrDogs, 100f);
    }

    public static void holdSwimmingTournament(Cat[] aArrCats)
    {
        swims(aArrCats, 10f );
        swims(aArrCats, 50f);
        swims(aArrCats, 100f);
    }

    public static void swims(Dog[] aArrDogs, float aLength)
    {
        System.out.println(String.format("Заплыв собак на %s метров", aLength));
        for (int i = 0; i < aArrDogs.length; i++)
        {
            aArrDogs[i].swim(aLength);
        }
        System.out.println();
    }

    public static void swims(Cat[] aArrCats, float aLength)
    {
        System.out.println(String.format("Заплыв кошек на %s метров", aLength));
        for (int i = 0; i < aArrCats.length; i++)
        {
            aArrCats[i].swim(aLength);
        }
        System.out.println();
    }

    public static void holdJumpingTournament(Dog[] aArrDogs)
    {
        jumps(aArrDogs, 0.5f);
        jumps(aArrDogs, 1f  );
        jumps(aArrDogs, 1.5f);
    }

    public static void holdJumpingTournament(Cat[] aArrCats)
    {
        jumps(aArrCats, 0.5f);
        jumps(aArrCats, 1f  );
        jumps(aArrCats, 1.5f);
    }

    public static void jumps(Dog[] aArrDogs, float aHeight)
    {
        System.out.println(String.format("Прыжки собак на %s метр(а)", aHeight));
        for (int i = 0; i < aArrDogs.length; i++)
        {
            aArrDogs[i].jump(aHeight);
        }
        System.out.println();
    }

    public static void jumps(Cat[] aArrCats, float aHeight)
    {
        System.out.println(String.format("Прыжки кошек на %s метр(а)", aHeight));
        for (int i = 0; i < aArrCats.length; i++)
        {
            aArrCats[i].jump(aHeight);
        }
        System.out.println();
    }

}
