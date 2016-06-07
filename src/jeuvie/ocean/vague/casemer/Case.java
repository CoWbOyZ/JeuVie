package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;
import jeuvie.ocean.IOcean;

public abstract class Case implements ICase {
	
	protected boolean vide = true;
	protected IBestiole occupant = null;

	protected abstract void setBestioleVivante();
	protected abstract Couleur getCouleurCaseVide();
	public abstract void evoluer(IOcean copie, int i, int j);
	
	public void setVivante() {
		this.vide = false;
		setBestioleVivante();
	}

	public Couleur getCouleur() {
		Couleur couleur =getCouleurCaseVide();
		if (!isVide()){
			couleur = occupant.getCouleur();
		}
		return couleur;
	}

	public boolean isVide() {
		return vide;
	}
	
	public IBestiole getOccupant() {
		return this.occupant;
	}

	public void tuerEventuelOccupant() {
		if (!isVide()) {
			occupant.tuer();
		}
	}
	
	public boolean contientBestioleVivante() {
		return (!isVide() && occupant.isVivante());
	}
	@Override
	public String toString() {
		return "Case [vide=" + vide + ", occupant=" + occupant + "]";
	}

	
}