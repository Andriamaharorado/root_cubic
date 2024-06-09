package RacineCubique;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		functions funct = new functions();
		
		double number = funct.saisirDouble("Entrer le nombre dont on veut calculer la racine cubique: ");
        
		double cubeRootNewtonRaphson = funct.racineCubiqueNewtonRaphson(number);
        
		double cubeRootdichotomie = funct.racineCubiqueDichotomie(number);
        
        System.out.println("La racine cubique methode 1 de " + number + " est " + cubeRootNewtonRaphson);
        
        System.out.println("La racine cubique methode 2 de " + number + " est " + cubeRootdichotomie);
	}

}
