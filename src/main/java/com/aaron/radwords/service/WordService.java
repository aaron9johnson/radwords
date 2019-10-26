package com.aaron.radwords.service;

import com.aaron.radwords.domain.Radword;
import com.aaron.radwords.repository.WordRepository;
import com.aaron.radwords.domain.TextCountResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
public class WordService {

    @Autowired
    private WordRepository wordRepository;

    public Radword getWordCount(String inWord) {
        String word = removePunctuationAndCase(inWord);
        Optional<Radword> optionalRadword = wordRepository.findById(word);
        if (optionalRadword.isPresent()) {
            return optionalRadword.get();
        }
        return new Radword(word, 0, null, null);
    }

    public Radword addWord(String inWord) {
        String word = removePunctuationAndCase(inWord); // already sanitized
        Optional<Radword> optionalRadword = wordRepository.findById(word);
        Radword radword;
        if (optionalRadword.isPresent()){
            radword = optionalRadword.get();
            radword.addOneCount();
            radword.setLastModified(Instant.now());
        } else {
            radword = new Radword(word, 1, Instant.now(), Instant.now());
        }
        wordRepository.save(radword);
        return radword;
    }

    private String removePunctuationAndCase(String text){
        return text.replaceAll("[^a-zA-Z ]", "").toLowerCase(); // .split("\\s+")[0];
    }
}
