package backend.receiver;

/**
 * Concrete Receiver of command design pattern
 *
 *
 */
public class EngineImpl implements Engine, Selection{

	private int selectionStart;                  	   // To hold start of current selection
	private int selectionEnd;                    	   // To hold end of current selection
	private String bufferContent;                	   // To hold buffer content
	private final Clipboard clipboard;                 // To hold current clipboard content
	
	public EngineImpl() {
		bufferContent = "";
		clipboard = new Clipboard();
	}
	
	@Override
	public String getBufferContents() {                  //  Method to return buffer content
		return bufferContent;
	}

	@Override
	public String getSelection() {              // Method to return current selection
		return bufferContent.substring(getBeginIndex(), getEndIndex()) + "[" + getBeginIndex() + "," + getEndIndex() + "]";
	}

	@Override
	public String getClipboardContents() {              // Method to return content of clipboard
		return clipboard.getContents();
	}

	@Override
	public void insert(String substring) {      // Method to insert text to MiniEditor
		bufferContent = bufferContent.substring(0, getBeginIndex()) + substring + bufferContent.substring(getEndIndex());
		setBeginIndex(getBeginIndex() + substring.length());
		setEndIndex(getBeginIndex());
	}

	@Override
	public void editorSelect(int start, int stop) {   // Method to select text from MiniEditor
		try {
			if((start >= 0 && start <= getBufferEndIndex()) && (stop >=0 && stop  <= getBufferEndIndex()) &&
					(stop >= start)) {
				setBeginIndex(start);
				setEndIndex(stop);
			} else {
				throw new IndexOutOfBoundsException();
			}
		} catch(IndexOutOfBoundsException e) {
			System.out.println("===ERROR! Invalid selection, selection index must be within the buffer index range===");
		}
	}

	@Override
	public void copySelectedText() {                         // Method to copy text from MiniEditor
		if(getBeginIndex() != getEndIndex())
			clipboard.setContents(bufferContent.substring(getBeginIndex(), getEndIndex()));
	}

	@Override
	public void cutSelectedText() {                          // Method to cut text from MiniEditor
		copySelectedText();
		delete();
	}

	@Override
	public void pasteClipboard() {                        // Method to paste text to MiniEditor
		if(!clipboard.isEmpty()) {
			bufferContent = bufferContent.substring(0, getBeginIndex()) + clipboard.getContents() + bufferContent.substring(selectionEnd);
			setBeginIndex(getBeginIndex() + clipboard.getContents().length());
			setEndIndex(getBeginIndex());
		}
	}
	
	@Override
	public void delete() {                       // Method to delete text from MiniEditor
		bufferContent = bufferContent.substring(0, getBeginIndex()) + bufferContent.substring(getEndIndex());
		setEndIndex(getBeginIndex());
	}

	@Override
	public void startRecord() {

	}

	@Override
	public void stopRecord() {

	}

	@Override
	public void replay() {

	}

	@Override
	public void editorUndo() {

	}

	@Override
	public void editorRedo() {

	}

	@Override
	public void editorOpen(String filePath) {

	}

	@Override
	public void editorWrite(String filePath) {

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
		return bufferContent.length();
	}

	@Override
	public void setBeginIndex(int beginIndex) {
		try{
			this.selectionStart = beginIndex;
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setEndIndex(int endIndex) {
		this.selectionEnd = endIndex;
	}
}
