package modèlePourEtudiants;
public class FromageALUnité extends Fromage {
	
	public FromageALUnité(String désignation) {
		super(désignation);
	}

	public String toString2() {
		return super.toString() + ", vendu à l'unité";
	}

}
