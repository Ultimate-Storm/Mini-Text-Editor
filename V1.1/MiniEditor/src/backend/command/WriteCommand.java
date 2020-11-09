package backend.command;

import backend.receiver.Engine;
/**
 * WriteCommand class for command design pattern.
 *
 *
 */
public class WriteCommand extends EditorCommand {

	private final String filePath;
	
	public WriteCommand(Engine editor, String filePath) {
		super(editor);
		this.filePath = filePath;
	}
	
	@Override
	public void execute() {
		editor.editorWrite(filePath);
	}
}
