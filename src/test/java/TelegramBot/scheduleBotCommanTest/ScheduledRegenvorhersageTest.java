package TelegramBot.scheduleBotCommanTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import TelegramBot.BotCommands.BotCommand;
import TelegramBot.scheduledBotCommands.ScheduledRegenvorhersage;

public class ScheduledRegenvorhersageTest {


	@Test
	public void executeTest() {
		BotCommand wetterCommand = new ScheduledRegenvorhersage();
		
		assertNotNull(wetterCommand.execute());
		assertFalse(wetterCommand.execute().contains("%"));
	}
}
