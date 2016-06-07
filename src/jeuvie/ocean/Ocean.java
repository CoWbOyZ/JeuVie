package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;

public abstract class Ocean implements IOcean {

	public static final int CLOWN = 1;
	public static final int CANON = 2;
	public static final int PETIT_VAISSEAU = 3;
	public static final int GRAND_VAISSEAU = 4;
	public static final int PI = 5;
	public static final int ALEA = 6;
	public static final int BARRE = 7;

	protected List<ILigneEau> grille;

	protected abstract void remplirDeLignesEau();

	private void setBestiole(int i, int j){
		this.get(j).get(i).setVivante();
	}

	public void etapeSuivante(){
		try {
			IOcean oceanInstantT = (IOcean) this.clone();
			
			for (int l = 0; l < getNbLignes(); l++) {
				for (int col = 0; col < getNbColonnes(); col++) {
					this.get(l).get(col).evoluer(oceanInstantT, col, l);
				}
			}
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}

	public ILigneEau get(int i){
		return grille.get(i);
	}

	public int compterVoisinsVivants(int col, int l) {
		int nbVivants = 0;
		int colonneDebut = col-1;
		int colonneFin = col+1;
		int ligneDebut = l-1;
		int ligneFin = l+1;

		if (col == 0) {colonneDebut = 0;}
		if (l == 0) {ligneDebut = 0;}
		if (col == getNbColonnes()-1) {colonneFin = col;}
		if (l == getNbLignes()-1) {ligneFin = l;}

		for (int k = ligneDebut; k <= ligneFin; k++) {
			//System.out.println("dans les lignes");
			for (int k2 = colonneDebut; k2 <= colonneFin; k2++) {
				//System.out.println("dans les colonnes");
				if (k != l || k2 != col) {
					if (this.get(k).get(k2).contientBestioleVivante()) {
						//System.out.println("+1");
						nbVivants++;
					}
				}
			}
		}
		return nbVivants;
	}

	protected void creerFormeDeVie(int forme){

		final int BASE_X = 25;
		final int BASE_Y = 25;

		switch (forme) {
		case PETIT_VAISSEAU:
			for (int i = 0; i < getNbLignes()/7; i++) {
				int delta=i*7+3;
				setBestiole(3, delta);
				setBestiole(4, delta+1);
				setBestiole(2, delta+2); setBestiole(3, delta+2); setBestiole(4, delta+2);
			}
			break;
		case GRAND_VAISSEAU:
			for (int i = 0; i < getNbLignes()/9; i++) {
				int delta=i*9+3;
				setBestiole(2, delta);setBestiole(5, delta);
				setBestiole(6, delta+1);
				setBestiole(2, delta+2); setBestiole(6, delta+2);
				setBestiole(3, delta+3);setBestiole(4, delta+3);setBestiole(5, delta+3);setBestiole(6, delta+3);
			}

			break;
		case PI:
			for (int i = 0; i < (getNbLignes()/47); i++) {
				int delta= i*47 + BASE_Y;
				setBestiole(BASE_X, delta+3);
				setBestiole(BASE_X-1, delta+2);setBestiole(BASE_X+1, delta+2);
				setBestiole(BASE_X-1, delta+1);setBestiole(BASE_X+1, delta+1);
				setBestiole(BASE_X-1, delta);setBestiole(BASE_X+1, delta);
			}
			break;
		case CLOWN:

			// ligne haute
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y); 			setBestiole(BASE_X+2, BASE_Y);

			// deux barres parallèles
			setBestiole(BASE_X, BASE_Y+1);			setBestiole(BASE_X+2, BASE_Y+1);
			setBestiole(BASE_X, BASE_Y+2); 			setBestiole(BASE_X+2, BASE_Y+2);
			break;
		case BARRE:
			// ligne haute			
			setBestiole(BASE_X, BASE_Y); 			setBestiole(BASE_X+1, BASE_Y);	setBestiole(BASE_X-1, BASE_Y);

			break;
		case CANON:
			// le canon à planneur
			// carré gauche
			setBestiole(2, 10);setBestiole(3, 10);
			setBestiole(2, 11);setBestiole(3, 11);

			// carré droit

			// carré droit
			setBestiole(36, 8);setBestiole(37, 8);
			setBestiole(36, 9);setBestiole(37, 9);


			//flèche gauche
			setBestiole(14, 8);setBestiole(15, 8);
			setBestiole(13, 9);setBestiole(17, 9);
			setBestiole(12, 10); setBestiole(18, 10);
			setBestiole(12, 11);setBestiole(16, 11);setBestiole(18, 11);setBestiole(19, 11);
			setBestiole(12, 12);setBestiole(18, 12);
			setBestiole(13, 13); setBestiole(17, 13);
			setBestiole(14, 14);setBestiole(15, 14);

			//flèche droite
			setBestiole(26, 6);
			setBestiole(24, 7);setBestiole(26, 7);
			setBestiole(22, 8);setBestiole(23, 8);
			setBestiole(22, 9);setBestiole(23, 9);
			setBestiole(22, 10);setBestiole(23, 10);
			setBestiole(24, 11);setBestiole(26, 11);
			setBestiole(26, 12);

			break;

		default: creerDeLaVieAleatoirement();
		break;
		}

	}

	private void creerDeLaVieAleatoirement() {
		for (int j = 0; j < getNbLignes(); j++) {
			ILigneEau ligne = get(j);
			for (int i = 0; i < ligne.getNbColonnes(); i++) {
				double alea = Math.random();
				if (alea<0.2) {
					setBestiole(i, j);
				}
			}
		}
	}


	public int getNbColonnes(){
		int rep = -1;
		if (grille != null && !grille.isEmpty()) {
			rep = this.get(0).getNbColonnes();
		}
		return rep;
	}

	public Ocean(int forme) {
		super();
		grille = new ArrayList<ILigneEau>(getNbLignes());
		remplirDeLignesEau();
		creerFormeDeVie(forme);
	}
	
	protected Ocean(List<ILigneEau> grille) {
		super();
		this.grille = grille;
	}
}
