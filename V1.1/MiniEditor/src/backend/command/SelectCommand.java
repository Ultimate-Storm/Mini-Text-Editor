package backend.command;

import backend.receiver.MiniEditor;

/**
 * Concrete command of Command design pattern
 *
 *
 */
public class SelectCommand extends EditorCommand implements Selection {
	
	private int selectionStart;
	private int selectionEnd;
	private int BufferBeginIndex;
	private int BufferEndIndex;
	
	public SelectCommand(int selectionStart, int selectionEnd, MiniEditor editor) {
		super(editor);
		this.selectionStart = selectionStart;
		this.selectionEnd = selectionEnd;
	}

	public SelectCommand(int selectionStart, int selectionEnd, MiniEditor editor, int BufferBeginIndex, int BufferEndIndex) {
		this(selectionStart, selectionEnd, editor);
		this.BufferBeginIndex = BufferBeginIndex;
		this.BufferEndIndex = BufferEndIndex;
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

	@Override
	public int getBeginIndex() {
		return this.selectionStart;
	}

	@Override
	public int getEndIndex() {
		return this.selectionEnd;
	}

	@Override
	public int getBufferBeginIndex() {
		return 0;
	}

	@Override
	public int getBufferEndIndex() {
		return 0;
	}

	@Override
	public void setBeginIndex(int beginIndex) {
		this.selectionStart = beginIndex;
	}

	@Override
	public void setEndIndex(int endIndex) {
		this.selectionEnd = endIndex;
	}
}
