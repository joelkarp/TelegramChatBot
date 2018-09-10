package TelegramBot.scheduledBotCommands;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.Wettervorhersage;

public class ScheduledRegenvorhersage implements BotCommand{

	@Override
	public String execute() {
		
		
		BotCommand wetterVorhersageCommand = new Wettervorhersage();
		
		String vorhersage = wetterVorhersageCommand.execute().split("\n")[2];
		
		if(getRainRiskInPercent( vorhersage)>40)
			return wetterVorhersageCommand.execute().split("\n")[2];
		
		return "";
	}
	private int getRainRiskInPercent(String percent) {
		
		percent = percent.split(" ")[1];
		return Integer.parseInt(percent.substring(0, percent.length()-1));
	
	}

}
