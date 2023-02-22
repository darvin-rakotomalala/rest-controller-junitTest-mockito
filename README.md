## Spring Boot REST Controller | JUnit Test & Mockito

Dans ce repo, nous allons voir des cas de test JUnit pour les API REST Spring Boot à l'aide de JUnit 5 et Mockito.

### Qu'est-ce que le tests unitaires ?
---
Les tests unitaires sont utilisés pour tester les plus petites unités d'une application. Les tests unitaires permettent
de s'assurer qu'une unité de code fonctionne comme prévu.
Il existe de nombreux frameworks de tests unitaires disponibles en Java. Exemple : TestNG, JUnit, Mockito, etc. Avec ces
frameworks, nous pouvons facilement ajouter des cas de test JUnit du contrôleur de Spring Boot.

### Technologies
---

- Java 17
- Spring Boot 3
- JUnit 5
- Mockito

### Quelques des points à noter
---

- `@WebMvcTest` : cette annotation initialise les configurations Web MVC requises pour écrire le cas de test JUnit pour
  les classes de contrôleur.
- `MockMvc` : cette classe fournit les méthodes requises pour tester la couche Spring MVC. avec la méthode perform () ,
  nous pouvons tester différents points de terminaison HTTP (GET, POST, PUT, DELETE, etc.)
- `@MockBean` : cette annotation crée des beans fictifs dans le contexte de l'application Spring.
- `@Test` : indique que la méthode est un cas de test.
- `Mockito` : cette classe de framework Mockito crée une maquette d'un objet. Nous nous sommes moqués des valeurs de
  retour de la couche service dans notre exemple.
- `jsonpath` : Spring boot fournit des supports intégrés JsonPath qui sont utiles pour vérifier la réponse JSON.
- `MvcResult` : MockMvc renvoie un objet de résultat lors de l'appel de andReturn() , qui contient les détails de la
  réponse d'une opération MVC particulière.

### Exécutez les tests unitaires
---

- Exécuter le test : `mvn test`

### Ressources utiles
---

- [JUnit Framework Best Practices](https://www.javaguides.net/2018/08/junit-framework-best-practices.html)
- [Best Practices for Unit Testing in Java](https://www.developer.com/java/best-practices-unit-testing-java/)