package TelegramBot.BotCommands;

public class RegenVorherSage implements BotCommand{

	@Override
	public String execute() {
		
		BotCommand wetterVorhersageCommand = new WetterVorherSage();
		System.out.println(wetterVorhersageCommand.execute().split("\n")[2]);
		
		return wetterVorhersageCommand.execute().split("\n")[2];
	}

}
