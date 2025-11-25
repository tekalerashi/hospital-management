package com.hospital;
import java.sql.*;
import java.util.*;

public class PatientDAO {

    public void addPatient(Patient p) {
        String query = "INSERT INTO patients(name, age, disease) VALUES (?, ?, ?)";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, p.getName());
            ps.setInt(2, p.getAge());
            ps.setString(3, p.getDisease());
            ps.executeUpdate();
            System.out.println("✅ Patient added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Patient> getAllPatients() {
        List<Patient> list = new ArrayList<>();
        String query = "SELECT * FROM patients";
        try (Connection con = DBConnection.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(query)) {
            while (rs.next()) {
                list.add(new Patient(rs.getInt("id"), rs.getString("name"), rs.getInt("age"), rs.getString("disease")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updatePatientDisease(int id, String disease) {
        String query = "UPDATE patients SET disease=? WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, disease);
            ps.setInt(2, id);
            ps.executeUpdate();
            System.out.println("✅ Patient updated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deletePatient(int id) {
        String query = "DELETE FROM patients WHERE id=?";
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("✅ Patient deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}