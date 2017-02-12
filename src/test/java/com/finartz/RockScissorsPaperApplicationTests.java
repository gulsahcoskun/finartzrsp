package com.finartz;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.finartz.logic.GameResult;
import com.finartz.logic.PaperStrategy;
import com.finartz.logic.RockStrategy;
import com.finartz.logic.ScissorStrategy;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RockScissorsPaperApplicationTests {

	@Test
	public void rockTest() {
		assertEquals(new RockStrategy().play(new ScissorStrategy()), GameResult.WON);
		assertEquals(new RockStrategy().play(new PaperStrategy()), GameResult.LOST);
		assertEquals(new RockStrategy().play(new RockStrategy()), GameResult.TIED);
	}

	@Test
	public void paperTest() {
		assertEquals(new PaperStrategy().play(new RockStrategy()), GameResult.WON);
		assertEquals(new PaperStrategy().play(new ScissorStrategy()), GameResult.LOST);
		assertEquals(new PaperStrategy().play(new PaperStrategy()), GameResult.TIED);
	}

	@Test
	public void scissorsTest() {
		assertEquals(new ScissorStrategy().play(new PaperStrategy()), GameResult.WON);
		assertEquals(new ScissorStrategy().play(new ScissorStrategy()), GameResult.TIED);
		assertEquals(new ScissorStrategy().play(new RockStrategy()), GameResult.LOST);
	}

}
