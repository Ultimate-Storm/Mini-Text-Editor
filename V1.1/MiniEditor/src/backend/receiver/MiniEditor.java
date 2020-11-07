package backend.receiver;

/**
 * Receiver of command design pattern
 *
 *
 */
public interface MiniEditor
{
	String getBuffer();                       // Method to return buffer content
	String getSelection();                    // Method to return current selection
	String getClipboard();                    // Method to return content of clipboard
	void editorInsert(String substring);      // Method to insert text to MiniEditor
	void editorSelect(int start, int stop);   // Method to select text from MiniEditor
	void editorCopy();                        // Method to copy text from MiniEditor
	void editorCut();                         // Method to cut text from MiniEditor
	void editorPaste() ;                      // Method to paste text to MiniEditor
	void editorDelete();                      // Method to delete text from MiniEditor
}
