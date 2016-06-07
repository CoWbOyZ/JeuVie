package jeuvie.ocean.vague;

import jeuvie.ocean.vague.casemer.CasePeuProfonde;
import jeuvie.ocean.vague.casemer.ICase;

public class Vague extends LigneEau {

	public Vague(int taille, boolean prevoirLesCasesVides) {
		super(taille, prevoirLesCasesVides);
	}

	@Override
	protected void remplirLesCasesVides() {
		for (int i = 0; i < super.getNbColonnes(); i++) {
			super.add(new CasePeuProfonde());
		}
	}

	@Override
	public Vague clone() {
		Vague nouvelleLigne = new Vague(super.getNbColonnes(), false);
		for (int i = 0; i < super.getNbColonnes(); i++) {
			ICase ancienneCase = super.get(i);
			nouvelleLigne.add(((CasePeuProfonde) ancienneCase).clone());
		}
		return nouvelleLigne;
	}

}
