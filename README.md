# Compte Rendu
Projet Final: Spring Angular JWT, Digital Banking

# Objectif du Projet
On souhaite créer une application qui permet de gérer des comptes bancaires.
chaque compte appartient à un client. un compte peut subir plusieurs opérations de type DEBIT ou CREDIT.
Il existe deux types de comptes : Comptes courants et comptes épargnes.

# Introduction
Le présent compte rendu vise à faire état de l'avancement et des résultats obtenus dans le cadre du projet de développement d'une application de gestion des Comptes bancaire et leur opérations.

# Technologies Utilisées
![1_-uckV8DOh3l0bCvqZ73zYg](https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/e4d0a83e-e97c-4e2a-9e19-4b64a550dd49)
  - Il s'agit d'une extension du framework Spring, axée sur la création d'applications autonomes et prêtes à l'emploi.
  - Spring Boot propose une configuration automatique basée sur les conventions.
  - Spring Boot intègre un serveur web embarqué, ce qui permet de lancer facilement une application sans nécessiter de configuration supplémentaire.
  - Spring Boot gère automatiquement les dépendances du projet en fonction des fonctionnalités requises.

![1_VKY-Ldkt-iHobItql7G_5w](https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/8c1482e0-2c7f-4624-a158-4a10d7872070)
  - un framework de développement d'applications web front-end open-source, créé par Google.
  - Angular suit une architecture de modèle-vue-contrôleur (MVC) qui permet de séparer clairement les préoccupations et d'organiser le code de manière structurée.
  - Angular propose une liaison de données bidirectionnelle qui permet de synchroniser automatiquement les données du modèle et de la vue.
  - Angular offre un système de routage intégré qui permet de gérer la navigation entre différentes vues ou composants de l'application.

# Architecture du Projet
![architecture du projet(spring boot angular)](https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/28e81ba3-3ec9-4875-86ea-7fc76c0f3b53)
  - La communication entre le front-end et le back-end sera mise en œuvre à l'aide d'une API REST.
  - Du côté du front-end, nous aurons un client HTTP et le back-end gérera ces requêtes HTTP à l'aide d'un contrôleur REST Spring.
  - L'application Angular du côté du front-end créera une interface utilisateur entièrement fonctionnelle pour gérer les publications (ajout, modification, recherche).
  - Toutes les données seront enregistrées dans une base de données MySQL, intégrée à l'application à l'aide de Spring Data JPA.

# Structure de L'Application (Backend)
 
  <img width="350" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/73d20b1c-b297-480d-9d06-0aaff3b19ce4">

  - Dependences utilisés:
    * Spring DATA JPA: Il simplifie le développement de la couche d'accès aux données en fournissant des fonctionnalités et des abstractions de haut niveau.
    * Spring Web: Il fournit des fonctionnalités et des abstractions pour la création de services web RESTful et la manipulation des requêtes HTTP.
    * MySQL: peut être utilisé comme système de gestion de base de données (SGBD) pour stocker et récupérer des données à partir d'une application JEE.
    * Lombok: simplifie le développement en réduisant la quantité de code boilerplate nécessaire pour les tâches courantes telles que la définition de getters et de setters.
    * spring-boot-starter-test: facilite les tests d'unité et d'intégration dans les applications Spring Boot.
    * springdoc-openapi-starter-webmvc-ui: facilite la génération automatique de la documentation API et fournit une interface utilisateur conviviale pour visualiser et interagir avec la documentation générée.

  - Configuration:
    ![Capture1](https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/12978cbd-85aa-4362-b09e-c055e5e6bdeb)

  - La Couche DAO:
    * Elle est responsable de l'accès et de la manipulation des données dans une application, en fournissant une interface entre la couche métier et la source de données sous-jacente.

      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/dd47767f-0168-4e0f-8234-4d3f01be3b7c">

      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/9b9caa2c-15ab-4c6d-a6d1-7812bd511ad4">

  - Partie DTO:
    * Les DTO sont des objets simples qui encapsulent les données et sont utilisés pour faciliter la communication et le transfert de données de manière efficace.

      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/456823f3-4cae-4216-b2da-456fb59b4dc8">

      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/48b46cc2-f7e5-45f6-8269-562061875b7e">

  - La Couche Métier:
    * La couche métier agit comme un pont entre la couche de présentation (interface utilisateur) et la couche d'accès aux données, en traitant les requêtes provenant de l'interface utilisateur et en effectuant les opérations nécessaires sur les données pour répondre à ces requêtes.

      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/62eca044-a90c-4130-b5aa-842b1b56efa9">

  - La Couche WEB:
    * Elle est responsable de la gestion des interactions avec les utilisateurs, de la présentation des données et de la représentation visuelle de l'application.

    <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/1be23d1e-ebf3-4783-b8e1-bd2a90207a18">

# Structure de L'Application (Frontend)

  <img width="350" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/81a289b8-b991-477c-b8b2-4def755f2902">

  - Les Modèles:
    * Ils permettent de séparer clairement la logique métier de l'interface utilisateur, facilitent la manipulation des données et offrent des fonctionnalités avancées telles que la liaison de données, les directives, les pipes et les modèles réactifs.

    <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/8288ab77-2ebb-483e-9a0b-5a92767db092">

  - Les Composants:
    * Ils permettent de découper l'interface utilisateur en parties modulaires, de gérer la logique et la présentation des données, et de créer des interfaces utilisateur interactives et réutilisables.
   
      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/70b0b758-26dc-4f3e-9937-f50c2fa40db9">
      <img width="300" alt="application properties" src="https://github.com/Sohaib-jalil/JEE_final-project/assets/92445933/d216b4f6-2d1f-4656-9b6f-da54722824d3">


