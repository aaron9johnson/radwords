package com.aaron.radwords.domain;

import com.aaron.radwords.domain.Radword;

import java.util.ArrayList;

public class TextCountResponse {
    private ArrayList<Radword> words;

    public TextCountResponse(){
        this.words = new ArrayList<>();
    }

    public ArrayList<Radword> getWords() {
        return words;
    }

    public void setWords(ArrayList<Radword> words) {
        this.words = words;
    }

//    public void addWord(Radword radword){
//        words.add(radword);
//    }

    public void addWord(Radword word){
        for (int i = 0; i < words.size(); i++) {
            if(words.get(i).getWord().equals(word.getWord())) {
                words.set(i, word);
                return;
            }
        }
        words.add(word);
    }
}
