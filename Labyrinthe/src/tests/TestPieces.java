package tests;
import composants.Piece;
import grafix.interfaceGraphique.IG;


public class TestPieces {

    public static void main(String[] args) {
        // Interface graphique
        // Saisie des diff�rents param�tres
        Object parametres[];
        parametres=IG.saisirParametres(); // On ouvre la fen�tre de param�trage pour la saisie

        // Création de la fenêtre de jeu et affichage de la fenêtre
        int nbJoueurs=((Integer)parametres[0]).intValue(); // Récupération du nombre de joueurs
        IG.creerFenetreJeu("TestPieces Team Foxers",nbJoueurs); // On crée la fenêtre
        IG.rendreVisibleFenetreJeu();  // On rend visible la fenêtre de jeu

        // Affichage d'un message
        String message[]={
                "",
                "",
                "Cliquez pour continuer ...",
                ""
        };
        IG.afficherMessage(message); // On change de message de la fenêtre de jeu
        IG.miseAJourAffichage(); // On effectue le rafraichissement de la fenêtre de jeu
        IG.attendreClic();  // On attend un clic de souris

        //Changement du plateau
        Piece[] PiecePlateau = Piece.nouvellesPieces();

        //Permet d'initialiser les pi�ces sur le tableau
        int compteur = 0;
        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++){
                IG.changerPiecePlateau(i, j, PiecePlateau[compteur].getModelePiece() ,PiecePlateau[compteur].getOrientationPiece());
                compteur++;
            }
        }

        //IG.changerPieceHorsPlateau(PiecePlateau[PiecePlateau.length-1].getModelePiece() ,PiecePlateau[PiecePlateau.length-1].getOrientationPiece());
        //System.out.println(PiecePlateau[PiecePlateau.length-1].toString());
        IG.miseAJourAffichage();
        IG.attendreClic();

        //Permet le tri des pi�ces par mod�le
        //On cr�� des listes pour chauque mod�le
        Piece[] Tableau_modele_0 = new Piece[20];
        Piece[] Tableau_modele_1 = new Piece[12];
        Piece[] Tableau_modele_2 = new Piece[18];
        
        int cpt0 = 0;
        int cpt1 = 0;
        int cpt2 = 0;
        //Nouveau tableau avec les pi�ces tri�es
        Piece[] Tableau_final = new Piece[50];

        //On trie les pi�ces par mod�le
        for(int i=0; i<50; i++){
            if(PiecePlateau[i].getModelePiece()==0){
                Tableau_modele_0[cpt0] = PiecePlateau[i];
                cpt0++;
            }
            else if(PiecePlateau[i].getModelePiece()==1){
                Tableau_modele_1[cpt1] = PiecePlateau[i];
                cpt1++;
            }
            else {
                Tableau_modele_2[cpt2] = PiecePlateau[i];
                cpt2++;
            }
        }

        //Tri
        for(int i = 0; i<20; i++){
            Tableau_final[i] = Tableau_modele_0[i];
        }
        for(int i = 0; i<12; i++){
            Tableau_final[i+20] = Tableau_modele_1[i];
        }
        for(int i = 0; i<18; i++){
            Tableau_final[i+20+12] = Tableau_modele_2[i];
        }

        //Permet de placer les pi�ces sur le plateau (6x6)
        int compteur_2 = 0;
        for(int i = 0; i<=6; i++){
            for(int j = 0; j<=6; j++){
                IG.changerPiecePlateau(i, j, Tableau_final[compteur_2].getModelePiece() ,Tableau_final[compteur_2].getOrientationPiece());
                compteur_2++;
            }
        }

        //Permet de placer la pi�ce hors plateau
        IG.changerPieceHorsPlateau(Tableau_final[Tableau_final.length-1].getModelePiece() ,Tableau_final[Tableau_final.length-1].getOrientationPiece());
        IG.miseAJourAffichage();
        IG.attendreClic();

        //Permet la rotation 4x dans le sens horaire
        for(int x=0; x<=3; x++) {
            int compteur_3 = 0;
            for (int i = 0; i < 7; i++) {
                for (int j = 0; j < 7; j++) {
                    Tableau_final[compteur_3].rotation();
                    IG.changerPiecePlateau(i, j, Tableau_final[compteur_3].getModelePiece(), Tableau_final[compteur_3].getOrientationPiece());
                    compteur_3++;
                }
            }
            Tableau_final[49].rotation();
            IG.changerPieceHorsPlateau(Tableau_final[Tableau_final.length-1].getModelePiece() ,Tableau_final[Tableau_final.length-1].getOrientationPiece());
            System.out.println(PiecePlateau[PiecePlateau.length-1].toString());
            IG.miseAJourAffichage();
            IG.attendreClic();
        }

        //Fin
        IG.fermerFenetreJeu();
        System.exit(0);
    }
}