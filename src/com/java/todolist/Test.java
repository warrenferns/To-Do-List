//Warren Fernandes 8940
package com.java.todolist;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Test {
	
	public static ArrayList<Task> taskList = new ArrayList<Task>(); 
	ToDoList todolist = new ToDoList("DS");
	
	public void testCreateTask() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the task");
		String name = sc.nextLine();
		
		System.out.println("Enter the Date");
		String date  = sc.nextLine();
			
		System.out.println("Enter the Employee name ");
		String emp= sc.nextLine();
		todolist.createTask(name, date, emp);
		
	}
	public void testDisplay() {
		todolist.display();
	}
	public void testAssignTask() {
		todolist.assignTask("task3", "Warren");
	}
	public void testAssignDeadline() throws ParseException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the new Date");
		String date  = sc.nextLine();
		todolist.assignDeadline("task3",  new SimpleDateFormat("dd/MM/yyyy").parse(date) );
	}
	public void testMarkAsDone() throws ParseException {
		todolist.markAsDone("task3");
	}
		

	public void testRemoveTask() throws ParseException {
		todolist.removeTask("task2");
	}

	public void testRenameTask() throws ParseException {
		todolist.renameTask("task1", "task5");
	}
	
	public static void main(String[] args) throws ParseException {
		Test tester = new Test();
		tester.testCreateTask();
		tester.testCreateTask();
		tester.testCreateTask();
		tester.testRenameTask();
		tester.testRemoveTask();
		tester.testAssignDeadline();
		tester.testAssignTask();
		tester.testMarkAsDone();
		tester.testDisplay();

	}

}
