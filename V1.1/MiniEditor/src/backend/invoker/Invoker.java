package backend.invoker;

/*
 * Invoker for Command design pattern
 */
import backend.command.Command;

public class Invoker {

	private final Command command;                   // Command to hold concrete command
	
	public Invoker(Command command) {
		this.command = command;
	}
	
	public void action() {                      // It calls execute method of whatever command it has.
		command.execute();
	}
}
