package backend.command;

import backend.receiver.MiniEditor;
/**
 * UndoCommand class for command design pattern.
 *
 *
 */
public class UndoCommand extends EditorCommand {

	public UndoCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorUndo();
	}
}
