package testsprint3;

import framework.controllers.Controller;
import framework.annotation.UrlHandler;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("Contrôleur avancé Sprint 3")
public class AdvancedController {

    @UrlHandler(url = "/time")
    public String time(HttpServletRequest request) {
        return String.valueOf(System.currentTimeMillis());
    }

    @UrlHandler(url = "/write")
    public void write(HttpServletResponse response) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        response.getWriter().println("Direct write from AdvancedController");
    }
}


