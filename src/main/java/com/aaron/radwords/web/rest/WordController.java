package com.aaron.radwords.web.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WordController {

//    @Autowired
//    private WordService wordService;

    @GetMapping("/home")
    public String home() {
        return "radwords";
    }
}
