package fr.afpa.employees;

/*
Objectif :
L’objectif de ce TP est de concevoir un programme en console basé sur une approche objet et
permettant de gérer (vraiment très basiquement) des salariés d’une entreprise.

Vous allez écrire une classe représentant les salariés d'une entreprise.
Vous pourrez vous aider du PDF disponible sur pour obtenir des informations sur la façon de faire.
*/

class Employee
{
	/**
	 * Matricule de l'employé
	 */
	private String registrationNumber;

	// TODO compléter les attributs comme présenté dans le PDF

	// TODO compléter le constructeur de la classe
	public Employee(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	// TODO implémenter les setters et getters de la classe (permet d'accéder aux attributs privés)
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	public void setRegistrationNumber(String registrationNumber) throws Exception {
		this.registrationNumber = registrationNumber;
	}

	// TODO ajouter les getters et les setters

	// TODO implémenter la méthode "toString()" qui renvoie une chaîne de caractère qui représente un objet de la classe employé
	// plus d'information sur la méthode "toString()" -> https://codegym.cc/fr/groups/posts/fr.986.mthode-java-tostring
}
