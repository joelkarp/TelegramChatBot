package TelegramBot.TelegramChatBot;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import TelegramBot.TelegramChatBot.TelegramBot;

public class TelegramBotTests {

	TelegramBot teleBot = new TelegramBot();

	@Test
	public void getBotTokenTest() {
		
		assertEquals("457679296:AAECBoRZxc9Co2dJOcJfZ0utwDa_rlB0ytY", teleBot.getBotToken());
	}

	@Test
	public void getBotUsernameTest() {
		System.out.println("Test getBotUsername");
		assertEquals("MyFirstKinoBot", teleBot.getBotUsername());
	}

}
