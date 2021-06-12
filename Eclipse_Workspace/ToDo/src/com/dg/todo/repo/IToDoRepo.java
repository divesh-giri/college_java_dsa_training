package com.dg.todo.repo;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import com.dg.todo.dto.ToDoDTO;

public interface IToDoRepo {
	public boolean addTask(ArrayList<ToDoDTO> todo) throws IOException;
	public ArrayList<ToDoDTO> printTask() throws FileNotFoundException, IOException, ClassNotFoundException;
}
