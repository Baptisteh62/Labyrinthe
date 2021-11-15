package joueurs;

import composants.Objet;
import composants.Piece;
import composants.Plateau;
import composants.Utils;
import partie.ElementsPartie;
import partie.Partie;

/**
 * 
 * Cette classe permet de représenter un joueur ordinateur de type T3.
 * 
 * @author Jean-François Condotta - 2021
 *
 */

public class JoueurOrdinateurT3 extends JoueurOrdinateur {

	/**
	 * Constructeur permettant de créer un joueur.
	 * 
	 * @param numJoueur Le numéro du joueur.
	 * @param nomJoueur Le nom du joueur.
	 * @param numeroImagePersonnage Le numéro de l'image représentant le joueur.
	 * @param posLignePlateau La ligne du plateau sur laquelle est positionnée le joueur.
	 * @param posColonnePlateau La colonne du plateau sur laquelle est positionnée le joueur.

	 */
	public JoueurOrdinateurT3(int numJoueur,String nomJoueur, int numeroImagePersonnage,int posLignePlateau,int posColonnePlateau) {
				super(numJoueur,nomJoueur, numeroImagePersonnage,posLignePlateau,posColonnePlateau);
	}
	
	private int[][] avoirObjetDeuxCoup(ElementsPartie elementspartie, Partie partie){
		int[][] tabSolution = new int[100][2];
		tabSolution=null;
		int nbSolution = 0;
		int numJoueur=partie.getJoueurActuel(); //r�cup�ration du num�ro du joueur actuel
		if(avoirObjetUnCoup(elementspartie,partie,numJoueur)!=null) { //Si on ne peut pas avoir l'objet en 1 coup
			for(int entree1=0; entree1<27; entree1++) { //Parcoure les entr�es du premier tour
				for (int orien1 = 0; orien1<3; orien1++) { //On parcours les diff�rentes orientations du coup 1
					ElementsPartie copyElementPartie = elementspartie.copy(); //Copie du plateau
					copyElementPartie.getPieceLibre().setOrientation(orien1); //D�finition de l'orientation de la pi�ce libre
					copyElementPartie.insertionPieceLibre(entree1); //Insertion de la pi�ce libre tour 1
					int colonne = copyElementPartie.getJoueurs()[numJoueur].getProchainObjet().getPosColonnePlateau(); //R�cup�re ???
					for (int entree2=0; entree2<27; entree2++) { //Parcours les entr�es au 2�me tour
						for(int orien2=0; orien2<3; orien2++) { //Parcours les orientations au 2�me tour
							copyElementPartie.insertionPieceLibre(entree2); //Insertion de la pi�ce libre tour 2
							if(copyElementPartie.getPlateau().calculChemin(copyElementPartie.getJoueurs()[numJoueur].getPosLigne(), copyElementPartie.getJoueurs()[numJoueur].getPosColonne(), PositionLigne, PositionColonne))
								tabSolution[nbSolution][0] = entree1;
								tabSolution[nbSolution][1] = orien1;
								nbSolution++;
						}
					}
				}
			}
		}
	}
	

	@Override
	public String getCategorie() {
		return "OrdiType3";
	}

	
	@Override
	public Joueur copy(Objet objets[]){
		Joueur nouveauJoueur=new JoueurOrdinateurT3(getNumJoueur(),getNomJoueur(), getNumeroImagePersonnage(),getPosLigne(),getPosColonne());
		nouveauJoueur.setObjetsJoueur(this.getObjetsJoueurGeneral(objets));
		while (nouveauJoueur.getNombreObjetsRecuperes()!=this.getNombreObjetsRecuperes())
			nouveauJoueur.recupererObjet();
		return nouveauJoueur;
	}

}
