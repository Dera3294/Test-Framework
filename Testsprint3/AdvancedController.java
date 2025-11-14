package testsprint3;

import framework.controllers.Controller;
import framework.annotation.UrlHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import framework.scanner.ModelView;

@Controller("Contrôleur avancé Sprint 3")
public class AdvancedController {

    @UrlHandler(url = "/time")
    public String time(HttpServletRequest request) {
        return String.valueOf(System.currentTimeMillis());
    }

    @UrlHandler(url = "/write")
    public ModelView write(){
        return new ModelView("a.jsp");
    }
}


