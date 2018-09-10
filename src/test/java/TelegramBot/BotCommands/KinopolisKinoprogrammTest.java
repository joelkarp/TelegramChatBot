package TelegramBot.BotCommands;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class KinopolisKinoprogrammTest {

	BotCommand kinopolisCom = new KinopolisKinoprogramm();
	
	@Test
	public void KinopolisKinoProgramExecuteTest() {
		assertNotNull(kinopolisCom.execute());
	}
	
}
