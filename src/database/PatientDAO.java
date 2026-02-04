package database;

import model.Doctor;
import model.Patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

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
    public void insertDoctor(Doctor doctor) {
        String sql = "INSERT INTO doctors (id, name, age, specialization, experienceYears) VALUES (?, ?, ?, ?, ?)";

        Connection connection = DatabaseConnection.getConnection();

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, doctor.getId());
            statement.setString(2, doctor.getName());
            statement.setInt(3, doctor.getAge());
            statement.setString(4, doctor.getSpecialization());
            statement.setInt(5, doctor.getExperienceYears());

            int testing = statement.executeUpdate();
            if (testing > 0) {
                System.out.println("✅ Doctor successfully added!");
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Insert failed");
            e.printStackTrace();
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
    public boolean deletePatient(int patientID) {
        String sql = "DELETE FROM patients WHERE id = ?";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            int rowDeleted = statement.executeUpdate();
            statement.close();
            if (rowDeleted > 0) {
                System.out.println("✅ Patient deleted (ID: " + patientID + ")");
                return true;
            } else {
                System.out.println("❌ No patient found with ID: " + patientID);
            }
        } catch (SQLException e) {
            System.out.println("❌ Delete failed!");
            e.printStackTrace();
        } finally{
            DatabaseConnection.closeConnection(connection);
        }
        return false;
    }
    public List<Patient> getAllPatients(){
        List<Patient> patientsList = new ArrayList<>();
        String sql = "SELECT * FROM Patients";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return patientsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("------ ALL PATIENTS FROM DATABASE -------");

            while (resultSet.next()) {
                Patient patient = extractPatient(resultSet);
                if (patient != null) {
                    patientsList.add(patient);
                }

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Select failed!");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return patientsList;
    }
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctorsList = new ArrayList<>();
        String sql = "SELECT * FROM doctors";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return doctorsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            System.out.println("---------- ALL DOCTORS FROM DATABASE --------");
            while (resultSet.next()) {
                Doctor doctor = extractDoctor(resultSet);
                if (doctor != null) {
                    doctorsList.add(doctor);
                }
            }
            statement.close();
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("❌ Select failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return doctorsList;
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
    private Doctor extractDoctor(ResultSet resultSet) throws SQLException {

        int id = resultSet.getInt("id");
        String name = resultSet.getString("name");
        int age = resultSet.getInt("age");
        String specialization = resultSet.getString("specialization");
        int exp = resultSet.getInt("experienceyears");

        Doctor doctor = null;

        doctor = new Doctor(id, name, age, specialization, exp);

        return doctor;
    }
    public List<Patient> searchByName(String name) {
        List<Patient> patientsList = new ArrayList<>();

        String sql = "SELECT * FROM patients WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return patientsList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Patient patient = extractPatient(resultSet);
                if (patient != null) {
                    patientsList.add(patient);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println("✅ Found " + patientsList.size());
        } catch (SQLException e) {
            System.out.println("❌ Search failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return patientsList;
    }
    public List<Doctor> searchDoctorByName(String name) {
        List<Doctor> doctorList = new ArrayList<>();

        String sql = "SELECT * FROM doctors WHERE name ILIKE ? ORDER BY name";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return doctorList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + name + "%");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Doctor doctor = extractDoctor(resultSet);
                if (doctor != null) {
                    doctorList.add(doctor);
                }
            }
            resultSet.close();
            statement.close();
            System.out.println("✅ Found " + doctorList.size());
        } catch (SQLException e) {
            System.out.println("❌ Search failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return doctorList;
    }
    public List<Patient> searchByAgeRange(int minAge, int maxAge) {
        List<Patient> patientList = new ArrayList<>();

        String sql = "SELECT * FROM patients WHERE age BETWEEN ? AND ? ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if (connection == null) return patientList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, minAge);
            statement.setInt(2, maxAge);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Patient patient = extractPatient(resultSet);
                if (patient != null) {
                    patientList.add(patient);
                }
            }
            statement.close();
            resultSet.close();

            System.out.println("✅ Found: " + patientList.size() + "patients");
        } catch (SQLException e) {
            System.out.println("❌`Search failed");
            e.printStackTrace();
        }  finally {
            DatabaseConnection.closeConnection(connection);
        }
        return patientList;
    }
    public List<Patient> searchByMinAge(int minAge) {
        List<Patient> patientList = new ArrayList<>();

        String sql = "SELECT * FROM patients WHERE age >= ? ORDER BY age DESC";

        Connection connection = DatabaseConnection.getConnection();
        if(connection == null) return patientList;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setInt(1, minAge);

            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Patient patient = extractPatient(resultSet);
                if (patient != null) {
                    patientList.add(patient);
                }
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("❌ Search failed");
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(connection);
        }
        return patientList;
    }
    public void demoPolymorhp() {
        List<Patient> patientList = getAllPatients();
        List<Doctor> doctorList = getAllDoctors();

        System.out.println("\n========================================");
        System.out.println("  POLYMORPHISM: Patients and Doctors from Database");
        System.out.println("========================================");

        if (patientList.isEmpty()) {
            System.out.println("No patients demo");
        } else {
            for (Patient p : patientList) {
                p.work();
            }
        }
        if (doctorList.isEmpty()) {
            System.out.println("No doctors demo");
        } else {
            for (Doctor d : doctorList) {
                d.work();
            }
        }
        System.out.println("========================================\n");
    }

}
