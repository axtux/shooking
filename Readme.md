# AutoChef : Projet de génie logiciel et gestion de projet (INFO-F-307)

L'objectif principal du projet est de concevoir un environnement pour la création d'une carte partagée entre plusieurs utilisateurs du système. Ce logiciel permettra de créer
une nouvelle carte en deux dimensions vide ou bien de se connecter à une carte existante.
Sur cette carte, le logiciel permettra d'ajouter des nouvelles informations ou de modifier
la réputation des informations existantes.

# Utilisation
L'utilisation complète et détailée se trouve [ici](team/usage.md) 

## Prérequis
- Java 1.8+
- Maven

## Librairies utilisées
Ces librairies seront téléchargées et installées automatiquement par Maven. Aucune action n'est nécessaire.

- Eclipselink 2.6.5
- H2 Database 1.4.197
- JUnit 4.12
- JavaFX 3.1.7
- GMapsFx 2.12.0
- Apache Common Lang 3.7

## Eclipse
Le projet peut être importé dans Eclipse en tant que projet Maven. Attention, plusieurs modifications majeures ont eu lieu durant le développement. En cas de problème :
1. Supprimer le projet dans Eclipse
1. Recloner le dépôt
1. Ré-importer le projet dans Eclipse

## Ligne commande
`Makefile` + `make.bat` = :heart:

Les commandes ci-dessous sont disponibles sur Windows, MacOS et Linux.

Si vous êtes sur Windows, assurez-vous d'avoir ajouté Maven dans votre environnement https://crunchify.com/how-to-setupinstall-maven-classpath-variable-on-windows-7/

### Compilation
```
make jar
```

### Exécution
Nécessite d'avoir compilé
```
make run
```

Des données de démonstrations peuvent être ajoutées avec cette commande. Attention, ceci supprimera l'ensemble des données existantes.
```
make preview
```

### Tests
```
make test
```

### Javadoc
```
make doc
```


# Configuration :

## Serveur 

Pas de serveur

## Client

Pas de client

# Misc

## Développement

## Screenshot

## Licence
