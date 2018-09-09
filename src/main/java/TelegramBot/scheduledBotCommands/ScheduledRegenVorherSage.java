package TelegramBot.scheduledBotCommands;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.WetterVorherSage;

public class ScheduledRegenVorherSage implements BotCommand{

	@Override
	public String execute() {
		
		
		BotCommand wetterVorhersageCommand = new WetterVorherSage();
		String vorhersage = wetterVorhersageCommand.execute().split("\n")[2];
		
		if(getRegenRisikoInProzent( vorhersage)>40)
			return wetterVorhersageCommand.execute().split("\n")[2];
		
		return "";
	}
	private int getRegenRisikoInProzent(String procent) {
		procent = procent.split(" ")[1];
		return Integer.parseInt(procent.substring(0, procent.length()-1));
	
	}

}
