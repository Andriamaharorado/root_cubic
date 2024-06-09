### Markdown du texte

---

Pour trouver la racine cubique d'un nombre, la méthode de résolution de l'équation \( f(x) = 0 \) est utilisée. Les déterminations de la solution commencent par l'équation \( f(x) = x^3 - a = 0 \).

Deux méthodes sont utilisées pour résoudre cette équation :

1. **La méthode de dichotomie** :
    - Basée sur le Théorème des Valeurs Intermédiaires, cette méthode est implémentée dans la fonction `racineCubiqueDichotomie`.
    - Elle consiste à diviser l'intervalle en deux de manière répétée jusqu'à ce que l'intervalle soit suffisamment petit pour contenir la solution avec la précision souhaitée.

2. **La méthode de Newton-Raphson** :
    - Cette méthode, également appelée méthode de la tangente, est implémentée dans la fonction `racineCubiqueNewtonRaphson`.
    - Elle affine successivement une approximation initiale en utilisant la dérivée de la fonction jusqu'à ce que la différence entre les approximations successives soit inférieure à une petite valeur (epsilon).

Pour le bon fonctionnement de ces deux fonctions, des méthodes auxiliaires sont créées :

- `puissance` : méthode pour calculer la puissance d'un nombre en gérant les exposants positifs, négatifs et zéro.
- `saisirDouble` : méthode pour saisir et valider un nombre réel avec gestion des exceptions.
- `valueAbs` : méthode pour calculer la valeur absolue d'un nombre.

Toutes ces fonctions sont implémentées dans le fichier `functions.java` et sont appelées dans le fichier `main.java` pour exécuter le programme principal. Ces méthodes assurent une base solide pour les calculs nécessaires à la recherche de la racine cubique.

---
