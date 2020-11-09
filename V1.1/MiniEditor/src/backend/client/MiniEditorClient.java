package backend.client;

import backend.command.*;
import backend.invoker.MiniEditorInvoker;
import backend.receiver.MiniEditor;
import backend.receiver.MiniEditorImpl;

/**
 * Client of Command design pattern.
 *
 *
 */
public class MiniEditorClient {
	private final MiniEditor editor;                 // Used to get buffer and selection.
	private Command cmd;                             // To hold a command object depending on user command.

	public MiniEditorClient() {
		editor = new MiniEditorImpl();
	}

	public void assemble(EditorCommand cmd){
		// Invoker of command design pattern.
		MiniEditorInvoker invoker = new MiniEditorInvoker(cmd);
		invoker.action();
	}
	public void insert(String text) {
		cmd = new InsertCommand(text, editor);       // Will be called if user command is I/i
		assemble((EditorCommand) cmd);
	}
	public void select(int start, int end) {
		cmd = new SelectCommand(start, end, editor); // Will be called if user command is S/s
		assemble((SelectCommand) cmd);
	}
	public void copy() {
		cmd = new CopyCommand(editor);               // Will be called if user command is C/c
		assemble((CopyCommand) cmd);
	}
	public void cut() {
		cmd = new CutCommand(editor);                // Will be called if user command is X/x
		assemble((CutCommand) cmd);
	}
	public void paste() {
		cmd = new PasteCommand(editor);             // Will be called if user command is P/p
		assemble((PasteCommand) cmd);
	}
	public void delete() {                          // Will be called if user command is D/d
		cmd = new DeleteCommand(editor);
		assemble((DeleteCommand) cmd);
	}
	public String getBufferText() {
		return editor.getBufferContents();                  // Gets buffer from the receiver.
	}
	public String getSelectionText() {
		return editor.getSelection();               // Gets selection from the receiver.
	}
	public int getBeginIndex() {
		return editor.getBeginIndex();
	}
	public int getEndIndex() {
		return editor.getEndIndex();
	}
	public int getBufferBeginIndex() {
		return editor.getBufferBeginIndex();
	}
	public int getBufferEndIndex() {
		return editor.getBufferEndIndex();
	}
	public void setBeginIndex(int beginIndex) {
		editor.setBeginIndex(beginIndex);
	}
	public void setEndIndex(int endIndex) {
		editor.setBeginIndex(endIndex);;
	}
}
