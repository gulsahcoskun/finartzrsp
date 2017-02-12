package com.finartz.logic;


public class RockStrategy implements RockScissorPaperStrategy{

	@Override
	public GameResult play(RockScissorPaperStrategy playerStrategy) {
		return playerStrategy.getResult(this);
	}

	@Override
	public GameResult getResult(PaperStrategy paperStrategy) {
		return GameResult.WON;
	}

	@Override
	public GameResult getResult(RockStrategy rockStrategy) {
		return GameResult.TIED;
	}

	@Override
	public GameResult getResult(ScissorStrategy scissorStrategy) {
		return GameResult.LOST;
	}
	
	
	

}
