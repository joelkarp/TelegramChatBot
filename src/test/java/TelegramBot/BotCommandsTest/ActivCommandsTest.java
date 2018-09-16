package TelegramBot.BotCommandsTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TelegramBot.BotCommands.ActivCommands;
import TelegramBot.BotCommands.CommandNotFoundException;
import TelegramBot.BotCommands.KinopolisKinoprogramm;

public class ActivCommandsTest {

	ActivCommands commandList;

	@BeforeEach
	public void beforEach() {
		this.commandList = new ActivCommands();
	}

	@Test
	public void testAddCommand() {
		assertEquals(0, commandList.getCommandCount());
		commandList.addCommand("kinopolis programm", new KinopolisKinoprogramm());
		assertEquals(1, commandList.getCommandCount());
		commandList.addCommand("kinopolis", new KinopolisKinoprogramm());
		assertEquals(2, commandList.getCommandCount());
	}

	@Test
	public void testRemoveCommand() {
		assertEquals(0, commandList.getCommandCount());
		commandList.addCommand("kinopolis programm", new KinopolisKinoprogramm());
		commandList.addCommand("kinopolis", new KinopolisKinoprogramm());
		assertEquals(2, commandList.getCommandCount());
		commandList.removeCommand("kinopolis programm");
		assertEquals(1, commandList.getCommandCount());
		commandList.removeCommand("kinopolis");
		assertEquals(0, commandList.getCommandCount());
	}

	@Test
	public void testGetCommand() {
		assertEquals(0, commandList.getCommandCount());
		commandList.addCommand("kinopolis programm", new KinopolisKinoprogramm());
		commandList.addCommand("kinopolis", new KinopolisKinoprogramm());
		assertEquals(2, commandList.getCommandCount());

		assertThrows(CommandNotFoundException.class, () -> {
			commandList.getCommand("keinGueltigerKey");
		});

	}

}
