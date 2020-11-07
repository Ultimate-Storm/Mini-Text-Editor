package backend.receiver;

//import backend.command.Selection;

/**
 * Receiver of command design pattern
 *
 *
 */
public interface MiniEditor
{
	/**
	 * Provides the whole contents of the buffer, as a string
	 * @return a copy of the buffer's contents
	 */
	String getBufferContents();

	String getSelection();

	/**
	 * Provides the clipboard contents
	 * @return a copy of the clipboard's contents
	 */
	String getClipboardContents();

	/**
	 * Inserts a string in the buffer, which replaces the contents of the selection
	 * @param substring the text to insert
	 */
	void insert(String substring);
	void editorSelect(int start, int stop);
//	Selection getSelection();

	/**
	 * Copies the text within the interval
	 * specified by the selection control object
	 * into the clipboard.
	 */
	void copySelectedText();
	/**
	 * Removes the text within the interval
	 * specified by the selection control object,
	 * from the buffer.
	 */
	void cutSelectedText();

	/**
	 * Replaces the text within the interval specified by the selection object with
	 * the contents of the clipboard.
	 */
	void pasteClipboard();

	/**
	 * Removes the contents of the selection in the buffer
	 */
	void delete();
}
