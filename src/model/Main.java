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

        Appointment appointment = new Appointment(
                1,
                patients.get(1),
                doctors.get(0),
                "19.12.2025"
        );
        Appointment appointment1 = new Appointment(2, patients.get(0), doctors.get(1), "22.12.2025");

        System.out.println("--- Appointments ---");
        System.out.println(appointment);
        System.out.println(appointment1);
        System.out.println();

        System.out.println("\n=== Program Complete ===");
        System.out.println("==========================");
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
                case 5:
                    addAppointment();
                    break;
                case 6:
                    viewAllAppointment();
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
        System.out.println("5. Add Appointment");
        System.out.println("6. View All Appointments");
        System.out.println("0. Exit");
        System.out.println("Enter choice: _");
    }
    public static void addPatient(){
        System.out.print("Enter patient id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < patients.size(); i++){
            if (patients.get(i).getID() == id) {
                System.out.println("Patient with this ID is already exists!");
                return;
            }
        }

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

        for (int i = 0; i < doctors.size(); i++){
            if (doctors.get(i).getId() == id){
                System.out.println("Doctor with this ID is already exists!");
                return;
            }
        }

        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.println("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("Enter doctor expirience: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        Doctor newDoctor = new Doctor(id, name, specialization, experienceYears);
        doctors.add(newDoctor);

        System.out.println("Doctor added!");
    }
    public static void viewAllDoctors(){
        for(int i = 0; i < doctors.size(); i++){
            System.out.println(doctors.get(i));
        }
    }
    public static void addAppointment(){
        System.out.println("Enter appointment ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < appointments.size(); i++){
            if(appointments.get(i).getId() == id) {
                System.out.println("Appointment with this ID is already exist!");
                return;
            }
        }

        System.out.println("Enter patient ID: ");
        int patID = scanner.nextInt();
        scanner.nextLine();

        Patient patient = findPatientID(patID);
        if (patient == null) {
            System.out.println("Patient not found!");
            return;
        }

        System.out.println("Enter doctor ID: ");
        int docID = scanner.nextInt();
        scanner.nextLine();

        Doctor doctor = findDoctorID(docID);
        if (doctor == null) {
            System.out.println("Doctor not found!");
            return;
        }

        System.out.println("Enter date of appointment: ");
        String date = scanner.nextLine();
    }
    public static void viewAllAppointment(){
        for (int i = 0; i < appointments.size(); i++){
            System.out.println(appointments.get(i));
        }
    }
    public static Patient findPatientID(int id) {
        for (int i = 0; i < patients.size(); i++){
            if(patients.get(i).getID() == id){
                return patients.get(i);
            }
        }
        return null;
    }
    public static Doctor findDoctorID(int id) {
        for (int i = 0; i < doctors.size(); i++){
            if(doctors.get(i).getId() == id){
                return doctors.get(i);
            }
        }
        return null;
    }




}
