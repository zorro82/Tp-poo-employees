package fr.afpa.employees;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.time.temporal.ChronoUnit;


public class EmployeeMain {
    public static void main(String[] args) {

        System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

        LocalDate birthDate1 = LocalDate.of(1980, 5, 15); //"1980-05-15"
        LocalDate birthDate2 = LocalDate.of(1990, 7, 20); //"1990-07-20"
        LocalDate birthDate3 = LocalDate.of(1985, 3, 10); //"1985-03-10"
        LocalDate birthDate4 = LocalDate.of(1995, 12, 25); //"1995-12-25"
        System.out.println("Today's date: " + LocalDate.now());

        // décalaration des variables employés
        Employee emp1 = null; // null -> c'est vide
        try {
            // Instancier 4 objets Employee avec des informations différentes
            emp1 = new Employee("125ZA45", "Doe", "John", 3000.0, birthDate1);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        Employee emp2 = null; // null -> c'est vide
        try {
            // Instancier 4 objets Employee avec des informations différentes
            emp2 = new Employee("67ADF90", "Smith", "Jane", 3500.0, birthDate2);
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        Employee emp3 = null; // null -> c'est vide
        try {
            // Instancier 4 objets Employee avec des informations différentes
            emp3 = new Employee("11BEA23", "Brown", "Cha8rlie", 3200.0, birthDate3);
           
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Employee emp4 = null; // null -> c'est vide
        try {
            // Instancier 4 objets Employee avec des informations différentes
            emp4 = new Employee("44AED56", "Jo5hnson", "Emma", 3100.0, birthDate4);

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        // Créer une liste d'employés
        ArrayList<Employee> employees = new ArrayList<>();

        // Ajouter les employés à la liste
        if (emp1 != null) {
            employees.add(emp1);
        }
        if (emp2 != null) {

            employees.add(emp2);
        }
        if (emp3 != null) {
            employees.add(emp3);

        }
        if (emp4 != null) {
            employees.add(emp4);
        }
                
        // Afficher la représentation en chaîne de caractères de chaque objet
        for (Employee emp : employees) {
            System.out.println(emp);
            // Afficher le nom complet de chaque employé
            System.out.println("Nom complet de " + emp.getRegistrationNumber() + " : " + emp.getFullName());
            // Afficher le salaire net de chaque employé
            System.out.println("Salaire net de " + emp.getRegistrationNumber() + " : " + emp.getNetSalary());
            // Afficher le nombre de jours restant avant l'anniversaire de chaque employé
            System.out.println("Jours avant l'anniversaire de " + emp.getRegistrationNumber() + " : " + emp.getDaysUntilBirthday());
        }
    }
}
