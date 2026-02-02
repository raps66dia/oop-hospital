package database;

import model.Patient;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class PatientDAO {

    public void insertPatient(Patient patient) {
         String sql = "INSERT INTO patients (id, name, age, illness, admitted) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, patient.getId());
            statement.setString(2, patient.getName());
            statement.setInt(3, patient.getAge());
            statement.setString(4, patient.getIllness());
            statement.setBoolean(5, patient.isAdmitted());

            int inserted = statement.executeUpdate(); // проверяет добавились ли строки, 1 если да и наобоорот

            if(inserted > 0) {
                System.out.println("✅ Inserted successfully!");
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Insert failed!");
            e.printStackTrace();
        }
    }
    public void getAllPatients(){
        String sql = "SELECT * FROM Patients";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("------ ALL PATIENTS FROM DATABASE -------");

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String illness = resultSet.getString("illness");

                System.out.println("ID: " + id);
                System.out.println("Name: " + name);
                System.out.println("Age: " + age);
                System.out.println("Illness: " + illness);
                System.out.println("-----------");

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
    }
    public boolean updatePatient(Patient patient) {
        String sql = "UPDATE patients SET name = ?, age = ?, illness = ? WHERE id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, patient.getName());
            statement.setInt(2, patient.getAge());
            statement.setString(3, patient.getIllness());
            statement.setInt(4, patient.getId());

            int updated = statement.executeUpdate();
            if (updated > 0) {
                System.out.println("✅ Patient updated: " + patient.getName());
                return true;
            }
        } catch (SQLException e) {
            System.out.println("❌ Update failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public Patient findPatientByID(int patientID) {
        String sql = "SELECT * FROM patients WHERE id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return null;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, patientID);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                Patient patient = extractPatient(resultSet);

                resultSet.close();
                statement.close();

                if (patient != null) {
                    System.out.println("✅Found patient with ID: " + patientID);
                }
                return patient;
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return null;
    }
    private Patient extractPatient(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String illness = resultSet.getString("illness");

        Patient patient = null;

        patient = new Patient(id, age, illness, name);

        return patient;
    }
}
