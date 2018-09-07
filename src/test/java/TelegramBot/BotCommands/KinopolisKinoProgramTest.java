package TelegramBot.BotCommands;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class KinopolisKinoProgramTest {

	BotCommand kinopolisCom = new KinopolisKinoProgram();
	
	@Test
	public void KinopolisKinoProgramExecuteTest() {
		assertNull(kinopolisCom.execute());
	}
	
}
