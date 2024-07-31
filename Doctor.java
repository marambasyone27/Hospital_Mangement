
import java.util. *;

public class Doctor extends Manager {

    public Doctor(String name, String id, double salary) {
        super(name, id, salary);
    }

    public Doctor(String name, String id) {
        super(name, id);
    }

   
    
    @Override
     public void calculateYearlySalary() {
        System.out.println("Yearly Salary of the Doctor : " +getSalary() * 12);
    }

    @Override
    public void displayInformation() {
        System.out.println("*********************** Doctor Details ***********************");
        System.out.println("Doctor Name: " + getName());
        System.out.println("Doctor ID: " + getId());
        System.out.println("Doctor Salary: " + getSalary());
        System.out.print("Annual salary of doctor:  " ) ;
        calculateYearlySalary();
    }

   
   public void salaryAfterIncrease(int val) {
        double salaryAfter = getSalary() + (getSalary() * (val / 100.0));
        System.out.println("Doctor's salary after increase: " + salaryAfter);
       
    }
}

