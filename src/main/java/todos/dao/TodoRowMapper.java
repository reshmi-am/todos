package todos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import todos.model.ToDo;

public class TodoRowMapper  implements RowMapper < ToDo >  {
	
	@Override
	public ToDo mapRow(ResultSet rs, int rowNum) throws SQLException {

		ToDo todo = new ToDo();
		
		todo.setId(rs.getInt("id"));
		todo.setItem(rs.getString("item"));
		todo.setDate_created(rs.getDate("date_created"));
		todo.setDate_due(rs.getDate("date_due"));
		todo.setDate_completed(rs.getDate("date_completed"));
		
		String status = rs.getString("status");
		todo.setStatus(status.charAt(0));
		
		return todo;

	}


}
