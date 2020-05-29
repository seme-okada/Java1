public class Cat extends Animal
{
    public Cat(String aName, float aWeight, int aAge)
    {
        super(aName, aWeight, aAge);
    }

    @Override
    public void printInfo()
    {
        System.out.println("Информация о кошке:");
        super.printInfo();
    }

    @Override
    public void run(float aLength)
    {
        System.out.println(String.format("Попытка кошки по кличке \"%s\" пробежать %s м: %s"
                , fName
                , aLength
                , getActionResult(aLength, fRunLimit)
                )
        );
    }

    @Override
    public void swim(float aLength)
    {
        System.out.println(String.format("Попытка кошки по кличке \"%s\" проплыть %s м: %s"
                , fName
                , aLength
                , getActionResult(aLength, fSwimLimit)
                )
        );
    }

    @Override
    public void jump(float aHeight)
    {
        System.out.println(String.format("Попытка кошки по кличке \"%s\" перепрыгнуть препятствие высотой %s м: %s"
                , fName
                , aHeight
                , getActionResult(aHeight, fJumpLimit)
                )
        );
    }
}
