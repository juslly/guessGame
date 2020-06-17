package com.twschool.practice.service;

import com.twschool.practice.domain.GuessNumberGame;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

public class GameService {
    @Autowired
    private  GuessNumberGame guessNumberGame;
    public GameService(GuessNumberGame guessNumberGame){
        this.guessNumberGame=guessNumberGame;
    }

    public String guess(String userAnswerString){
        List<String> userAnswer= Arrays.asList(userAnswerString.split(""));
        return guessNumberGame.guess(userAnswer);
    }


}
