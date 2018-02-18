package todos.model;

public enum TODO_STATUS {

	PENDING('P') , COMPLETED('C'), DELETED('D');
	
	private char status;
	
	TODO_STATUS(char status){
		this.status = status;
	}
	
	public char getStatus(){
		return status;
	}
}
