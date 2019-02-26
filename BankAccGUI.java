import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BankAccGUI extends JFrame
{
	private ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
	public BankAccGUI() 
	{
	//Title
		setTitle("Bank Account");
		setBounds(100,100,600,400);
		setLayout(null);	
		
	// Name label
		JLabel name = new JLabel("Name: ");
		name.setBounds(20,20,100,30);
		add(name);
		
	// Name field
		JTextField nameField = new JTextField("");
		nameField.setBounds(120,20,100,30);
		add(nameField);
		
	//Account type label
		JLabel type = new JLabel("Account Type: ");
		type.setBounds(20,60,100,30);
		add(type);
		
	//Checkings or Savings
		String[] typeList = {"", "Checkings", "Savings"};
		JComboBox typeBox = new JComboBox(typeList);
		typeBox.setBounds(120, 60, 100, 30);
		add(typeBox);
		
	//Balance label
		JLabel balance = new JLabel("Initial Balance: ");
		balance.setBounds(20,100, 100, 30);
		add(balance);
		
	//Balance field 
		JTextField balanceField = new JTextField("");
		balanceField.setBounds(120,100,100,30);
		add(balanceField);
		
	//Create Button
		JButton create = new JButton("Create Account");
		create.setBounds(20, 150, 150, 30);
		add(create);
		create.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						String name = nameField.getText();
						Double bal = Double.parseDouble(balanceField.getText());
						if(typeBox.getSelectedItem().equals("Checking")) 
						{
							BankAccount checkAcc = new CheckingAccount(name,bal,15,1.5,10);
							accounts.add(checkAcc);
						}
						else if(typeBox.getSelectedItem().equals("Savings")) 
						{
							BankAccount saveAcc = new SavingsAccount(name,bal,.0025,300,10);
							accounts.add(saveAcc);
						}
						
					}
				});
		
	//Display button
		JButton display = new JButton("Display All Accounts");
		display.setBounds(200, 150, 150, 30);
		add(display);
		display.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent a) 
					{
						for(BankAccount x: accounts) 
						{
							System.out.println(accounts.toString());
						}
					}
				});
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	public static void main(String[] args) 
	{
		new BankAccGUI();
	}
}
