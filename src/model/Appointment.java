package model;

public class Appointment {
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
    public int getId(){
        return id;
    }
    public Patient getPatient(){
        return patient;
    }
    public Doctor getDoctor(){
        return doctor;
    }
    public String getDate(){
        return date;
    }
    public void setDate(String date){
        if (date != null && !date.trim().isEmpty()) {
            this.date = date;
        } else {
            System.out.println("Warning: date cannot be empty!");
            this.date = "Unknown";
        }
    }
    public void startAppointment(){
        patient.admitPatient();
        System.out.println("Information about parient: " + patient);
        System.out.println();
        System.out.println("Appointment started on " + date);
        doctor.assignPatient();
        System.out.println("Information about doctor: " + doctor);
    }
    public void comletedAppointment(){
        System.out.println("Appointment finished");
        System.out.println();
        completed = true;
        doctor.finishAppoinment();
        patient.dischargePatient();
        System.out.println();
    }
    @Override
    public String toString(){
        return "Appointment[id: " + id + ", " + this.patient + ", " + this.doctor + ", date: " + date + "]";
     }
}
