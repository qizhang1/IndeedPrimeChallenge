import java.io.*;

/**  
* Soyuz11 rocket print
* @author Qi Zhang
* @version Jun 13, 2015.
*/

public class Soyuz11 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in)); 
		
		int size = Integer.parseInt(in.readLine());
		
		// head
		System.out.println("  /\\");
		
		// neck
		for (int i = 0; i < size; i++){
			System.out.println("  ||");
		}
		
		System.out.println(" /||\\");
		System.out.println("/:||:\\");
		
		// body
		for (int i = 0; i < size - 1; i++) {
			System.out.println("|:||:|");
		}
		
		// tail
		System.out.println("|/||\\|");
		System.out.println("  **");
		System.out.println("  **");
	}

}
