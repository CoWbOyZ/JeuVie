package jeuvie.bestiole;

import jeuvie.Couleur;

public class Dauphin extends Bestiole {
	private static final Couleur MORT = Couleur.BLEU_MARINE;
	private static final Couleur VIVANT = Couleur.BLEU_GRIS;
	
	@Override
	protected Couleur getCouleurVivant() {
		return VIVANT;
	}
	
	@Override
	protected Couleur getCouleurMort() {
		return MORT;
	}

	public Dauphin() {
		super();
	}

	public Dauphin(Couleur couleur, int n, boolean vivante) {
		super(couleur, n, vivante);
	}
	
	public Dauphin clone() {
		return new Dauphin(super.getCouleur(), super.getNumero(), super.vivante);
	}
}
