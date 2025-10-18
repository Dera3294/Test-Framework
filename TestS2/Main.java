package tests2;

import framework.annotation.UrlHandler;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        // Obtenir la classe de test
        Class<TestUrlHandler> classeTest = TestUrlHandler.class;

        // Parcourir toutes les méthodes de la classe
        for (Method methode : classeTest.getDeclaredMethods()) {

            // Vérifier si la méthode possède l'annotation UrlHandler
            if (methode.isAnnotationPresent(UrlHandler.class)) {
                // Récupérer l'annotation
                UrlHandler annotation = methode.getAnnotation(UrlHandler.class);

                // Afficher le nom de la méthode et l'URL associée
                System.out.println("Méthode : " + methode.getName());
                System.out.println("→ URL associée : " + annotation.url());
                System.out.println("----------------------------------");
            }
        }
    }
}
