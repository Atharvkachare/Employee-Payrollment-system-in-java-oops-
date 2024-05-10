import java.util.ArrayList;

abstract class Employee{
    private String name;
    private int id;

    public Employee(String name, int id){
        this.name = name;
        this.id = id;
    }
// Encapsulation
    public String getName(){
        return name;
    }
    public int getId(){
        return id;
    }
// Abstract method
    public abstract double calculateSalary();
    // Polymorphism
    @Override
    public String toString(){
        return "Employee[name]"+name+", id="+id+", salary="+calculateSalary()+"]";
    }
    
}

class FullTimeEmployee extends Employee{
     private double monthlySalary;
    public FullTimeEmployee(String name, int id, double monthlySalary) {
        super(name, id);
        //TODO Auto-generated constructor stub
        this.monthlySalary = monthlySalary();
    }
    private double monthlySalary() {
        return monthlySalary;
    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
        //throw new UnsupportedOperationException("Unimplemented method 'calculateSalary'");
        return monthlySalary;
    }
}

class PartTimeEmployee extends Employee{
    private int hoursWorked;
    private double hoursRate;

    public PartTimeEmployee(String name, int id, int hoursWorked, double hoursRate){
        super(name, id);
        this.hoursWorked=hoursWorked;
        this.hoursRate=hoursRate;

    }

    @Override
    public double calculateSalary() {
        // TODO Auto-generated method stub
       // throw new UnsupportedOperationException("Unimplemented method 'calculateSalary'");
       return hoursWorked*hoursRate;
    }
    

}

class PayRollSystem{
    private ArrayList<Employee> employeeList;
    public PayRollSystem(){
        employeeList = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        employeeList.add(employee);
    }

    public void removeEmployee(int id){
         Employee employeeToRemove = null;
         for(Employee employee : employeeList){
             if(employee.getId()==id){
                employeeToRemove = employee;
                break;
             }
         }
         if(employeeToRemove!=null){
            employeeList.remove(employeeToRemove);
         }
    }

    public void displayEmployees(){
        for(Employee employee :employeeList ){
            System.out.println(employee);
        }
    }
}
public class Main{
public static void main(String[] args) {
   PayRollSystem payRollSystem = new PayRollSystem();
   FullTimeEmployee emp1 = new FullTimeEmployee("Vikas", 1, 70000);
   PartTimeEmployee emp2 = new PartTimeEmployee("Alex", 2, 40, 100);

   payRollSystem.addEmployee(emp1);
   payRollSystem.addEmployee(emp2);

   System.out.println("Initial Employee Details: ");
   payRollSystem.displayEmployees();
   System.out.println("Removing employees: ");
   payRollSystem.removeEmployee(2);
   System.out.println("Remaining Employees Details: ");
   payRollSystem.displayEmployees();
    
 }

}















