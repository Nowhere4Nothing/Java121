package Ass3;

import Ass2.Department;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class ApplicationManagment extends JFrame implements ActionListener, ListSelectionListener {
    private final ArrayList<Applicant> applicants;
    private final ArrayList<Position> positions;
    private final ArrayList<Apply> applies;
    private DefaultListModel<Integer> defaultApplist, defaultPosList;
    private JList<Integer> applicantNo;
    private JList<Integer> positionNo;

    private final Container container;
    private GridBagLayout layout;
    private final GridBagConstraints con;
    private JLabel label;
    private JButton apply, save;
    private JTextArea applicantDetails, positionDetails;
    private JTextField messages;
    private final String applicantList = "src/Ass3/applicants.txt";
    private final String applyList = "src/Ass3/applies.txt";
    private  final String positionList ="src/Ass3/positions.txt";

    Formatter format;

    public ApplicationManagment() {
        super("Application Management system");

        applicants = new ArrayList<>();
        positions = new ArrayList<>();
        applies = new ArrayList<>();

        // load the data
        loadData();

        //Set the container
        container = getContentPane();
        layout = new GridBagLayout();
        container.setLayout(layout);
        container.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        con = new GridBagConstraints();
        con.fill = GridBagConstraints.BOTH;

        Font bigFont = new Font("Dialog", Font.BOLD, 15);

        createGUI(bigFont);
        //make the GUI

        createButtons();
        // make the buttons

        createMessages(bigFont);
        //create the messages

        showDetails();
        //show the details on load

    }

    private void loadData() {
        Path path = Paths.get(applicantList);
        try {
            if(Files.exists(path)) {

                if(!Files.isDirectory(path)) {
                    Scanner fin = new Scanner(path);
                    fin.useDelimiter("\t|\r\n|\n");

                    while(fin.hasNext()) {
                        Applicant applicant = new Applicant();
                        applicant.readData(fin);

                        if (!applicants.contains(applicant)) {
                            applicants.add(applicant);
                        }
                    }
                    fin.close();
                }
                else
                    System.out.printf("File %s does not exist", path);
            }
        }
        catch (IOException err) {
            System.out.println("IO exception error");
        }

        for (Applicant appList : applicants) {
            System.out.println(appList);

        }

        Path path2 = Paths.get(applyList);
        try {
            if(Files.exists(path2)) {

                if(!Files.isDirectory(path2)) {
                    Scanner fin = new Scanner(path2);
                    fin.useDelimiter("\t|\r\n|\n");

                    while(fin.hasNext()) {
                        Apply apply = new Apply();
                        apply.readData(fin);

                        if (!applies.contains(apply)) {
                            applies.add(apply);
                        }
                    }
                    fin.close();
                }
                else
                    System.out.printf("File %s does not exist", path);
            }
        }
        catch (IOException err) {
            System.out.println("IO exception error");
        }

        for (Apply appList: applies) {
            System.out.println(appList);
        }

        Path path3 = Paths.get(positionList);
        try {
            if(Files.exists(path3)) {

                if(!Files.isDirectory(path3)) {
                    Scanner fin = new Scanner(path3);
                    fin.useDelimiter("\t|\r\n|\n");

                    while(fin.hasNext()) {
                        Position pos = new Position();
                        pos.readData(fin);

                        if (!positions.contains(pos)) {
                            positions.add(pos);
                        }
                    }
                    fin.close();
                }
                else
                    System.out.printf("File %s does not exist", path);
            }
        }
        catch (IOException err) {
            System.out.println("IO exception error");
        }
        for (Position pList: positions) {
            System.out.println(pList);
        } // end for
    } // end method

    public void createGUI(Font font) {
       JPanel guiPanelRowOne = new JPanel(new FlowLayout());

        label = new JLabel("Applicant Number: ");
        guiPanelRowOne.add(label);

        label = new JLabel("          ");
        guiPanelRowOne.add(label);

        defaultApplist = new DefaultListModel<>();
        for(Applicant aList : applicants) {
            defaultApplist.addElement(aList.getaNumber());
        }

        applicantNo = createJList(defaultApplist, font);

        JScrollPane applicantNoScroller = createScrollerV(applicantNo);
        guiPanelRowOne.add(applicantNoScroller);

        label = new JLabel("          ");
        guiPanelRowOne.add(label);

        label = new JLabel("Applicant Number: ");
        guiPanelRowOne.add(label);

        label = new JLabel("          ");
        guiPanelRowOne.add(label);

       defaultPosList = new DefaultListModel<>();
        for(Position pList : positions) {
            defaultPosList.addElement(pList.getpNumber());
        }

       positionNo = createJList(defaultPosList, font);

        JScrollPane posScroller = createScrollerV(positionNo);
        guiPanelRowOne.add(posScroller);

        con.weightx = 0.5;
        con.gridx = 0;
        con.gridy = 0;
        con.ipady = 50;
        container.add(guiPanelRowOne, con);
        // add the panel to the top row first column

        JPanel guiPanelRowTwo = new JPanel(new FlowLayout());

        label = new JLabel("Applicant details: ");
        guiPanelRowTwo.add(label);

        label = new JLabel("          ");
        guiPanelRowTwo.add(label);

        applicantDetails = createTextArea(font);
        JScrollPane appTextAreaScroller = createScrollerVH(applicantDetails);

        guiPanelRowTwo.add(appTextAreaScroller);

        label = new JLabel("          ");
        guiPanelRowTwo.add(label);

        label = new JLabel("Position details: ");
        guiPanelRowTwo.add(label);

        label = new JLabel("          ");
        guiPanelRowTwo.add(label);

        positionDetails = createTextArea(font);
        JScrollPane posTextAreaScroller = createScrollerVH(positionDetails);

        guiPanelRowTwo.add(posTextAreaScroller);

        con.weightx = 0.5;
        con.gridx = 0;
        con.gridy = 2;
        con.ipady = 0;
        container.add(guiPanelRowTwo, con);
    }

    private JList<Integer> createJList(DefaultListModel<Integer> d, Font font) {
        JList<Integer> theList = new JList<>(d);
        theList.addListSelectionListener(this);
        theList.setFont(font);
        theList.setVisibleRowCount(5);
        theList.setFixedCellWidth(35);
        theList.setFixedCellHeight(20);
        return theList;
    }
    private JScrollPane createScrollerV(JList<Integer> des) {
        JScrollPane scroller = new JScrollPane(des);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        return scroller;
        // to scroll vertical only
    }

    private JTextArea createTextArea(Font font) {
        JTextArea textArea = new JTextArea(10, 17);
        textArea.setFont(font);
        textArea.setBorder(BorderFactory.createBevelBorder(1,Color.BLUE,Color.cyan));
        return textArea;
    }

    private JScrollPane createScrollerVH(JTextArea des) {
        JScrollPane scroller = new JScrollPane(des);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        return scroller;
        // to scroll vertical and horizontal
    }

    private JTextField createTextBoxBig (Font font) {
        JTextField textField = new JTextField(50);
        textField.setFont(font);
        textField.setBorder(BorderFactory.createBevelBorder(1,Color.BLUE, Color.YELLOW));
        return textField;
    }

    public void createButtons() {
        JPanel buttonPanel = new JPanel(new FlowLayout());

        apply = new JButton("Apply");
        apply.addActionListener(this);
        buttonPanel.add(apply);

        save = new JButton("Save");
        save.addActionListener(this);
        buttonPanel.add(save);

        con.weightx = 0.5;
        con.gridx = 0;
        con.gridy = 3;
        con.ipady = 50;
        container.add(buttonPanel, con);

    }

    public void createMessages(Font font) {
        JPanel messagesPanel = new JPanel(new FlowLayout());

        label = new JLabel("Messages    ");
        messagesPanel.add(label);

        messages = createTextBoxBig(font);
        messagesPanel.add(messages);

        con.weightx = 0.5;
        con.gridx = 0;
        con.gridy = 4;

        container.add(messagesPanel, con);

    }

    public void showDetails() {

    }

    public static void main (String[] args) {
        ApplicationManagment app = new ApplicationManagment();

        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setSize(500, 500);
        app.setVisible(true);

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        int i = applicantNo.getSelectedIndex();

        for (Applicant aList: applicants) {
            if (i + 1 == aList.getaNumber()) {
                applicantDetails.setText(aList.toString());
            } // end if statement
        } // end for loop

        int j = positionNo.getSelectedIndex();

        for (Position pList: positions) {
            if (j + 1 == pList.getpNumber()) {
                positionDetails.setText(pList.toString());
            } // end if loop
        } //end for loop

        messages.setText("");
    } // end method

    @Override
    public void actionPerformed(ActionEvent e) {
        int i = applicantNo.getSelectedIndex();
        int j = positionNo.getSelectedIndex();

        if (e.getSource() == apply) {

            if (!(findApp(i)) || !(findPos(j))) {
                messages.setText("Choose an applicant and / or position");
            } // end iff validation

               else if (!haveTheyAlreadyApplied(i, j)) {

                    int in = JOptionPane.showConfirmDialog(null, "Would you like to confirm the application?", "A confirmation",
                            JOptionPane.YES_NO_OPTION);

                    if (in == 0) {
                        messages.setText("An application has been added");
                    } else {
                        messages.setText("An application has been discarded");
                    }

                } else {
                    messages.setText("The application exists!");
                }

            } // end if button apply


        else if (e.getSource() == save) {
            int saveIt = JOptionPane.showConfirmDialog(null, "Would you like to save all data?", "A confirmation",
                    JOptionPane.YES_NO_OPTION);

            if (saveIt == 0) {
                saveData();

            } else {
                messages.setText("Data has not been saved");
            } // end else
        } // end else if save
    } // end method

    private boolean findPos(int find) {
        find = find + 1;
        for (Position pList: positions) {
            if (pList.getpNumber() == find) {
                return true;
                /*
                using a for loop to go through the objects in the emps array
                comparing the objects eNumber with the users input
                if found it'll return the object, if not it'll return null
                 */
            } // end if loop
        } // end advanced for loop
        return false;
    }

    private void saveData() {
        try {
            format = new Formatter(applicantList);

            for (Applicant appList: applicants) {
                appList.writeData(format);
            } // end for loop

            System.out.println("Applicant Data Saved");

            format.close();
            //Using formatter to re-write and save the file
        } // end try
        catch (IOException er) {
            System.out.println("Io error, can not save '" + applicantList + "'");
        } // end catch

        try {
            format = new Formatter(positionList);

            for (Position pList : positions) {
                pList.writeData(format);
            } // end for loop

            System.out.println("Position Data Saved");

            format.close();
            //Using formatter to re-write and save the file
        } // end try
        catch (IOException er) {
            System.out.println("Io error, can not save '" + positionList + "'");
        } // end catch

        try {
            format = new Formatter(applyList);

            for (Apply applyList : applies) {
                applyList.writeData(format);
            } // end for loop

            messages.setText("Data Saved!");
            System.out.println("Apply Data Saved");

            format.close();
            //Using formatter to re-write and save the file
        } // end try
        catch (IOException er) {
            System.out.println("Io error, can not save '" + applicantList + "'");
        } // end catch

    }

    private boolean findApp(int find) {
        find = find + 1;
        for (Applicant aList: applicants) {
            if (aList.getaNumber() == find) {
                return true;
                /*
                using a for loop to go through the objects in the emps array
                comparing the objects eNumber with the users input
                if found it'll return the object, if not it'll return null
                 */
            } // end if loop
        } // end advanced for loop
        return false;
        }

        private boolean haveTheyAlreadyApplied(int apply, int pos) {
        apply = apply + 1;
        pos = pos + 1;

            for (Apply appList : applies) {
                if (appList.inApplies(apply, pos)) {
                /*
                a boolean that takes the users input to a method in the class WorksOn that gets the objects eNumber and pNumber
                returns true if found, if not returns false
                 */
                    return true;
                } // end if statement
            } // end for loop
            return false;
        }

} // end class
