__2. Créer le projet__  
  
__B. Exécuter les tests unitaires__  
  
Les tests mettent autant de temps à cause de la méthode isWellSortedLargeArrays.
En effet, elle prend 16819 ms.
Elle prend autant de temps, car la liste est composée de 50 000 integer, et qu'elle est entierement triée 2 fois.  
  
__3. Intégration continue__   
  
__A. S'assurer que le code de l'application ne comporte pas d'erreurs__  
  
__2.__ Les tests ne passent pas, il y a une erreur de compilation.  
  
__4.__ Après avoir récupéré les derniers changements, les autres membres ont également une erreur de compliation pour les tests.  
  
  
__B. Mise en place de l'intégration continue__  
  
__6.__ Sur le repo Github, il est affiché le push correspondant au message 'Script pour compiler le code à chaque push', suivi d'une croix.
Lorsqu'on clique sur la croix, il est indiqué 'All checks have failed', à cause du problème de compilation précédent.  
  
__9.__ On a une erreur dans les badTest, qui est bien censé ne pas fonctionné.  
  
__10.__ On remarque que l'erreur est toujours présente sur le repo Github après le commit+push.  
  
__13.__ Après le commit+push, on remarque que la croix a disparu, puisqu'à présent les tests s'exécutent à chaque push  
  
__4. Exercices__  
  
__1.__ Nous avons ajouté iuts3.class@gmail.com aux notifications.  


 