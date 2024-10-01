import java.util.ArrayList;
import java.util.List;

class PayrollSystem {
    private List<Employee> employees;

    public PayrollSystem() {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void displayEmployees() {
        for (Employee emp : employees) {
            System.out.println(emp.getName() + ": " + emp.calculatePay());
        }
    }

    public void updateEmployee(int index, String name, int hoursWorked, double hourlyRate, double overtimeHours) {
        if (index >= 0 && index < employees.size()) {
            Employee emp = employees.get(index);
            emp.name = name;
            emp.hoursWorked = hoursWorked;
            emp.hourlyRate = hourlyRate;
            if (emp instanceof FullTimeEmployee) {
                ((FullTimeEmployee) emp).setOvertimeHours(overtimeHours);
            }
        }
    }    

    public void removeEmployee(int index) {
        if (index >= 0 && index < employees.size()) {
            employees.remove(index);
        }
    }
}
