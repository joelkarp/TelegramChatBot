package TelegramBot.TelegramChatBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class TelegramBot extends TelegramLongPollingBot {

	
	public String getBotUsername() {

		return "MyFirstKinoBot";

	}

	
	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {
			
			System.out.println("nachicht erhalten");
			
		} else {
			
			System.out.println("leere Nachicht erhalten");
		
		}
		
	}

	@Override
	public String getBotToken() {

		return "457679296:AAECBoRZxc9Co2dJOcJfZ0utwDa_rlB0ytY";

	}

}
