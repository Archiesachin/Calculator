import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Calculator implements ActionListener{
	
	JFrame frame = new JFrame("CALCULATOR");
	JTextField textfield;
	JButton [] numButtons = new JButton[10];
	JButton [] funButtons = new JButton[8];
	JButton addButton, subButton, mulButton, divButton, decButton, eqlButton, delButton, clrButton;
	JPanel panel;
	
	double num1 = 0, num2=0, result=0;
	char operations;
	

	
	Calculator(){
		
		frame.setSize(300,400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setResizable(false);
		
		textfield = new JTextField();
		textfield.setBounds(0, 25, 400 ,75);
		textfield.setEditable(false);
		frame.add(textfield);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("x");
		divButton = new JButton("/");
		decButton = new JButton(".");
		eqlButton = new JButton("=");
		delButton = new JButton("DEL");
		clrButton = new JButton("CLR");
		
		
		funButtons[0] = addButton;
		funButtons[1] = subButton;
		funButtons[2] = mulButton;
		funButtons[3] = divButton;
		funButtons[4] = decButton;
		funButtons[5] = eqlButton;
		funButtons[6] = delButton;
		funButtons[7] = clrButton;
		
		for(int i = 0; i<8; i++) {
			funButtons[i].addActionListener(this);
			funButtons[i].setFocusable(false);
			
		}
		
		for(int i = 0; i<10; i++) {
			numButtons[i] = new JButton(String.valueOf(i));
			numButtons[i].addActionListener(this);
			numButtons[i].setFocusable(false);
	
		}
		
		
		delButton.setBounds(47,300,75,35);
		clrButton.setBounds(160,300,75,35);
		
	
		
		panel = new JPanel();
		panel.setBounds(45, 125, 200, 150 );
		panel.add(numButtons[1]);
		panel.add(numButtons[2]);
		panel.add(numButtons[3]);
		panel.add(addButton);
		panel.add(numButtons[4]);
		panel.add(numButtons[5]);
		panel.add(numButtons[6]);
		panel.add(subButton);
		panel.add(numButtons[7]);
		panel.add(numButtons[8]);
		panel.add(numButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numButtons[0]);
		panel.add(eqlButton);
		panel.add(divButton);
		panel.setLayout(new GridLayout(4,4,5,2));
		
		
		
		
		
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		new Calculator(); 
		
		

	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i = 0; i<10; i++){
			if(e.getSource() == numButtons[i]){
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
				
			}
		}
		if(e.getSource() == decButton){
			textfield.setText(textfield.getText().concat("."));
			
		}
		if(e.getSource() == addButton){
			num1= Double.parseDouble(textfield.getText());
			operations='+';
			textfield.setText("");
			
		}
		if(e.getSource() == subButton){
			num1= Double.parseDouble(textfield.getText());
			operations='-';
			textfield.setText("");
			
		}
		if(e.getSource() == mulButton){
			num1= Double.parseDouble(textfield.getText());
			operations='x';
			textfield.setText("");
			
		}
		if(e.getSource() == divButton){
			num1= Double.parseDouble(textfield.getText());
			operations='/';
			textfield.setText("");
			
		}
		if(e.getSource()==eqlButton) {
			num2=Double.parseDouble(textfield.getText());
			
			switch(operations){
				case'+':
				result=num1 + num2;
				break;
				
				case'-':
				result = num1 - num2;
				break;
				
				case'x':
				result = num1 * num2;
				break;
				
				case'/':
				result = num1 / num2;
				break;
	
			}
			textfield.setText(String.valueOf(result));
			num1=result;
			
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i=0;i<string.length()-1;i++) {
				textfield.setText(textfield.getText()+string.charAt(i));
			}
		}
			
		
	}

}