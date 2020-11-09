package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import backend.client.Client;
import backend.receiver.Engine;

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
			System.out.println("Enter command.[I(Insert)/S(Select)/C(Copy)/P(Paste)/X(Cut)/D(Delete)/Q(Quit)]");                             // Available commands.
			try {
				userCommand = cmd.parseInput();
				// Switch on the bases of user command.
				switch (userCommand.substring(0, 1).toUpperCase()) {
					case "I" -> {
						client.insert(userCommand.substring(2));                               // Call insert method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "S" -> {
						String[] userCommandArgs = userCommand.substring(2).split(",");
						client.select(Integer.parseInt(userCommandArgs[0]), Integer.parseInt(userCommandArgs[1]));     // Call select method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "C" -> {
						client.copy();                                                         // Call cop method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "P" -> {
						client.paste();                                                        // Call paste method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "X" -> {
						client.cut();                                                          // Call cut method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "D" -> {
						client.delete();                                                      // Call delete method of client.
						cmd.messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "Q" -> System.exit(1);                                               // Quit when user enters [q/Q] command.
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
		String userCommand = keyboard.readLine();                                             						  // Input from console
		while(!userCommand.matches("([Ii][ :].*)|([Ss][ :][\\d]+,[\\d]+)|([CPDXQcpdxq])")) {          // Regex to parse user command
			System.out.println("===ERROR! Please select valid option===");
			userCommand = keyboard.readLine();	                                                              // In case of invalid regex, read again
		}
		return userCommand;
	}

}
