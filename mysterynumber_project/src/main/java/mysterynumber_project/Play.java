package mysterynumber_project;									//On se situe dans le package mysterynumber_project

import java.util.Scanner;										//On importe l'outil java.util.Scanner pour pouvoir récupérer l'entrée de l'utilisateur


public class Play {												//Classe java nommée Play qui permet de lancer le jeu (main class)

	public static void main(String[] args) {					//fonction principale qui est éxécutée par la console

		Mystery_number mn = new Mystery_number(0000, 9999); 	/*Appel de l'objet Mystery_number ou le constructeur se trouve dans l'autre classe avec 
																  les paramètres (int numberMin, int numberMax)*/

		int choice = 0;											//Initialisation de la variable choice pour le menu

		do {													//Boucle do while pour l'affichage du menu et sa sélection

			mn.mainMenu();										/*Appel de la fonction mainMenu située dans la classe Mystery_number.java qui affiche 
																  le menu principal du jeu*/

			@SuppressWarnings("resource")						//Sert à fermer le scanner sc pour ne pas avoir d'erreur
			Scanner sc = new Scanner(System.in);				//Ouverture du scanner pour récupérer la valeur entrée par l'utilisateur
			choice = sc.nextInt();		      					//La variable choice récupère le choice entré par l'utilisateur  

			switch(choice) {									//Menu avec le switch case en fonction de la variable choice
			case 1: 
				Mystery_number.play1();							//Choice = 1 va lancer la fonction play1 qui est une static void et correspond au mode de jeu n°1 
				break;
			case 2: 
				Mystery_number.play2();							//Choice = 2 va lancer la fonction play1 qui est une static void et correspond au mode de jeu n°2
				break;
			}

		} while(choice != 3); 									/*On éxécute le code situé dans le "do" tant que le choix n'est pas égal à 3 
																  sinon on sort de la boucle et on affiche le texte de fin de partie et on quitte l'application*/

		System.out.println("Fin de la partie...");				//Affichage du texte de fin de partie
		System.exit(0);											//On ferme l'application
	}
}