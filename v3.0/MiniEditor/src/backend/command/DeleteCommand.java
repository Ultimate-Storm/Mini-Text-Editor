package backend.command;

import backend.MiniEditor;

/**
 * DeleteCommand class for command design pattern.
 *
 *
 */
public class DeleteCommand extends EditorCommand{

	public DeleteCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorDelete();
	}
}
