package jeuvie.bestiole;

import jeuvie.Couleur;

public abstract class Bestiole implements IBestiole {

	protected Couleur couleur;
	protected boolean vivante = true;
	protected final int NUMERO;
	protected static int compteur = 0;

	protected abstract Couleur getCouleurVivant();
	protected abstract Couleur getCouleurMort();

	public Bestiole() {
		super();
		this.couleur = getCouleurVivant();
		this.NUMERO = compteur++;
	}

	public Bestiole(Couleur couleur, int n, boolean vivante) {
		super();
		this.couleur = couleur;
		NUMERO = n;
		this.vivante = vivante;
	}

	public int getNumero() {
		return NUMERO;
	}

	public boolean isVivante() {
		return vivante;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void tuer() {
		couleur = getCouleurMort();
		vivante = false;
	}

	@Override
	public String toString() {
		return "Bestiole [couleur=" + couleur + ", vivante=" + vivante + ", NUMERO=" + NUMERO + "]";
	}

}
