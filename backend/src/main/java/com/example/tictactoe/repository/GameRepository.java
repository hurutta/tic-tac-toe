package com.example.tictactoe.repository;

import com.example.tictactoe.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, String> 
{

    Game findByGameId(String gameId);
    
}
