package testsprint3;

//import framework.controllers.Controller;
import framework.annotation.UrlHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Controller("Contrôleur avancé Sprint 3")
public class Test1 {

    @UrlHandler(url = "/dera")
    public String time(HttpServletRequest request) {
        return String.valueOf(System.currentTimeMillis());
    }

}