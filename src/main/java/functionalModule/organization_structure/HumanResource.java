package functionalModule.organization_structure;

/**
 * 人力资源
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 15:01
 */
public abstract class HumanResource {

    protected long id;
    protected double salary;

    public HumanResource(long id) {
        this.id = id;
    }

    public abstract double calculateSalary();

    public long getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }
}
