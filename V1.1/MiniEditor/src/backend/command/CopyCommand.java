package backend.command;

import backend.receiver.Engine;

/**
 * Concrete command of Command design pattern
 *
 *
 */
public class CopyCommand extends EditorCommand{
	
	public CopyCommand(Engine editor) {
		super(editor);
	}
	
	@Override
	public void execute() {                  // This concrete command gives its own definition of execute method
		editor.copySelectedText();
	}
	

}
