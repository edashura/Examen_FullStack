# Examen_FullStack
BackEnd
Concernant la possibilité de modifier une image d'illustration, avez-vous fait une route dédiée au fait de remplacer la photo ou bien considérez-vous qu'il faille simplement appeler la route de suppression puis la route d'ajout ?
Il est préférable d'avoir une route dédiée au remplacement de la photo d'illustration. Cela permet une gestion plus simple et évite des opérations séparées de suppression et d'ajout.

Concernant le stockage des images, est-il préférable de mettre d'avoir une seule table contenant tous les IDs de toutes les images (et faire une jointure systématique donc) ou bien vaut-il mieux mettre l'ID de la photo d'illustration dans la table restaurant et ne pas mettre d'ID en DB pour l'image d'illustration d'un restaurant ?
Il est préférable de stocker l'ID de la photo d'illustration directement dans la table du restaurant. Cela simplifie les requêtes en évitant des jointures systématiques.

Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner la photo systématiquement (via un lien bien sûr) ?
Tout dépend de comment on veut gérer les ressources, la gestion du trafic réseau..

Lorsque vous retournez un restaurant, est-ce une bonne idée de retourner l'évaluation finale systématiquement ?
Oui ça évite de devoir refaire une autre requete, et ça reste une des informations les plus importantes.

Expliquez l'implémentation que vous avez fait des tags (quelles solutions avez-vous envisagées et pourquoi avoir retenu la vôtre en particulier)
Pas fait



