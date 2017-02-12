package com.finartz.logic;

public class PaperStrategy implements RockScissorPaperStrategy{

	@Override
	public GameResult play(RockScissorPaperStrategy playerStrategy) {
		return playerStrategy.getResult(this);
	}

	@Override
	public GameResult getResult(PaperStrategy paperStrategy) {
		return GameResult.TIED;
	}

	@Override
	public GameResult getResult(RockStrategy rockStrategy) {
		return GameResult.LOST;
	}

	@Override
	public GameResult getResult(ScissorStrategy scissorStrategy) {
		return GameResult.WON;
	}

}
