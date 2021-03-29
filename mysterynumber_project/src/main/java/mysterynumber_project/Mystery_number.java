package mysterynumber_project;		//On se situe dans le package mysterynumber_project

import java.util.Scanner;			//On importe l'outil java.util.Scanner pour pouvoir r�cup�rer l'entr�e de l'utilisateur

public class Mystery_number {		//Classe java nomm�e Mystery_number qui permet de cr�er l'objet Mystery_number et comprend les fonctions li�es au jeu


	/****************************************************************
	 * 																*
	 * D�claration de toutes les variables utilis�es dans la classe *
	 * 																*
	 ****************************************************************/

	static Scanner userInput = new Scanner(System.in);	//Scanner qui permet de r�cup�rer la valeur entr�e par l'utilisateur
	private static int mysteryNumber;					//Variable qui stocke le nombre myst�re g�n�r� al�atoirement
	@SuppressWarnings("unused")							//Permet de fermer les variables consid�r�es comme "inutilis�es"
	private static int numberMin;						//Variable qui stocke le nombre minimum d�fini par l'application
	@SuppressWarnings("unused")				
	private static int numberMax;						//Variable qui stocke le nombre maximum d�fini par l'application
	private static int maxiTrials;						//Variable qui stocke le nombre maximum de tentatives disponibles par l'application


	/***************************************************************************
	 * 																		   *
	 * Constructeur de la classe Mystery_number qui va cr�er le nombre myst�re * 
	 *  par rapport aux param�tres fournis dans l'objet appel� dans Play.java  *
	 * 																		   *
	 ***************************************************************************/

	public Mystery_number(int numberMin, int numberMax) {

		Mystery_number.mysteryNumber = (int)(Math.random()*numberMax);		//G�n�ration du nombre myst�re al�atoirement gr�ce � la fonction Math.random()

	}


	/*************************************************************************
	 * 																		 *
	 * Fonction qui constitue le mode de jeu n�1 en static void car elle est *
	 *      instanci�e dans cette classe et ne retourne aucune valeur        *
	 * 																		 *
	 *************************************************************************/

	public static void play1() {

		maxiTrials = 10;																				//D�finition du nombre maximum de tentatives � 10

		System.out.println("Vous avez choisi le mode de jeu n�1 : Devinez le nombre myst�re");			//Affichage du mode de jeu choisi
		System.out.println("A vous de jouer... ! \n");

		for(int tries = 0; tries< maxiTrials; tries++) {												/*Boucle qui s'effectue tant que le nombre de tentatives est sup�rieur au nombre
																					  					  de tentatives restantes */
			int numberEnteredByPlayer = userInput.nextInt();											//Variable qui stocke et r�cup�re l'entr�e utilisateur 					
			if (numberEnteredByPlayer == mysteryNumber) {												//1ere condition de partie gagn�e si le nombre myst�re est �gal � celui entr�
				System.out.println("F�licitations !! Vous avez r�ussi � trouver le nombre myst�re");	//Affichage du message de victoire
			} else if (numberEnteredByPlayer < mysteryNumber) {											//2e condition qui test si le nombre entr� est plus petit que le nombre myst�re
				System.out.println("Ce n'est pas assez bonhomme ! Il vous reste " +					
						(maxiTrials-tries-1) + " tentative(s).");										//Affichage du message trop petit avec le nombre d'essai restant pour jouer
			} else {																					//3e condition qui test si le nombre entr� est plus grand que le nombre myst�re
				System.out.println("L� tu vises un peu trop haut ! Il te reste " +					
						(maxiTrials-tries-1) + " tentative(s).");										//Affichage du message trop grand avec le nombre d'essai restant pour jouer
			}  
		}    																							//On sort de la boucle si le joueur n'a pas r�ussi � trouver le nombre myst�re

		System.out.println("\n Le nombre myst�re �tait : "   
				+ mysteryNumber + "\n"); 																// Affichage du message de partie perdue avec la solution

		playAgain(); 																					//On appelle la fonction playAgain pour inviter le joueur � rejouer ou non (voir apr�s)

	}


	/**************************************************************************************************
	 * 																					              *
	 * Fonction qui appelle et affiche le jeu n�2, elle est reli�e � la fonction mysteryNumberReverse *
	 * 																								  *
	 **************************************************************************************************/

	public static void play2() {

		System.out.println("Vous avez choisi le mode de jeu n�2 : Nombre Myst�re invers� ");	//Affichage du mode de jeu choisi
		System.out.println("Votre adversaire a effectu� " + mysteryNumberReverse() + 
				" tentatives pour d�couvrir votre nombre myst�re ! F�licitations � lui !!!\n"); /*On affiche le r�sultat de la fonction nombreMystereInverse 
																								  et le message de fin de partie*/

		playAgain();																			//On appelle la fonction playAgain pour inviter le joueur � rejouer ou non (voir apr�s)
	}

	/*****************************************************************************
	 * 																			 *
	 * Fonction qui constitue le mode de jeu n�2 en static int car elle retourne *
	 *               la valeur de la variable compteur_ordi                      *
	 * 																			 *
	 *****************************************************************************/

	public static int mysteryNumberReverse() {


		//D�claration des variables n�cessaires � la fonction mysteryNumberReverse

		int nbMax = 9999; 				//Variable qui stocke le nombre maximum que l'ordinateur peut deviner
		int nbMin = 0;					//Variable qui stocke le nombre minimum que l'ordinateur peut deviner
		int compteur_ordi = 0;			//Variable qui stocke le nombre de tours que va prendre l'ordinateur pour trouver le nombre myst�re (elle est ici nulle pour �tre initialis�e)
		int mindNumber = 0;				//Variable qui stocke le nombre que l'ordinateur doit deviner (et qui est dans notre t�te) & (elle est ici nulle pour �tre initialis�e)
		@SuppressWarnings("unused")
		int previousMindNumber = 0;		//Variable qui stocke le nombre pr�c�dent que l'ordinateur a essay�
		char userInput = ' ';			//Variable qui stocke l'entr�e du clavier de l'utilisateur (elle est ici vide pour �tre initialis�e)

		do {																			/*Boucle Do While qui s'�x�cute tant que l'ordinateur n'a pas trouv� 
		 																				  votre nombre myst�re qui est stock� dans votre t�te*/
			System.out.println("+------------------------------------+");												
			System.out.println("| " +  mindNumber + " est-il votre nombre myst�re ? |");	//Affichage de texte en console
			System.out.println("+------------------------------------+ \n");
			
			userInput = readUserInput(); 													/*On remplace la valeur de UserInput par le
																							  contenu que retourne la fonction readUserInput()*/
			
			if (userInput == '+') {														//1�re condition qui s'�x�cute si l'utilisateur rentre + dans le terminal
				nbMin = mindNumber + 1;													//Dans ce cas le nombre minimum est chang�
			} else if (userInput == '-') {												//2�me condition qui s'�x�cute si l'utilisateur rentre - dans le terminal
				nbMax = mindNumber - 1;													//Dans ce cas le nombre maximum est chang�
			}

			previousMindNumber = mindNumber;											//On remplace le nombre pr�c�dent que l'ordinateur a essay� par le nouveau
			mindNumber = nbMin + ((nbMax - nbMin) / 2);									//G�n�ration d'un exemple du nombre � deviner par un calcul

			compteur_ordi ++;															//On incr�mente le compteur � chaque tour tant que l'utilisateur n'a pas tap� '='
		} while (userInput != '=');														//On �x�cute le code de la boucle tant que l'entr�e utilisateur n'est pas le symbole '='

		return compteur_ordi;															//On retourne la valeur du compteur pour pouvoir la r�utiliser dans la fonction play2()
	}

	/*************************************************************
	 * 														     *
	 * Fonction readUserInput qui affiche le menu du mode de 	 *
	 * jeu n�2 tant que l'utilisateur rentre un symbole + - ou = *
	 * 														     *
	 *************************************************************/

	public static char readUserInput() {

		char usInput = '3';														//Variable qui stocke ce que l'utilisateur rentre dans le terminal					

		do {																	/*Boucle Do While qui s'�x�cute et affiche le texte suivant*/
			System.out.print("Veuillez entrez les symboles suivants :\n\n");	
			System.out.print("+ si votre nombre est sup�rieur\n");				//Affichage de texte en console...
			System.out.print("- si votre nombre est inf�rieur\n");
			System.out.print("= si votre nombre est le m�me\n");

			usInput = userInput.next().charAt(0);								/*On remplace la valeur de la variable usInput par ce que l'utilisateur vient de taper au clavier
																				avec la m�thode charAt qui prend en compte que le premier caract�re que l'utilisateur tape*/

		} while (usInput != '+' && usInput != '-' && usInput != '=');			//On �x�cute ce code tant que l'utilisateur ne rentre pas une valeur �gale � + - ou =

		return usInput;															//On retourne la valeur pour pouvoir la r�utiliser
	}


	/***********************************************************
	 * 														   *
	 * Fonction playAgain qui affiche un menu en fin de partie *
	 * 														   *
	 ***********************************************************/

	public static void playAgain() {
		int choice = 0;										//Initialisation de la variable choice pour le menu

		do {												/*Boucle do while pour l'affichage de fin de partie et sa s�lection*/
			System.out.println("Voulez vous rejouer ?");	/*Affichage du texte en cas de fin de partie*/
			System.out.println("1 : Mode de jeu n�1");
			System.out.println("2 : Mode de jeu n�2");
			System.out.println("3 : Quitter le jeu");		

			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);			//Scanner qui permet de r�cup�rer la valeur entr�e par l'utilisateur
			choice = sc.nextInt();							//La variable choice r�cup�re le choice entr� par l'utilisateur

			switch (choice) {								//menu avec le switch case en fonction du choice entr� par l'utilisateur
			case 1:											
				play1();									//Choice = 1 on lance le mode de jeu n�1
				break;
			case 2:											
				play2();									//Choice = 2 on lance le mode de jeu n�2
				break;
			}			
		} while(choice != 3);								//On �x�cute le code situ� dans le "do" tant que le choix n'est pas �gal � 3 sinon on sort de la boucle

		System.out.println("Fin de la partie...");			//Affichage du texte de fin de partie
		System.exit(0);										//On ferme l'application

	}


	/************************************************************
	 * 														    *
	 * Fonction mainMenu qui affiche le menu principal de d�but *
	 * 														    *
	 ************************************************************/

	public void mainMenu() {

		System.out.println("+--------------------------------+");												//Affichage de texte en console...
		System.out.println("|    Bienvenue sur notre jeu     |");
		System.out.println("| Devinez le nombre myst�rieux ! |");
		System.out.println("+--------------------------------+ \n");
		System.out.println("Mode de jeu n�1 : Devinez le nombre que l'ordinateur a g�n�r� al�atoirement.");
		System.out.println("Mode de jeu n�2 : Guidez l'ordinateur pour qu'il devine votre nombre. \n");
		System.out.println("1 : Mode de jeu n�1");
		System.out.println("2 : Mode de jeu n�2");
		System.out.println("3 : Quitter le jeu");

	}

	/********************
	 * 					*
	 * FIN DU PROGRAMME *
	 * 					*
	 ********************/

}