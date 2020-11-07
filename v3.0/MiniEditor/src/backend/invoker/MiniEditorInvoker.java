package backend.invoker;

import backend.command.Command;

/**
 * MiniEditorInvoker class as invoker for command design pattern.
 *
 *
 */
public class MiniEditorInvoker {

	Command command;
	
	public MiniEditorInvoker(Command command) {
		this.command = command;
	}
	
	public void action() {
		command.execute();
	}
}
