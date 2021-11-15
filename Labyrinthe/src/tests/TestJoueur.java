package tests;

import composants.Piece;
import composants.Plateau;
import grafix.interfaceGraphique.IG;
import joueurs.Joueur;

public class TestJoueur {
		public static void main(String[] args) {
			Object parametresJeu[];
			parametresJeu=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie
			
			Plateau plateau=new Plateau();
			
			
			
			Joueur joueurs[]=Joueur.nouveauxJoueurs(parametresJeu);
						
			// Cr�ation de la fen�tre de jeu et affichage de la fen�tre 
			int nbJoueurs=joueurs.length; // R�cup�ration du nombre de joueurs
			IG.creerFenetreJeu("D�mo Team Foxers Librairie IG version 1.9", nbJoueurs); // On cr�e la fen�tre
			IG.rendreVisibleFenetreJeu();  // On rend visible la fen�tre de jeu
					
			//Initialise les joueurs
			for(int i=0; i<nbJoueurs; i++) {
			IG.changerNomJoueur(joueurs[i].getNumJoueur(), joueurs[i].getNomJoueur()+" ("+joueurs[i].getCategorie()+")");
			IG.changerImageJoueur(joueurs[i].getNumJoueur(),joueurs[i].getNumeroImagePersonnage());
			//System.out.println(joueurs[i].getPosLigne());
			IG.placerJoueurSurPlateau(i, joueurs[i].getPosLigne(), joueurs[i].getPosColonne());
			}
			
			// Affichage du message de bienvenue + mise � jour affichage + attente clic
			String message[]={
				"",
				"",
				"Cliquez pour continuer...",
				""
			};
			IG.afficherMessage(message); // On change de message de la fen�tre de jeu
			IG.miseAJourAffichage();
			IG.attendreClic();
			
			Piece pieceHorsPlateau=plateau.placerPiecesAleatoirement();
			
		
			// Affichage message
			String message1[]={
				"",
				"Au tour de "+joueurs[0].getNomJoueur(),
				"S�lectionner une case ...",
				""
			};
			IG.afficherMessage(message1); // On change de message de la fen�tre de jeu
			
			IG.miseAJourAffichage();
            IG.attendreClic();
            
            boolean bool01 = true;
            while(bool01 == true) {
                int[] tabArrivee = joueurs[0].choisirCaseArrivee(null);
                int ligArrivee = tabArrivee[0];
                int colArrivee = tabArrivee[1];

                IG.selectionnerPiecePlateau(ligArrivee,colArrivee);

                IG.placerJoueurSurPlateau(0, ligArrivee, colArrivee);
                IG.miseAJourAffichage();
                bool01 = false;
            }
            
         // Affichage message
         String message2[]={
         	"",
         	"Au tour de "+joueurs[1].getNomJoueur(),
         	"S�lectionner une case ...",
         	""
         };
         IG.afficherMessage(message2); // On change de message de la fen�tre de jeu
         			
         IG.miseAJourAffichage();
         IG.attendreClic();
            
            boolean bool02 = true;
            while(bool02 == true) {
                int[] tabArrivee = joueurs[1].choisirCaseArrivee(null);
                int ligArrivee = tabArrivee[0];
                int colArrivee = tabArrivee[1];

                IG.selectionnerPiecePlateau(ligArrivee,colArrivee);

                IG.placerJoueurSurPlateau(1, ligArrivee, colArrivee);
                IG.miseAJourAffichage();
                bool02 = false;
            }
            
         // Affichage message
            String message3[]={
            	"",
            	"Au tour de "+joueurs[2].getNomJoueur(),
            	"S�lectionner une case ...",
            	""
            };
            IG.afficherMessage(message3); // On change de message de la fen�tre de jeu
            			
            IG.miseAJourAffichage();
            IG.attendreClic();
               
               boolean bool03 = true;
               while(bool03 == true) {
                   int[] tabArrivee = joueurs[2].choisirCaseArrivee(null);
                   int ligArrivee = tabArrivee[0];
                   int colArrivee = tabArrivee[1];

                   IG.selectionnerPiecePlateau(ligArrivee,colArrivee);

                   IG.placerJoueurSurPlateau(2, ligArrivee, colArrivee);
                   IG.miseAJourAffichage();
                   bool03 = false;
               }
		}
		
}
