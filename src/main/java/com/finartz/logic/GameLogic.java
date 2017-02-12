package com.finartz.logic;

import org.springframework.stereotype.Service;


/**
 * GameLogic
 */
@Service
public class GameLogic {

private RockScissorPaperStrategy strategy;

	
	public void setStrategy(RockScissorPaperStrategy strategy) {
		this.strategy = strategy;
	}
	
	public RockScissorPaperStrategy getStrategy() {
		return strategy;
	}

	public GameResult playGame(RockScissorPaperStrategy secondPlayerStrategy) {
	    return strategy.play(secondPlayerStrategy);
	  }



}
