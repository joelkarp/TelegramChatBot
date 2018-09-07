package TelegramBot.BotCommands;

import java.util.HashMap;

public class ActivCommands {

	private HashMap<String, BotCommand> commands;

	public ActivCommands() {
		commands = new HashMap<String, BotCommand>();
	}

	public void addCommand(String key, BotCommand newCommand) {

		commands.put(key, newCommand);

	}

	public void removeCommand(String key) {

		commands.remove(key);

	}

	public BotCommand getCommand(String key) {
		return commands.get(key);
	}

	public int getCommandCount() {
		return commands.size();
	}
}
