package testsprint3;

import framework.controllers.Controller;
import framework.annotation.UrlHandler;

@Controller("Contrôleur d'exemple Sprint 3")
public class SampleController {

    @UrlHandler(url = "/hello")
    public String hello() {
        return "Hello from SampleController";
    }

    @UrlHandler(url = "/ping")
    public String ping() {
        return "pong";
    }
}


