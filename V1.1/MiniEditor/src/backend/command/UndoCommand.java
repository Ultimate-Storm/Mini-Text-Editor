package backend.command;

import backend.receiver.Engine;
/**
 * UndoCommand class for command design pattern.
 *
 *
 */
public class UndoCommand extends EditorCommand {

	public UndoCommand(Engine editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorUndo();
	}
}
