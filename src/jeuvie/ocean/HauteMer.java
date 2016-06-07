package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.LigneEauProfonde;

public class HauteMer extends Ocean {

	protected final int NB_COLONNES = 60;
	protected final int NB_LIGNES = 55;

	public HauteMer(int forme) {
		super(forme);
	}

	public HauteMer(List<ILigneEau> grille) {
		super(grille);
	}

	public int getNbLignes() {
		return NB_LIGNES;
	}

	@Override
	protected void remplirDeLignesEau() {
		for (int i = 0; i < NB_LIGNES; i++) {
			grille.add(i, new LigneEauProfonde(NB_COLONNES, true));
		}
	}

	public HauteMer clone() {
		List<ILigneEau> grilleDuplique = new ArrayList<ILigneEau>(NB_LIGNES);
		for (ILigneEau iLigneEau : grille) {
			grilleDuplique.add(((LigneEauProfonde) iLigneEau).clone());
		}
		return new HauteMer(grilleDuplique);
	}

}
