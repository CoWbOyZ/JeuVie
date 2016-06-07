package jeuvie;

import controleur.Controleur;
import jeuvie.ocean.BordDeCote;
import jeuvie.ocean.HauteMer;
import jeuvie.ocean.Ocean;

public class JeuVie {

	public static void main(String[] args) {
		new Controleur(new BordDeCote(Ocean.PI));
		new Controleur(new HauteMer(Ocean.ALEA));
//		new Controleur(new HauteMer(Ocean.BARRE));
//		new Controleur(new HauteMer(Ocean.CANON));
//		new Controleur(new HauteMer(Ocean.CLOWN), Controleur.ITER_CLOWN);
//		new Controleur(new HauteMer(Ocean.PI), Controleur.ITER_PI);
//		new Controleur(new HauteMer(Ocean.GRAND_VAISSEAU));
//		new Controleur(new HauteMer(Ocean.PETIT_VAISSEAU));
		
	}
}
