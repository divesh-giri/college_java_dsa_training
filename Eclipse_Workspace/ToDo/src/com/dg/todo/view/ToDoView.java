package com.dg.todo.view;

import java.io.EOFException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.dg.todo.dto.ToDoDTO;
import com.dg.todo.repo.IToDoRepo;
import com.dg.todo.repo.ToDoRepo;
import com.dg.todo.utils.Constants;

import static com.dg.todo.utils.MessageReader.getValue;
import static com.dg.todo.utils.Constants.*;

public class ToDoView {
	private static Scanner sc = new Scanner(System.in);
	private static void addTask()
	{
		sc.nextLine();
		System.out.println(getValue("input.taskname"));
		String name = sc.nextLine();
		System.out.println(getValue("input.taskdesc"));
		String desc = sc.nextLine();
		
		ToDoDTO todo = new ToDoDTO(name, desc);
		
		String result = getValue("record.notadded");
		
		
		// try catch - throw early catch later
		ArrayList<ToDoDTO> tasks = null;
		try {
			IToDoRepo repo = ToDoRepo.getInstance();
			
			try
			{
				tasks = repo.printTask();
			}
			catch(EOFException e)
			{
				System.out.println("File is empty, Trying to add new task");
			}
			
			
			if(tasks!=null && tasks.size()>0) // means previous tasks exist
			{
				tasks.add(todo);
			}
			else // No task exist
			{
				tasks = new ArrayList<>();
				tasks.add(todo);
			}
			
			result = repo.addTask(tasks)?getValue("record.added"):getValue("record.notadded");
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(result);
	}
	
	private static void deleteTask()
	{
		sc.nextLine();
		System.out.println(getValue("delete.taskname"));
		String delete_task = sc.nextLine();
		int flag = 0;
		ToDoDTO delete_task_DTO = null;
		
		try {
			IToDoRepo repo = ToDoRepo.getInstance();
			
			ArrayList<ToDoDTO> tasks = repo.printTask();
			for(ToDoDTO task: tasks)
			{
				if(task.getName().equals(delete_task))
				{
					flag = 1;
					delete_task_DTO = task;
					break;
				}
			}
			if(flag == 1)
			{
				tasks.remove(delete_task_DTO);	
				repo.addTask(tasks);
				System.out.println(getValue("delete.success"));
			}
			else
			{
				System.out.println(getValue("delete.notfound"));
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void updateTask()
	{
		sc.nextLine();
		System.out.println(getValue("update.taskname"));
		String update_taskname = sc.nextLine();
		ToDoDTO update_task_DTO = null;
		
		int flag = 0;
		
		IToDoRepo repo;
		try {
			repo = ToDoRepo.getInstance();
			ArrayList<ToDoDTO> tasks = repo.printTask();
			
			for(ToDoDTO task: tasks)
			{
				if(task.getName().equals(update_taskname))
				{
					flag = 1;
					update_task_DTO = task;
					break;
				}
			}
			
			if(flag == 1)
			{
				update_task_DTO.setStatus(Constants.COMPLETED);
				repo.addTask(tasks);
				System.out.println(getValue("update.success"));
			}
			else
			{
				System.out.println(getValue("update.fail"));
			}
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
			
	}
	
	private static void searchTask()
	{
		sc.nextLine();
		System.out.println(getValue("search.task"));
		String taskname = sc.nextLine();
		int flag = 0;
		try {
			IToDoRepo repo = ToDoRepo.getInstance();
			ArrayList<ToDoDTO> tasks = repo.printTask();
			for(ToDoDTO task:tasks)
			{
				if(task.getName().equals(taskname))
				{
					flag = 1;
					System.out.println(task);
					break;
				}
			}
			if(flag == 0)
			{
				System.out.println(getValue("search.fail"));
			}
			
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static void printAllTask()
	{
		
		try {
			IToDoRepo repo = ToDoRepo.getInstance();
			
			ArrayList<ToDoDTO> tasks = repo.printTask();
			for(ToDoDTO task:tasks)
			{
				System.out.println(task);
			}
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		outer:
		while(true)
		{
			System.out.println(getValue("addtask"));
			System.out.println(getValue("deletetask"));
			System.out.println(getValue("updatetask"));
			System.out.println(getValue("searchtask"));
			System.out.println(getValue("printtask"));
			System.out.println(getValue("exit"));
			System.out.println(getValue("choice"));
			int choice = sc.nextInt();
			switch(choice)
			{
				case ADD_TASK: 
					addTask();
					break;
				case DELETE_TASK:
					deleteTask();
					break;
				case UPDATE_TASK:
					updateTask();
					break;
				case SEARCH_TASK:
					searchTask();
					break;
				case PRINT_TASK:
					printAllTask();
					break;
				case EXIT:
					break outer;				
			}
		}
		
		sc.close();
		

	}

}
