package backend.command;

import backend.MiniEditor;
/**
 * StartRecordCommand class for command design pattern.
 *
 *
 */
public class StartRecordCommand extends EditorCommand {

	public StartRecordCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorStartRecord();
	}
}
