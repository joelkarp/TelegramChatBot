package TelegramBot.scheduledBotCommands;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.Wettervorhersage;

public class ScheduledRegenvorhersage implements BotCommand{

	@Override
	public String execute() {
		
		
		BotCommand wettervorhersageCommand = new Wettervorhersage();
		
		String vorhersage = wettervorhersageCommand.execute().split("\n")[2];
		
		if(getRainRiskInPercent( vorhersage)>40)
			return wettervorhersageCommand.execute().split("\n")[2];
		
		return "";
	}
	private int getRainRiskInPercent(String percent) {
		
		percent = percent.split(" ")[1];
		return Integer.parseInt(percent.substring(0, percent.length()-1));
	
	}

}
