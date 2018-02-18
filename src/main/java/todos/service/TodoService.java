package todos.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import todos.dao.TodoRepository;
import todos.model.TODO_STATUS;
import todos.model.ToDo;

@Service
public class TodoService {

	@Autowired
	TodoRepository repo;
	
	public List<ToDo> getAll(){
		return repo.findAllTodos();
	}

	public void addItem(ToDo todo){
		todo.setDate_created(new Date());
		todo.setDate_completed(null);
		todo.setStatus(TODO_STATUS.PENDING.getStatus());
		repo.insert(todo);
	}
	
	public void updateItem(ToDo todo){
		repo.updateItem(todo);
	}
	
	public void deleteItem(int id){
		repo.updateStatus(id, TODO_STATUS.DELETED.getStatus());
	}
	
	public void markAsDone(int id){
		repo.updateStatus(id, TODO_STATUS.COMPLETED.getStatus());
	}
}
