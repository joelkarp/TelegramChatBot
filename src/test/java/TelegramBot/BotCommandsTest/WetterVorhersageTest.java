package TelegramBot.BotCommandsTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.Wettervorhersage;

public class WetterVorhersageTest {

	BotCommand wetterCommand = new Wettervorhersage();

	@Test
	public void testExecute() {
		assertNotNull(wetterCommand.execute());
		assertTrue(wetterCommand.execute().contains("Risiko"));
	}

}
