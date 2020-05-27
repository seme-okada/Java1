public class Employee
{
    private String fFullName;
    private String fPosition;
    private String fEmail;
    private String fPhone;
    private float  fSalary;
    private int    fAge;

    public Employee(String aFullName
                  , String aPosition
                  , String aEmail
                  , String aPhone
                  , float  aSalary
                  , int    aAge)
    {
        fFullName = aFullName;
        fPosition = aPosition;
        fEmail    = aEmail;
        fPhone    = aPhone;
        fSalary   = aSalary;
        fAge      = aAge;
    }

    public void printEmployeeInfo()
    {
        System.out.println("Информация о сотруднике:");
        System.out.println("ФИО      : " + fFullName );
        System.out.println("Должность: " + fPosition );
        System.out.println("email    : " + fEmail    );
        System.out.println("Телефон  : " + fPhone    );
        System.out.println("Зарплата : " + fSalary   );
        System.out.println("Возраст  : " + fAge      );
    }

    public String getFullName() { return fFullName; }
    public void   setFullName(String aFullName) { fFullName = aFullName; }

    public String getPosition() { return fPosition; }
    public void   setPosition(String aPosition) { fPosition = aPosition; }

    public String getEmail() { return fEmail; }
    public void   setEmail(String aEmail) { fEmail = aEmail; }

    public String getPhone() { return fPhone; }
    public void   setPhone(String aPhone) { fPhone = aPhone; }

    public float getSalary() { return fSalary; }
    public void  setSalary(float aSalary) { fSalary = aSalary; }

    public int  getAge() { return fAge; }
    public void setAge(int aAge) { fAge = aAge; }
}
