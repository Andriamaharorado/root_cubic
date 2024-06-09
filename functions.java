package RacineCubique;
import java.util.Scanner;

public class functions {

    // Scanner pour la saisie utilisateur
    Scanner scanner = new Scanner(System.in);
    
    // Epsilon pour la précision des calculs
    double epsilon = puissance(10, -10);
    
    // Méthode pour calculer la puissance d'un nombre
    public double puissance(double base, int exposant) {
        double power = 1.0;
        
        if (exposant > 0) {
            // Calcul de la puissance positive
            for (int i = 0; i < exposant; i++) {
                // Le nombre est multiplié n fois par lui-même
                power *= base;
            }
        } else if (exposant == 0) {
            // Si l'exposant est 0, le résultat est 1
            power = 1;
        } else {
            // Calcul de la puissance négative
            for (int i = 0; i < valueAbs(exposant); i++) {
                // L'inverse du nombre est multiplié n fois par lui-même
                power *= 1 / base;
            }
        }
        return power;
    }
    
    // Méthode pour saisir un nombre réel avec validation
    public double saisirDouble(String message) {
        double valeur;
        
        while (true) {
            System.out.println(message);
            try {
                // Lire la valeur entrée par l'utilisateur
                valeur = scanner.nextDouble();
                break;  // Sortie de la boucle si la saisie est correcte
            } catch (Exception e) {
                // En cas d'erreur, demander une nouvelle saisie
                System.out.println("Erreur : Veuillez entrer un nombre réel valide.");
                scanner.next();  // Effacer l'entrée incorrecte du scanner
            }
        }
        return valeur;
    }
    
    // Méthode pour calculer la valeur absolue d'un nombre
    public double valueAbs(double x) {
        if (x < 0) {
            // Si le nombre est négatif, retourner son opposé
            return -x;
        } else {
            // Si le nombre est déjà positif, retourner tel quel
            return x;
        }
    }
    
    // Méthode pour calculer la racine cubique par dichotomie
    public double racineCubiqueDichotomie(double nombre) {
        double inf, sup;  // Borne inférieure et supérieure

        if (nombre < 0) {
            // Si le nombre est négatif, borne inférieure = nombre, borne supérieure = 0
            inf = nombre;
            sup = 0;
        } else {
            // Si le nombre est positif, borne inférieure = 0, borne supérieure = nombre
            inf = 0;
            sup = nombre;
        }
        
        double c0 = 0;  // Variable pour stocker l'approximation de la racine cubique
        
        while ((sup - inf) > epsilon) {
            c0 = (inf + sup) / 2.0;
            double midCubed = puissance(c0, 3);

            if (midCubed == nombre) {
                // Si c0^3 == nombre, racine exacte trouvée
                return c0;
            } else if (midCubed < nombre) {
                // Si c0^3 < nombre, ajuster la borne inférieure
                inf = c0;
            } else {
                // Si c0^3 > nombre, ajuster la borne supérieure
                sup = c0;
            }
        }

        // Retourner l'approximation de la racine cubique
        return c0;
    }

    // Méthode pour calculer la racine cubique par Newton-Raphson
    public double racineCubiqueNewtonRaphson(double nombre) {
        double prop = nombre / 3.0;  // Initialiser la première approximation
        double difference;
        
        do {
            double ancien_prop = prop;
            // Nouvelle approximation selon la méthode de Newton-Raphson
            prop = (2.0 / 3.0) * prop + (nombre / (3.0 * puissance(prop, 2)));
            // Calculer la différence entre l'ancienne et la nouvelle approximation
            difference = valueAbs(prop - ancien_prop);
        } while (difference > epsilon);  // Continuer jusqu'à ce que la différence soit inférieure à epsilon

        return prop;  // Retourner l'approximation finale
    }
}
