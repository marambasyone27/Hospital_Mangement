
public class Nurse extends Manager {

    public Nurse(String name, String id, double salary) {
        super(name, id, salary);
    }

    public Nurse(String name, String id) {
        super(name, id);
    }

    @Override
    public void calculateYearlySalary() {
         System.out.println("Yearly Salary of the Nurse : " +getSalary() * 12);
    }

    
    public void salaryAfterIncrease(int val) {
        double salaryAfter = getSalary() + (getSalary() * (val / 100.0));
          System.out.println("Doctor's salary after increase: " + salaryAfter);
    }

    @Override
    public void displayInformation() {
        System.out.println("*********************** Nurse Details ***********************");
        System.out.println("Nurse Name: " + getName());
        System.out.println("Nurse ID: " + getId());
        System.out.println("Nurse Salary: " + getSalary());
        System.out.println("Annual salary of nurse: " ); 
        calculateYearlySalary();
    }
}