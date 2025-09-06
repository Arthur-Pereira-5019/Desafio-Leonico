package com.art5019.desafio_leonico;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    Logger logger = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/")
    public String mainPage() {
        logger.info("Atempted");
        return "mainPage";
    }
}
