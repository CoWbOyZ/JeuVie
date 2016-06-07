package jeuvie.ocean;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.ILigneEau;
import jeuvie.ocean.vague.Vague;

public class BordDeCote extends Ocean {
	
	protected final int NB_COLONNES = 70;
	protected final int NB_LIGNES = 95;
	
	public BordDeCote(int forme) {
		super(forme);
	}
	
	public BordDeCote(List<ILigneEau> grille) {
		super(grille);
	}
	
	public int getNbLignes() {
		return NB_LIGNES;
	}

	@Override
	protected void remplirDeLignesEau() {
		for (int i = 0; i < NB_LIGNES; i++) {
			grille.add(i, new Vague(NB_COLONNES, true));
		}
	}
	
	public BordDeCote clone() {
		List<ILigneEau> grilleDuplique = new ArrayList<ILigneEau>(NB_LIGNES);
		for (ILigneEau iLigneEau : grille) {
			grilleDuplique.add(((Vague) iLigneEau).clone());
		}
		return new BordDeCote(grilleDuplique);
	}

}
