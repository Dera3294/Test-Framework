package sprint2bis;

import framework.controllers.Controller;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        Class<?>[] classes = {Tes1.class, Tes2.class, Tes.class};

        System.out.println("=== Classes avec @Controller ===");
        for (Class<?> cls : classes) {
            if (cls.isAnnotationPresent(Controller.class)) {

                Controller annotation = cls.getAnnotation(Controller.class);
                System.out.println(annotation.value());
                System.out.println("Classe : " + cls.getSimpleName());
                System.out.println("Package : " + cls.getPackageName());
                System.out.println("Méthodes :");
                for (Method m : cls.getDeclaredMethods()) {
                    System.out.println("  - " + m.getName());
                }
                System.out.println("--------------------------------------------------");
            }
        }

        System.out.println("=== Classes sans @Controller ===");
        for (Class<?> cls : classes) {
            if (!cls.isAnnotationPresent(Controller.class)) {
                System.out.println("Classe : " + cls.getSimpleName());
                System.out.println("Package : " + cls.getPackageName());
                for (Method m : cls.getDeclaredMethods()) {
                    System.out.println("  - " + m.getName());
                }
                System.out.println();
            }
        }
    }
}
