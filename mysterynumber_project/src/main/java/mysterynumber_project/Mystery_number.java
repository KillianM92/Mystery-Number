package mysterynumber_project;		//On se situe dans le package mysterynumber_project

import java.util.Scanner;			//On importe l'outil java.util.Scanner pour pouvoir récupérer l'entrée de l'utilisateur

public class Mystery_number {		//Classe java nommée Mystery_number qui permet de créer l'objet Mystery_number et comprend les fonctions liées au jeu


	/****************************************************************
	 * 																*
	 * Déclaration de toutes les variables utilisées dans la classe *
	 * 																*
	 ****************************************************************/

	static Scanner userInput = new Scanner(System.in);	//Scanner qui permet de récupérer la valeur entrée par l'utilisateur
	private static int mysteryNumber;					//Variable qui stocke le nombre mystère généré aléatoirement
	@SuppressWarnings("unused")							//Permet de fermer les variables considérées comme "inutilisées"
	private static int numberMin;						//Variable qui stocke le nombre minimum défini par l'application
	@SuppressWarnings("unused")				
	private static int numberMax;						//Variable qui stocke le nombre maximum défini par l'application
	private static int maxiTrials;						//Variable qui stocke le nombre maximum de tentatives disponibles par l'application


	/***************************************************************************
	 * 																		   *
	 * Constructeur de la classe Mystery_number qui va créer le nombre mystère * 
	 *  par rapport aux paramètres fournis dans l'objet appelé dans Play.java  *
	 * 																		   *
	 ***************************************************************************/

	public Mystery_number(int numberMin, int numberMax) {

		Mystery_number.mysteryNumber = (int)(Math.random()*numberMax);		//Génération du nombre mystère aléatoirement grâce à la fonction Math.random()

	}


	/*************************************************************************
	 * 																		 *
	 * Fonction qui constitue le mode de jeu n°1 en static void car elle est *
	 *      instanciée dans cette classe et ne retourne aucune valeur        *
	 * 																		 *
	 *************************************************************************/

	public static void play1() {

		maxiTrials = 10;																				//Définition du nombre maximum de tentatives à 10

		System.out.println("Vous avez choisi le mode de jeu n°1 : Devinez le nombre mystère");			//Affichage du mode de jeu choisi
		System.out.println("A vous de jouer... ! \n");

		for(int tries = 0; tries< maxiTrials; tries++) {												/*Boucle qui s'effectue tant que le nombre de tentatives est supérieur au nombre
																					  					  de tentatives restantes */
			int numberEnteredByPlayer = userInput.nextInt();											//Variable qui stocke et récupère l'entrée utilisateur 					
			if (numberEnteredByPlayer == mysteryNumber) {												//1ere condition de partie gagnée si le nombre mystère est égal à celui entré
				System.out.println("Félicitations !! Vous avez réussi à trouver le nombre mystère");	//Affichage du message de victoire
			} else if (numberEnteredByPlayer < mysteryNumber) {											//2e condition qui test si le nombre entré est plus petit que le nombre mystère
				System.out.println("Ce n'est pas assez bonhomme ! Il vous reste " +					
						(maxiTrials-tries-1) + " tentative(s).");										//Affichage du message trop petit avec le nombre d'essai restant pour jouer
			} else {																					//3e condition qui test si le nombre entré est plus grand que le nombre mystère
				System.out.println("Là tu vises un peu trop haut ! Il te reste " +					
						(maxiTrials-tries-1) + " tentative(s).");										//Affichage du message trop grand avec le nombre d'essai restant pour jouer
			}  
		}    																							//On sort de la boucle si le joueur n'a pas réussi à trouver le nombre mystère

		System.out.println("\n Le nombre mystère était : "   
				+ mysteryNumber + "\n"); 																// Affichage du message de partie perdue avec la solution

		playAgain(); 																					//On appelle la fonction playAgain pour inviter le joueur à rejouer ou non (voir après)

	}


	/**************************************************************************************************
	 * 																					              *
	 * Fonction qui appelle et affiche le jeu n°2, elle est reliée à la fonction mysteryNumberReverse *
	 * 																								  *
	 **************************************************************************************************/

	public static void play2() {

		System.out.println("Vous avez choisi le mode de jeu n°2 : Nombre Mystère inversé ");	//Affichage du mode de jeu choisi
		System.out.println("Votre adversaire a effectué " + mysteryNumberReverse() + 
				" tentatives pour découvrir votre nombre mystère ! Félicitations à lui !!!\n"); /*On affiche le résultat de la fonction nombreMystereInverse 
																								  et le message de fin de partie*/

		playAgain();																			//On appelle la fonction playAgain pour inviter le joueur à rejouer ou non (voir après)
	}

	/*****************************************************************************
	 * 																			 *
	 * Fonction qui constitue le mode de jeu n°2 en static int car elle retourne *
	 *               la valeur de la variable compteur_ordi                      *
	 * 																			 *
	 *****************************************************************************/

	public static int mysteryNumberReverse() {


		//Déclaration des variables nécessaires à la fonction mysteryNumberReverse

		int nbMax = 9999; 				//Variable qui stocke le nombre maximum que l'ordinateur peut deviner
		int nbMin = 0;					//Variable qui stocke le nombre minimum que l'ordinateur peut deviner
		int compteur_ordi = 0;			//Variable qui stocke le nombre de tours que va prendre l'ordinateur pour trouver le nombre mystère (elle est ici nulle pour être initialisée)
		int mindNumber = 0;				//Variable qui stocke le nombre que l'ordinateur doit deviner (et qui est dans notre tête) & (elle est ici nulle pour être initialisée)
		@SuppressWarnings("unused")
		int previousMindNumber = 0;		//Variable qui stocke le nombre précédent que l'ordinateur a essayé
		char userInput = ' ';			//Variable qui stocke l'entrée du clavier de l'utilisateur (elle est ici vide pour être initialisée)

		do {																			/*Boucle Do While qui s'éxécute tant que l'ordinateur n'a pas trouvé 
		 																				  votre nombre mystère qui est stocké dans votre tête*/
			System.out.println("+------------------------------------+");												
			System.out.println("| " +  mindNumber + " est-il votre nombre mystère ? |");	//Affichage de texte en console
			System.out.println("+------------------------------------+ \n");
			
			userInput = readUserInput(); 													/*On remplace la valeur de UserInput par le
																							  contenu que retourne la fonction readUserInput()*/
			
			if (userInput == '+') {														//1ère condition qui s'éxécute si l'utilisateur rentre + dans le terminal
				nbMin = mindNumber + 1;													//Dans ce cas le nombre minimum est changé
			} else if (userInput == '-') {												//2ème condition qui s'éxécute si l'utilisateur rentre - dans le terminal
				nbMax = mindNumber - 1;													//Dans ce cas le nombre maximum est changé
			}

			previousMindNumber = mindNumber;											//On remplace le nombre précédent que l'ordinateur a essayé par le nouveau
			mindNumber = nbMin + ((nbMax - nbMin) / 2);									//Génération d'un exemple du nombre à deviner par un calcul

			compteur_ordi ++;															//On incrémente le compteur à chaque tour tant que l'utilisateur n'a pas tapé '='
		} while (userInput != '=');														//On éxécute le code de la boucle tant que l'entrée utilisateur n'est pas le symbole '='

		return compteur_ordi;															//On retourne la valeur du compteur pour pouvoir la réutiliser dans la fonction play2()
	}

	/*************************************************************
	 * 														     *
	 * Fonction readUserInput qui affiche le menu du mode de 	 *
	 * jeu n°2 tant que l'utilisateur rentre un symbole + - ou = *
	 * 														     *
	 *************************************************************/

	public static char readUserInput() {

		char usInput = '3';														//Variable qui stocke ce que l'utilisateur rentre dans le terminal					

		do {																	/*Boucle Do While qui s'éxécute et affiche le texte suivant*/
			System.out.print("Veuillez entrez les symboles suivants :\n\n");	
			System.out.print("+ si votre nombre est supérieur\n");				//Affichage de texte en console...
			System.out.print("- si votre nombre est inférieur\n");
			System.out.print("= si votre nombre est le même\n");

			usInput = userInput.next().charAt(0);								/*On remplace la valeur de la variable usInput par ce que l'utilisateur vient de taper au clavier
																				avec la méthode charAt qui prend en compte que le premier caractère que l'utilisateur tape*/

		} while (usInput != '+' && usInput != '-' && usInput != '=');			//On éxécute ce code tant que l'utilisateur ne rentre pas une valeur égale à + - ou =

		return usInput;															//On retourne la valeur pour pouvoir la réutiliser
	}


	/***********************************************************
	 * 														   *
	 * Fonction playAgain qui affiche un menu en fin de partie *
	 * 														   *
	 ***********************************************************/

	public static void playAgain() {
		int choice = 0;										//Initialisation de la variable choice pour le menu

		do {												/*Boucle do while pour l'affichage de fin de partie et sa sélection*/
			System.out.println("Voulez vous rejouer ?");	/*Affichage du texte en cas de fin de partie*/
			System.out.println("1 : Mode de jeu n°1");
			System.out.println("2 : Mode de jeu n°2");
			System.out.println("3 : Quitter le jeu");		

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);			//Scanner qui permet de récupérer la valeur entrée par l'utilisateur
			choice = sc.nextInt();							//La variable choice récupère le choice entré par l'utilisateur

			switch (choice) {								//menu avec le switch case en fonction du choice entré par l'utilisateur
			case 1:											
				play1();									//Choice = 1 on lance le mode de jeu n°1
				break;
			case 2:											
				play2();									//Choice = 2 on lance le mode de jeu n°2
				break;
			}			
		} while(choice != 3);								//On éxécute le code situé dans le "do" tant que le choix n'est pas égal à 3 sinon on sort de la boucle

		System.out.println("Fin de la partie...");			//Affichage du texte de fin de partie
		System.exit(0);										//On ferme l'application

	}


	/************************************************************
	 * 														    *
	 * Fonction mainMenu qui affiche le menu principal de début *
	 * 														    *
	 ************************************************************/

	public void mainMenu() {

		System.out.println("+--------------------------------+");												//Affichage de texte en console...
		System.out.println("|    Bienvenue sur notre jeu     |");
		System.out.println("| Devinez le nombre mystérieux ! |");
		System.out.println("+--------------------------------+ \n");
		System.out.println("Mode de jeu n°1 : Devinez le nombre que l'ordinateur a généré aléatoirement.");
		System.out.println("Mode de jeu n°2 : Guidez l'ordinateur pour qu'il devine votre nombre. \n");
		System.out.println("1 : Mode de jeu n°1");
		System.out.println("2 : Mode de jeu n°2");
		System.out.println("3 : Quitter le jeu");

	}

	/********************
	 * 					*
	 * FIN DU PROGRAMME *
	 * 					*
	 ********************/

}