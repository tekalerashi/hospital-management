package com.hospital;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== Hospital Management System ===");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Update Patient Disease");
            System.out.println("4. Delete Patient");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter age: ");
                    int age = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter disease: ");
                    String disease = sc.nextLine();
                    dao.addPatient(new Patient(name, age, disease));
                }
                case 2 -> dao.getAllPatients().forEach(System.out::println);
                case 3 -> {
                    System.out.print("Enter patient ID to update: ");
                    int id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter new disease: ");
                    String disease = sc.nextLine();
                    dao.updatePatientDisease(id, disease);
                }
                case 4 -> {
                    System.out.print("Enter patient ID to delete: ");
                    int id = sc.nextInt();
                    dao.deletePatient(id);
                }
                case 5 -> {
                    System.out.println("Exiting...");
                    System.exit(0);
                }
                default -> System.out.println("❌ Invalid choice!");
            }
        }
    }
}