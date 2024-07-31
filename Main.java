
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("****************************************MAIN DETAILS****************************************");
        Manager manager = new Manager("Maram", "1122", 3000000);
        manager.calculateYearlySalary();
        manager.displayInformation();
        System.out.println("");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Choose an option: \n");
            System.out.println("1. Add Doctor or Nurse or Register Patient ");
            System.out.println("2. Search about Doctor or Nurse or  Patient");
            System.out.println("3. Remove Doctor or Nurse or  Patient");
            System.out.println("4. Add or return Patient's Medical History");
            System.out.println("5. Calculate Salary for Doctor or Nurse");
            System.out.println("6. Appointment Management of patients");
            System.out.println("7. Medication And Treatment Management for patients");
            System.out.println("8. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1 -> {
                    System.out.println("\n Enter who you want to add (Doctor , Nurse , Patient)");
                    System.out.println(" ADD doctor. If you want to Add new doctor ");
                    System.out.println(" ADD Nurse. If you want to Add new Nurse ");
                    System.out.println("Register Patient. If you want to Register Patient ");

                    String Add = scanner.nextLine();

                    if (Add.equalsIgnoreCase("ADD doctor")) {
                        System.out.print("Enter Doctor name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Doctor ID: ");
                        String DoctorID = scanner.nextLine();
                        System.out.print("Enter Doctor Salary: ");
                        double DoctorSalary = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        Doctor doctor = new Doctor(name, DoctorID, DoctorSalary);
                        manager.addDoctor(doctor);
                        doctor.displayInformation();
                    } else if (Add.equalsIgnoreCase("ADD Nurse")) {
                        System.out.print("Enter Nurse name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Nurse ID: ");
                        String NurseID = scanner.nextLine();
                        System.out.print("Enter Nurse Salary: ");
                        double NurseSalary = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        Nurse nurse = new Nurse(name, NurseID, NurseSalary);
                        manager.addNurse(nurse);
                        nurse.displayInformation();
                    } else if (Add.equalsIgnoreCase("Register Patient")) {
                        System.out.print("Enter Patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String PatientID = scanner.nextLine();
                        System.out.print("Enter Patient Number to Contact: ");
                        String PatientNumber = scanner.nextLine();
                        System.out.print("Enter the Age of the Patient: ");
                        double PatientAge = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter The Address of the Patient: ");
                        String PatientAddress = scanner.nextLine();
                        Patient_Mangement mang = new Patient_Mangement(name, PatientID, PatientNumber, PatientAge, PatientAddress);
                        mang.registerPatient(mang);
                    } else {
                        System.out.println("Invalid input, please try Again");
                    }
                }

                case 2 -> {
                    System.out.println("\n Enter, who do you want to search for (Doctor , Nurse , Patient)");
                    System.out.println(" Sereach_doctor . If you want to search about a doctor ");
                    System.out.println(" Sereach_Nurse. If you want  to search about a Nurse ");
                    System.out.println(" Find Patient. If you want  to find a Patient ");

                    String sereach = scanner.nextLine();

                    if (sereach.equalsIgnoreCase("Sereach_doctor")) {
                        String DoctorID = scanner.nextLine();
                        manager.searchDoctorByID(DoctorID);

                    } else if (sereach.equals("Sereach_Nurse")) {
                        System.out.print("Enter Nurse ID: ");
                        String NurseID = scanner.nextLine();
                        manager.searchNurseByID(NurseID);

                    } else if (sereach.equalsIgnoreCase("Find Patient")) {
                        System.out.print("Enter Patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String PatientID = scanner.nextLine();
                        System.out.print("Enter Patient Number to Contact: ");
                        String PatientNumber = scanner.nextLine();
                        System.out.print("Enter the Age of the Patient: ");
                        double PatientAge = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter The Address of the Patient: ");
                        String PatientAddress = scanner.nextLine();
                        Patient_Mangement mang = new Patient_Mangement(name, PatientID, PatientNumber, PatientAge, PatientAddress);
                        mang.findPatientById(PatientID);
                    } else {
                        System.out.println("Invalid input, please try Again");
                    }
                }

                case 3 -> {
                    System.out.println("\n Enter, who do you want to Delete (Doctor , Nurse , Patient)");
                    System.out.println(" Del_doctor . If you want to Remove a doctor ");
                    System.out.println(" Del_Nurse. If you want to Remove a  Nurse ");
                    System.out.println(" Del_Patient. If you want to Remove  a Patient ");

                    String remove = scanner.nextLine();

                    if (remove.equalsIgnoreCase("Del_doctor")) {

                        System.out.print("Enter Doctor ID: ");
                        String DoctorID = scanner.nextLine();

                        try {
                            manager.removeDoctorById(DoctorID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (remove.equalsIgnoreCase("Del_Nursee")) {

                        System.out.print("Enter Nurse ID: ");
                        String NurseID = scanner.nextLine();

                        try {
                            manager.removeNurseById(NurseID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } else if (remove.equalsIgnoreCase("Del_Patient")) {
                        System.out.print("Enter Patient name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Patient ID: ");
                        String PatientID = scanner.nextLine();
                        System.out.print("Enter Patient Number to Contact: ");
                        String PatientNumber = scanner.nextLine();
                        System.out.print("Enter the Age of the Patient: ");
                        double PatientAge = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        System.out.print("Enter The Address of the Patient: ");
                        String PatientAddress = scanner.nextLine();
                        Patient_Mangement mang = new Patient_Mangement(name, PatientID, PatientNumber, PatientAge, PatientAddress);
                        try {
                            mang.RemovePatient(PatientID);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        System.out.println("Invalid input, please try Again");
                    }
                }

                case 4 -> {
                    System.out.print("Enter Patient Condition: ");
                    String Condition = scanner.nextLine();
                    System.out.print("Enter Patient Treatment: ");
                    String treatment = scanner.nextLine();
                    System.out.print("Enter the name of the Doctor : ");
                    String Doc_name = scanner.nextLine();
                    System.out.print("Enter The Date: ");
                    String date = scanner.nextLine();
                    System.out.print("Write a note you would like to give to the patient : ");
                    String notes = scanner.nextLine();
                    System.out.print("Enter Patient name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient ID: ");
                    String PatientID = scanner.nextLine();
                    System.out.print("Enter Patient Number to Contact: ");
                    String PatientNumber = scanner.nextLine();
                    System.out.print("Enter the Age of the Patient: ");
                    double PatientAge = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter The Address of the Patient: ");
                    String PatientAddress = scanner.nextLine();
                    Patient_Mangement mange = new Patient_Mangement(Condition, treatment, Doc_name, date, notes, name, PatientID, PatientNumber, PatientAge, PatientAddress);
                    Patient_Mangement mang = new Patient_Mangement(name, PatientID, PatientNumber, PatientAge, PatientAddress);
                    System.out.println("\n Enter, who do you want to do (Add or return Patient's Medical History)");
                    System.out.println(" Add_Medical . if you want to Add Patient's Medical History ");
                    System.out.println(" Return_Medical . if you want to Return Patient's Medical History ");
                    System.out.println(" Add,Return_Medical . if you want to Add and Return Patient's Medical History ");
                    String Make = scanner.nextLine();
                    if (Make.equalsIgnoreCase("Add_Medical")) {

                        mange.addMedicalHistory(mange, Condition, treatment, Doc_name, date, notes);
                    } else if (Make.equalsIgnoreCase("Return_Medical")) {

                        mang.returnMedicalHistories(PatientID);
                    } else if (Make.equalsIgnoreCase("Add,Return_Medical")) {
                        mange.addMedicalHistory(mange, Condition, treatment, Doc_name, date, notes);
                        mang.returnMedicalHistories(PatientID);
                    } else {
                        System.out.println("Invalid input, please try Again");
                    }
                }

                case 5 -> {
                    System.out.println("\n Enter, who do you want to Calculate Salary (Doctor , Nurse)");
                    System.out.println(" Doctor . If you want to calculate Doctor's Salary ");
                    System.out.println(" Nurse. If you want to calculate Doctor's Salary ");
                    String calc = scanner.nextLine();
                    if (calc.equalsIgnoreCase("Doctor")) {
                        System.out.print("Enter Doctor name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Doctor ID: ");
                        String DoctorID = scanner.nextLine();
                        System.out.print("Enter Doctor Salary: ");
                        double DoctorSalary = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        Doctor doctor = new Doctor(name, DoctorID, DoctorSalary);
                        doctor.calculateYearlySalary();
                        System.out.println("Enter the value of the bonus to increase the doctor's salary");
                        int raised_value = scanner.nextInt();
                        doctor.salaryAfterIncrease(raised_value);
                    } else if (calc.equalsIgnoreCase("Nurse")) {
                        System.out.print("Enter Nurse name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter Nurse ID: ");
                        String NurseID = scanner.nextLine();
                        System.out.print("Enter Nurse Salary: ");
                        double NurseSalary = scanner.nextDouble();
                        scanner.nextLine(); // Consume newline
                        Nurse nurse = new Nurse(name, NurseID, NurseSalary);
                        nurse.calculateYearlySalary();
                        System.out.println("Enter the value of the bonus to increase the Nurse's salary");
                        int raised_value = scanner.nextInt();
                        nurse.salaryAfterIncrease(raised_value);
                    } else {
                        System.out.println("invalid input , please check again");
                    }

                }

                case 6 -> {
                    System.out.println("\n Enter, what do you want to do ");
                    System.out.println("1. if you want to schedule the Appointment of the patient ");
                    System.out.println("2. if you want to update AppointmentSchedule of the patient");
                    System.out.println("3. if you want to cancel the Appointment of the patient");
                    System.out.println("4. if you want to  view Appointments  Patient BY His/her ID of the patient");
                    System.out.println("5. if you want to Solve the problem of conflicting appointments");
                    System.out.println("6. if you want to Viewing All Appointments");
                    int press = scanner.nextInt();

                    if (press == 1) {
                        System.out.println("Enter appointment ID: ");
                        String appointmentId = scanner.next();
                        System.out.println("Enter Patient ID: ");
                        String PatientID = scanner.next();
                        System.out.println("Enter Doctor name: ");
                        String name = scanner.next();
                        System.out.println("Enter The Date: ");
                        String date = scanner.next();
                        System.out.println("Enter The Time: ");
                        String time = scanner.next();
                        AppointmentManagement appoint = new AppointmentManagement(appointmentId, PatientID, name, date, time);
                        appoint.scheduleAppointment(appointmentId, PatientID, name, date, time);
                    } else if (press == 2) {
                        System.out.print("Enter appointment ID: ");
                        String appointmentId = scanner.next();
                        System.out.println("Enter Patient ID: ");
                        String PatientID = scanner.next();
                        System.out.println("Enter Doctor name: ");
                        String name = scanner.next();
                        System.out.println("Enter The Date: ");
                        String date = scanner.next();
                        System.out.println("Enter The Time: ");
                        String time = scanner.next();
                        AppointmentManagement appoint = new AppointmentManagement(appointmentId, PatientID, name, date, time);
                        appoint.updateAppointmentSchedule(appointmentId, date, time);
                    } else if (press == 3) {
                        System.out.println("Enter appointment ID: ");
                        String appointmentId = scanner.next();
                        System.out.println("Enter Patient ID: ");
                        String PatientID = scanner.next();
                        System.out.println("Enter Doctor name: ");
                        String name = scanner.next();
                        System.out.println("Enter The Date: ");
                        String date = scanner.next();
                        System.out.println("Enter The Time: ");
                        String time = scanner.next();
                        AppointmentManagement appoint = new AppointmentManagement(appointmentId, PatientID, name, date, time);
                        appoint.cancelAppointment(appointmentId);
                    } else if (press == 4) {
                        System.out.println("Enter appointment ID: ");
                        String appointmentId = scanner.next();
                        System.out.println("Enter Patient ID: ");
                        String PatientID = scanner.next();
                        System.out.println("Enter Doctor name: ");
                        String name = scanner.next();
                        System.out.println("Enter The Date: ");
                        String date = scanner.next();
                        System.out.println("Enter The Time: ");
                        String time = scanner.next();
                        AppointmentManagement appoint = new AppointmentManagement(appointmentId, PatientID, name, date, time);
                        appoint.viewAppointmentsPatientById(PatientID);
                    } else if (press == 5) {
                        System.out.println("Enter appointment ID: ");
                        String appointmentId = scanner.next();
                        System.out.println("Enter Patient ID: ");
                        String PatientID = scanner.next();
                        System.out.println("Enter Doctor name: ");
                        String name = scanner.next();
                        System.out.println("Enter The Date: ");
                        String date = scanner.next();
                        System.out.println("Enter The Time: ");
                        String time = scanner.next();
                        AppointmentManagement appoint = new AppointmentManagement(appointmentId, PatientID, name, date, time);
                        appoint.resolveConflicts();
                    } else if (press == 6) {
                        System.out.println("Enter appointment ID: ");
                        String appointmentId = scanner.next();
                        System.out.println("Enter Patient ID: ");
                        String PatientID = scanner.next();
                        System.out.println("Enter Doctor name: ");
                        String name = scanner.next();
                        System.out.println("Enter The Date: ");
                        String date = scanner.next();
                        System.out.println("Enter The Time: ");
                        String time = scanner.next();
                        AppointmentManagement appoint = new AppointmentManagement(appointmentId, PatientID, name, date, time);
                        appoint.viewAppointments();
                    } else {
                        System.out.println("invalid input , please check again");
                    }
                }
                case 7 -> {
                 Medication_And_Treatment_Management treat = new Medication_And_Treatment_Management();

            System.out.println("\n Enter, what do you want to make:");
            System.out.println("1. Prescribe a medication to the patient");
            System.out.println("2. Add medication");
            System.out.println("3. Update medication quantity");
            System.out.println("4. Remove a medication");
            System.out.println("5. Exit");

            int input = scanner.nextInt();
            scanner.nextLine(); 

            switch (input) {
                case 1:
                    System.out.print("Enter Patient ID: ");
                    String patientID = scanner.nextLine();
                    System.out.print("Enter Medicine name: ");
                    String medicineName = scanner.nextLine();
                    System.out.print("Enter the dose given of the medicine: ");
                    String dosage = scanner.nextLine();
                    System.out.print("Enter the number of times to repeat the medication daily: ");
                    String frequency = scanner.nextLine();
                    System.out.print("Enter how long you should take this medicine: ");
                    String duration = scanner.nextLine();
                    treat.prescribeMedication(patientID, medicineName, dosage, frequency, duration);
                    break;

                case 2:
                  System.out.print("Enter Medicine name: ");
                    String newMedicineName = scanner.nextLine();
                    System.out.print("Enter the available quantity of this medicine: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine(); 
                    treat.addMedication(newMedicineName, quantity);
                    break;

                case 3:
                    System.out.print("Enter Medicine name: ");
                    String updateMedicineName = scanner.nextLine();
                    System.out.print("Enter the new quantity for the medication: ");
                    int newQuantity = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    treat.updateMedicationQuantity(updateMedicineName, newQuantity);
                    break;

                case 4:
                    System.out.print("Enter Medicine name: ");
                    String removeMedicineName = scanner.nextLine();
                    treat.removeMedication(removeMedicineName);
                    break;

                default:
                    System.out.println("Invalid input, please try again.");
                    break;
            }
        }
    

                
                case 8 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default ->
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
