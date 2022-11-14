import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.awt.Desktop;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;
import java.awt.Font;

public class HW8Main {

	private JFrame frame;
    private Inventory inventory;
    private File inventoryFile = new File("inventory.txt");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HW8Main window = new HW8Main();
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
	public HW8Main() {
        startInventory();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0,0, 300, 240);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(null);
		
		JButton fileButton = new JButton("Show Inventory");
		fileButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // On click, prompt user to select a file. Take selected file and send it to process()
				System.out.println("Clicked fileButton");
                try {
                    Desktop.getDesktop().open(inventoryFile);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
			}
		});
		fileButton.setBounds(50, 75, 200, 23);
		frame.getContentPane().add(fileButton);

        JButton addButton = new JButton("Add textbook");
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // On click, prompt user to select a file. Take selected file and send it to process()
				System.out.println("Clicked addButton");
                addTextbook();
			}
		});
		addButton.setBounds(50, 100, 200, 23);
		frame.getContentPane().add(addButton);

        JButton remButton = new JButton("Remove textbook");
		remButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // On click, prompt user to select a file. Take selected file and send it to process()
				System.out.println("Clicked remButton");
                removeTextbook();
			}
		});
		remButton.setBounds(50, 125, 200, 23);
		frame.getContentPane().add(remButton);

        JButton detButton = new JButton("Get textbook details");
		detButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) { // On click, prompt user to select a file. Take selected file and send it to process()
				System.out.println("Clicked detButton");
                getTextDetails();
			}
		});
		detButton.setBounds(50, 150, 200, 23);
		frame.getContentPane().add(detButton);
		
		JLabel lblIM = new JLabel("Inventory Management");
		lblIM.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIM.setBounds(60, 25, 200, 35);
		frame.getContentPane().add(lblIM);
	}

    /*
     * Window if an error occurs.
     */
    private void initError() {
        frame = new JFrame();
		frame.setBounds(100, 100, 100, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

        JLabel lblErrorlbl = new JLabel("An error has occured.");
		lblErrorlbl.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblErrorlbl.setBounds(10, 50, 100, 23);
		frame.getContentPane().add(lblErrorlbl);
    }
    /*
     * Upon app start, check if there is a new file. If a new file is not found, one is created. 
     */
    private void startInventory() {

        try {
            if(!inventoryFile.createNewFile()) {
                System.out.println("File found.");
                inventory = new Inventory(inventoryFile);
                initialize();
            } else {
                System.out.println("File not found. Making new one.");
                inventory = new Inventory(inventoryFile);
                initialize();
            }
        } catch (IOException e) {
            System.out.println("An error has occured.");
            e.printStackTrace();
            initError();
        }
    }
    /*
     * Function opens new frame to add a textbook to the inventory.
     */
    private void addTextbook() {
        JFrame addFrame = new JFrame();
        addFrame.setBounds(frame.getLocation().x + 10, frame.getLocation().y + 10, 350, 400);
		addFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addFrame.getContentPane().setLayout(null);
        addFrame.setVisible(true);

        JLabel addLabel = new JLabel("Add Textbook");
        addLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addLabel.setBounds(115, 10, 200, 23);
		addFrame.getContentPane().add(addLabel);

        JLabel detSKU = new JLabel("SKU");
        detSKU.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detSKU.setBounds(15, 50, 200, 23);
		addFrame.getContentPane().add(detSKU);

        JTextField skuField = new JTextField();
        skuField.setBounds(90, 50, 235, 23);
		addFrame.getContentPane().add(skuField);
		skuField.setColumns(10);

        JLabel detTitle = new JLabel("Title");
        detTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detTitle.setBounds(15, 95, 200, 23);
		addFrame.getContentPane().add(detTitle);

        JTextField titleField = new JTextField();
        titleField.setBounds(90, 95, 235, 23);
		addFrame.getContentPane().add(titleField);
		titleField.setColumns(10);

        JLabel detPrice = new JLabel("Price");
        detPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detPrice.setBounds(15, 140, 200, 23);
		addFrame.getContentPane().add(detPrice);

        JTextField priceField = new JTextField();
        priceField.setBounds(90, 140, 235, 23);
		addFrame.getContentPane().add(priceField);
		priceField.setColumns(10);

        JLabel detQty = new JLabel("Quantity");
        detQty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detQty.setBounds(15, 185, 200, 23);
		addFrame.getContentPane().add(detQty);

        JTextField qtyField = new JTextField();
        qtyField.setBounds(90, 185, 235, 23);
		addFrame.getContentPane().add(qtyField);
		qtyField.setColumns(10);

        JLabel addLabel2 = new JLabel("");
        addLabel2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		addLabel2.setBounds(100, 300, 200, 23);
		addFrame.getContentPane().add(addLabel2);

        JButton addButton = new JButton("Enter");
        addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked getDetButton");
                if(inventory.addTextbook(skuField.getText(), titleField.getText(), priceField.getText(), qtyField.getText())){
                    addLabel2.setText("Textbook added");
                } else {
                    addLabel2.setText("SKU already in inventory.");
                }
                
			}
		});
		addButton.setBounds(75, 230, 200, 23);
		addFrame.getContentPane().add(addButton);
    }
    /*
     * Function opens a new frame to remove a textbook from the inventory.
     */
    private void removeTextbook() {
        JFrame remFrame = new JFrame();
        remFrame.setBounds(frame.getLocation().x + 10, frame.getLocation().y + 10, 350, 240);
		remFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		remFrame.getContentPane().setLayout(null);
        remFrame.setVisible(true);

        JLabel remLabel = new JLabel("Remove Textbook");
        remLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		remLabel.setBounds(105, 10, 200, 23);
		remFrame.getContentPane().add(remLabel);

        JTextField remField = new JTextField("Enter SKU");
        remField.setBounds(15, 50, 320, 23);
		remFrame.getContentPane().add(remField);
		remField.setColumns(10);

        JLabel remLabel2 = new JLabel("");
        remLabel2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		remLabel2.setBounds(100, 150, 200, 23);
		remFrame.getContentPane().add(remLabel2);

        JButton remButton = new JButton("Enter");
		remButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked getDetButton");
                if(inventory.removeTextbook(remField.getText())) {
                    remLabel2.setText("Textbook removed.");
                } else {
                    remLabel2.setText("SKU not found.");
                }
			}
		});
		remButton.setBounds(75, 85, 200, 23);
		remFrame.getContentPane().add(remButton);
    }
    /*
     * Function gets a textbook's details with a given SKU.
     */
    private void getTextDetails() {
        JFrame detFrame = new JFrame();
        detFrame.setBounds(frame.getLocation().x + 10, frame.getLocation().y + 10, 350, 350);
		detFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		detFrame.getContentPane().setLayout(null);
        detFrame.setVisible(true);

        JLabel detLabel = new JLabel("Get Textbook Details");
        detLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detLabel.setBounds(90, 10, 200, 23);
		detFrame.getContentPane().add(detLabel);

        JTextField detField = new JTextField("Enter SKU");
        detField.setBounds(15, 50, 320, 23);
		detFrame.getContentPane().add(detField);
		detField.setColumns(10);

        JLabel detSKU = new JLabel("SKU");
        detSKU.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detSKU.setBounds(15, 130, 200, 23);
		detFrame.getContentPane().add(detSKU);

        JTextField skuField = new JTextField();
        skuField.setBounds(90, 130, 235, 23);
		detFrame.getContentPane().add(skuField);
		skuField.setColumns(10);

        JLabel detTitle = new JLabel("Title");
        detTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detTitle.setBounds(15, 175, 200, 23);
		detFrame.getContentPane().add(detTitle);

        JTextField titleField = new JTextField();
        titleField.setBounds(90, 175, 235, 23);
		detFrame.getContentPane().add(titleField);
		titleField.setColumns(10);

        JLabel detPrice = new JLabel("Price");
        detPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detPrice.setBounds(15, 220, 200, 23);
		detFrame.getContentPane().add(detPrice);

        JTextField priceField = new JTextField();
        priceField.setBounds(90, 220, 235, 23);
		detFrame.getContentPane().add(priceField);
		priceField.setColumns(10);

        JLabel detQty = new JLabel("Quantity");
        detQty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		detQty.setBounds(15, 265, 200, 23);
		detFrame.getContentPane().add(detQty);

        JTextField qtyField = new JTextField();
        qtyField.setBounds(90, 265, 235, 23);
		detFrame.getContentPane().add(qtyField);
		qtyField.setColumns(10);

        JButton getDetButton = new JButton("Enter");
		getDetButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.out.println("Clicked getDetButton");
                String[] detArray = inventory.getTextDetails(detField.getText());
                if(detArray != null) {
                    skuField.setText(detArray[0]);
                    titleField.setText(detArray[1]);
                    priceField.setText(detArray[2]);
                    qtyField.setText((detArray[3]));
                } else {
                    skuField.setText("SKU not found.");
                    titleField.setText("");
                    priceField.setText("");
                    qtyField.setText("");
                }
			}
		});
		getDetButton.setBounds(75, 85, 200, 23);
		detFrame.getContentPane().add(getDetButton);
    }
}