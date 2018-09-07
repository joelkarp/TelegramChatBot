package TelegramBot.BotCommands;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ActivCommandsTest {

	ActivCommands commandList;

	@BeforeEach
	public void beforEachTest() {
		this.commandList = new ActivCommands();
	}

	@Test
	public void addCommandTest() {
		assertEquals(0, commandList.getCommandCount());
		commandList.addCommand("kinopolis programm", new KinopolisKinoProgram());
		assertEquals(1, commandList.getCommandCount());
		commandList.addCommand("kinopolis", new KinopolisKinoProgram());
		assertEquals(2, commandList.getCommandCount());
	}

	@Test
	public void removeCommandTest() {
		assertEquals(0, commandList.getCommandCount());
		commandList.addCommand("kinopolis programm", new KinopolisKinoProgram());
		commandList.addCommand("kinopolis", new KinopolisKinoProgram());
		assertEquals(2, commandList.getCommandCount());

		commandList.removeCommand("kinopolis programm");
		assertEquals(1, commandList.getCommandCount());
		commandList.removeCommand("kinopolis");
		assertEquals(0, commandList.getCommandCount());
	}

}
