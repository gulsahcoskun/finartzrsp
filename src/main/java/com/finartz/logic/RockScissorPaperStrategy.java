package com.finartz.logic;


public interface RockScissorPaperStrategy {
	
	public GameResult play(RockScissorPaperStrategy playerStrategy);
	
	public GameResult getResult(PaperStrategy paperStrategy);
	
	public GameResult getResult(RockStrategy rockStrategy);
	
	public GameResult getResult(ScissorStrategy scissorStrategy);

}
