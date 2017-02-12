package com.finartz.logic;

public enum GameResult {
	
	WON(" won the game!"),
	LOST(" lost the game!"),
	TIED(" made the same move!");
	
	private String result;
	
	private GameResult(String result){
		this.result = result;
	}
	
	 public String toString(){
	        return result;
	 }
}
