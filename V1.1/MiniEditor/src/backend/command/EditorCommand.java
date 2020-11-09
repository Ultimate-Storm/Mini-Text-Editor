package backend.command;

import backend.receiver.Engine;

/**
 * It comes between command and concrete command.
 * Otherwise each class must have MiniEditor object.
 *
 *
 */
public abstract class EditorCommand implements Command{

	protected Engine editor;
	
	public EditorCommand(Engine editor) {
		this.editor = editor;
	}
}
