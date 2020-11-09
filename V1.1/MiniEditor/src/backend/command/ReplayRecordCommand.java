package backend.command;

import backend.receiver.Engine;

public class ReplayRecordCommand extends EditorCommand {

	public ReplayRecordCommand(Engine editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.replay();
	}
}
