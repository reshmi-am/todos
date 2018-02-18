import { Component } from '@angular/core';
import { TodoService } from './services/todo.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  todos : any;
  displaydetails: boolean = false;
  newitem: string;
  duedate: Date;

  constructor(private service: TodoService) {
  }

  ngOnInit(){
    this.fetchTodos();
  }

  fetchTodos (){
    this.service.getAllToDos().
                    subscribe(data => this.handleResponse(data));
  }

  handleResponse(data){
    if(data && data.length > 0){
      this.todos = data;
    }
  }

  showDialog (){
    this.displaydetails = true;
  }

  saveItem(){
    if(this.newitem == null || this.newitem.length == 0 ||
        this.duedate == null || this.newitem.length == 0 ){
      return;
    }
    this.service.saveNewItem(this.newitem, this.duedate.toISOString())
                    .subscribe(data=>this.handleSaveSuccess());
  }

  handleSaveSuccess(){
    this.fetchTodos(); 
    this.newitem = null; 
    this.duedate = null;
  }
}
