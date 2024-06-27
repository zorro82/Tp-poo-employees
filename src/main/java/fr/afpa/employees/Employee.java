package fr.afpa.employees;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
//import java.util.regex.Pattern;

public class Employee {
    private String registrationNumber;
    private String lastName;
    private String firstName;
    private double salary;
    private final int socialRate = 30; // Taux de charges sociales fixe
    private LocalDate birthDate; // Date de naissance

    // Constructeur avec paramètres
    public Employee(String registrationNumber, String lastName, String firstName, double salary, LocalDate birthDate) throws Exception {
        
        boolean result1 = this.checkRegistrLationNumber(registrationNumber);
        if (result1 == false) {
            throw new Exception("Le paramètre d'entrée n'est pas correctement formaté." + registrationNumber);
        }

        if (!checkName(firstName)) {
            throw new Exception("Le prénom ne doit pas être vide et ne doit pas contenir de chiffres." + registrationNumber);
        }

        if (!checkName(lastName)) {
            throw new Exception("Le nom ne doit pas être vide et ne doit pas contenir de chiffres." + registrationNumber);
        }
                
        this.registrationNumber = registrationNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    // Getters (Accesseurs)
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getSalary() {
        return salary;
    }

    public int getSocialRate() {
        return socialRate;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Setters (Mutateurs)
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    // Ici, il faudra implémenter l'algorithme de vérification pour matricule
    /**
     * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel correctement formaté ou non
     * @param inputToCheck1 La chaîne de caractère à vérifier
     * @return VRAI s'il s'agit d'un matricule, FAUX sinon
     */
    private boolean checkRegistrLationNumber (String inputToCheck1) {

        // Vérification de la taille de la chaîne de caractères
        if (inputToCheck1.length() != 7) {
            return false;
        }

        // déclaration du booléen qui va stocker le résultat de la vérification
        // VRAI -> la chaîne de caractères passée en paramètre est un matricule correctement formaté
        // FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien formaté
        boolean isRegistrationNumber = false;

        // Cette première boucle permet de passer en revue TOUS les caractères de la chaîne
        for (int index = 0; index < inputToCheck1.length(); index++) {

            char ch = inputToCheck1.charAt(index);
            if (index == 0 || index == 1 || index == 5 || index == 6) {

                // vérification du caractère, s'agit-il d'un chiffre ?
                if (Character.isDigit(ch) == true) {
                    isRegistrationNumber = true;
                } else { // attention, ce n'est pas un chiffre
                    return false;
                }

            } else { // cas de la position 2, 3 ou 4 -> vérification de letter

                // Quelle opération dois-je faire ?
                if (Character.isLetter(ch)) {
                    isRegistrationNumber = true;
                } else {
                    return false;
                }
            }
        } // fin du FOR

        return isRegistrationNumber;
    } 

    public void setLastName(String lastName) throws Exception {
        if (!checkName(lastName)) {
            throw new Exception("Le nom ne doit pas être vide et ne doit pas contenir de chiffres.");
        }
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) throws Exception {
        if (!checkName(firstName)) {
            throw new Exception("Le prénom ne doit pas être vide et ne doit pas contenir de chiffres.");
        }
        this.firstName = firstName;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setBirthDate(String birthDate) throws Exception {
        if (!checkDate(birthDate)) {
            throw new Exception("Le format de la date de naissance est incorrect.");
        }
        this.birthDate = LocalDate.parse(birthDate);
    }

    // Méthode pour obtenir le nom complet
    public String getFullName() {
        return lastName + " " + firstName;
    }

    // Méthode pour calculer le salaire net
    public double getNetSalary() {
        return salary - salary * socialRate / 100;
    }

    // Méthode pour calculer le nombre de jours restants avant l'anniversaire
    public long getDaysUntilBirthday() {
        LocalDate currentDate = LocalDate.now();
        LocalDate nextBirthday = birthDate.withYear(currentDate.getYear());
        if (nextBirthday.isBefore(currentDate) || nextBirthday.isEqual(currentDate)) {
            nextBirthday = nextBirthday.plusYears(1);
        }
        return ChronoUnit.DAYS.between(currentDate, nextBirthday);
    }

    // Méthode toString()
    @Override
    public String toString() {
        return "Employee{" +
                "registrationNumber='" + registrationNumber + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", salary=" + salary +
                ", socialRate=" + socialRate +
                ", birthDate=" + birthDate +
                '}';
    }

    // Méthodes de vérification
    private boolean checkName(String name) {
        return name != null && !name.trim().isEmpty() && name.matches("[a-zA-Z]+");
    }

    private boolean checkDate(String date) {
        try {
            LocalDate.parse(date);
            return true;
        } catch (DateTimeParseException e) {
            return false;
        }
    }

    // La méthode de vérification du matricule peut être implémentée plus tard
    // private boolean checkRegistrationNumber(String registrationNumber) {
    //     return registrationNumber != null && registrationNumber.matches("\\d{2}[A-Z]{3}\\d{2}");
    // }
}
