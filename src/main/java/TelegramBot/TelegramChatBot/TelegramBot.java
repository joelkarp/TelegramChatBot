package TelegramBot.TelegramChatBot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import TelegramBot.BotCommands.ActivCommands;
import TelegramBot.BotCommands.CommandNotFoundException;
import TelegramBot.BotCommands.KinopolisKinoProgram;

public class TelegramBot extends TelegramLongPollingBot {

	private ActivCommands commandList;

	public TelegramBot() {
		commandList = new ActivCommands();
		initCommandList();
	}

	private void initCommandList() {
		commandList.addCommand("kinopolis", new KinopolisKinoProgram());
	}

	public String getBotUsername() {

		return "MyFirstKinoBot";

	}

	public void onUpdateReceived(Update update) {

		if (update.hasMessage() && update.getMessage().hasText()) {

			String message_text = update.getMessage().getText();
			final long chat_id = update.getMessage().getChatId();

			String answer = getCommandAnswer(message_text);
			sendMessage(answer, chat_id);

		} else {

			System.out.println("leere Nachicht erhalten");

		}

	}

	@Override
	public String getBotToken() {

		return "457679296:AAECBoRZxc9Co2dJOcJfZ0utwDa_rlB0ytY";

	}

	private String getCommandAnswer(String message_text) {
		try {
			return this.commandList.getCommand(message_text).execute();
		}
		catch(CommandNotFoundException e) {
			return "Befehl leider nicht erkannt";
		}
				
			
	}

	private void sendMessage(String content, long chatID) {

		SendMessage newMessage = new SendMessage().setChatId(chatID);
		newMessage.setText(content);

		try {
			execute(newMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}

	}
	


}
