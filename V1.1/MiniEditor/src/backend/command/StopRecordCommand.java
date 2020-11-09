package backend.command;

import backend.receiver.Engine;

public class StopRecordCommand extends EditorCommand {

	public StopRecordCommand(Engine editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.stopRecord();
	}
}
