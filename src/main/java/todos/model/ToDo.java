package todos.model;

import java.util.Date;

public class ToDo {
	
	int id;
	String item;
	Date date_created;
	Date date_due;
	Date date_completed;
	char status;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItem() {
		return item;
	}
	public void setItem(String item) {
		this.item = item;
	}
	public Date getDate_created() {
		return date_created;
	}
	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}
	public Date getDate_due() {
		return date_due;
	}
	public void setDate_due(Date date_due) {
		this.date_due = date_due;
	}
	public Date getDate_completed() {
		return date_completed;
	}
	public void setDate_completed(Date date_completed) {
		this.date_completed = date_completed;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}

}
