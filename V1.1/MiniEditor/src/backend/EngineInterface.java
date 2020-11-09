package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

import backend.client.Client;

/**
 * Front-end
 *
 *
 */
public class EngineInterface {
	static EngineInterface cmd = new EngineInterface();
	public static void main(String[] args) {
		String userCommand;
		Client client = new Client();                                      // Client of Command design Pattern
		do {
			System.out.println("Enter command:[Insert/Select/Copy/Paste/Cut/Delete/Quit](case not sensitive)");                             // Available commands.
			try {
				userCommand = cmd.parseInput();
				List<String> cmdSeg = cmd.parseInput(userCommand);
				// Switch on the bases of user command.
				switch (cmdSeg.get(0).toUpperCase()) {
					case "INSERT" -> {
						client.insert(cmdSeg.get(1));                               // Call insert method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "SELECT" -> {
						String[] userCommandArgs = cmdSeg.get(1).split(",");
						client.select(Integer.parseInt(userCommandArgs[0]), Integer.parseInt(userCommandArgs[1]));     // Call select method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "COPY" -> {
						client.copy();                                                         // Call cop method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "PASTE" -> {
						client.paste();                                                        // Call paste method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "CUT" -> {
						client.cut();                                                          // Call cut method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "DELETE" -> {
						client.delete();                                                      // Call delete method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "QUIT" -> System.exit(1);                                               // Quit when user enters [q/Q] command.
					default -> System.out.println("===ERROR! Please select a valid option===");
				}
				System.out.println("----------------------------------");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} while(true);

	}

	private void messageDisplay(String BufferText, String SelectionText, int bufferBeginIndex, int bufferEndIndex){
		System.out.println("Text : " + BufferText);               // Display buffer text after executing command.
		System.out.println("Selection : " + SelectionText);       // Display selection after executing command.
		System.out.println("Buffer index: " + '[' + bufferBeginIndex + ',' + bufferEndIndex + ']');        // Display selection after executing command.
	}

	private String parseInput() throws IOException {
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));        // To read input from the console terminal.
		return keyboard.readLine();
	}
	private List<String> parseInput(String input) {
		String[] parts = input.split(" ");
		return Arrays.asList(parts);
	}
}
