package com.example.tictactoe.controller;

import java.util.List;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.Query;
import com.example.tictactoe.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:3000/")
@RestController
public class GameController
{

    @Autowired
    public GameService gameService;

    @PostMapping(value = "/validate")
    public String validateGame(@RequestBody Query query) 
    {
        return gameService.validateGame(query);
    }

    @GetMapping(value = "/history")
    public List<Game> getAllGame() 
    {
        return gameService.getAllGame();
    }

}