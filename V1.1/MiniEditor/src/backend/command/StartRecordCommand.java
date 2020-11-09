package backend.command;

import backend.receiver.Engine;

public class StartRecordCommand extends EditorCommand {

	public StartRecordCommand(Engine editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.startRecord();
	}
}
