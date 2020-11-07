package backend.command;

import backend.MiniEditor;
/**
 * Abstract class used between command and concrete commands.
 *
 *
 */
public abstract class EditorCommand implements Command{

	protected MiniEditor editor;
	
	public EditorCommand(MiniEditor editor) {
		this.editor = editor;
	}
}
