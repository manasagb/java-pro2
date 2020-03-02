package man;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class Frame1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame1 window = new Frame1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Connection conn=null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JRadioButton opt1;
	private JRadioButton opt2;
	private JRadioButton opt3;
	private JRadioButton opt4;
	/**
	 * Create the application.
	 */
	public Frame1() {
		conn=connection.dbConnector();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 442);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
				
					String query="select Question from quiz where Qno=1";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(299, 9, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(41, 57, 625, 37);
		frame.getContentPane().add(table);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(41, 54, 625, 40);
		frame.getContentPane().add(scrollPane);
		
		JButton btnNewButton_1 = new JButton("Options");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query="select opt1,opt2,opt3,opt4 from quiz where Qno=1";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_1.setBounds(299, 115, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		table_2 = new JTable();
		table_2.setBounds(41, 176, 625, 23);
		frame.getContentPane().add(table_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(43, 176, 623, 23);
		frame.getContentPane().add(scrollPane_1);
		
		JButton btnNewButton_opt1 = new JButton("");
		scrollPane_1.setRowHeaderView(btnNewButton_opt1);
		
		opt1 = new JRadioButton("1");
		opt1.setFont(new Font("Tahoma", Font.BOLD, 14));
		opt1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 
					if(opt1.isSelected())
					{
						opt2.setSelected(false);
						opt3.setSelected(false);
						opt4.setSelected(false);
					}
					String query="select opt1 from quiz where Qno=1";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		opt1.setBounds(41, 206, 109, 23);
		frame.getContentPane().add(opt1);
		
		opt2 = new JRadioButton("2");
		opt2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try { 
	if(opt2.isSelected())
	{
		opt1.setSelected(false);
		opt3.setSelected(false);
		opt4.setSelected(false);
	}
					String query="select opt2 from quiz where Qno=1";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		opt2.setFont(new Font("Tahoma", Font.BOLD, 14));
		opt2.setBounds(205, 206, 109, 23);
		frame.getContentPane().add(opt2);
		
		opt3 = new JRadioButton("3");
		opt3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try { 
	if(opt3.isSelected())
	{
		opt2.setSelected(false);
		opt1.setSelected(false);
		opt4.setSelected(false);
	}		
					String query="select opt3 from quiz where Qno=1";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		opt3.setFont(new Font("Tahoma", Font.BOLD, 14));
		opt3.setBounds(369, 208, 109, 23);
		frame.getContentPane().add(opt3);
		
		opt4 = new JRadioButton("4");
		opt4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
try { 
	if(opt4.isSelected())
	{
		opt2.setSelected(false);
		opt3.setSelected(false);
		opt1.setSelected(false);
	}
					
					String query="select opt4 from quiz where Qno=1";
					PreparedStatement pst=conn.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_2.setModel(DbUtils.resultSetToTableModel(rs));
				
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}
		});
		opt4.setFont(new Font("Tahoma", Font.BOLD, 14));
		opt4.setBounds(557, 206, 109, 23);
		frame.getContentPane().add(opt4);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					btnNewButton.setEnabled(false);
					if(opt1.isSelected()==false && opt2.isSelected()==false && opt3.isSelected()==false && opt4.isSelected()==false)
					{
						JOptionPane.showMessageDialog(null, "Please enter answer");
					}
					else
					{
						opt1.setSelected(false);
						opt2.setSelected(false);
						opt3.setSelected(false);
						opt4.setSelected(false);
						String query="select Question from quiz where Qno=2";
						PreparedStatement pst=conn.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
				

						String query1="select opt1,opt2,opt3,opt4 from quiz where Qno=2";
						PreparedStatement pst1=conn.prepareStatement(query1);
						ResultSet rs1=pst1.executeQuery();
					
						table_2.setModel(DbUtils.resultSetToTableModel(rs1));
					
					
					}
					}
				 catch (Exception ex){
					ex.printStackTrace();
				}
			}});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD, 12));
		btnNewButton_2.setBounds(299, 292, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
	}
}
