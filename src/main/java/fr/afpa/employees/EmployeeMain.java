package fr.afpa.employees;

//import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;

/**
 * Classe principale du projet, contient la fonction "main"
 */
class EmployeeMain {
	public static void main(String[] args) {
		System.out.println("\n----- Exercice de programmation objet - classe \"Employee\" -----");

		// instanciez 4 objets de la classe "Employee" (une fois celle-ci implémentée)
		Employee employee1 = new Employee(": 11ABC22", ": Don", ": Michel", 2000);
		employee1.getbirtDate();
		System.out.println(employee1.getRegistrationNumber());
		Employee employee2 = new Employee(": 125FE78", ": Zannese", ": Aurélie", 2000);
		System.out.println(employee2.getRegistrationNumber());
		Employee employee3 = new Employee(": 98BN15", ": Sanchez", ": Michel", 2000);
		System.out.println(employee3.getRegistrationNumber());
		Employee employee4 = new Employee(" : 75AZ23", "Don", "Michel", 2000);
		System.out.println(employee4.getRegistrationNumber());

		System.out.println(employee1.toString());
		// Modification de la variable registrationNumber grace au Setter de la classe
		// Employee, nouvelle donnée attribuer à registrationNumber
		employee1.setRegistrationNumber("123456789");
		System.out.println(employee1.getRegistrationNumber());

		// Déclaration d'une String
		//String testString = "123"; // appel au constructeur de string implicite

		// appel explicite au constructeur de String
		//String otheString = new String("123");

		// Tentative de modification avec un matricule correctement formaté
		employee1.setRegistrationNumber("64AZE88");

		// test des matricules en erreur
		employee1.setRegistrationNumber("EEAZE88");

		employee1.setRegistrationNumber("6444433");

		employee1.setRegistrationNumber("64AZ");

		employee1.setRegistrationNumber("6");

		employee1.setRegistrationNumber("");

		employee1.setRegistrationNumber("987654");

		// TODO afficher les informations des employés avec System.out.println
	}
}
