import java.util.Scanner;

public class PayrollTest {
    public static void main(String[] args) {
        Scanner oop = new Scanner(System.in);
        PayrollSystem payrollSystem = new PayrollSystem();

        while (true) {
            System.out.println("\n*******************************");
            System.out.println("Heyts Heyt You Payroll System Menu");
            System.out.println("*******************************");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Remove Employee");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = oop.nextInt();
            oop.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("\n*******************************");
                    System.out.print("Enter Employee Type (fulltime/parttime/contractual): ");
                    String type = oop.nextLine();
                    System.out.print("Enter Name: ");
                    String name = oop.nextLine();
                    System.out.print("Enter Hours Worked: ");
                    int hoursWorked = oop.nextInt();
                    System.out.print("Enter Hourly Rate: ");
                    double hourlyRate = oop.nextDouble();

                    if (type.equalsIgnoreCase("fulltime")) {
                        System.out.print("Enter Overtime Hours: ");
                        double overtimeHours = oop.nextDouble();
                        payrollSystem.addEmployee(new FullTimeEmployee(name, hoursWorked, hourlyRate, overtimeHours));
                    } else if (type.equalsIgnoreCase("parttime")) {
                        payrollSystem.addEmployee(new PartTimeEmployee(name, hoursWorked, hourlyRate));
                    } else {
                        payrollSystem.addEmployee(new ContractualEmployee(name, hoursWorked, hourlyRate));
                    }
                    System.out.println("*******************************\n");
                    break;

                case 2:
                    System.out.println("\n*******************************");
                    System.out.println("Employee Payroll");
                    System.out.println("*******************************");
                    payrollSystem.displayEmployees();
                    System.out.println("*******************************\n");
                    break;

                case 3:
                    System.out.println("\n*******************************");
                    System.out.print("Enter Employee Index to Update: ");
                    int indexToUpdate = oop.nextInt();
                    oop.nextLine();
                    System.out.print("Enter New Name: ");
                    String newName = oop.nextLine();
                    System.out.print("Enter New Hours Worked: ");
                    int newHoursWorked = oop.nextInt();
                    System.out.print("Enter New Hourly Rate: ");
                    double newHourlyRate = oop.nextDouble();
                    System.out.print("Enter Overtime Hours (if fulltime): ");
                    double newOvertimeHours = oop.nextDouble();
                    payrollSystem.updateEmployee(indexToUpdate, newName, newHoursWorked, newHourlyRate, newOvertimeHours);
                    System.out.println("*******************************\n");
                    break;

                case 4:
                    System.out.println("\n*******************************");
                    System.out.print("* Enter Employee Index to Remove: ");
                    int indexToRemove = oop.nextInt();
                    payrollSystem.removeEmployee(indexToRemove);
                    System.out.println("Employee removed successfully.");
                    System.out.println("*******************************\n");
                    break;

                case 5:
                    System.out.println("\n*******************************");
                    System.out.println("\tExiting Payroll System");
                    System.out.println("*******************************\n");
                    System.exit(0);
                    break;

                default:
                    System.out.println("\n*******************************");
                    System.out.println("Invalid option. Please try again.");
                    System.out.println("*******************************\n");
            }
        }
    }
}