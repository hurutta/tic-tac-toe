package com.example.tictactoe.controller;

import java.util.List;

import com.example.tictactoe.model.Game;
import com.example.tictactoe.model.PlayerImage;
import com.example.tictactoe.model.Query;
import com.example.tictactoe.service.AwsService;
import com.example.tictactoe.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.awt.*;
import java.util.List;
import static java.net.HttpURLConnection.HTTP_OK;

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

    @Autowired
    public AwsService awsService;

    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file[]) {
        try
        {
            String file1Name = awsService.saveFile(file[0]);
            String file2Name = awsService.saveFile(file[1]);
            gameService.saveFileName(file1Name);
            gameService.saveFileName(file2Name);

            return "Upload Sucessful";
        }catch(Exception e)
        {
            return "File not found";
        }
    }

    @GetMapping(value = "/playerImageList")
    public List<PlayerImage> getAllFileName() 
    {
        return gameService.getAllFileName();
    }

    @GetMapping("download/{filename}")
    public ResponseEntity<byte[]> download(@PathVariable("filename") String filename) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-type", MediaType.ALL_VALUE);
        headers.add("Content-Disposition", "attachment; filename=" + filename);
        byte[] bytes = awsService.downloadFile(filename);
        return ResponseEntity.status(HTTP_OK).headers(headers).body(bytes);
    }
}