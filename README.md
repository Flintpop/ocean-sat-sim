# Ocean Sat Sim


## Lancement du projet

Il faut lancer le main WindowController.java dans src/app

## Présentation du scénario

Une entreprise spécialisée dans l'étude des océans organise des campagnes de mesure de caractéristiques physiques comme la température, les courants, la luminosité et la composition du milieu marin. Pour cela, un ensemble de balises autonomes sont larguées dans les zones à étudier.

Une fois lancée, une balise effectue le cycle suivant :
- **Etape d'enregistrement**: la balise plonge et se déplace dans l'eau ; elle effectue des mesures et les enregistre
- **Etape de remontée et de synchronisation**: la balise remonte en surface et se place en attente de synchronisation avec un satellite

## Les éléments mobiles

La simulation met en œuvre des éléments mobiles : des balises et des satellites.

Les satellites se déplacent autour de la terre, toujours dans le même sens. Leur vitesse de déplacement est variable et certains peuvent être géostationnaires.

Les balises se déplacent dans le milieu. Le déplacement est variable. Dans un premier temps, sa nature est décidée lors de la programmation de la balise à terre. Par exemple, un déplacement peut être horizontal, vertical ou bien sinusoïdal. La balise peut aussi rester immobile à une certaine profondeur.

## Etape de collecte

Le rôle d'une balise est de collecter des données dans le milieu marin. L'étape de collecte consiste pour la balise à enregistrer des données et les stocker dans sa mémoire. Lorsque sa mémoire est pleine, elle entame une procédure d'émission de ses données vers un satellite pour pouvoir reprendre la collecte.

## Etape de synchronisation

Pour vider sa mémoire, une balise remonte à la surface. Elle attend le passage d'un satellite disponible avec lequel elle est en mesure de se synchroniser. Etre en mesure de se synchroniser signifie que le satellite est disponible et qu'il se situe au dessus de la balise.

Lorsque la balise et un satellite sont synchronisés, la balise envoie les données au satellite. Quand toutes les données sont transférées, la balise repasse à l'étape de collecte.

## Explication du technique

Le projet est réalisé en Java avec l'IDE IntelliJ IDEA. Il utilise la bibliothèque NiEllipse pour la visualisation graphique.

Le projet est structuré en packages :
- **annoucer** : contient les classes pour la synchronisation entre les views et les models
- **command** : contient les classes pour les commandes
  - Pas implémenté
- **controller** : contient les classes pour les contrôleurs
- **model** : contient les classes pour les modèles
  - Contient les données de la simulation
- **view** : contient les classes pour les vues
  - Les vues sont les éléments graphiques de la simulation
- **strategy** : contient les classes pour les stratégies
  - Définie le comportement de déplacement des balises et des satellites
- **state** : contient les classes pour les états
  - Changement des état en fonction des actions de la balise et du satellite
- **observer** : contient les classes pour les observateurs
    -Implémenté avec le pattern Announcer et des events
- **factory** : contient les classes pour les factories
  - Il existe des factories pour les balises, les satellites et les cercles



