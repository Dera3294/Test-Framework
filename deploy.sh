#!/bin/bash

# Créer la structure si elle n'existe pas
mkdir -p WEB-INF/lib

# Copier le JAR depuis Framework
cp ../Framework/framework.jar WEB-INF/lib/

# Vérifier si le JAR a été copié
if [ ! -f "WEB-INF/lib/framework.jar" ]; then
    echo "Erreur : framework.jar introuvable"
    exit 1
fi

# Copier Test.xml en web.xml
cp Test.xml WEB-INF/web.xml

# Générer le WAR
jar cvf Test1.war .

# Déployer sur Tomcat
TOMCAT_WEBAPPS="/home/zed/apache-tomcat-10.1.28/webapps/"
cp Test1.war "$TOMCAT_WEBAPPS"

# Redémarrer Tomcat si nécessaire (optionnel)
# /home/zed/apache-tomcat-10.1.28/bin/shutdown.sh
# /home/zed/apache-tomcat-10.1.28/bin/startup.sh

echo "Génération de Test1.war et déploiement terminés."