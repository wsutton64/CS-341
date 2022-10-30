import java.awt.EventQueue;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class HW6Main {

	private JFrame frame;
	private JTextField fileField;
	private JTextArea sumCodeArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW6Main window = new HW6Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HW6Main() {
		initialize();
	}
	
	public void process(File file) { // Creates new list and Scanner. Reads the input file and adds the lines to the list. Sends list to calculate()
		System.out.println("Start Process");
		try {
			HW6List list = new HW6List();
			Scanner reader = new Scanner(file);
			while(reader.hasNextLine()) {
				String line = reader.nextLine();
				list.addNode(line);
			}
			
			calculate(list);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void calculate(HW6List list) { //  Takes a list and does math to the numbers
		System.out.println("Start calculate");
		Node currentNode = list.head;
		int counter = 0;
		Boolean pause = false;

		// If the node is empty, just return that the file is empty.
		if(currentNode == null) {
			sumCodeArea.setText("File is empty.");
			return;
		} else {
			// output the total number of lines to the console.
			System.out.println("Total Lines: " + list.getSize());
		}

		// Traverse all of the list's nodes
		while(currentNode != null){
			String currentStr = currentNode.getString();
			//System.out.println(currentStr);
			// If the given line/string starts with "//", "/*", "*", or is empty, then ignore it and go to the next node. Otherwise, count the line and move on.
			if(currentStr.startsWith("//") || currentStr.startsWith("/*") || currentStr.length() == 0 || pause == true){
				if(currentStr.startsWith("/*")){
					pause = true;
				}
				if(currentStr.contains("*/")){
					pause = false;
				}
				currentNode = currentNode.next;
			} else {
				if(pause == false) {
					counter++;
					System.out.println(currentStr);
				}
				currentNode = currentNode.next;
			}
		}
		// Apply the total lines of code to the text area.
		sumCodeArea.setText(counter + "");
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 220);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton chooseFileButton = new JButton("Choose File");
		chooseFileButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) { // On click, prompt user to select a file. Take selected file and send it to process()
				System.out.println("Clicked Button");
				JFileChooser j = new JFileChooser();
				int returnVal = j.showOpenDialog(frame);
				File file = j.getSelectedFile();
				fileField.setText(file+"");
				process(file);
			}
		});
		chooseFileButton.setBounds(367, 69, 89, 23);
		frame.getContentPane().add(chooseFileButton);
		
		sumCodeArea = new JTextArea();
		sumCodeArea.setEditable(false);
		sumCodeArea.setBounds(200, 126, 240, 23);
		frame.getContentPane().add(sumCodeArea);
		
		JLabel label1 = new JLabel("Lines of Code");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label1.setBounds(40, 126, 125, 23);
		frame.getContentPane().add(label1);
		
		fileField = new JTextField();
		fileField.setBounds(21, 70, 336, 20);
		frame.getContentPane().add(fileField);
		fileField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please input a code file.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(140, 28, 446, 23);
		frame.getContentPane().add(lblNewLabel_1);
	}
}