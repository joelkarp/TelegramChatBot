package TelegramBot.BotCommands;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class RegenVohersageTest {

	BotCommand wetterCommand = new RegenVorherSage();

	@Test
	public void executeTest() {
		assertNull(wetterCommand.execute());
		assertTrue(wetterCommand.execute().contains("Risiko"));
	}

}
