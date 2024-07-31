/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Maram Basyone
 */
 public class Manager implements Hospital_Mangement {
    protected String name;
    protected String id;
    protected double salary;

    public Manager(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Manager(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public double getSalary() {
        return salary;
    }

    public void addDoctor(Doctor doctor) {
        Doctors.add(doctor);
        System.out.println("Good job, this doctor which his ID is : " + doctor.getId() +"has been added successfully.");
    }

    public void searchDoctorByID(String ID) {
        System.out.println("================= Search by ID result =================");
        for (Doctor doctor : Doctors) {
            if (doctor.getId().equalsIgnoreCase(ID)) {
                System.out.println("This doctor is found and the name is: " + doctor.getName());
                return;
            }
        }
        System.out.println("This doctor is not found.");
    }

  public void removeDoctorById(String id) throws Exception {
    try {
        Doctor doctorToRemove = null;
        for (Doctor doctor : Doctors) {
            if (doctor.getId().equals(id)) {
                doctorToRemove = doctor;
                break;
            }
        }

        if (doctorToRemove != null) {
            Doctors.remove(doctorToRemove);
            System.out.println("Done! This doctor with ID: " + id + " has been suspended from work.");
        } else {
            throw new Exception("OH NO! This doctor with ID " + id + " does not exist.");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw e;
    }
}


    public void addNurse(Nurse nurse) {
        Nurses.add(nurse);
        System.out.println("Good job, this nurse which his ID is : " + nurse.getId() +"   has been added successfully.");
    }

public void removeNurseById(String id) throws Exception {
    try {
        Nurse nurseToRemove = null;
        for (Nurse nurse : Nurses) {
            if (nurse.getId().equals(id)) {
                nurseToRemove = nurse;
                break;
            }
        }

        if (nurseToRemove != null) {
            Nurses.remove(nurseToRemove);
            System.out.println("Done! This nurse with ID: " + id + " has been suspended from work.");
        } else {
            throw new Exception("OH NO! This nurse with ID " + id + " does not exist.");
        }
    } catch (Exception e) {
        System.out.println(e.getMessage());
        throw e;
    }
}


    public void searchNurseByID(String ID) {
        System.out.println("================= Search by ID result =================");
        for (Nurse nurse : Nurses) {
            if (nurse.getId().equalsIgnoreCase(ID)) {
                System.out.println("This nurse is found and the name is: " + nurse.getName());
                return;
            }
        }
        System.out.println("This nurse is not found.");
    }

     public void calculateYearlySalary(){
      System.out.println("Yearly Salary of the Manger : " +getSalary() * 12);
     }
   

    public void displayInformation() {
        System.out.println("*********************** Manager Details ***********************");
        System.out.println("Manager Name: " + name);
        System.out.println("Manager ID: " + id);
        System.out.println("Manager Salary: " + salary);
    }
}

