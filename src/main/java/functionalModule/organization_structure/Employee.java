package functionalModule.organization_structure;

/**
 * 员工类
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 15:02
 */
public class Employee extends HumanResource {
    public Employee(long id,double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
