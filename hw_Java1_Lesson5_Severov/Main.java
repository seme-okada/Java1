public class Main
{

    public static void main(String[] args)
    {
        workWithEmployees();
    }

    public static void workWithEmployees()
    {
        Employee[] empArr = new Employee[5];
        createEmployees(empArr);
        viewEmployeesMore40YearsOld(empArr);
    }

    public static void createEmployees(Employee[] aEmpArr)
    {
        aEmpArr[0] = new Employee("Сидорович Андрей Александрович"
                                , "Завхоз"
                                , "saa@uralsnab.ru"
                                , "3-16-27"
                                , 26500.68f
                                , 46);
        aEmpArr[1] = new Employee("Антипина Мария Захаровна"
                                , "Бухгалтер"
                                , "amz@uralsnab.ru"
                                , "3-00-18"
                                , 38900.12f
                                , 51);
        aEmpArr[2] = new Employee("Прокопчук Виталий Сергеевич"
                                , "Генеральный директор"
                                , "pvs@uralsnab.ru"
                                , "3-13-45"
                                , 79650.00f
                                , 63);
        aEmpArr[3] = new Employee("Коваленко Елена Викторовна"
                                , "Секретарь-администратор"
                                , "kev@uralsnab.ru"
                                , "3-78-94"
                                , 31245.75f
                                , 29);
        aEmpArr[4] = new Employee("Дмитриев Валентин Петрович"
                                , "Системный администратор"
                                , "dvp@uralsnab.ru"
                                , "3-42-17"
                                , 38768.53f
                                , 32);
    }

    public static void viewEmployeesMore40YearsOld(Employee[] aEmpArr)
    {
        for (int i = 0; i < aEmpArr.length; i++)
        {
            if (aEmpArr[i].getAge() > 40)
            {
                aEmpArr[i].printEmployeeInfo();
                System.out.println();
            }
        }
    }
}
