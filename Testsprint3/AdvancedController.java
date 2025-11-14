package testsprint3;

import framework.controllers.Controller;
import framework.annotation.UrlHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

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

    @UrlHandler(url = "/liste")
    public ModelView getListe() {
        ModelView mv = new ModelView("liste.jsp");
        mv.addItem("nom", "Dera");
        mv.addItem("notes", List.of(15, 17, 19));
        return mv;
    }
}


