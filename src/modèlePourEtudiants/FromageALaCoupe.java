package mod�lePourEtudiants;
public class FromageALaCoupe extends Fromage {

	public FromageALaCoupe(String d�signation) {
		super(d�signation);
	}
	
	public String toString2() {
		return super.toString() + ", vendu � la coupe ou au poids";
	}

}
