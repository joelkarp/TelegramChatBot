package TelegramBot.BotCommands;

import TelegramBot.TelegramChatBot.TelegramBot;

public class Regenvorhersage implements BotCommand {

	@Override
	public String execute() {

		BotCommand wettervorhersageCommand = new Wettervorhersage();
		String answer = wettervorhersageCommand.execute().split("\n")[2];
		
		TelegramBot.getBotLogger().info("Regenvorhersage abgerufen: " + answer);
		return answer;
	}

}
