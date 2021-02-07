package com.java.todolist;


import java.awt.Font;
//import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.InputMismatchException;

import javax.swing.*;


public class GUI extends ToDoList{
	private static int j = 0;
	JFrame f;  
	JPanel p1;
	JPanel p2;
	JPanel p3;
	JPanel p4;
	JPanel p5;
	JPanel p6;
	JPanel p7;
	
    private JLabel name; 
    private JLabel nname; 
    private JTextField tname2;
    private JTextField ntname2; 
    private JTextField tname3;
    private JTextField tname4;
    private JTextField tname5;
    private JTextField enam5;
    private JTextField tname6;
    
    private JLabel ename; 
    private JLabel disname;
   
    private JTextField enamee;
    private JTextField ttname;
    
//    private JTextField enam; 
    private JLabel ddate; 
    private JLabel mdate; 
//    @SuppressWarnings("rawtypes")
	private JFormattedTextField dates; 
	private JTextField date; 
//    @SuppressWarnings("rawtypes")
//	private JComboBox month; 
//    @SuppressWarnings("rawtypes")
//	private JComboBox year;    
	private JButton viewList;
    private JButton addt;
    private JButton rename; 
    private JButton modify; 
    private JButton remove; 
    private JButton assign; 
    private JButton reset; 
    private JButton isdone; 
    
    ToDoList obj = new ToDoList("Life");
    ToDoListDAO dao = new ToDoListDAO();
    
//    private String dates[] 
//            = { "1", "2", "3", "4", "5", 
//                "6", "7", "8", "9", "10", 
//                "11", "12", "13", "14", "15", 
//                "16", "17", "18", "19", "20", 
//                "21", "22", "23", "24", "25", 
//                "26", "27", "28", "29", "30", 
//                "31" }; 
//        private String months[] 
//            = { "Jan", "Feb", "Mar", "Apr", 
//                "May", "Jun", "July", "Aug", 
//                "Sup", "Oct", "Nov", "Dec" }; 
//        private String years[] 
//            = { "2020", "2021", "2022","2023"};
	

	GUI(){  
		
        
	    f=new JFrame();   
	    p1 = new JPanel();  
	    p2=new JPanel(); 
	    p3=new JPanel(); 
	    p4=new JPanel(); 
	    p5=new JPanel(); 
	    p6=new JPanel(); 
	    p7=new JPanel(); 
	    
	    //rename ,remove , modify deadline, assign, mark as done view list
	    JTabbedPane tp = new JTabbedPane();  
	    tp.setBounds(40,40,700,350);  
	    tp.add("Add Task",p1);  
	    tp.add("Rename Task",p2); 
	    tp.add("Remove Task",p3); 
	    tp.add("Modify Deadline",p4); 
	    tp.add("Assign Task",p5); 
	    tp.add("Mark as Done",p6); 
	    tp.add("View Task List",p7); 
	    addTask();
	    renameTask();
	    removeTask();
	    modifyDeadline();
	    assignTask();
	    markAsDone();
	    viewTaskList();
	    f.add(tp);  
	    f.setSize(800,480);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	}
	public void addTask() {
		p1.setLayout(null); 
		  
        name = new JLabel("Enter Task Name: "); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(500, 20); 
        name.setLocation(50, 30); 
        p1.add(name); 
  
        ttname = new JTextField(); 
        ttname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        ttname.setSize(250, 30); 
        ttname.setLocation(275, 25);
        p1.add(ttname); 
  
        ename = new JLabel("Enter Employee Name: "); 
        ename.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ename.setSize(250, 20); 
        ename.setLocation(50, 75); 
        p1.add(ename); 
  
        enamee = new JTextField(); 
        enamee.setFont(new Font("Arial", Font.PLAIN, 15)); 
        enamee.setSize(250, 30); 
        enamee.setLocation(275, 70); 
        p1.add(enamee); 
  
        ddate = new JLabel("Enter Task Deadline: "); 
        ddate.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ddate.setSize(250, 20); 
        ddate.setLocation(50, 125); 
        p1.add(ddate); 
        
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        
        dates = new JFormattedTextField(format); 
        dates.setFont(new Font("Arial", Font.PLAIN, 15)); 
        dates.setSize(250, 30); 
        dates.setLocation(275, 125); 
        p1.add(dates); 
        
//        System.out.println(dates);
        
  
        
//        date = new JComboBox(dates); 
//        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
//        date.setSize(50, 20); 
//        date.setLocation(275, 125); 
//        p1.add(date); 
//  
//        month = new JComboBox(months); 
//        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
//        month.setSize(60, 20); 
//        month.setLocation(330, 125); 
//        p1.add(month); 
//  
//        year = new JComboBox(years); 
//        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
//        year.setSize(60, 20); 
//        year.setLocation(400, 125); 
//        p1.add(year); 
 
        addt = new JButton("Add Task"); 
        addt.setFont(new Font("Arial", Font.PLAIN, 15)); 
        addt.setSize(150, 20); 
        addt.setLocation(150, 175); 
        addt.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {

        				try {
        					Task t = new Task(ttname.getText(),dates.getText(),enamee.getText());
							dao.addTask(t);
							JOptionPane.showMessageDialog(f, "task added successfully");
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        		); 
        p1.add(addt); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(300, 175); 
        //reset.addActionListener(this); 
        p1.add(reset); 
  

		
	}
	public void renameTask() {
		p2.setLayout(null);
		
        name = new JLabel("Enter Task Name: "); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(500, 20); 
        name.setLocation(50, 30); 
        p2.add(name); 
  
        tname2 = new JTextField(); 
        tname2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname2.setSize(250, 30); 
        tname2.setLocation(275, 25);
        p2.add(tname2); 
  
        nname = new JLabel("Enter New Task Name: "); 
        nname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        nname.setSize(250, 20); 
        nname.setLocation(50, 75); 
        p2.add(nname); 
  
        ntname2 = new JTextField(); 
		ntname2.setFont(new Font("Arial", Font.PLAIN, 15)); 
        ntname2.setSize(250, 30); 
        ntname2.setLocation(275, 70); 
        p2.add(ntname2); 
        
        rename = new JButton("Rename Task"); 
        rename.setFont(new Font("Arial", Font.PLAIN, 15)); 
        rename.setSize(150, 20); 
        rename.setLocation(150, 175); 
        rename.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
//        				renameTask(tname2.getText(), ntname2.getText());
//        				JOptionPane.showMessageDialog(f, "task renamed successfully");
        				try {
							dao.renameTask(tname2.getText(), ntname2.getText());
							JOptionPane.showMessageDialog(f, "task renamed successfully");
						} catch (ClassNotFoundException | SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        		); 
        p2.add(rename); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(300, 175); 
        //reset.addActionListener(this); 
        p2.add(reset); 
         
	}
	public void removeTask() {
		p3.setLayout(null); 
		
		name = new JLabel("Enter Task Name: "); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(500, 20); 
        name.setLocation(50, 30); 
        p3.add(name); 
  
        tname3 = new JTextField(); 
        tname3.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname3.setSize(250, 30); 
        tname3.setLocation(275, 25);
        p3.add(tname3); 
        
        remove = new JButton("Remove Task"); 
        remove.setFont(new Font("Arial", Font.PLAIN, 15)); 
        remove.setSize(150, 20); 
        remove.setLocation(150, 175); 
        remove.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
//        				removeTask(tname3.getText());
//        				JOptionPane.showMessageDialog(f, "task remove successfully");
        				try {
							dao.removeTask(tname3.getText());
							JOptionPane.showMessageDialog(f, "task remove successfully");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        		); 
        p3.add(remove); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(300, 175); 
        //reset.addActionListener(this); 
        p3.add(reset); 
  
        
	}
	public void modifyDeadline() {
		p4.setLayout(null);
		
		name = new JLabel("Enter Task Name: "); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(500, 20); 
        name.setLocation(50, 30); 
        p4.add(name); 
  
        tname4 = new JTextField(); 
        tname4.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname4.setSize(250, 30); 
        tname4.setLocation(275, 25);
        p4.add(tname4);
        
        mdate = new JLabel("Enter Modified Deadline: "); 
        mdate.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mdate.setSize(250, 20); 
        mdate.setLocation(50, 75); 
        p4.add(mdate); 
  
//        date = new JComboBox(dates); 
//        date.setFont(new Font("Arial", Font.PLAIN, 15)); 
//        date.setSize(50, 20); 
//        date.setLocation(275, 75); 
//        p4.add(date); 
//  
//        month = new JComboBox(months); 
//        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
//        month.setSize(60, 20); 
//        month.setLocation(330, 75); 
//        p4.add(month); 
//  
//        year = new JComboBox(years); 
//        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
//        year.setSize(60, 20); 
//        year.setLocation(400, 75); 
//        p4.add(year); 
        
        date = new JTextField();
        date.setFont(new Font("Arial", Font.PLAIN, 20)); 
        date.setSize(250, 30); 
        date.setLocation(300, 75); 
        p4.add(date); 
 
        modify = new JButton("Modify Deadline"); 
        modify.setFont(new Font("Arial", Font.PLAIN, 15)); 
        modify.setSize(150, 20); 
        modify.setLocation(150, 175); 
        modify.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
//        				try {
//							assignDeadline(tname4.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(date.getText()));
//							JOptionPane.showMessageDialog(f, "task deadline modified successfully");
//						} catch (ParseException e1) {
//							// TODO Auto-generated catch block
//							e1.printStackTrace();
//						}
        				try {
							dao.modifyDeadLine(tname4.getText(), new SimpleDateFormat("dd/MM/yyyy").parse(date.getText()));
							JOptionPane.showMessageDialog(f, "task deadline modified successfully");
        				} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        		); 
        p4.add(modify); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(300, 175); 
        //reset.addActionListener(this); 
        p4.add(reset); 
  
        
	}
	public void assignTask() {
		p5.setLayout(null); 
		  
        name = new JLabel("Enter Task Name: "); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(500, 20); 
        name.setLocation(50, 30); 
        p5.add(name); 
  
        tname5 = new JTextField(); 
        tname5.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname5.setSize(250, 30); 
        tname5.setLocation(275, 25);
        p5.add(tname5); 
  
        ename = new JLabel("Enter Employee Name: "); 
        ename.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ename.setSize(250, 20); 
        ename.setLocation(50, 75); 
        p5.add(ename); 
  
        enam5 = new JTextField(); 
        enam5.setFont(new Font("Arial", Font.PLAIN, 15)); 
        enam5.setSize(250, 30); 
        enam5.setLocation(275, 70); 
        p5.add(enam5);
        
        assign = new JButton("Assign Task"); 
        assign.setFont(new Font("Arial", Font.PLAIN, 15)); 
        assign.setSize(150, 20); 
        assign.setLocation(150, 175); 
        assign.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
//        				assignTask(tname5.getText(), enam5.getText());
//        				JOptionPane.showMessageDialog(f, "task assigned successfully");
        				try {
							dao.assignTask(tname5.getText(), enam5.getText());
							JOptionPane.showMessageDialog(f, "task assigned successfully");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        		); 
        p5.add(assign); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(300, 175); 
        //reset.addActionListener(this); 
        p5.add(reset); 
  
        
	}
	public void markAsDone() {
		p6.setLayout(null); 
		  
        name = new JLabel("Enter Task Name: "); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(500, 20); 
        name.setLocation(50, 30); 
        p6.add(name); 
  
        tname6 = new JTextField(); 
        tname6.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname6.setSize(250, 30); 
        tname6.setLocation(275, 25);
        p6.add(tname6); 
        
        isdone = new JButton("Mark As Done"); 
        isdone.setFont(new Font("Arial", Font.PLAIN, 15)); 
        isdone.setSize(150, 20); 
        isdone.setLocation(150, 175); 
        isdone.addActionListener(      		   
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
//        				markAsDone(tname6.getText());
//        				JOptionPane.showMessageDialog(f, "task marked as done successfully");
        				try {
							dao.markAsDone(tname6.getText());
							JOptionPane.showMessageDialog(f, "task marked as done successfully");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
        			}
        		}
        		
        		
        		); 
        p6.add(isdone); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(300, 175); 
        //reset.addActionListener(this); 
        p6.add(reset); 
  
        
	}
	public void viewTaskList() {
		p7.setLayout(null);
		viewList = new JButton("Display All Tasks"); 
		viewList.setFont(new Font("Arial", Font.PLAIN, 12)); 
		viewList.setSize(135, 30); 
		viewList.setLocation(560, 20); 
		viewList.addActionListener(
        		new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
//        				int j = 0;
//        				for(int i = 0; i<taskList.size(); i++) {
//        					String str = String.format("%s %tB %<te, %<tY", "Due date:", taskList.get(i).deadline);
//        					disname = new JLabel("Name:" + taskList.get(i).name + ", " +str +", Emp:"+ taskList.get(i).emp +", Status: "+ taskList.get(i).status); 
//            		        disname.setFont(new Font("Arial", Font.PLAIN, 14)); 
//            		        disname.setSize(520, 50); 
////            		        disname.setLocation(700/taskList.size() + i*100, 30); 
//            		        disname.setLocation(25, j);
//            		        j = j+25;
//            		        p7.add(disname);
//            		        
//        				}
        				try {
							ResultSet rs = dao.viewList();
							//int j = 0;
							
							while(rs.next()) {
	        					String str = String.format("%s %tB %<te, %<tY", "Due date:", rs.getDate(3));
	        					disname = new JLabel("Name:" + rs.getString(1) + ", " +str +", Emp:"+ rs.getString(2) +", Status: "+ rs.getString(4)); 
	            		        disname.setFont(new Font("Arial", Font.PLAIN, 14)); 
	            		        disname.setSize(520, 50); 
//	            		        disname.setLocation(700/taskList.size() + i*100, 30); 
	            		        disname.setLocation(25, j);
	            		        j = j+25;
	            		        p7.add(disname);
							}    
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						} 
        		  
//        				JOptionPane.showMessageDialog(f, display());
        			}
        		}
        		
        		); 
        p7.add(viewList); 
	}
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public static void main(String[] args) {  
	    new GUI();  
	}

}

