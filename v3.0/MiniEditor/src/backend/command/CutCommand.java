package backend.command;


/**
 * CutCommand class for command design pattern.
 *
 *
 */
import backend.MiniEditor;

public class CutCommand extends EditorCommand{

	public CutCommand(MiniEditor editor) {
		super(editor);
	}
	
	@Override
	public void execute() {
		editor.editorCut();
	}
}
