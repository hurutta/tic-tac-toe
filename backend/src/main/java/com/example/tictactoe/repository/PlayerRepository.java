package com.example.tictactoe.repository;

import com.example.tictactoe.model.PlayerImage;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends MongoRepository<PlayerImage, String> {

}
