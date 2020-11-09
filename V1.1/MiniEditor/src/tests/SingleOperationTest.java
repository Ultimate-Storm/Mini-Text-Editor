package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import backend.receiver.Engine;
import backend.receiver.EngineImpl;

/**
 * To test single commands on miniEditor.
 *
 *
 */
public class SingleOperationTest {

	Engine editor;
	
	@Before
	public void initialize() {
		editor = new EngineImpl();
	}
	
	@Test
	public void insertTest() {
		Assert.assertEquals("", editor.getBufferContents());
		editor.insert("Test");
		Assert.assertEquals("Test", editor.getBufferContents());
	}
	
	@Test
	public void copyTest() {
		Assert.assertEquals("", editor.getBufferContents());
		editor.insert("Test");
		Assert.assertEquals("Test", editor.getBufferContents());
		editor.editorSelect(1, 3);
		editor.copySelectedText();
		Assert.assertEquals("es", editor.getClipboardContents());
	}
	
	@Test
	public void pasteTest() {
		Assert.assertEquals("", editor.getBufferContents());
		editor.insert("Test");
		Assert.assertEquals("Test", editor.getBufferContents());
		editor.editorSelect(1,3);
		editor.copySelectedText();
		Assert.assertEquals("es", editor.getClipboardContents());
		editor.editorSelect(0,0);
		editor.pasteClipboard();
		Assert.assertEquals("esTest", editor.getBufferContents());
	}
	
	@Test
	public void cutTest() {
		Assert.assertEquals("", editor.getBufferContents());
		editor.insert("Test");
		Assert.assertEquals("Test", editor.getBufferContents());
		editor.editorSelect(1,3);
		editor.cutSelectedText();
		Assert.assertEquals("es", editor.getClipboardContents());
		Assert.assertEquals("Tt", editor.getBufferContents());
	}
	
	@Test
	public void selectTest() {
		Assert.assertEquals("", editor.getBufferContents());
		Assert.assertEquals("", editor.getSelection().substring(0, editor.getSelection().indexOf('[')));
		editor.insert("Test");
		Assert.assertEquals("", editor.getSelection().substring(0, editor.getSelection().indexOf('[')));
		editor.editorSelect(1,3);
		Assert.assertEquals("es", editor.getSelection().substring(0, editor.getSelection().indexOf('[')));
		editor.editorSelect(1,2);
		Assert.assertEquals("e", editor.getSelection().substring(0, editor.getSelection().indexOf('[')));
	}
	
	@Test
	public void deleteTest() {
		Assert.assertEquals("", editor.getBufferContents());
		editor.insert("Test");
		Assert.assertEquals("Test", editor.getBufferContents());
		editor.editorSelect(1,3);
		editor.delete();
		Assert.assertEquals("", editor.getClipboardContents());
		Assert.assertEquals("Tt", editor.getBufferContents());
	}
	
	@After
	public void clean() {
		editor = null;
	}
}
