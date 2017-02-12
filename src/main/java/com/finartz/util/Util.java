package com.finartz.util;

import com.finartz.web.model.GameRequest;
import com.finartz.web.model.GameResponse;

public class Util {

	public static GameResponse getErrorResponse(){
    	GameResponse gameResponse = new GameResponse();
    	gameResponse.setFirstPlayerWins(false);
		gameResponse.setSecondPlayerWins(false);
		gameResponse.setMessage("Please check your input!");
		gameResponse.setWinner("");
		return gameResponse;
    }
    
    public static boolean empty( final String s ) {
  	  return s == null || s.trim().isEmpty();
  	}
    
    public static boolean checkRequestParameters(GameRequest request){
    	if(empty(request.getFirstPlayerMove()) || empty(request.getSecondPlayerMove()) || 
    			empty(request.getFirstPlayerName()) || empty(request.getSecondPlayerName())){
    		return false;
    	}
    	return true;
    }
    
    public static boolean checkPlayersMoves(String move){
    	if(move.equalsIgnoreCase("rock") || move.equalsIgnoreCase("scissors") || move.equalsIgnoreCase("paper")){
    		return true;
    	}
    	return false;
    }
}
