package functionalModule.organization_structure;

import java.util.ArrayList;
import java.util.List;

/**
 * 公司组织架构使用Demo
 *
 * @author RubyJing
 * @version 1.0
 * @date 2020/11/16 15:10
 */
public class Demo {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    //依赖注入
    private DepartmentRepo departmentRepo;
    private EmployeeRepo employeeRepo;


    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }


    /**
     * 使用递归初始化组织架构
     *
     * @param department 部门
     */
    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }

    class DepartmentRepo {
        List<Long> getSubDepartmentIds(Long id) {
            return new ArrayList<>();
        }
    }

    class EmployeeRepo {
        List<Long> getDepartmentEmployeeIds(Long id) {
            return new ArrayList<>();
        }

        double getEmployeeSalary(Long id) {
            return 0.0d;
        }
    }
}
