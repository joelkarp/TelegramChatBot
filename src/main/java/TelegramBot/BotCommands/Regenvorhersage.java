package TelegramBot.BotCommands;

public class Regenvorhersage implements BotCommand {

	@Override
	public String execute() {

		BotCommand wettervorhersageCommand = new Wettervorhersage();
		System.out.println(wettervorhersageCommand.execute().split("\n")[2]);

		return wettervorhersageCommand.execute().split("\n")[2];
	}

}
