package com.aaron.radwords.web.rest;

import com.aaron.radwords.domain.Radword;
import com.aaron.radwords.service.WordService;
import com.aaron.radwords.domain.TextCountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class WordController {

    @Autowired
    private WordService wordService;

    @GetMapping("/home")
    public String home() {
        return "radwords";
    }

    @GetMapping("/word/count/{inWord}")
    public Radword getWordCount(@PathVariable String inWord) {
        return wordService.getWordCount(inWord);
    }
}
