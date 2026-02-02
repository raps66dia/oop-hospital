package menu;

import database.PatientDAO;
import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private ArrayList<Person> people;
    private Scanner scanner;
    private Appointment appointment;
    private PatientDAO patientDAO;

    public HospitalMenu() {
        this.people = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.patientDAO = new PatientDAO();

        people.add(new Doctor(1, "Dr.Arystan", 45, "surgeon", 20));
        people.add(new Patient(1, 18, "cancer", "Nurasyl"));
        Doctor d = new Doctor(2, "Dr.Almas", 50, "Main Doctor", 20);
        Patient p = new Patient(2, 20, "blood transportation", "Aibek");
        appointment = new Appointment(1, p, d, "20.01.2026");
    }


    @Override
    public void displayMenu(){
        System.out.println("\n========================");
        System.out.println("HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("==========================");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. View All People");
        System.out.println("4. Make All Work(Show Polymorhism)");
        System.out.println("5. Start treatment");
        System.out.println("6. Finish treatment");
        System.out.println("0. Exit");
        System.out.println("==========================");
    }
    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.println("Enter action: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            try {
                switch (choice) {
                    case 1: addDoctor(); break;
                    case 2: addPatient(); break;
                    case 3: viewAll(); break;
                    case 4: allWork(); break;
                    case 5: appointment.start();
                    case 6: appointment.finish();
                    case 0: running = false; System.out.println("Completed"); break;
                    default: System.out.println("Error");
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }
    private void addDoctor(){
        try {
            System.out.println("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("name: ");
            String name = scanner.nextLine();

            System.out.println("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Specalization: ");
            String spec = scanner.nextLine();

            System.out.println("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            Doctor doctor = new Doctor(id, name, age, spec, exp);
            people.add(doctor);

            System.out.println("✅ Doctor added!");
        } catch (Exception e){
            System.out.println("❌ " + e.getMessage());
        }
    }
    private void addPatient(){
        try {
            System.out.println("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Illness: ");
            String illness = scanner.nextLine();

            System.out.println("Name: ");
            String name = scanner.nextLine();

            Patient patient = (new Patient(id, age, illness, name));
            people.add(patient);
            System.out.println("✅ Patient added!");
        } catch (IllegalArgumentException    e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    private void viewAll() {
        if (people.isEmpty()){
            System.out.println("❌ NOT FOUND!");
        }
        for (int i = 0; i < people.size(); i++) {
            System.out.println(i+1 + ". " + people.get(i));
        }
    }
    private void allWork() {
        System.out.println("\n------- ALL WORK --------");
        for(Person p : people) {
            p.work();
        }
    }
    private void updatePatient() {
        System.out.println("Enter patient ID to update: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();

        Patient existingPatient = patientDAO.findPatientByID(patientID);

        if (existingPatient == null) {
            System.out.println("❌ Patient not found with ID: " + patientID);
            return;
        }

        System.out.println("Current Info: ");
        System.out.println(existingPatient.toString());

        System.out.println("Name [" + existingPatient.getName() + "]");
        System.out.println("Write new name or press (Enter) and stay name");
        String newName = scanner.nextLine();
        if (newName.trim().isEmpty()){
            newName = existingPatient.getName();
        }

        System.out.println("Illness [" + existingPatient.getIllness() + "]");
        System.out.println("Write new illness or press (Enter) and stay illness");
        String newIllness = scanner.nextLine();
        if (newIllness.trim().isEmpty()) {
            newIllness = existingPatient.getIllness();
        }

        System.out.println("Age [" + existingPatient.getAge() + "]");
        System.out.println("Write new age or press (Enter) and stay age");
        String Age = scanner.nextLine();
        int newAge;
        if(Age.trim().isEmpty()){
            newAge = existingPatient.getAge();
        } else {
            newAge = Integer.parseInt(Age);
        }

        Patient newPatient = new Patient(patientID, newAge, newIllness, newName);
        patientDAO.updatePatient(newPatient);

    }
}
