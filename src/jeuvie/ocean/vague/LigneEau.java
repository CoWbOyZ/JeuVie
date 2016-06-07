package jeuvie.ocean.vague;

import java.util.ArrayList;
import java.util.List;

import jeuvie.ocean.vague.casemer.ICase;

public abstract class LigneEau implements ILigneEau {

	private final int NB_COLONNES;
	private List<ICase> lesCases = new ArrayList<ICase>();
	
	protected abstract void remplirLesCasesVides();
	protected abstract ILigneEau clone();

	protected LigneEau(int taille, boolean prevoirLesCasesVides) {
		super();
		this.NB_COLONNES = taille;
		if (prevoirLesCasesVides) {remplirLesCasesVides();}
	}

	public ICase get(int i) {
		return lesCases.get(i);
	}

	public int getNbColonnes() {
		return NB_COLONNES;
	}
	
	public boolean add(ICase uneCase) {
		return lesCases.add(uneCase);
	}

}
