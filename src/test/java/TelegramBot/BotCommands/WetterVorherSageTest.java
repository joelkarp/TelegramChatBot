package TelegramBot.BotCommands;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class WetterVorherSageTest {

	BotCommand wetterCommand = new WetterVorherSage();

	@Test
	public void executeTest() {
		assertNotNull(wetterCommand.execute());
		assertTrue(wetterCommand.execute().contains("Risiko"));
	}

}
