package model;

public class Main {
    public static void main(String[] args){
        System.out.println("=== Hospital Management System ===");
        System.out.println();
        Patient patient1 = new Patient(1, 20, "flu", "Ilya Ermakov");
        Patient patient2 = new Patient(2,19,"fever", "Alimhan Bahanov");
        Patient patient3 = new Patient();

        Doctor doctor1 = new Doctor(1, "Dr.Almas", "therapist", 10);
        Doctor doctor2 = new Doctor(2, "Dr.Ali", "main doctor", 20);
        Appointment appointment = new Appointment(
                1,
                patient1,
                doctor1,
                "19.12.2025"
        );
        Appointment appointment1 = new Appointment(2, patient2, doctor2, "22.12.2025");

        System.out.println("--- Patients ---");
        System.out.println(patient1);
        System.out.println(patient2);
        System.out.println(patient3);
        System.out.println();

        System.out.println("--- Doctors ---");
        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println();

        System.out.println("--- Appointments ---");
        System.out.println(appointment);
        System.out.println(appointment1);
        System.out.println();

        System.out.println("--- Testing Getters ---");
        System.out.println("Patient name: " + patient1.getName());
        System.out.println("Patient illness: " + patient1.getIllness());
        System.out.println("Doctor name: " + doctor1.getName());
        System.out.println("Doctor specialization: " + doctor2.getSpecialization());
        System.out.println("Appointment doctor: " + doctor1);
        System.out.println();

        System.out.println("--- Testing Setters ---");
        System.out.println("Updating patient1...");
        patient1.setName("Bekmansur Sadykov");
        patient1.setAge(20);
        patient1.setIllness("a cold");
        System.out.println("Updated: " + patient1);
        System.out.println();

        System.out.println("Changing Doctor1...");
        doctor1.setName("Dr.Azamat");
        System.out.println("Updated: " + doctor1);
        System.out.println();

        System.out.println("--- Testing Patient Methods ---");
        patient2.admitPatient();
        patient1.dischargePatient();
        System.out.println();

        System.out.println("--- Testing Doctor Methods ---");
        doctor2.assignPatient();
        doctor1.finishAppoinment();
        System.out.println();

        System.out.println("--- Testing Appointment Methods ---");
        appointment.startAppointment();
        appointment.comletedAppointment();
        System.out.println();

        System.out.println("--- Final State ---");
        System.out.println("All patients: ");
        System.out.println(patient1);
        System.out.println(patient2);
        System.out.println(patient3);
        System.out.println();

        System.out.println("Doctors: ");
        System.out.println(doctor1);
        System.out.println(doctor2);
        System.out.println();

        System.out.println("Appointments: ");
        System.out.println(appointment);
        System.out.println(appointment1);

        System.out.println("\n=== Program Complete ===");
    }

}
