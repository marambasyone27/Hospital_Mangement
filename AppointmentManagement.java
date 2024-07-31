import java.util.ArrayList;
import java.util.List;

/**
 * Manages appointments including scheduling, updating, canceling, and viewing
 * appointments.
 */
public class AppointmentManagement implements Hospital_Mangement {

    private static List<AppointmentManagement> appointments = new ArrayList<>();
    private String appointmentId;
    private String patientId;
    private String doctorName;
    private String date;
    private String time;

    // Constructor, Getters, and Setters
    public AppointmentManagement(String appointmentId, String patientId, String doctorName, String date, String time) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorName = doctorName;
        this.date = date;
        this.time = time;
    }

    public void setDate(String date) { 
        this.date = date;
    }
    public void setTime(String time) { 
        this.time = time; 
    }
    public String getAppointmentId() { 
        return appointmentId; 
    }
    public String getPatientId() { 
        return patientId; 
    }
    public String getDoctorName() { 
        return doctorName; 
    }
    public String getDate() {
        return date; 
    }
    public String getTime() { 
        return time;
    }

    public void scheduleAppointment(String appointmentId, String patientId, String doctorName, String date, String time) {
        AppointmentManagement appointment = new AppointmentManagement(appointmentId, patientId, doctorName, date, time);
        appointments.add(appointment);
        System.out.println("Appointment scheduled successfully.");
    }

      private static AppointmentManagement findAppointmentById(String appointmentId) {
        for (AppointmentManagement appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                return appointment;
            }
        }
          System.out.println("This appointment is not found");
        return null;
    }
      
   public void updateAppointmentSchedule(String appointmentId, String newDate, String newTime) {
        System.out.println("_______________Updating Appointment Schedule_______________");
        AppointmentManagement appointment = findAppointmentById(appointmentId);
        if (appointment != null) {
            appointment.setDate(newDate);
            appointment.setTime(newTime);
            System.out.println("Appointment updated successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void cancelAppointment(String appointmentId) {
        System.out.println("_______________Canceling Appointment_______________");
        AppointmentManagement appointmentToRemove = null;
        for (AppointmentManagement appointment : appointments) {
            if (appointment.getAppointmentId().equals(appointmentId)) {
                appointmentToRemove = appointment;
                break;
            }
        }
        if (appointmentToRemove != null) {
            appointments.remove(appointmentToRemove);
            System.out.println("Appointment canceled successfully.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    public void viewAppointments() {
        System.out.println("_______________Viewing All Appointments_______________");
        if (appointments.isEmpty()) {
            System.out.println("No appointments available.");
        } else {
            for (AppointmentManagement appointment : appointments) {
                appointment.displayAppointmentDetails();
            }
        }
    }

    public void viewAppointmentsPatientById(String patientId) {
        System.out.println("_______________Appointments for Patient ID: " + patientId + "_______________");
        boolean found = false;
        for (AppointmentManagement appointment : appointments) {
            if (appointment.getPatientId().equals(patientId)) {
                appointment.displayAppointmentDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No appointments found for Patient ID: " + patientId);
        }
    }

    public void displayAppointmentDetails() {
        System.out.println("*************************Appointment Details*************************");
        System.out.print("Patient ID: " + patientId + "     ");
        System.out.print("Appointment ID: " + appointmentId + "     ");
        System.out.print("Doctor Name: " + doctorName + "     ");
        System.out.print("Date: " + date + "     ");
        System.out.println("Time: " + time);
    }

    public void resolveConflicts() {
        System.out.println("_______________Resolving Schedule Conflicts_______________");
        for (int i = 0; i < appointments.size(); i++) {
            AppointmentManagement appointment1 = appointments.get(i);
            for (int j = i + 1; j < appointments.size(); j++) {
                AppointmentManagement appointment2 = appointments.get(j);
                if (appointment1.getDate().equals(appointment2.getDate())
                        && appointment1.getTime().equals(appointment2.getTime())
                        && !appointment1.getAppointmentId().equals(appointment2.getAppointmentId())) {
                    System.out.println("Conflict detected:");
                    System.out.println("Appointment 1: " + appointment1);
                    System.out.println("Appointment 2: " + appointment2);
                }
            }
        }
        System.out.println("Check complete.");
    }
}
