package TelegramBot.scheduleBotCommanTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import TelegramBot.BotCommands.BotCommand;
import TelegramBot.scheduledBotCommands.ScheduledRegenVorherSage;

public class ScheduledRegenVorherSageTest {

	BotCommand wetterCommand = new ScheduledRegenVorherSage();

	@Test
	public void executeTest() {
		assertNotNull(wetterCommand.execute());
		assertFalse(wetterCommand.execute().contains("%"));
	}
}
