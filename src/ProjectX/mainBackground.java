package ProjectX;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class mainBackground {

	private JFrame frame;
	private JTextField txtTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainBackground window = new mainBackground();
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
	public mainBackground() {
		initialize();
	}
	
	private double[] getNumbers(String s)
	{
		double[] numbers = new double[12];
		int index = 0;
		double nr;
		StringBuilder numb = new StringBuilder("");
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || 
					s.charAt(i) == '*')
			{
				if(numb.isEmpty() == false)
				{
					nr = Double.parseDouble(numb.toString());
					index++;
					numbers[index] = nr;
					numb.delete(0, numb.length());
				}
				else numb.append(s.charAt(i));
			}
			else numb.append(s.charAt(i));
		}
		nr = Double.parseDouble(numb.toString());
		index++;
		numbers[index] = nr;
		numb.delete(0, numb.length());
		numbers[0] = index;
		return numbers;
	}
	private char[] getSigns(String s)
	{
		char[] signs = new char[12];
		int index = 0;
		for(int i = 0; i < s.length(); i++)
		{
			if(s.charAt(i) == '+' || s.charAt(i) == '-' || s.charAt(i) == '/' || 
					s.charAt(i) == '*')
			{
				if(i != 0)
					signs[++index] = s.charAt(i);
			}
		}
		signs[0] = (char) index;
		return signs;
	}
	
	private double compute(String s)
	{
		double rez = 0;
		double[] numbers = new double[12];
		char[] signs = new char[11];
		numbers = getNumbers(s);
		signs = getSigns(s);
		int nrNumbers = (int)numbers[0];
		int nrSigns = (int)signs[0];
		
		int isSign = 1;
		while(isSign == 1)
		{
			isSign = 0;
			for(int i=1; i<=nrSigns;i++)
			{
				int ok = 0;
				if(signs[i] == '*')
				{
					isSign = 1;
					ok = 1;
					numbers[i] *= numbers[i+1];
				}
				else if(signs[i] == '/')
				{
					ok=1;
					isSign = 1;
					numbers[i] /= numbers[i+1];
				}
				if(ok == 1)
				{
					//if(signs[i+1] == '*' || signs[i+1] == '/')
					//{
						for(int k = i ; k<=nrSigns+1; k++)
						{
							signs[k]=signs[k+1];
						}
						for(int k = i + 1; k<=nrSigns+1; k++)
						{
							numbers[k]=numbers[k+1];
						}
					//}
					//else 
					//	for(int j = i +1; j<=nrSigns+1; j++)
						//{
					//		signs[j]=signs[j+1];
					//		numbers[j]=numbers[j+1];
						//}
					//numbers[nrSigns] = numbers[nrSigns] + 1;
					nrNumbers--;
					nrSigns--;
					if(signs[i+1] == '*' || signs[i+1] == '/')
						i--;
				}
			}
		}
		while(nrSigns!=0)
		{	
			int i=1;
			for(int x=1; x<=nrSigns;x++)
			{
				System.out.println(signs[x]);
			}
			for(int x=1; x<=nrNumbers;x++)
			{
				System.out.println(numbers[x]);
			}
			System.out.println("");
				int ok = 0;
				if(signs[i] == '+')
				{
					ok = 1;
					numbers[i] += numbers[i+1];
				}
				else if(signs[i] == '-')
				{
					ok=1;
					numbers[i] -= numbers[i+1];
				}
				if(ok == 1)
				{
					for(int j = i+1; j<=nrSigns; j++)
					{
						signs[j-1]=signs[j];
						numbers[j]=numbers[j+1];
					}
					nrSigns--;
					nrNumbers--;
				}
			
		}
		rez = numbers[1];
		return rez;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.setTitle("Calculator by Alex");
		frame.setResizable(false);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btn1 = new JButton("1");
		btn1.setFocusTraversalKeysEnabled(false);
		btn1.setFocusable(false);
		btn1.setBorder(null);
		btn1.setForeground(new Color(0, 153, 255));
		btn1.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "1");
			}
		});
		btn1.setBackground(new Color(51, 51, 51));
		btn1.setBounds(24, 167, 57, 57);
		panel.add(btn1);
		
		JButton btn4 = new JButton("4");
		btn4.setFocusTraversalKeysEnabled(false);
		btn4.setFocusable(false);
		btn4.setBorder(null);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "4");
			}
		});
		btn4.setForeground(new Color(0, 153, 255));
		btn4.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn4.setBackground(new Color(51, 51, 51));
		btn4.setBounds(24, 235, 57, 57);
		panel.add(btn4);
		
		JButton btn2 = new JButton("2");
		btn2.setFocusTraversalKeysEnabled(false);
		btn2.setFocusable(false);
		btn2.setBorder(null);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "2");
			}
		});
		btn2.setForeground(new Color(0, 153, 255));
		btn2.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn2.setBackground(new Color(51, 51, 51));
		btn2.setBounds(91, 167, 57, 57);
		panel.add(btn2);
		
		JButton btn5 = new JButton("5");
		btn5.setFocusTraversalKeysEnabled(false);
		btn5.setFocusable(false);
		btn5.setBorder(null);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "5");
			}
		});
		btn5.setForeground(new Color(0, 153, 255));
		btn5.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn5.setBackground(new Color(51, 51, 51));
		btn5.setBounds(91, 234, 57, 57);
		panel.add(btn5);
		
		JButton btn3 = new JButton("3");
		btn3.setFocusTraversalKeysEnabled(false);
		btn3.setFocusable(false);
		btn3.setBorder(null);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "3");
			}
		});
		btn3.setForeground(new Color(0, 153, 255));
		btn3.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn3.setBackground(new Color(51, 51, 51));
		btn3.setBounds(158, 167, 57, 57);
		panel.add(btn3);
		
		JButton btn6 = new JButton("6");
		btn6.setFocusTraversalKeysEnabled(false);
		btn6.setFocusable(false);
		btn6.setBorder(null);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "6");
			}
		});
		btn6.setForeground(new Color(0, 153, 255));
		btn6.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn6.setBackground(new Color(51, 51, 51));
		btn6.setBounds(158, 234, 57, 57);
		panel.add(btn6);
		
		JButton btn7 = new JButton("7");
		btn7.setFocusTraversalKeysEnabled(false);
		btn7.setFocusable(false);
		btn7.setBorder(null);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "7");
			}
		});
		btn7.setForeground(new Color(0, 153, 255));
		btn7.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn7.setBackground(new Color(51, 51, 51));
		btn7.setBounds(24, 303, 57, 57);
		panel.add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFocusTraversalKeysEnabled(false);
		btn8.setFocusable(false);
		btn8.setBorder(null);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "8");
			}
		});
		btn8.setForeground(new Color(0, 153, 255));
		btn8.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn8.setBackground(new Color(51, 51, 51));
		btn8.setBounds(91, 302, 57, 57);
		panel.add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFocusTraversalKeysEnabled(false);
		btn9.setFocusable(false);
		btn9.setBorder(null);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "9");
			}
		});
		btn9.setForeground(new Color(0, 153, 255));
		btn9.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn9.setBackground(new Color(51, 51, 51));
		btn9.setBounds(158, 302, 57, 57);
		panel.add(btn9);
		
		JButton btn0 = new JButton("0");
		btn0.setFocusTraversalKeysEnabled(false);
		btn0.setFocusable(false);
		btn0.setBorder(null);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTest.getText().length()<21)
					txtTest.setText(txtTest.getText() + "0");
			}
		});
		btn0.setForeground(new Color(0, 153, 255));
		btn0.setFont(new Font("Arial Black", Font.BOLD, 30));
		btn0.setBackground(new Color(51, 51, 51));
		btn0.setBounds(24, 370, 57, 57);
		panel.add(btn0);
		
		txtTest = new JTextField();
		txtTest.setBorder(null);
		txtTest.setForeground(new Color(255, 69, 0));
		txtTest.setBackground(Color.DARK_GRAY);
		txtTest.setDisabledTextColor(new Color(204, 204, 204));
		txtTest.setFocusable(false);
		txtTest.setFocusTraversalKeysEnabled(false);
		txtTest.setEditable(false);
		txtTest.setFont(new Font("Arial Black", Font.BOLD, 28));
		txtTest.setText("");
		txtTest.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTest.setBounds(24, 19, 258, 57);
		panel.add(txtTest);
		txtTest.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 255));
		panel_1.setBorder(null);
		panel_1.setBounds(0, 87, 501, 1);
		panel.add(panel_1);
		
		JButton btnC = new JButton("C");
		btnC.setFocusTraversalKeysEnabled(false);
		btnC.setFocusable(false);
		btnC.setBorder(null);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtTest.setText("");
			}
		});
		btnC.setForeground(new Color(0, 153, 255));
		btnC.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnC.setBackground(new Color(51, 51, 51));
		btnC.setBounds(24, 99, 57, 57);
		panel.add(btnC);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFocusTraversalKeysEnabled(false);
		btnPlus.setFocusable(false);
		btnPlus.setBorder(null);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtTest.getText();
				int length = text.length()-1;
				if(txtTest.getText().length()<21 && length>=0)
				{
					if(text.charAt(length) != '+' && text.charAt(length) != '-' && text.charAt(length) != '.' 
						&& text.charAt(length) != '*' && text.charAt(length) != '/'  )
					txtTest.setText(txtTest.getText() + "+");
					else
					{
						if(length > 0)
						{
							StringBuilder back = new StringBuilder(txtTest.getText());
							back.deleteCharAt(length);
							back.append("+");
							txtTest.setText(back.toString());
						}
					}
				}
			}
		});
		btnPlus.setForeground(new Color(0, 153, 255));
		btnPlus.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnPlus.setBackground(new Color(51, 51, 51));
		btnPlus.setBounds(225, 167, 57, 124);
		panel.add(btnPlus);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFocusTraversalKeysEnabled(false);
		btnMinus.setFocusable(false);
		btnMinus.setBorder(null);
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtTest.getText();
				int length = text.length()-1;
				if(txtTest.getText().length()<21 && txtTest.getText().length() != 0)
				{
					if(text.charAt(length) != '+' && text.charAt(length) != '-' && text.charAt(length) != '.' 
							&& text.charAt(length) != '*' && text.charAt(length) != '/'  )
						txtTest.setText(txtTest.getText() + "-");
					else
					{
						if(length > 0)
						{
							StringBuilder back = new StringBuilder(txtTest.getText());
							back.deleteCharAt(length);
							back.append("-");
							txtTest.setText(back.toString());
						}
					}
				}
				else if(txtTest.getText().length() == 0)
					txtTest.setText(txtTest.getText() + "-");
			}
		});
		btnMinus.setForeground(new Color(0, 153, 255));
		btnMinus.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnMinus.setBackground(new Color(51, 51, 51));
		btnMinus.setBounds(225, 302, 57, 57);
		panel.add(btnMinus);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFocusTraversalKeysEnabled(false);
		btnEqual.setFocusable(false);
		btnEqual.setBorder(null);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result;
				result = txtTest.getText();
				int length = result.length() - 1;
				if(result.charAt(length) == '+' || result.charAt(length) == '-' || 
						result.charAt(length) == '/' || result.charAt(length) == '*' || result.charAt(length) == '.')
				{
					result = "";
					JOptionPane.showMessageDialog(frame,"Format Invalid!");
					txtTest.setText(result);
				}
				else
				{
					Double rezultat;
					rezultat = compute(result);
					Integer a = rezultat.intValue();
					if(rezultat == rezultat.intValue())
						result = a.toString();
					else result = rezultat.toString();
					txtTest.setText(result);
				}
			}
		});
		btnEqual.setForeground(new Color(0, 153, 255));
		btnEqual.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnEqual.setBackground(new Color(51, 51, 51));
		btnEqual.setBounds(158, 370, 124, 57);
		panel.add(btnEqual);
		
		JButton btnPoint = new JButton(".");
		btnPoint.setFocusTraversalKeysEnabled(false);
		btnPoint.setFocusable(false);
		btnPoint.setBorder(null);
		btnPoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtTest.getText();
				int length = text.length()-1;
				if(length<21)
				{ 
					if(text.charAt(length) != '+' && text.charAt(length) != '-' && text.charAt(length) != '.' 
						&& text.charAt(length) != '*' && text.charAt(length) != '/'  )
						{
						int ok = 1;
							for(int i = length-1; i > 0 ; i--)
							{
								if(text.charAt(i) == '+' || text.charAt(i) == '-' ||  text.charAt(i) == '*' ||
										text.charAt(i) == '/')
									break;
								if(text.charAt(i) == '.')
								{
									ok = 0; 
									break;
								}
							}
							if(ok == 1)
								txtTest.setText(txtTest.getText() + ".");
						}
					else
					{
						if(length > 0)
						{
							int ok = 1;
							for(int i = length-1; i > 0 ; i--)
							{
								if(text.charAt(i) == '+' || text.charAt(i) == '-' ||  text.charAt(i) == '*' ||
										text.charAt(i) == '/')
									break;
								if(text.charAt(i) == '.')
								{
									ok = 0; 
									break;
								}
							}
							if(ok == 1)
							{
								StringBuilder back = new StringBuilder(txtTest.getText());
								back.deleteCharAt(length);
								back.append(".");
								txtTest.setText(back.toString());
							}
						}
					}
				}
			}
		});
		btnPoint.setForeground(new Color(0, 153, 255));
		btnPoint.setFont(new Font("Arial Black", Font.BOLD, 30));
		btnPoint.setBackground(new Color(51, 51, 51));
		btnPoint.setBounds(91, 370, 57, 57);
		panel.add(btnPoint);
		
		JButton btnAC = new JButton("AC");
		btnAC.setFocusTraversalKeysEnabled(false);
		btnAC.setFocusable(false);
		btnAC.setBorder(null);
		btnAC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int number = txtTest.getText().length() - 1;
				int length = number + 1;
				if(length > 0)
				{
					StringBuilder back = new StringBuilder(txtTest.getText());
					back.deleteCharAt(number);
					txtTest.setText(back.toString());
				}
			}
		});
		btnAC.setForeground(new Color(0, 153, 255));
		btnAC.setFont(new Font("Arial Black", Font.BOLD, 14));
		btnAC.setBackground(new Color(51, 51, 51));
		btnAC.setBounds(91, 99, 57, 57);
		panel.add(btnAC);
		
		JButton btnMul = new JButton("*");
		btnMul.setFocusTraversalKeysEnabled(false);
		btnMul.setFocusable(false);
		btnMul.setBorder(null);
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtTest.getText();
				int length = text.length()-1;
				if(txtTest.getText().length()<21)
				{
					if(text.charAt(length) != '+' && text.charAt(length) != '-' && text.charAt(length) != '.' 
						&& text.charAt(length) != '*' && text.charAt(length) != '/'  )
					txtTest.setText(txtTest.getText() + "*");
					else
					{
						if(length > 0)
						{
							StringBuilder back = new StringBuilder(txtTest.getText());
							back.deleteCharAt(length);
							back.append("*");
							txtTest.setText(back.toString());
						}
					}
				}
			}
		});
		btnMul.setForeground(new Color(0, 153, 255));
		btnMul.setFont(new Font("Arial Black", Font.BOLD, 35));
		btnMul.setBackground(new Color(51, 51, 51));
		btnMul.setBounds(158, 99, 57, 57);
		panel.add(btnMul);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFocusTraversalKeysEnabled(false);
		btnDiv.setFocusable(false);
		btnDiv.setBorder(null);
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String text = txtTest.getText();
				int length = text.length()-1;
				if(txtTest.getText().length()<21)
				{
					if(text.charAt(length) != '+' && text.charAt(length) != '-' && text.charAt(length) != '.' 
							&& text.charAt(length) != '*' && text.charAt(length) != '/'  )
						txtTest.setText(txtTest.getText() + "/");
					else
					{
						if(length > 0)
						{
							StringBuilder back = new StringBuilder(txtTest.getText());
							back.deleteCharAt(length);
							back.append("/");
							txtTest.setText(back.toString());
						}
					}
				}
			}
		});
		btnDiv.setForeground(new Color(0, 153, 255));
		btnDiv.setFont(new Font("Arial Black", Font.BOLD, 28));
		btnDiv.setBackground(new Color(51, 51, 51));
		btnDiv.setBounds(225, 99, 57, 57);
		panel.add(btnDiv);
		frame.setBounds(100, 100, 317, 487);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
