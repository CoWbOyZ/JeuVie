package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Dauphin;
import jeuvie.ocean.IOcean;

public class ColonneEau extends Case {

	private static final Couleur CASE_VIDE = Couleur.BLEU_SOMBRE;
	
	public Couleur getCouleurCaseVide() {
		return CASE_VIDE;
	}
	
	public ColonneEau() {
		super();
	}

	public ColonneEau(Dauphin occupant, boolean vide) {
		super();
		super.vide = vide;
		super.occupant = occupant;
	}

	@Override
	protected void setBestioleVivante() {
		this.occupant = new Dauphin();		
	}

	@Override
	public void evoluer(IOcean copie, int i, int j) {
		int nbVivantsAutour = copie.compterVoisinsVivants(i, j);
		if (this.contientBestioleVivante()) {
			if (nbVivantsAutour != 2 && nbVivantsAutour != 3) {
				this.tuerEventuelOccupant();
			}
		} else {
			if (nbVivantsAutour == 3){
				this.setVivante();
			}
		}
	}
	
	public ColonneEau clone() {
		ColonneEau nouvelleCase;
		if (super.isVide()) {
			nouvelleCase = new ColonneEau();
		} else {
			nouvelleCase = new ColonneEau(((Dauphin)occupant).clone(), false);
		}
		return nouvelleCase;
	}
}