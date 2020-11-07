package backend.command;

import backend.receiver.MiniEditor;

/**
 * Concrete command of Command design pattern
 *
 *
 */
public class SelectCommand extends EditorCommand{
	
	private final int selectionStart;
	private final int selectionEnd;
	
	public SelectCommand(int selectionStart, int selectionEnd, MiniEditor editor) {
		super(editor);
		this.selectionStart = selectionStart;
		this.selectionEnd = selectionEnd;
	}
	
	@Override
	public void execute() {                        // This concrete command gives its own definition of execute method
		try {
			editor.editorSelect(selectionStart, selectionEnd);	
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
