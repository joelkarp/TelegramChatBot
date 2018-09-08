package TelegramBot.BotCommands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

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

	public BotCommand getCommand(String key) throws CommandNotFoundException {

		key = surchForKey(key);
		return commands.get(key);

	}

	public int getCommandCount() {
		return commands.size();
	}

	private String surchForKey(String message) throws CommandNotFoundException {

		Stream<String> messageAsStream = Arrays.asList(message.toLowerCase().split(" ")).stream();
		String[] antwort = messageAsStream.filter(word -> commands.containsKey(word)).toArray(String[]::new);
		
		Arrays.asList(antwort).stream().forEach(word->System.out.println(word));

		
		if (antwort.length == 0)
			throw new CommandNotFoundException();
		else
			return antwort[0];

	}

}
