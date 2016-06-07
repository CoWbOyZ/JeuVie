package jeuvie.bestiole;

import jeuvie.Couleur;

public class Bigorneau extends Bestiole {
	private static final Couleur MORT = Couleur.GRIS_CLAIR;
	private static final Couleur VIVANT = Couleur.NOIR;
	
	@Override
	protected Couleur getCouleurVivant() {
		return VIVANT;
	}
	
	@Override
	protected Couleur getCouleurMort() {
		return MORT;
	}

	public Bigorneau() {
		super();
	}

	public Bigorneau(Couleur couleur, int n, boolean vivante) {
		super(couleur, n, vivante);
	}
	
	public Bigorneau clone() {
		return new Bigorneau(super.getCouleur(), super.getNumero(), super.vivante);
	}
}
