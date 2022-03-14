package com.example.tictactoe;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

@SpringBootTest
class TicTacToeApplicationTests 
{
	public static void main(String[] args) 
	{
		Result result = JUnitCore.runClasses(GameUserServiceTest.class);
      
		for(Failure failure : result.getFailures()) 
		{
		   	System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());	
	}

	@Test
	void contextLoads() {
	}

}
