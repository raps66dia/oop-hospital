package database;

import model.Patient;

public class TestInsert {
    public static void main(String[] args){
        Patient patient = new Patient(3, 21, "cancer", "Ali");

        PatientDAO dao = new PatientDAO();
        dao.insertPatient(patient);

    }
}
