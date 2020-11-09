package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import backend.receiver.Clipboard;
import backend.receiver.Engine;
import backend.receiver.EngineImpl;

public class EngineTest {
	
	private Clipboard c ;
	private Engine editor;
	
	@Before
	public void initialize() {
		c = new Clipboard();
		editor = new EngineImpl();
	}
	
	@Test
	public void emptyClipBoardTest() {                               // Test for clipboard    
		Assert.assertTrue(c.isEmpty());
		c.setContents("Test");
		Assert.assertFalse(c.isEmpty());
	}
	
	@Test
	public void contentChangeTest() {                               // Test for change in content
		Assert.assertEquals("", c.getContents());
		c.setContents("Test");
		Assert.assertEquals("Test", c.getContents());
		c.setContents("");
		Assert.assertEquals("", c.getContents());
	}
	
	@Test
	public void bufferTest() {                                     // Test for buffer
		Assert.assertEquals("", editor.getBufferContents());
	}
	
	@After
	public void clean() {
		c = null;
	}
}
