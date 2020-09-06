package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.*;
public class second extends JFrame {

	private JPanel contentPane;
	private JTextField qno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					second frame = new second();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection con=null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTextField ans;
	
	

	/**
	 * Create the frame.
	 */
	
	public second() {
		con = connection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome To Quiz");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(48, 11, 274, 32);
		contentPane.add(lblNewLabel);
		
		final JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String sql="Select question from quiz where qno='"+qno.getText()+"'";
					PreparedStatement pst=con.prepareStatement(sql);
					ResultSet rs=pst.executeQuery(sql);
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					String sql1="Select opt1,opt2 from quiz where qno='"+qno.getText()+"'";
					PreparedStatement pst1=con.prepareStatement(sql1);
					ResultSet rs1=pst.executeQuery(sql1);
					table_1.setModel(DbUtils.resultSetToTableModel(rs1));
					
					String sql2="Select opt3,opt4 from quiz where qno='"+qno.getText()+"'";
					PreparedStatement pst2=con.prepareStatement(sql2);
					ResultSet rs2=pst.executeQuery(sql2);
					table_2.setModel(DbUtils.resultSetToTableModel(rs2));
					
					con.close();
				}catch(Exception ex) {System.out.print(ex);}
			}
		});
		btnNewButton.setBounds(166, 42, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Enter the QNO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(214, 197, 89, 23);
		contentPane.add(lblNewLabel_1);
		
		qno = new JTextField();
		qno.setBounds(313, 198, 58, 23);
		contentPane.add(qno);
		qno.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 414, 38);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 103, 414, 38);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 148, 414, 38);
		contentPane.add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JLabel lblNewLabel_2 = new JLabel("Enter your Answer");
		lblNewLabel_2.setBounds(10, 201, 118, 19);
		contentPane.add(lblNewLabel_2);
		
		ans = new JTextField();
		ans.setBounds(138, 198, 66, 20);
		contentPane.add(ans);
		ans.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("SAVE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int score=0;
				String qno1=qno.getText();
				String ans1=ans.getText();
				int q1=Integer.parseInt(qno1);
				int a1=Integer.parseInt(ans1);
				if(q1==1 && a1==2)
					score=score+1;
				else if(q1==2 && a1==1)
					score=score+1;
				else
					score=score+0;
				
			}
		});
		btnNewButton_1.setBounds(166, 227, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
