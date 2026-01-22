package menu;

import model.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HospitalMenu implements Menu {
    private ArrayList<Person> people;
    private ArrayList<Appointment> appointments;
    private Scanner scanner;
    private Appointment appointment;

    public HospitalMenu() {
        this.people = new ArrayList<>();
        this.appointments = new ArrayList<>();
        this.scanner = new Scanner(System.in);

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
    public void run(){
        boolean running = true;
        while(running){
            displayMenu();
            System.out.println("Enter action: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1: addDoctor(); break;
                    case 2: addPatient(); break;
                    case 3: viewAll(); break;
                    case 4: allWork(); break;
                    case 5: appointment.start(); break;
                    case 6: appointment.finish(); break;
                    case 0: running = false; break;
                    default: System.out.println("Error!");
                }
            } catch (Exception e) {
                System.out.println("Error " + e.getMessage());
                scanner.nextLine();
            }
        }
        scanner.close();
    }
    private void addDoctor(){
        try {
            System.out.println("ID: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Name: ");
            String name = scanner.nextLine();

            System.out.println("Age: ");
            int age = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Specialization: ");
            String spec = scanner.nextLine();

            System.out.println("Experience: ");
            int exp = scanner.nextInt();
            scanner.nextLine();

            Doctor doctor = new Doctor(id, name, age, spec, exp);
            people.add(doctor);
            System.out.println("✅ Doctor added!");
        } catch (IllegalArgumentException e) {
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


}
