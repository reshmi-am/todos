import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';

import { DataTableModule,
          DialogModule,
          ButtonModule,
          CalendarModule,
          InputTextModule}  from 'primeng/primeng';
import { TodoService } from './services/todo.service';
import { AppComponent } from './app.component';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    DataTableModule,
    HttpModule,
    DialogModule,
    ButtonModule,
    BrowserAnimationsModule,
    CalendarModule,
    InputTextModule,
    FormsModule
  ],
  providers: [TodoService],
  bootstrap: [AppComponent]
})
export class AppModule { }
