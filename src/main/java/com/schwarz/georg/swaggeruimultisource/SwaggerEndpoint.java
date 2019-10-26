package com.schwarz.georg.swaggeruimultisource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SwaggerEndpoint {

    @GetMapping(path = "/")
    String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
