package TelegramBot.scheduledBotCommands;

import java.util.TimerTask;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import TelegramBot.BotCommands.CommandNotFoundException;
import TelegramBot.TelegramChatBot.TelegramBot;

public class TimerTaskFactory {
	
	public static final int PERSECOND = 1000;
	public static final int PERMINUTE = 60000;
	public static final int PERHOURE = 3600000;
	public static final int PERDAY = 86400000;
	public static final int PERWEEK = 604800000;

	public static TimerTask getTimerTaskInstanze(String command, TelegramBot bot) {
		return new TimerTask() {

			private final String chatId = "579358021";

			@Override
			public void run() {

				String antwort;
				try {
					antwort = bot.getCommandList().getCommand(command).execute();

					SendMessage message = new SendMessage();
					message.setChatId(this.chatId);
					message.setText(antwort);

					bot.execute(message);

				} catch (CommandNotFoundException | TelegramApiException e1) {

					e1.printStackTrace();
				}

			}

		};
	}

}
