package sprint2bis;

import framework.controllers.Controller;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            String basePackage = "sprint2bis"; //Le package à scanner
            List<Class<?>> allClasses = getAllClasses(basePackage); // Récupération de toutes les classes

            //Partie 1 : afficher les classes qui ont @Controller
            System.out.println("=== Classes avec @Controller ===");
            for (Class<?> cls : allClasses) {
                if (cls.isAnnotationPresent(Controller.class)) {
                    System.out.println("Classe : " + cls.getSimpleName());
                    System.out.println("Package : " + cls.getPackageName());
                    System.out.println("Méthodes :");
                    for (Method m : cls.getDeclaredMethods()) {
                        System.out.println("  - " + m.getName());
                    }
                    System.out.println();
                }
            }

            // Partie 2 : afficher les classes qui n'ont PAS @Controller
            System.out.println("=== Classes sans @Controller ===");
            for (Class<?> cls : allClasses) {
                if (!cls.isAnnotationPresent(Controller.class)) {
                    System.out.println("Classe : " + cls.getSimpleName());
                    System.out.println("Package : " + cls.getPackageName());
                    System.out.println();
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode qui récupère toutes les classes d’un package donné (ici "test")
     */
    private static List<Class<?>> getAllClasses(String basePackage) throws Exception {
        List<Class<?>> classes = new ArrayList<>();

        // Transforme le nom du package ("test") en chemin de dossier ("test/")
        String path = basePackage.replace('.', '/');

        // Le dossier à explorer
        File baseDir = new File(path);

        if (!baseDir.exists()) {
            System.err.println("⚠️ Dossier introuvable : " + baseDir.getAbsolutePath());
            return classes;
        }

        // Appel récursif pour parcourir tous les fichiers du package
        findClasses(baseDir, basePackage, classes);
        return classes;
    }

    /**
     * Recherche récursive des classes .class dans un dossier
     */
    private static void findClasses(File directory, String packageName, List<Class<?>> classes) {
        File[] files = directory.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isDirectory()) {
                // Si on tombe sur un sous-dossier, on continue à chercher à l’intérieur
                String newPackage = packageName + "." + file.getName();
                findClasses(file, newPackage, classes);
            } else if (file.getName().endsWith(".class")) {
                // Si c’est un fichier .class → on essaye de le charger
                String className = file.getName().substring(0, file.getName().length() - 6);
                try {
                    String fullName = packageName + "." + className;
                    Class<?> cls = Class.forName(fullName); // Chargement dynamique
                    classes.add(cls);
                } catch (Throwable ignored) {
                    // On ignore les erreurs (par ex. classes internes ou invalides)
                }
            }
        }
    }
}
