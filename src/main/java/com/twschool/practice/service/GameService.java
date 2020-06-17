package com.twschool.practice.service;

import com.twschool.practice.domain.GameStatus;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

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


    public void calculateScore(GuessNumberGame guessNumberGame, String userId) {
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
        int countUser = 0;
        List<User> userList = new ArrayList<User>();
        //从数据库中查询用户保留了几条数据添加到userList中
        for (User user : userList){
            if(user.getStatus().equals("SUCCESS")){
                countUser++;
            }
        }
        return countUser;
    }
}
