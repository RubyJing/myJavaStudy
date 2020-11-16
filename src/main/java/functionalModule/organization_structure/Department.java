package functionalModule.organization_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 15:05
 */
public class Department extends HumanResource {

    private List<HumanResource> subNodes = new ArrayList<>();

    public Department(long id) {
        super(id);
    }



    @Override
    public double calculateSalary() {
        double allSalary = 0.0;
        for (HumanResource employeeOrDepartment : subNodes) {
            allSalary += employeeOrDepartment.calculateSalary();
        }
        this.salary = allSalary;
        return allSalary;
    }

    public void addSubNode(HumanResource employeeOrDepartment) {
        subNodes.add(employeeOrDepartment);
    }
}
