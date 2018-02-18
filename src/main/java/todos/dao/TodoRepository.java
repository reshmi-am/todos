package todos.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import todos.model.TODO_STATUS;
import todos.model.ToDo;

@Repository
public class TodoRepository {
	
    @Autowired
    JdbcTemplate jdbcTemplate;
    
    public List<ToDo> findAllTodos() {
    	return jdbcTemplate.query("select * from todo_list where status != ? " , new Object[] {
    			TODO_STATUS.DELETED.getStatus()
        },  new TodoRowMapper());
    }
    
    public int insert(ToDo todo) {

        return jdbcTemplate.update("insert into todo_list (item, date_created, date_due, date_completed, status) " + "values(?, ?, ?, ?, ?)",

            new Object[] {
            		todo.getItem(), todo.getDate_created(), todo.getDate_due(), todo.getDate_completed(), todo.getStatus()
            });
    }

    public int updateStatus(int id, char status){
    	
        return jdbcTemplate.update("update todo_list " + " set status= ? " + " where id = ?",
                new Object[] {
                		status, id
                });
    }
}
