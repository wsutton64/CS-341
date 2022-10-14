import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;

public class ScrabbleApp {

	private JFrame frame;
	private JTextField text1;
	private JTextField text2;
	private JTextField text3;
	private JTextField text4;
	private JButton goButton;
	public JTextPane resultPane;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScrabbleApp window = new ScrabbleApp();
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
	public ScrabbleApp() {
		initialize();
	}
	
	private void runApp() {
		ArrayList<String> charSet = new ArrayList<String>();
		charSet.add(text1.getText());
		charSet.add(text2.getText());
		charSet.add(text3.getText());
		charSet.add(text4.getText());
		String str = "";
		
		for(int i = 0; i < charSet.size(); i++) {
			str = str + charSet.get(i);
		}
		
		if(text1.getText().length() == 1 && text2.getText().length() == 1 && text3.getText().length() == 1 && text4.getText().length() == 1) {
			printAllPermutations(str, "");
		} else {
			resultPane.setText("Requirements not met. Enter one letter per box.");
		}
	}

	
	private void printAllPermutations(String string, String result) {

		 // If the string is empty, print empty string and return

		 if (string.length() == 0) {
			 
			 System.out.println(result + " ");
			 resultPane.setText(resultPane.getText() + result + " ");

			 return;

		 }

		 for (int i = 0; i < string.length(); i++) {

			 // character number 'i' of string

			 char ch = string.charAt(i);

			 // Rest of the string after excluding character number 'i'

			 String ros = string.substring(0, i) + string.substring(i + 1);

			 // call the function again recursively
			 printAllPermutations(ros, result + ch);
			 
		 }

	 }
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter 4 characters");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(145, 30, 135, 14);
		frame.getContentPane().add(lblNewLabel);
		
		text1 = new JTextField();
		text1.setBounds(58, 74, 43, 20);
		frame.getContentPane().add(text1);
		text1.setColumns(10);
		
		text2 = new JTextField();
		text2.setBounds(155, 74, 43, 20);
		frame.getContentPane().add(text2);
		text2.setColumns(10);
		
		text3 = new JTextField();
		text3.setBounds(237, 74, 43, 20);
		frame.getContentPane().add(text3);
		text3.setColumns(10);
		
		text4 = new JTextField();
		text4.setBounds(324, 74, 43, 20);
		frame.getContentPane().add(text4);
		text4.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("1");
		lblNewLabel_1.setBounds(44, 77, 20, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("2");
		lblNewLabel_2.setBounds(144, 77, 20, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("3");
		lblNewLabel_3.setBounds(227, 77, 20, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("4");
		lblNewLabel_4.setBounds(314, 77, 20, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(59, 195, 314, 55);
		frame.getContentPane().add(scrollPane);
		
		resultPane = new JTextPane();
		scrollPane.setViewportView(resultPane);
		
		JLabel lblPossibleWords = new JLabel("Possible Words");
		lblPossibleWords.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPossibleWords.setBounds(163, 170, 116, 14);
		frame.getContentPane().add(lblPossibleWords);
		
		goButton = new JButton("Go!");
		goButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				runApp();
			}
		});
		goButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		goButton.setBounds(168, 117, 89, 23);
		frame.getContentPane().add(goButton);
	}
}