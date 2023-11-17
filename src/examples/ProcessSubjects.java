/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author txia
 */
import java.util.*;
import java.io.*;

public class ProcessSubjects {
    LinkedList<Subject> allSubjects;
    static final String file="Subjects.txt";
    
    ProcessSubjects() {
        allSubjects = new LinkedList<Subject>();
    }
    
    public static void main(String[] args) {
        ProcessSubjects proc = new ProcessSubjects();
        
        proc.readData();
        proc.processData();
    }
    
    void readData() {
        //Open file prepare to read
        BufferedReader dr=null;
        try {
            dr = new BufferedReader(new FileReader(file));
        } catch (Exception e) {
            System.out.println("File "+file+" open error.");
            System.exit(0);
        }
        
        //Ready to read data from the file
        try {
            String aline;
            while((aline = dr.readLine()) != null) {
                String	str[] = aline.split(";");
                Subject s = new Subject(str[0], str[1], Integer.parseInt(str[2].trim()), str[3], str[4], Integer.parseInt(str[5].trim()), Integer.parseInt(str[6].trim()));
                allSubjects.add(s);
            }
        } catch (Exception e) {
            System.out.println("Read file "+file+" error.");
        }
        
    }
    
    void processData() {
        //Read input from keyboard
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String s = "S";
            while(!s.equalsIgnoreCase("Q")) {
                displayMenu();
                s = input.readLine().trim();
                if(s.equalsIgnoreCase("S")){
                    System.out.print("Subject code:");
                    s = input.readLine().trim();
                    Subject tmp = searchSubject(s);
                    if(tmp != null)
                        printSubject(tmp);
                    else
                        System.out.println("Subject doesn't exist");
                }
                else if (s.equalsIgnoreCase("P")) {
                    Iterator it = allSubjects.iterator();
                    while(it.hasNext()) {
                        Subject tmp = (Subject)it.next();
                        printSubject(tmp);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Cannot read input from keyboard");
            System.exit(0);
        }
    }
    
    void displayMenu() {
        System.out.println("Search a subject");
        System.out.println("Print all subjects");
        System.out.println("Quit");
        System.out.println("Please input (S, P or Q):");
    }
    
    Subject searchSubject(String code) {
        Iterator it = allSubjects.iterator();
        while(it.hasNext()) {
            Subject s = (Subject)it.next();
            if(s.getCode().equals(code))
                return s;
        }
        return null;
    }
    
    void printSubject(Subject s) {
        System.out.println("Code:"+s.getCode());
        System.out.println("Name:"+s.getName());
        System.out.println("Credit:"+s.getCredit());
        System.out.println("Description:"+s.getDescription());
        System.out.println("Pre-requisites:"+s.getPreRequisites());
        System.out.println("Class hours:"+s.getClassTime());
        System.out.println("Lab hours:"+s.getLabTime());
        System.out.println("");
    }
}
