package backend.command;

import backend.MiniEditor;
/**
 * StopRecordCommand class for command design pattern.
 *
 *
 */
public class StopRecordCommand extends EditorCommand {

	public StopRecordCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorStopRecord();
	}
}
