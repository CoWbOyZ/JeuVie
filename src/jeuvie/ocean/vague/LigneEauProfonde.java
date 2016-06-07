package jeuvie.ocean.vague;

import jeuvie.ocean.vague.casemer.ColonneEau;
import jeuvie.ocean.vague.casemer.ICase;

public class LigneEauProfonde extends LigneEau {
	
	public LigneEauProfonde(int taille, boolean prevoirLesCasesVides) {
		super(taille, prevoirLesCasesVides);
	}

	@Override
	protected void remplirLesCasesVides() {
		for (int i = 0; i < super.getNbColonnes(); i++) {
			super.add(new ColonneEau());
		}
	}

	@Override
	public LigneEauProfonde clone() {
		LigneEauProfonde nouvelleLigne = new LigneEauProfonde(super.getNbColonnes(), false);
		for (int i = 0; i < super.getNbColonnes(); i++) {
			ICase ancienneCase = super.get(i);
			nouvelleLigne.add(((ColonneEau) ancienneCase).clone());
		}
		return nouvelleLigne;
	}
	
}
