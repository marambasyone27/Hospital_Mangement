import java.util.ArrayList;

public class Medication_And_Treatment_Management {

    private ArrayList<Prescription> prescriptions = new ArrayList<>();
    private ArrayList<Medication> medicationInventory = new ArrayList<>();

    public void prescribeMedication(String patientId, String medicationName, String dosage, String frequency, String duration) {
        Prescription prescription = new Prescription(patientId, medicationName, dosage, frequency, duration);
        prescriptions.add(prescription);
        System.out.println("Medication prescribed successfully:");
        prescription.displayPrescription();
    }

    public void addMedication(String medicationName, int quantity) {
        if (quantity <= 0) {
            System.out.println("Quantity must be positive.");
            return;
        }

        Medication existingMedication = findMedication(medicationName);
        if (existingMedication != null) {
            existingMedication.setQuantity(existingMedication.getQuantity() + quantity);
        } else {
            Medication newMedication = new Medication(medicationName, quantity);
            medicationInventory.add(newMedication);
        }
        System.out.println("Medication added successfully: " + medicationName + ", Quantity: " + quantity);
    }

    public void updateMedicationQuantity(String medicationName, int newQuantity) {
        if (newQuantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        Medication medication = findMedication(medicationName);
        if (medication != null) {
            medication.setQuantity(newQuantity);
            System.out.println("Medication quantity updated: " + medicationName + ", New Quantity: " + newQuantity);
        } else {
            System.out.println("Medication not found in inventory: " + medicationName);
        }
    }

    public void removeMedication(String medicationName) {
        Medication medication = findMedication(medicationName);
        if (medication != null) {
            medicationInventory.remove(medication);
            System.out.println("Medication removed from inventory: " + medicationName);
        } else {
            System.out.println("Medication not found in inventory: " + medicationName);
        }
    }

     private Medication findMedication(String medicationName) {
        for (Medication medication : medicationInventory) {
            if (medication.getName().equalsIgnoreCase(medicationName.trim())) { 
                return medication;
            }
        }
        return null;
    }

    private class Prescription {
        private String patientId;
        private String medicationName;
        private String dosage;
        private String frequency;
        private String duration;

        public Prescription(String patientId, String medicationName, String dosage, String frequency, String duration) {
            this.patientId = patientId;
            this.medicationName = medicationName;
            this.dosage = dosage;
            this.frequency = frequency;
            this.duration = duration;
        }

        public String getPatientId() {
            return patientId;
        }

        public String getMedicationName() {
            return medicationName;
        }

        public String getDosage() {
            return dosage;
        }

        public String getFrequency() {
            return frequency;
        }

        public String getDuration() {
            return duration;
        }

        public void displayPrescription() {
            System.out.println("---------------------------------Medicine Prescription---------------------------------");
            System.out.print("Patient ID: " + patientId + "   ");
            System.out.print("Medicine Name: " + medicationName + "   ");
            System.out.print("Dosage: " + dosage + "   ");
            System.out.print("Frequency: " + frequency + "   ");
            System.out.println("Duration: " + duration);
        }
    }

    public class Medication {
        private String name;
        private int quantity;

        public Medication(String name, int quantity) {
            this.name = name;
            this.quantity = quantity;
        }

        public String getName() { 
            return name;
        }
        public int getQuantity() { 
            return quantity; 
        }
        public void setQuantity(int quantity) { 
            this.quantity = quantity; 
        }

        public void displayDetails() {
            System.out.println("---------------------Medication Details---------------------");
            System.out.print("Medicine Name: " + name + "   ");
            System.out.println("Quantity: " + quantity);
        }
    }
}
