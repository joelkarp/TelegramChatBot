package TelegramBot.BotCommandsTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.Regenvorhersage;

public class RegenvorhersageTest {

	BotCommand wetterCommand = new Regenvorhersage();

	@Test
	public void executeTest() {
		
		assertNotNull(wetterCommand.execute());
		assertTrue(wetterCommand.execute().contains("Risiko"));
	
	}

}
