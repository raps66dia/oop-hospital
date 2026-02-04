package menu;

import database.PatientDAO;
import model.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private Scanner scanner;
    private Appointment appointment;
    private PatientDAO patientDAO;

    public HospitalMenu() {
        this.scanner = new Scanner(System.in);
        this.patientDAO = new PatientDAO();
    }


    @Override
    public void displayMenu(){
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         MAIN MENU - Week 8            ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("=====Management============");
        System.out.println("1. Add Doctor");
        System.out.println("2. Add Patient");
        System.out.println("3. View Only Patients");
        System.out.println("4. View Only Doctors");
        System.out.println("5. Update Patients");
        System.out.println("6. Delete Patients");
        System.out.println("=====Search and Filter=====");
        System.out.println("7. Search by Name");
        System.out.println("8. Search Doctor by Name");
        System.out.println("9. Search by Age Range Patients");
        System.out.println("10. Minimum Age Patients");
        System.out.println("=====Demo and Other========");
        System.out.println("11. Polymorphism Demo");
        System.out.println("0. Exit");
        System.out.println("============================");
    }
    @Override
    public void run() {
        boolean running = true;
        while (running) {
            displayMenu();
            System.out.println("Enter action: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1: addDoctor(); break;
                    case 2: addPatient(); break;
                    case 3: viewPatients(); break;
                    case 4: viewDoctors(); break;
                    case 5: updatePatient(); break;
                    case 6: deletePatient(); break;
                    case 7: searchByName(); break;
                    case 8: searchDoctorByName();
                    case 9: searchByAgeRange(); break;
                    case 10: searchByMinAge(); break;
                    case 11: allWork(); break;
                    case 0:
                        running = false;
                        System.out.println("\n╔════════════════════════════════════════╗");
                        System.out.println("║  Thank you for using our system!      ║");
                        System.out.println("║  Goodbye! 👋                          ║");
                        System.out.println("╚════════════════════════════════════════╝");
                        break;
                    default: System.out.println("❌ Invalid choice! Select 0-11.");
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
            }
        }
    }
    private void addDoctor(){
        try {
            System.out.println("\n┌─ ADD DOCTOR ─────────────────────────────┐");
            System.out.println("Enter Doctor ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter name: ");
            String name = scanner.nextLine();

            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter specalization: ");
            String spec = scanner.nextLine();

            System.out.println("Enter experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            Doctor doctor = new Doctor(id, name, age, spec, exp);
            patientDAO.insertDoctor(doctor);

            System.out.println("✅ Doctor added!");
        } catch (Exception e){
            System.out.println("❌ " + e.getMessage());
        }
    }
    private void addPatient(){
        try {
            System.out.println("Enter patient ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter patient age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Enter patient illness: ");
            String illness = scanner.nextLine();

            System.out.println("Enter patient name: ");
            String name = scanner.nextLine();

            Patient patient = new Patient(id, age, illness, name);
            patientDAO.insertPatient(patient);
            System.out.println("✅ Patient added!");
        } catch (IllegalArgumentException    e) {
            System.out.println("❌ " + e.getMessage());
        }
    }
    private void viewPatients() {
        List<Patient> patients = patientDAO.getAllPatients();
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║            PATIENTS                    ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (patients.isEmpty()) {
            System.out.println("❌ No patients in database");
        } else {
            for (int i = 0; i < patients.size(); i++) {
                Patient patient = patients.get(i);
                System.out.println((i + 1) + ". " + patient.toString());
                System.out.println();
            }
            System.out.println("Total patients: " + patients.size());
        }
    }
    private void viewDoctors() {
        List<Doctor> doctors = patientDAO.getAllDoctors();

        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║        DOCTORS ONLY                   ║");
        System.out.println("╚════════════════════════════════════════╝");

        if (doctors.isEmpty()) {
            System.out.println("NOT FOUND ❌");
        } else {
            for (int i = 0; i < doctors.size(); i++) {
                Doctor doctor = doctors.get(i);
                System.out.println((i + 1) + ". " + doctor.toString());
                System.out.println();
            }
            System.out.println("Total doctor: " + doctors.size());
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
    private void deletePatient() {
        System.out.println("Enter Patient ID for delete: ");
        int patientID = scanner.nextInt();
        scanner.nextLine();

        Patient patient = patientDAO.findPatientByID(patientID);

        if (patient == null) {
            System.out.println("No patient found with ID: " + patientID);
            return;
        }

        // patient details
        System.out.println("Patient to delete: ");
        System.out.println(patient.toString());

        System.out.println("⚠️Are you sure? (yes/no): ");
        String confirmation = scanner.nextLine();

        if (confirmation.equalsIgnoreCase("yes")) {
            patientDAO.deletePatient(patientID);
        } else {
            System.out.println("❌ Delete canceled");
        }
    }
    private void searchByName() {
        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
        System.out.print("│ Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");

        List <Patient> results = patientDAO.searchByName(name);

        displaySearchResults(results,"Search: '" + name + "'");
    }
    private void searchDoctorByName() {
        System.out.println("\n┌─ SEARCH BY NAME ───────────────────────┐");
        System.out.print("│ Enter name to search: ");
        String name = scanner.nextLine();
        System.out.println("└────────────────────────────────────────┘");

        List <Doctor> results = patientDAO.searchDoctorByName(name);

        displayDoctorsSearchResults(results,"Search: '" + name + "'");
    }
    private void searchByAgeRange() {
        try {
            System.out.println("\n┌─ SEARCH BY AGE   RANGE ───────────────┐");
            System.out.print("│ Enter minimum age: ");
            int minAge = scanner.nextInt();

            System.out.print("│ Enter maximum age: ");
            int maxAge = scanner.nextInt();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<Patient> results = patientDAO.searchByAgeRange(minAge, maxAge);

            displaySearchResults(results, "Age: " + minAge + " - " + maxAge + " years");
        } catch (java.util.InputMismatchException e){
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }
    private void searchByMinAge() {
        try {
            System.out.println("\n┌─ HIGH AGE PATIENTS ──────────────────────┐");
            System.out.print("│ Enter minimum salary: ");
            int minAge = scanner.nextInt();
            scanner.nextLine();
            System.out.println("└────────────────────────────────────────┘");

            List<Patient> results = patientDAO.searchByMinAge(minAge);

            displaySearchResults(results, "Age >= " + minAge + " years");
        } catch (java.util.InputMismatchException e) {
            System.out.println("❌ Error: Invalid number!");
            scanner.nextLine();
        }
    }
    private void displaySearchResults(List<Patient> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No patient found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                Patient p = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + p.getRole() + "] ");
                System.out.println(p.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }
    private void displayDoctorsSearchResults(List<Doctor> results, String criteria) {
        System.out.println("\n╔════════════════════════════════════════╗");
        System.out.println("║         SEARCH RESULTS                ║");
        System.out.println("╚════════════════════════════════════════╝");
        System.out.println("Criteria: " + criteria);
        System.out.println("─────────────────────────────────────────");

        if (results.isEmpty()) {
            System.out.println("📭 No doctors found matching criteria.");
        } else {
            for (int i = 0; i < results.size(); i++) {
                Doctor d = results.get(i);
                System.out.print((i + 1) + ". ");
                System.out.print("[" + d.getRole() + "] ");
                System.out.println(d.toString());
            }
            System.out.println("─────────────────────────────────────────");
            System.out.println("Total Results: " + results.size());
        }
    }
    private void allWork() {
        patientDAO.demoPolymorhp();
    }

}
