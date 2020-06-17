package com.twschool.practice.controller;

import com.twschool.practice.domain.RandomAnswerGenerator;
import com.twschool.practice.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

public class GameController {
    @Autowired
    private GameService gameService;
    @Autowired
    RandomAnswerGenerator randomAnswerGenerator;
    private Logger logger = LoggerFactory.getLogger(GameController.class);

    @GetMapping("/game")
    public Map<String, String> guess(@RequestParam String guess) {
        Map<String, String> map = new HashMap<>();
        String result = gameService.guess(guess);
        map.put("input", guess);
        map.put("output", result);
        return map;
    }
}
