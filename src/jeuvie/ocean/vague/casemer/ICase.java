package jeuvie.ocean.vague.casemer;

import jeuvie.Couleur;
import jeuvie.bestiole.IBestiole;
import jeuvie.ocean.IOcean;

public interface ICase extends Cloneable {

	public void setVivante();
	
	public Couleur getCouleur();
	
	public void evoluer(IOcean copie, int i, int j);

	public boolean isVide();
	
	public IBestiole getOccupant();
	public void tuerEventuelOccupant();
	public boolean contientBestioleVivante();
	
	
}
