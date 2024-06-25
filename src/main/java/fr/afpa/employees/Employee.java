package fr.afpa.employees;

import java.time.LocalDate;

/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee {
	
	// 1) Attributs :
	/**
	 * Matricule de l'employé
	 */

	// compléter les attributs comme présenté dans le PDF
	// Permet de stock les informations à rentrer.
	private String registrationNumber;
	private String lastName;
	private String fistName;
	private double salaryBrut;
	private final int socialRate = 30; // pour empêcher toute modification d’une variable
	private LocalDate birtDate;


	// 2) Constructeurs :
	// compléter le constructeur de la classe
	public Employee(String registrationNumber, String lastName, String fistName,
			double salary) {
		this.registrationNumber = registrationNumber;
		this.lastName = lastName;
		this.fistName = fistName;
		this.salaryBrut = salary;

		// this.socialRate = socialRate;
	}

	// 3) Getter / Setterss :
	// implémenter les setters et getters de la classe (permet d'accéder aux
	// attributs privés)
	// MATRICULE
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	// NOM
	public String getlastName() {
		return lastName;
	}

	public void setlastName(String lastName) throws Exception {
		this.lastName = lastName;
	}

	// PRENOM
	public String getfistName() {
		return fistName;
	}

	public void setfistName(String fistName) throws Exception {
		this.fistName = fistName;
	}

	// SALAIRE
	public double getsalary() {
		return salaryBrut;
	}

	public void setsalary(double salary) throws Exception {
		this.salaryBrut = salary;
	}

	// ANNIVERSAIRE
	public LocalDate getbirtDate() {
		return this.birtDate;
	}

	public void setbirtDate(LocalDate birtDate) {
		this.birtDate = birtDate;
	}

	/*
	 * public String getsocialRate() {
	 * return socialRate;
	 * }
	 * 
	 * public void set socialRate(String socialRate) throws Exception {
	 * this.socialRate = socialRate;
	 * }
	 */

	// TODO implémenter la méthode "toString()" qui renvoie une chaîne de caractère
	// qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" ->
	// https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
	public String toString() {
		return "Employee | "
				+ " Matricule " + getRegistrationNumber()
				+ " Nom " + getlastName()
				+ " Prénom " + getfistName()
				+ " Salaire " + getsalary()
				// + " Date d'anniversaire " + get()
				+ '|';
	}

	// Fonction pour obtenir le nom complet
	public String fullName() {
		return this.lastName + this.fistName;
	}

	// Fonction pour calculer le salaire net
	public double netSalary(double salary, final int socialRate) {
		return  this.salaryBrut - this.salaryBrut * this.socialRate; //Salaire net = salaire brut – salaire brut * taux de charges sociales
	}

	// Fonction pour calculer le nombre de jours restant avant la date
	// d'anniversaire
	/*
	 * public String dayBeforeBirthDate(int birtDate) {
	 * //return this.lastName + this.fistName
	 * }
	 */

	// Fonction pour calculer le salaire
	/*
	 * public double salary(double salary) {
	 * //return this.lastName + this.fistName
	 * }
	 */

	/**
	 * Vérifie qu'une chaîne de caractères passée en paramètre est un prénom
	 * 
	 * Règles de vérification :
	 * Un prénom ne doit pas comporter de chiffres, ni de caractère spéciale tel que
	 * '#', '$', '%', '/, '\'
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un prénom correctement formaté, FAUX sinon
	 */
	private boolean checkFirstName(String inputToCheck) {

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isRegistrationNumber = false;

		for (int index = 0; index < inputToCheck.length(); index++) {
			char value = inputToCheck.charAt(index);
			System.out.println( value);
		}
		return isRegistrationNumber;
	}

	// 4) Autres méthodes
	/**
	 * Vérifie une chaîne de caractères et indique s'il s'agit d'un matricuel
	 * correctement formaté ou non
	 * 
	 * @param inputToCheck La chaîne de caractère à vérifier
	 * @return VRAI s'il s'agit d'un matricule, FAUX sinon
	 */

	private boolean checkRegistrationNumber(String inputToCheck) {

		// Vérification de la taille de la chaîne de caractères
		if (inputToCheck.length() != 7) {
			return false;
		}

		// déclaration du booléen qui va stocker le résultat de la vérification
		// VRAI -> la chaîne de caractères passée en paramètre est un matricule
		// correctement formaté
		// FAUX -> la chaîne de caractères passée en paramètre est un matricule pas bien
		// formaté
		boolean isRegistrationNumber = false;

		// Cette première boucle permet de passer en revue TOUS les caractères de la
		// chaîne
		for (int index = 0; index < inputToCheck.length(); index++) {
			// index = longueur de intupToCheck - 1 = 6
			char ch = inputToCheck.charAt(index);
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
		} // fin du FOR, BRAVO !

		return isRegistrationNumber;
	}

}
