package TelegramBot.BotCommands;

import org.junit.jupiter.api.Test;

public class WetterVorherSageTest {

	BotCommand wetterCommand = new WetterVorherSage();
	
	@Test
	public void executeTest() {
		System.out.println(wetterCommand.execute() );
	}
	
}
