import java.io.*;

/**
 * This is a hello world style program I have written to showcase basic Java knowledge.
 * @author Dillon Welch
 */
public class JavaHelloWorld 
{
	// Constants for the different user input states. Used to decide which branch of code to go down.
    static final int startState = 0;
    static final int factState = 1;
    static final int jokeState = 2;
    static final int finalState = jokeState;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException 
	{       
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // Variable for reading in user input.
        
        String inputResult = null; // Variable for storing user input before being converted.
        int finalResult = 0; // Variable for final storage of user input, used to decide which branch of code to go down.
        
        System.out.println("Hello there!!");
        System.out.println("Would you like to hear some facts, or hear some jokes?");
		
		// Continuously ask for input until proper, valid input has been received.
        while(finalResult == 0)
        {
            System.out.println("Press 1 to hear some facts.");
            System.out.println("Press 2 to hear some jokes.");
			
			// Get the input from the user.
            try
            {
                inputResult = br.readLine();
            } 
            catch (IOException io) 
            {
                System.err.println("IO error reading in result. Please try running the program again.");
                System.exit(1);
            }
            
			// Convert it to a number.
            try
            {
                finalResult = Integer.parseInt(inputResult);
            }
            catch(Exception e)
            {
				// If the user did not type in a number, ask for input again.
                System.err.println("Hey silly! That's not a number!.");
                finalResult = 0;
                continue;
            }
            
			// If the user input a number, but not a valid number, ask for input again.
            if(finalResult <= startState || finalResult > finalState)
            {
                System.err.println("Hey goofball! That's number is not a valid choice!");
                finalResult = 0;
            }
        }
       
		// Based on user input, go down a particular path.
		// Sleeps are inserted between each statement to give the user time to read each line - and for dramatic effect.
        switch(finalResult)
        {
            case factState:
            {
                // A series of very silly and dubious facts.
                // Source: http://gaming.stackexchange.com/questions/20817/what-are-all-the-facts-that-core-3-babbles-about-in-portal-2
                System.out.println("\n\nHumans can survive underwater. But not for very long.");
                Thread.sleep(2000);
                System.out.println("\n\n89% of magic tricks are not magic. Technically, they are sorcery.");
                Thread.sleep(2000);
                System.out.println("\n\nIf you have trouble with simple counting, use the following mnemonic device:");
                System.out.println("One comes before two comes before 60 comes after 12 comes before six trillion comes after 504.");
                System.out.println("This will make your earlier counting difficulties seem like no big deal.");
                Thread.sleep(2000);
                break;
            }
            case jokeState:
            {
                // A series of increasingly bad jokes.
                System.out.println("\n\nWhy do Java developers wear glasses? Because they can't C#!");
                Thread.sleep(2000);
                System.out.println("\n\nHow about another one?");
                System.out.println("debate (noun) - Used to catch defish.");
                Thread.sleep(2000);
                System.out.println("\n\nJust one more, please!");
                System.out.println("What do you call a fish with no i?");
                Thread.sleep(2000);
                System.out.println("...");
                Thread.sleep(2000);
                System.out.println(".....");
                Thread.sleep(2000);
                System.out.println("...");
                Thread.sleep(2000);
                System.out.println("\n\nFsh!");
                System.out.println("Ok, I'll see myself out.");
                break;
            }
            default:
            {
                // Uh oh, shouldn't get here.
                System.err.println("This shouldn't happen. Abort!");
                System.exit(1);
            }              
        }
        
        System.out.println("\n\nThanks for running my little Java Hello World program.");
        System.out.println("I hope it brought a smile to your face. :)");
    }
}
