package TelegramBot.BotCommands;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RegenvorhersageTest {

	BotCommand wetterCommand = new Regenvorhersage();

	@Test
	public void executeTest() {
		
		assertNotNull(wetterCommand.execute());
		assertTrue(wetterCommand.execute().contains("Risiko"));
	
	}

}
