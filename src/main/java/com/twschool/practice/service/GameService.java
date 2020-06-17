package com.twschool.practice.service;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
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
        if(getGuessNumberGame() != null){
            startGame();
        }
        List<String> userAnswer= Arrays.asList(userAnswerString.split(""));
        return guessNumberGame.guess(userAnswer);
    }

    public GuessNumberGame getGuessNumberGame() {
        return guessNumberGame;
    }

    public void startGame() {
        guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator());
    }



//    public ResultPlayingDTO guessByUserId(String userAnswerString, String userId) {
//        if(getGuessNumberGame() != null){
//            startGame();
//        }
//        return contineGame(userAnswerString, userId, playingGame);
//
//    }

    public void calculateScore(GuessNumberGame guessNumberGame, String userId) {
        //计算增量
        int score = 0;
        if(guessNumberGame.getStatus().equals(GameStatus.SUCCEED)) {
            int times = calculateWinTimes(userId);
            if(times >= 1 ){
                score += times;
                if(times >= 3){
                    score += 2;
                    if(times >= 5){
                        score += 1;
                    }
                }
            }
        }else if(guessNumberGame.getStatus().equals(GameStatus.FAILED)) {
            score = -3;
        }

    }

    private int calculateWinTimes(String userId) {
        return 0;
    }
}
