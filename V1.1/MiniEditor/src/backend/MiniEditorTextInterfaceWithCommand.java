package backend;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import backend.client.MiniEditorClient;

/**
 * Front-end
 *
 *
 */
public class MiniEditorTextInterfaceWithCommand {
	
	public static void main(String[] args) {
	
		BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));        // To read input from the console terminal.
		
		String userCommand = "";
		MiniEditorClient client = new MiniEditorClient();                                      // Client of Command design Pattern
		System.out.println("*************************");
		System.out.println("*Mini-Editor Version 1.0*");
		System.out.println("*************************");
		do {
			System.out.println("Enter command.[I(Insert)/S(Select)/C(Copy)/P(Paste)/X(Cut)/D(Delete)/Q(Quit)]");                             // Available commands.
			try {
				userCommand = keyboard.readLine();                                             						  // Input from console
				while(!userCommand.matches("([Ii][ :].*)|([Ss][ :][\\d]+,[\\d]+)|([CPDXQcpdxq])")) {          // Regex to parse user command
					System.out.println("ERROR! Please select valid option");
					userCommand = keyboard.readLine();	                                                              // In case of invalid regex, read again
				}
				// Switch on the bases of user command.
				switch (userCommand.substring(0, 1).toUpperCase()) {
					case "I" -> {
						client.insert(userCommand.substring(2));                               // Call insert method of client.
						messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "S" -> {
						String[] userCommandArgs = userCommand.substring(2).split(",");
						client.select(Integer.parseInt(userCommandArgs[0]), Integer.parseInt(userCommandArgs[1]));     // Call select method of client.
						messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "C" -> {
						client.copy();                                                         // Call cop method of client.
						messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "P" -> {
						client.paste();                                                        // Call paste method of client.
						messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "X" -> {
						client.cut();                                                          // Call cut method of client.
						messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "D" -> {
						client.delete();                                                      // Call delete method of client.
						messageDisplay(client.getBufferText(), client.getSelectionText(), client.getBufferBeginIndex(), client.getBufferEndIndex());
					}
					case "Q" -> System.exit(1);                                               // Quit when user enters [q/Q] command.
					default -> System.out.println("ERROR! Please select a valid option.");
				}
				System.out.println("----------------------------------");
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
		} while(true);

	}

	private static void messageDisplay(String BufferText, String SelectionText, int bufferBeginIndex, int bufferEndIndex){
		System.out.println("Text : " + BufferText);               // Display buffer text after executing command.
		System.out.println("Selection : " + SelectionText);       // Display selection after executing command.
		System.out.println("Buffer index: " + '[' + bufferBeginIndex + ',' + bufferEndIndex + ']');        // Display selection after executing command.
	}

}
