

public class Patient extends Doctor {
     private   double Age;
    private  String Address;
    private  String number;
    
    public Patient(String Name, String id , String number , double Age , String Address) {
        super(Name, id);
        this.Age = Age;
        this.Address=Address;
        this.number = number;
    }

    public double getAge() {
        return Age;
    }

    public String getAddress() {
        return Address;
    }

    public String getNumber() {
        return number;
    }
    
    @Override
     public void displayInformation(){
         System.out.println(" ***************patient information*********** ");
         System.out.print(" Patient name is : " +  name + "     ");
          System.out.print(" Patient ID is : " +  id  + "     ");
           System.out.print(" Patient Address is : " +  Address + "     ");
            System.out.println(" Patient Age is : " +  Age);
     }
}
