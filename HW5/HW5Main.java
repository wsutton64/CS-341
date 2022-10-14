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

public class HW5Main {

	private JFrame frame;
	private JTextField fileField;
	private JTextArea meanArea;
	private JTextArea stdDevArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW5Main window = new HW5Main();
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
	public HW5Main() {
		initialize();
	}
	
	public void process(File file) { // Creates new list and Scanner. Reads the input file and adds the lines to the list. Sends list to calculate()
		System.out.println("Start Process");
		try {
			HW5List list = new HW5List();
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
	
	public void calculate(HW5List list) { //  Takes a list and does math to the numbers
		System.out.println("Start calculate");
		Node currentNode = list.head;
		double sum = 0;
		double size = 0;
		if(currentNode == null) {
			meanArea.setText("List is empty.");
			stdDevArea.setText("List is empty.");
			return;
		}
		
		
		while(currentNode != null) {
			sum += currentNode.num;
			size++;
			currentNode = currentNode.next;
		}
		
		double mean = sum / size;
		
		currentNode = list.head;
		HW5List newList = new HW5List();
		
		while(currentNode != null) {
			newList.addNode(currentNode.getNum() - mean + "");
			currentNode = currentNode.next;
		}
		
		currentNode = newList.head;
		while(currentNode != null) {
			currentNode.setNum(currentNode.getNum() * currentNode.getNum());
			currentNode = currentNode.next;
		}
		
		currentNode = newList.head;
		sum = 0;
		while(currentNode != null) {
			sum += currentNode.num;
			currentNode = currentNode.next;
		}
		
		double stdDev = Math.sqrt(sum / size);
		
		meanArea.setText(mean + "");
		stdDevArea.setText(String.format("%,.5f", stdDev));
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 500, 250);
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
		
		meanArea = new JTextArea();
		meanArea.setEditable(false);
		meanArea.setBounds(175, 126, 240, 23);
		frame.getContentPane().add(meanArea);
		
		stdDevArea = new JTextArea();
		stdDevArea.setEditable(false);
		stdDevArea.setBounds(175, 160, 240, 23);
		frame.getContentPane().add(stdDevArea);
		
		JLabel label1 = new JLabel("Mean");
		label1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label1.setBounds(79, 126, 54, 23);
		frame.getContentPane().add(label1);
		
		JLabel lblNewLabel = new JLabel("Std Dev");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(79, 160, 102, 23);
		frame.getContentPane().add(lblNewLabel);
		
		fileField = new JTextField();
		fileField.setBounds(21, 70, 336, 20);
		frame.getContentPane().add(fileField);
		fileField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Please input a text file with only integers on new lines.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(21, 28, 446, 23);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
