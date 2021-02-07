//Warren Fernandes 8940
package com.java.todolist;

import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date; 


public class ToDoList {
	
	
	public static ArrayList<Task> taskList = new ArrayList<Task>(); 
	
	public String topic;

	public int count = taskList.size();
	public ToDoList() {
		super();
	}
	

	public ToDoList(String topic) {
		this.topic = topic;
	}
	
	public void createTask(String name, String date, String emp) throws ParseException {
		
		Task newTask = new Task(name, date, emp);
		taskList.add(newTask);
		
	}
	
	public void display() {
		for (Task t : taskList){
			System.out.println("***********************");
			System.out.println(t.name); 		
	        System.out.printf("%s %tB %<te, %<tY", "Due date:", t.deadline);
	        System.out.println();
	        System.out.println(t.emp); 	
	        System.out.println(t.status);
	        System.out.println("***********************");
		}
		
	}
	
	public String displayGUI(int count) {
		String x = null;
		for (Task t : taskList){
			 x = t.name +" "+ t.deadline +" "+ t.emp +" "+ t.status; 		
		}
		return x;
	}


	public void assignTask(String taskName, String emp) {
		int flag = 0;
		for (Task t : taskList){ 		      
			if(t.name.equals(taskName)) {
				t.setEmp(emp);
				flag = 1;
				break;
			}	
		}
		if(flag == 0) {
			System.out.println("Task not found");
		}
		
	}
	
	public void removeTask(String taskName) {
		int flag = 0;
		for (Task t : taskList){ 		      
			if(t.name.equals(taskName)) {
				taskList.remove(t);
				flag = 1;
				break;
			}	
		}
		if(flag == 0) {
			System.out.println("Task not found");
		}
		
	}
	
	
	public void markAsDone(String taskName) {
		int flag = 0;
		for (Task t : taskList){ 		      
			if(t.name.equals(taskName)) {
				t.setStatus('Y');
				System.out.println("status set");
				flag = 1;
				break;
			}	
		}
		if(flag == 0) {
			System.out.println("Task not found");
		}
		
	}
	
	public void assignDeadline(String taskName, Date date) {
		int flag = 0;
		for (Task t : taskList){ 		      
			if(t.name.equals(taskName)) {
				t.setDeadline(date);
				flag = 1;
				break;
			}	
		}
		if(flag == 0) {
			System.out.println("Task not found");
		}
	}
	
	public void renameTask(String oldTaskName, String newTaskName) {
		System.out.println("Rename task ");
		int flag = 0;
		for (Task t : taskList){ 		      
			if(t.name.equals(oldTaskName)) {
				t.setName(newTaskName);
				flag = 1;
				break;
			}	
		}
		if(flag == 0) {
			System.out.println("Task not found");
		}
		
	}
	


}
