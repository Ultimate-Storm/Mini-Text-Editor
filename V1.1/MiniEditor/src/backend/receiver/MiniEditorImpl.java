package backend.receiver;

import backend.exceptions.InvalidSelectionException;

/**
 * Concrete Receiver of command design pattern
 *
 *
 */
public class MiniEditorImpl implements MiniEditor{

	private int selectionStart;                  	   // To hold start of current selection
	private int selectionEnd;                    	   // To hold end of current selection
	private String bufferContent;                	   // To hold buffer content
	private final Clipboard clipboard;                 // To hold current clipboard content
	
	public MiniEditorImpl() {
		bufferContent = "";
		clipboard = new Clipboard();
	}
	
	@Override
	public String getBufferContents() {                  //  Method to return buffer content
		return bufferContent;
	}

	@Override
	public String getSelection() {              // Method to return current selection
		return bufferContent.substring(selectionStart, selectionEnd) + "[" + selectionStart + "," + selectionEnd + "]";
	}

	@Override
	public String getClipboardContents() {              // Method to return content of clipboard
		return clipboard.getContents();
	}

	@Override
	public void insert(String substring) {      // Method to insert text to MiniEditor
		bufferContent = bufferContent.substring(0, selectionStart) + substring + bufferContent.substring(selectionEnd);
		selectionStart = selectionEnd = selectionStart + substring.length();
	}

	@Override
	public void editorSelect(int start, int stop) {   // Method to select text from MiniEditor
		try {
			if((start >= 0 && start <= bufferContent.length()) && (stop >=0 && stop  <= bufferContent.length()) &&
					(stop >= start)) {
				selectionStart = start;
				selectionEnd = stop;
			} else {
				throw new InvalidSelectionException();
			}
		} catch(InvalidSelectionException ise) {
			System.out.println("ERROR! Invalid selection.");
		}
	}

	@Override
	public void copySelectedText() {                         // Method to copy text from MiniEditor
		if(selectionStart != selectionEnd)
			clipboard.setContents(bufferContent.substring(selectionStart, selectionEnd));
	}

	@Override
	public void cutSelectedText() {                          // Method to cut text from MiniEditor
		copySelectedText();
		delete();
	}

	@Override
	public void pasteClipboard() {                        // Method to paste text to MiniEditor
		if(!clipboard.isEmpty()) {
			bufferContent = bufferContent.substring(0, selectionStart) + clipboard.getContents() + bufferContent.substring(selectionEnd);
			selectionStart = selectionEnd = selectionStart + clipboard.getContents().length();
		}
	}
	
	@Override
	public void delete() {                       // Method to delete text from MiniEditor
		bufferContent = bufferContent.substring(0, selectionStart) + bufferContent.substring(selectionEnd);
		selectionEnd = selectionStart;
	}
}
