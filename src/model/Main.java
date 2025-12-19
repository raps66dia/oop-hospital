package model;

public class Main {
    public static void main(String[] args){
        Patient patient = new Patient(1, 20, "flu", "Ilya Ermakov");
        Doctor doctor = new Doctor(1, "Dr.Almas", "therapist", 10);

        Appointment appointment = new Appointment(
                1,
                patient,
                doctor,
                "19.12.2025"
        );
        appointment.startAppointment();
        appointment.comletedAppointment();
    }

}
