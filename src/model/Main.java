package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        doctors.add(new Doctor(3, "Dr.Mark", "surgeon", 12));
        doctors.add(new Doctor(4, "Dr.Dana", "surgeon helper", 3));
        doctors.add(new Doctor(5, "Dr.Nazar", "director", 20));

        patients.add(new Patient(4, 15, "appendicitis", "Nuray Eshimova"));
        patients.add(new Patient(5, 20, "liver transplant", "Aydin Kasteev"));

        appointments.add(new Appointment(10, patients.get(0), doctors.get(0), "30.12.2025"));

        System.out.println();
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
        boolean running = true;
        while (running){
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewAllPatients();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewAllDoctors();
                    break;
                case 0:
                    System.out.println("Goodbye, see you later!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid action");
            }
        }
    }
    public static void displayMenu() {
        System.out.println("=== HOSPITAL SYSTEM ===");
        System.out.println("1. Add Patient");
        System.out.println("2. View All Patients");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Doctors");
        System.out.println("0. Exit");
        System.out.println("Enter choice: _");
    }
    public static void addPatient(){
        System.out.print("Enter patient id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter patient illness: ");
        String illness = scanner.nextLine();

        System.out.print("Enter patient name: ");
        String name = scanner.nextLine();

        Patient newPatient = new Patient(id, age, illness, name);
        patients.add(newPatient);

        System.out.println("Patient added!");
    }
    public static void viewAllPatients(){
        for (int i = 0; i < patients.size(); i++){
            System.out.println(patients.get(i));
        }
    }
    public static void addDoctor(){
        System.out.println("Enter doctor id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.println("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("Enter doctor expirience: ");
        int expirienceYears = scanner.nextInt();
        scanner.nextLine();

        Doctor newDoctor = new Doctor(id, name, specialization, expirienceYears);
        doctors.add(newDoctor);

        System.out.println("Doctor added!");
    }
    public static void viewAllDoctors(){
        for(int i = 0; i < doctors.size(); i++){
            System.out.println(doctors.get(i));
        }
    }


}
