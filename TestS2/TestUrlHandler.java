package tests2;

import framework.annotation.UrlHandler;

public class TestUrlHandler {
   public TestUrlHandler() {
   }

   @UrlHandler(
      url = "/accueil"
   )
   public void afficherAccueil() {
      System.out.println("Page d'accueil affichée");
   }

   @UrlHandler(
      url = "/contact"
   )
   public void afficherContact() {
      System.out.println("Page de contact affichée");
   }

   public void methodeNormale() {
      System.out.println("Ceci n'est pas une URL");
   }
}
