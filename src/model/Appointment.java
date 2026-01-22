package model;

import menu.Appointable;

public class Appointment implements Appointable {
    private int id;
    private Patient patient;
    private Doctor doctor;
    private String date;
    private boolean completed;

    public Appointment(int id, Patient patient, Doctor doctor, String date){
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
        this.completed = false;
    }
    public Appointment(){
    }
    public void setDate(String date){
        if (date != null && !date.trim().isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Warning: date cannot be empty!");
            this.date = "Unknown";
        }
    }
    public String getDate(){
        return date;
    }
    public int getId(){return id;}
    public Patient getPatient(){
        return patient;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    @Override
    public void start(){
        patient.admitPatient();
        doctor.assignPatient();
        System.out.println("Appointment started on " + date);
    }
    @Override
    public void finish(){
        doctor.finishAppoinment();
        patient.dischargePatient();
        System.out.println("Appointment finished");
    }
    @Override
    public String toString(){
        return "Appointment[id: " + id + ", " + this.patient + ", " + this.doctor + ", date: " + date + "]";
     }
}
