package backend.command;

import backend.MiniEditor;
/**
 * RedoCommand class for command design pattern.
 *
 *
 */
public class RedoCommand extends EditorCommand {

	public RedoCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorRedo();
	}
}
