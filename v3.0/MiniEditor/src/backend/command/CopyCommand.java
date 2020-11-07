package backend.command;

/**
 * CopyCommand class for command design pattern.
 *
 *
 */
import backend.MiniEditor;

public class CopyCommand extends EditorCommand{
	
	public CopyCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorCopy();
	}
	

}
