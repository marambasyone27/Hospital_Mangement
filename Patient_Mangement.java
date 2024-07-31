

import java.util.ArrayList;
import java.util.List;

public class Patient_Mangement extends Patient implements Hospital_Mangement {
    private String condition;
    private String treatment;
    private String doctorName;
    private String date;
    private String notes;

    private static List<Patient_Mangement> medicalHistories = new ArrayList<>();

    
    public Patient_Mangement(String condition, String treatment, String doctorName, String date, String notes, String name, String id, String number, double age, String address) {
        super(name, id, number, age, address);
        this.condition = condition;
        this.treatment = treatment;
        this.doctorName = doctorName;
        this.date = date;
        this.notes = notes;
    }

   
    public Patient_Mangement(String name, String id, String number, double age, String address) {
        super(name, id, number, age, address);
    }

    public void registerPatient(Patient patient) {
        System.out.println("_______________Patient Registration_______________");
        Patients.add(patient);
        System.out.println("Patient with ID: " + patient.getId() + " has been added successfully.");
    }

    public void findPatientById(String patientId) {
        System.out.println("_______________Finding Patient_______________");
        for (Patient patient : Patients) {
            if (patient.getId().equals(patientId)) {
                System.out.println("Patient with ID: " + patient.getId() + " found");
                patient.displayInformation();
                return;
            }
        }
        System.out.println("Patient not found.");
    }

 public void RemovePatient(String patientId) throws Exception {
    System.out.println("_______________Removing Patient_______________");
    patientId = patientId.trim(); 
    Patient patientToRemove = null;

    System.out.println("Current patients in the list:");
    for (Patient patient : Patients) {
        System.out.println("Patient ID: " + patient.getId());
    }

    System.out.println("Patient ID to remove: " + patientId);

    for (Patient patient : Patients) {
        if (patient.getId().trim().equals(patientId)) {
            patientToRemove = patient;
            break;
        }
    }

    if (patientToRemove != null) {
        Patients.remove(patientToRemove);
        System.out.println("Patient with ID: " + patientId + " has been removed successfully");
        patientToRemove.displayInformation();
    } else {
        throw new Exception("Patient does not exist.");
    }
}


    public void addMedicalHistory(Patient patient, String condition, String treatment, String doctorName, String date, String notes) {
        System.out.println("_______________Adding Medical History_______________");

        if (patient != null) {
            Patient_Mangement medicalHistory = new Patient_Mangement(condition, treatment, doctorName, date, notes, patient.getName(), patient.getId(), patient.getNumber(), patient.getAge(), patient.getAddress());
            medicalHistories.add(medicalHistory);
            System.out.println("Medical history added successfully for Patient ID: " + patient.getId());
        } else {
            System.out.println("Please double-check the patient's data.");
        }
    }

    public void returnMedicalHistories(String patientId) {
        System.out.println("_______________Displaying Medical Histories_______________");
        boolean historyFound = false;

        for (Patient_Mangement history : medicalHistories) {
            if (history.getId().trim().equals(patientId.trim())) {
                if (!historyFound) {
                    System.out.println("Medical histories for patient ID: " + patientId + ":");
                    historyFound = true;
                }
                history.displayPatientMedicalHistories();
                return;
            }
            else {
               System.out.println("No medical histories found for patient ID: " + patientId);
               return;
            }
        }

            
        
    }

    public void displayPatientMedicalHistories() {
        System.out.println("***************Patient Medical Histories***********");
        System.out.print("Condition: " + condition + "     ");
        System.out.print("Treatment: " + treatment + "     ");
        System.out.print("Doctor Name: " + doctorName + "     ");
        System.out.print("Date: " + date + "     ");
        System.out.println("Notes: " + notes);
    }
}
