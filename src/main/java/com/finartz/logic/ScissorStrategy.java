package com.finartz.logic;


public class ScissorStrategy implements RockScissorPaperStrategy{

	@Override
	public GameResult play(RockScissorPaperStrategy playerStrategy) {
		return playerStrategy.getResult(this);
	}

	@Override
	public GameResult getResult(PaperStrategy paperStrategy) {
		return GameResult.LOST;
	}

	@Override
	public GameResult getResult(RockStrategy rockStrategy) {
		return GameResult.WON;
	}

	@Override
	public GameResult getResult(ScissorStrategy scissorStrategy) {
		return GameResult.TIED;
	}
	
}
