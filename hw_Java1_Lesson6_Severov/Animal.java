public abstract class Animal
{
    protected String fName;
    protected float  fWeight;
    protected int    fAge;

    protected float fRunLimit;
    protected float fSwimLimit;
    protected float fJumpLimit;

    public Animal(String aName, float aWeight, int aAge)
    {
        fName   = aName;
        fWeight = aWeight;
        fAge    = aAge;
    }

    public void printInfo()
    {
        System.out.println("Имя          : " + fName  );
        System.out.println("Вес (кг)     : " + fWeight);
        System.out.println("Возраст (лет): " + fAge   );
    }

    public void setActionLimits(float aRunLimit, float aSwimLimit, float aJumpLimit)
    {
        fRunLimit  = aRunLimit;
        fSwimLimit = aSwimLimit;
        fJumpLimit = aJumpLimit;
    }

    public String getActionResult(float aTarget, float aLimit)
    {
        if (aTarget <= aLimit)
            return "Успешно";
        else
            return  "Неуспешно";
    }

    public abstract void run (float aLength);
    public abstract void swim(float aLength);
    public abstract void jump(float aHeight);

    public String getName() { return fName; }
    public void   setName(String aName) { fName = aName; }

    public float getWeight() { return fWeight; }
    public void  setWeight(float aWeight) { this.fWeight = aWeight; }

    public int  getAge() { return fAge; }
    public void setAge(int aAge) { this.fAge = aAge; }

    public float getRunLimit() { return fRunLimit; }
    public void  setRunLimit(float aRunLimit) { fRunLimit = aRunLimit; }

    public float getSwimLimit() { return fSwimLimit; }
    public void  setSwimLimit(float aSwimLimit) { fSwimLimit = aSwimLimit; }

    public float getJumpLimit() { return fJumpLimit; }
    public void  setJumpLimit(float aJumpLimit) { fJumpLimit = aJumpLimit; }
}
