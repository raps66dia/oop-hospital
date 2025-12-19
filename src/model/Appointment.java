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
    public void startAppointment(){
        patient.admitPatient();
        System.out.println(patient);
        System.out.println("Appointment started on " + date);
        doctor.assignPatient();
        System.out.println(doctor);
    }
    public void comletedAppointment(){
        System.out.println("Appointment finished");
        completed = true;
        doctor.finishAppoinment();
        patient.dischargePatient();
    }
}
