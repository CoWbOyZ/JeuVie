package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.Bigorneau;
import jeuvie.ocean.IOcean;

public class CasePeuProfonde extends Case {

	private static final Couleur CASE_VIDE = Couleur.BLEU_CLAIR;

	public Couleur getCouleurCaseVide() {
		return CASE_VIDE;
	}
	
	public CasePeuProfonde() {
		super();
	}
	
	public CasePeuProfonde(Bigorneau occupant, boolean vide) {
		super();
		super.vide = vide;
		super.occupant = occupant;
	}

	@Override
	protected void setBestioleVivante() {
		this.occupant = new Bigorneau();		
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
	
	public CasePeuProfonde clone() {
		CasePeuProfonde nouvelleCase;
		if (super.isVide()) {
			nouvelleCase = new CasePeuProfonde();
		} else {
			nouvelleCase = new CasePeuProfonde(((Bigorneau)occupant).clone(), false);
		}
		return nouvelleCase;
	}
}