package TelegramBot.TelegramChatBot;

import java.util.Timer;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import TelegramBot.BotCommands.ActivCommands;
import TelegramBot.BotCommands.CommandNotFoundException;
import TelegramBot.BotCommands.KinopolisKinoprogramm;

import TelegramBot.BotCommands.Regenvorhersage;
import TelegramBot.BotCommands.Wettervorhersage;
import TelegramBot.scheduledBotCommands.ScheduledRegenvorhersage;
import TelegramBot.scheduledBotCommands.TimerTaskFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TelegramBot extends TelegramLongPollingBot {

	private ActivCommands commandList;
	private final static Logger logger = LoggerFactory.getLogger(TelegramBot.class);

	public TelegramBot() {

		logger.info("Bot started!");
		
		commandList = new ActivCommands();
		initCommandList();
		initScheduledCommands();
	}

	private void initCommandList() {

		commandList.addCommand("kinopolis", new KinopolisKinoprogramm());
		commandList.addCommand("wetter", new Wettervorhersage());
		commandList.addCommand("regnen", new Regenvorhersage());

	}

	private void initScheduledCommands() {

		new Timer().schedule(TimerTaskFactory.getTimerTaskInstanze("kinopolis", this), 00, TimerTaskFactory.PERWEEK);
		new Timer().schedule(TimerTaskFactory.getTimerTaskInstanze(new ScheduledRegenvorhersage(), this), 00, TimerTaskFactory.PERHOUR);

		
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

			System.out.println("leere Nachricht erhalten");

		}

	}

	@Override
	public String getBotToken() {

		return "457679296:AAECBoRZxc9Co2dJOcJfZ0utwDa_rlB0ytY";

	}

	private String getCommandAnswer(String message_text) {

		try {
			return this.commandList.getCommand(message_text).execute();
		} catch (CommandNotFoundException e) {
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

	public final ActivCommands getCommandList() {
		return commandList;
	}

	public static final Logger getBotLogger() {
		return logger;
	}

	
}
