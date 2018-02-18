package todos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import todos.model.ToDo;
import todos.service.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MainController {
	
	@Autowired
	TodoService service;
	
	/*
	 * Get all items in the DB
	 */
    @RequestMapping("/todos")
    public @ResponseBody List<ToDo> getAllTodos() {
        return service.getAll();
    }
    
    /*
     * Create a new item
     */
    @RequestMapping(value="/todo", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody void addItem(@RequestBody ToDo todo) {
    	service.addItem(todo);
    }
    
    /*
     * Edit details of an item
     */
    @RequestMapping(value="/todo", method = RequestMethod.PUT, consumes = "application/json")
    public void updateItem(@RequestBody ToDo todo) {
    	service.updateItem(todo);
    }
    	
    /*
     * Mark an item as deleted
     */
    @RequestMapping(value="/todo/{id}", method = RequestMethod.DELETE)
    public void deleteItem(@PathVariable("id") int itemid) {
    	service.deleteItem(itemid);
    }
    
    /*
     * Mark an item as completed 
     */
    @RequestMapping(value="/todo/{id}", method = RequestMethod.PUT)
    public void completeItem(@PathVariable("id") int itemid) {
    	service.markAsDone(itemid);
    }
}
