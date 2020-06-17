package com.twschool.practice.api;

import com.twschool.practice.domain.Answer;
import com.twschool.practice.domain.GuessNumberGame;
import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.service.GameService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;

public class GameServiceTest {
    @Autowired
    RandomAnswerGenerator randomAnswerGenerator;
    @Test
    public void should_create_game_once_when_guess_incorrect_number_twice() {
        GameService gameService = Mockito.mock(GameService.class);
        RandomAnswerGenerator randomAnswerGenerator = Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(new Answer(Arrays.asList("1","2","3","4")));


        GuessNumberGame guessNumberGame = new GuessNumberGame(randomAnswerGenerator);
        Mockito.when(gameService.getGuessNumberGame()).thenReturn(guessNumberGame);
       // Mockito.when(gameService.guess(Mockito.any())).thenCallMethod();

        gameService.guess("1 2 3 5");
        gameService.guess("1 2 3 5");

        Mockito.verify(gameService,Mockito.times(1)).startGame();

    }


}
