package model;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Doctor> doctors = new ArrayList<>();
    private static ArrayList<Patient> patients = new ArrayList<>();
    private static ArrayList<Appointment> appointments = new ArrayList<>();
    private static ArrayList<Person> people = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        doctors.add(new Doctor(3, "Dr.Mark", 45, "surgeon", 12));
        doctors.add(new Doctor(4, "Dr.Dana", 44, "surgeon helper", 3));
        doctors.add(new Doctor(5, "Dr.Nazar", 40, "director", 20));

        patients.add(new Patient(4, 15, "appendicitis", "Nuray Eshimova"));
        patients.add(new Patient(5, 20, "liver transplant", "Aydin Kasteev"));

        people.add(new Patient(6, 22, "flu", "Alihan Smaev"));
        people.add(new Doctor(6, "Dr. Saya", 47, "Surgeon", 22));

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
                    addPerson();
                    break;
                case 2:
                    addPatient();
                    break;
                case 3:
                    addDoctor();
                    break;
                case 4:
                    viewAllPeople();
                    break;
                case 5:
                    demonPolymor();
                    break;
                case 6:
                    viewAllPatients();
                    break;
                case 7:
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
        System.out.println("1. Add Person");
        System.out.println("2. Add Patient");
        System.out.println("3. Add Doctor");
        System.out.println("4. View All Person(Polymorphic)");
        System.out.println("5. Start treatment(Polymorphism Demo)");
        System.out.println("6. View Only Patient");
        System.out.println("7. View Only Doctors");
        System.out.println("0.Exit");
        System.out.println("Enter choice: _");
    }
    public static void addPerson(){
        System.out.println("Enter person ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if (id < 0) {
           System.out.print("ID cannot be negative") ;
           return;
        }
        for(int i = 0; i < people.size(); i++){
            if(people.get(i).getId() == id){
                System.out.print("Person with this ID is already");
                return;
            }
        }

        System.out.println("Enter person name: ");
        String name = scanner.nextLine();

        if (!(name != null && !name.trim().isEmpty())) {
            System.out.print("Name cannot be empty");
            return;
        }

        System.out.println("Enter person age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        if (age < 0) {
            System.out.print("Cannot be negative");
            return;
        }
        Person newPerson = new Person(id, name, age);
        people.add(newPerson);

        System.out.println("Person added!");

    }
    public static void viewAllPeople(){
        System.out.println("==================");
        System.out.println("    ALL PEOPLE    ");
        System.out.println("==================");
        if (people.isEmpty()){
            System.out.println("NOT FOUND");
            return;
        }
        System.out.println("Total people " + people.size());
        System.out.println();

        for(int i = 0; i < people.size(); i++){
            System.out.println(people.get(i));
        }
    }
    public static void demonPolymor(){
        System.out.println("\n=======================");
        System.out.println("    POLYMORPHISM DEMO    ");
        System.out.println("=========================");
        System.out.println("Calling work() on all people");
        System.out.println();

        for (Person person : people){
            person.work();
        }
        System.out.println();
    }
    public static void addPatient(){
        System.out.print("Enter patient id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(id < 0){
            System.out.println("ID cannot be negative!");
            return;
        }

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
        people.add(newPatient);

        System.out.println("Patient added!");
    }
    public static void viewAllPatients(){
        System.out.println("\n==========================");
        System.out.println("       PATIENTS ONLY        ");
        System.out.println("===========================");

        int patietnsCount = 0;

        for (Person person : people){
            if (person instanceof Patient){
                Patient patient = (Patient) person;
                patietnsCount++;

                System.out.println(patietnsCount + "." + patient.getName());
                System.out.println("Name: " + patient.getName());
                System.out.println("Illness: " + patient.getIllness());
            }
        }
    }
    public static void addDoctor(){
        System.out.println("Enter doctor id: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        if(id < 0){
            System.out.println("ID cannot be negative!");
            return;
        }

        for (int i = 0; i < doctors.size(); i++){
            if (doctors.get(i).getId() == id){
                System.out.println("Doctor with this ID is already exists!");
                return;
            }
        }

        System.out.println("Enter doctor name: ");
        String name = scanner.nextLine();

        System.out.println("Enter doctor age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter doctor specialization: ");
        String specialization = scanner.nextLine();

        System.out.println("Enter doctor expirience: ");
        int experienceYears = scanner.nextInt();
        scanner.nextLine();

        Doctor newDoctor = new Doctor(id, name, age, specialization, experienceYears);
        people.add(newDoctor);

        System.out.println("Doctor added!");
    }
    public static void viewAllDoctors(){
        System.out.println("\n==========================");
        System.out.println("       DOCTORS ONLY        ");
        System.out.println("===========================");

        int doctorsCount = 0;

        for (Person person: people){
            if (person instanceof Doctor){
                Doctor doctor = (Doctor) person;
                doctorsCount++;

                System.out.println(doctorsCount + "." + doctor.getName());
                System.out.println("Name: " + doctor.getName());
                System.out.println("Specialization " + doctor.getSpecialization());
            }
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
