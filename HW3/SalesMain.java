package HW3;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalesMain {

	private JFrame frame;
	private JTextField itemField;
	private JTextField quantField;
	private JTextField costField;
	private JTextField totalField;
	private JTextArea listArea;
	private SalesSlip slip = new SalesSlip();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SalesMain window = new SalesMain();
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
	public SalesMain() {
		initialize();
		
	}
	
	public void runApp() {
		slip.addItem(itemField.getText(), costField.getText(), quantField.getText());
		listArea.setText(slip.toString());
		totalField.setText(slip.totalSales() + "");
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Sales List");
		title.setFont(new Font("Tahoma", Font.PLAIN, 30));
		title.setBounds(150, 11, 123, 37);
		frame.getContentPane().add(title);
		
		JLabel lblNewLabel = new JLabel("Item: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(94, 65, 46, 19);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cost: $");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(94, 100, 59, 19);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Quantity");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(94, 135, 59, 19);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton addButton = new JButton("Add item to the Sales List");
		addButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				runApp();
			}
		});
		addButton.setBounds(107, 178, 229, 23);
		frame.getContentPane().add(addButton);
		
		itemField = new JTextField();
		itemField.setBounds(183, 66, 170, 20);
		frame.getContentPane().add(itemField);
		itemField.setColumns(10);
		
		quantField = new JTextField();
		quantField.setBounds(183, 136, 170, 20);
		frame.getContentPane().add(quantField);
		quantField.setColumns(10);
		
		costField = new JTextField();
		costField.setBounds(183, 101, 170, 20);
		frame.getContentPane().add(costField);
		costField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Total Sales: $");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(120, 320, 90, 19);
		frame.getContentPane().add(lblNewLabel_3);
		
		totalField = new JTextField();
		totalField.setBounds(219, 321, 100, 20);
		frame.getContentPane().add(totalField);
		totalField.setColumns(10);
		
		listArea = new JTextArea();
		listArea.setBounds(74, 215, 300, 94);
		frame.getContentPane().add(listArea);
	}

}
