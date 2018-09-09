package TelegramBot.scheduledBotCommands;

import TelegramBot.BotCommands.BotCommand;
import TelegramBot.BotCommands.RegenVorherSage;

public class ScheduledRegenVorherSage implements BotCommand{

	@Override
	public String execute() {
		
		BotCommand regenVorhersage = new RegenVorherSage();
		
		
		return  ""+getRainRiskInPercent(regenVorhersage.execute());
	}
	private int getRainRiskInPercent(String vorhersage) {
		String wahrscheinlichkeit = vorhersage.split(" ")[1];
		wahrscheinlichkeit = wahrscheinlichkeit.substring(0, wahrscheinlichkeit.length()-1);
		return Integer.parseInt(wahrscheinlichkeit);
	}

}
