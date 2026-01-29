package database;
import database.PatientDAO;

public class TestSelect {
    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();
        dao.getAllPatients();
    }
}