//Warren Fernandes 8940
package com.java.todolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Task {
	public String name;
	public String date;
	public String emp;
//	public Date deadline=new SimpleDateFormat("dd/MM/yyyy").parse(date);
	public Date deadline;
	public boolean status;
	
	public Task(String name, String date, String emp) throws ParseException {
		super();
		this.name = name;
		this.deadline = new SimpleDateFormat("dd/MM/yyyy").parse(date);
		this.emp = emp;
		this.status = false;
	}
	
	//set name, deadline, employee
	public void setName(String name) {
		this.name = name;
	}
	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}
	public void setEmp(String emp) {
		this.emp = emp;
	}
	public void setStatus(char x) {
		if(x == 'Y')
			this.status = true;
		else if(x == 'N')
			this.status = false;
		else
			System.out.println("Error ! Enter valid argument");
	}

	public String getName() {
		return name;
	}

	public String getDate() {
		return date;
	}

	public String getEmp() {
		return emp;
	}

	public Date getDeadline() {
		return deadline;
	}

	public boolean isStatus() {
		return status;
	}
	
	
	
//	public static void main(String args[]) throws ParseException {
//		Task x = new Task("Write a Program", "31/10/2020", "Yash");
//		System.out.println(x.deadline.toString());
//	}
//	
	
}
