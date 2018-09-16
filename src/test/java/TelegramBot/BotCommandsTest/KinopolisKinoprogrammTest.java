package TelegramBot.BotCommandsTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.KinopolisKinoprogramm;

public class KinopolisKinoprogrammTest {

	BotCommand kinopolisCom = new KinopolisKinoprogramm();
	
	@Test
	public void testKinopolisKinoProgramExecute() {
		assertNotNull(kinopolisCom.execute());
	}
	
}
