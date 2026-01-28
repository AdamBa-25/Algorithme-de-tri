# Visualiseur d'algorithme de tri

Visualisation simple des principaux algorithmes de tri directement dans le terminal.

---

##  Présentation du projet

Ce projet a pour objectif devisualiser le fonctionnement des algorithmes de tri.  
Chaque valeur du tableau est représentée par une colonne de blocs (`■`) dont la hauteur correspond à sa valeur.

L’utilisateur peut :
- choisir la taille du tableau (entre 3 et 20),
- Sélectionner un algorithme de tri,
- observer étape par étape le déroulement du tri dans le terminal.

Ce projet est particulièrement intéressant pour les personnes comme moi qui ne comprennent pas les fonctionnement des algorithmes de tri car ce programme permet une visualisation claire de ceux-ci.

---

## Langage et outils utilisés

- Langage : Java
- Librairies utilisées :
  - `java.util.Random`
  - `java.util.Scanner`
  - `java.lang.Thread`

---

## Algorithmes de tri implémentés

- Tri par sélection
- Tri par insertion
- Tri à bulles
- Tri rapide (QuickSort)

---

## Comment lancer le programme

Se mettre dans un terminal dans l'emplacement où le projet est téléchargé et exécuter les commandes suivantes :

```bash
javac tri.java
java tri -encoding utf-8
