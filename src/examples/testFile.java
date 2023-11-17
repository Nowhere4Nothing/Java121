import java.util.Scanner;
import java.util.Formatter;
import java.io.IOException;
import java.nio.file.*;

/*
Created by T. Xia
*/

public class testFile {
	private Scanner in;
	private Formatter out;
	
	public testFile() {
	}
	
	public static void main(String[] args) {
		testFile t = new testFile();
		
		if(args.length >= 1) {
			int test = Integer.parseInt(args[0]);
			//System.out.println("args[0] = " + args[0]);
			
			switch(test) {
				case 1: //Check if a file is a directory
					t.dir();
					break;
				case 2: //Read data from a text file with delimiters
					t.readFile();
					break;
				case 3: //Read strings from keyboard and write to a text file
					t.writeFile();
					break;
				default: //Others
					System.out.println("No others");
					break;
			}
		}
		else
			System.out.printf("Usage: java testFile [1 | 2 | 3]\n");
		
	}
	
	//If an input file name is a directory name, display the files in the folder
	public void dir() {
		System.out.println("Check if a filename is a directory name, then print the files in the folder.");
		in = new Scanner(System.in); 
		System.out.print("Input a file or directory name: "); 
		String name = in.nextLine();
		
		Path path = Paths.get(name);
		try {
			if(Files.exists(path)) { //File exists
				System.out.printf("%s exists. \n", path.getFileName());
			
				if(Files.isDirectory(path)) { //It is a directory
					System.out.println("Directory contains:");
				
					DirectoryStream<Path> ds = Files.newDirectoryStream(path);
					for(Path p : ds)
						System.out.println(p);
				}
				else
					System.out.printf("%s is a file.", path);
			}
			else
				System.out.printf("%s does not exist.", path);
		}
		catch (IOException err) {
			System.out.println("IO exception error");
		}
	}
	
	//Read data from a text file. The delimiters can be , new line, tab.
	public void readFile() {
		System.out.println("Read data from a text file. The delimiters can be , new line, tab, etc.");
		in = new Scanner(System.in); 
		System.out.print("Input a text filename: "); 
		String name = in.nextLine();
		in.close();
		Path path = Paths.get(name);
		try {
			if(Files.exists(path)) {
				System.out.printf("%s exists", path.getFileName());
			
				if(!Files.isDirectory(path)) { //Not a directory, read data
					System.out.println("A file " + name + " contains:");
				
					in = new Scanner(path);
					in.useDelimiter(",|\r\n|\t|\n");
					while(in.hasNext()) {
						System.out.printf("[%s] ", in.next());
						System.out.printf("[%s] ", in.next());
						System.out.printf("[%d] ", in.nextInt());
						System.out.printf("[%s] ", in.next());
						System.out.printf("[%s] ", in.next());
						System.out.printf("[%f] \n", in.nextDouble());
					}
					in.close();
				}
				else
					System.out.printf("File %s does not exist", path);
			}
		}
		catch (IOException err) {
			System.out.println("IO exception error");
		}	
	}
	
	//Get input strings from the keyboard, then save them to a text file
	public void writeFile() {
		System.out.println("Get input strings from the keyboard, then save them to a text file.");
		Scanner in = new Scanner(System.in); 
		System.out.print("Input an output filename: "); 
		String name = in.nextLine();
		try {
			//Open an output file
			Formatter fout = new Formatter(name);
			while(in.hasNextLine()) {
				String s = in.nextLine();
				fout.format("%s\n", s);
			}
			fout.close();
		}
		catch (IOException err) {
			System.out.println("IO exception error");
		}	
	}
}