package com.finartz.web;

import com.finartz.web.model.GameRequest;
import com.finartz.web.model.GameResponse;
import com.finartz.logic.GameLogic;
import com.finartz.logic.GameResult;
import com.finartz.logic.PaperStrategy;
import com.finartz.logic.RockScissorPaperStrategy;
import com.finartz.logic.RockStrategy;
import com.finartz.logic.ScissorStrategy;
import com.finartz.util.Util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * GameController
 */
@RestController
@RequestMapping("/game")
public class GameController implements ApplicationContextAware {

    private ApplicationContext applicationContext;

    @RequestMapping(value = "/play", method = RequestMethod.POST)
    public GameResponse play(@RequestBody GameRequest request) {

    	if(!Util.checkRequestParameters(request))
    		return Util.getErrorResponse();
    	if(!Util.checkPlayersMoves(request.getFirstPlayerMove()) || !Util.checkPlayersMoves(request.getSecondPlayerMove())){
    		return Util.getErrorResponse();
    	}
    	
    	GameLogic gameLogic = applicationContext.getBean(GameLogic.class);
    	
    	gameLogic.setStrategy(moveToStrategy(request.getFirstPlayerMove()));
    	GameResult gameResult = gameLogic.playGame(moveToStrategy(request.getSecondPlayerMove()));
    	
    	return evaluateGameResult(gameResult, request);
    
    }
    
   
    private GameResponse evaluateGameResult(GameResult result, GameRequest request){
    	GameResponse gameResponse = new GameResponse();
    	switch (result) {
    	case WON:
    		gameResponse.setFirstPlayerWins(true);
    		gameResponse.setSecondPlayerWins(false);
    		gameResponse.setMessage(request.getFirstPlayerName() + GameResult.WON.toString());
    		gameResponse.setWinner(request.getFirstPlayerName());
    		return gameResponse;
    	case LOST:
    		gameResponse.setFirstPlayerWins(false);
    		gameResponse.setSecondPlayerWins(true);
    		gameResponse.setMessage(request.getSecondPlayerName() + GameResult.WON.toString());
    		gameResponse.setWinner(request.getSecondPlayerName());
    		return gameResponse;
    	case TIED:
    		gameResponse.setFirstPlayerWins(false);
    		gameResponse.setSecondPlayerWins(false);
    		gameResponse.setMessage(request.getFirstPlayerName() + " and " + request.getSecondPlayerName() + GameResult.TIED.toString());
    		gameResponse.setWinner("");
    		return gameResponse;
		default:
			break;
		}
    	return gameResponse;
    }
    	 
    	 
    private RockScissorPaperStrategy moveToStrategy(String move){
    	if(move.equalsIgnoreCase("rock"))
    		return new RockStrategy();
    	else if(move.equalsIgnoreCase("paper"))
    		return new PaperStrategy();
    	else if(move.equalsIgnoreCase("scissors"))
    		return new ScissorStrategy();
    	else
    		throw new IllegalArgumentException();
    }
 
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }
    
}
