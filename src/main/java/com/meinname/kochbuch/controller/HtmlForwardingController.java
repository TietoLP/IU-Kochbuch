package com.meinname.kochbuch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlForwardingController {

    @GetMapping("/rezept/{id}")
    public String forwardRezept() {
        return "forward:/rezept.html"; // leitet auf die statische HTML-Datei weiter
    }
}
