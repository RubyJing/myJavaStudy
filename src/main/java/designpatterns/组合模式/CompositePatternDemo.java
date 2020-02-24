package designpatterns.组合模式;

/**
 * 使用Employee类来创建和打印员工的层次结构
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/2/24 14:46
 */
public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee CEO = new Employee("John", "CEO", 30000);

        Employee headSales = new Employee("Robert", "Head Sales", 20000);

        Employee headMarketing = new Employee("Michel", "Head Marketing", 20000);

        Employee clerk = new Employee("Laura", "Marking", 10000);
        Employee clerk2 = new Employee("Bob", "Marking", 10000);

        Employee salesExecutive = new Employee("Richard", "Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob", "Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk);
        headMarketing.add(clerk2);

       getListEmployee(CEO);
    }

    /**
     * 通过递归遍历打印值
     */
    private static void getListEmployee(Employee employee) {
        if (employee!= null) {
            System.out.println(employee.toString());
            employee.getSubordinates().forEach(CompositePatternDemo::getListEmployee);
        }
    }
}
