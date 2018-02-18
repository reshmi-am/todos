import { Injectable } from '@angular/core';
import { Http , Response, RequestOptions, Headers } from '@angular/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';

@Injectable()
export class TodoService {

    private URL : string = "http://localhost:8080/";

    constructor(private http: Http){}

    getAllToDos(): Observable<any> {
       
        return this.http.get(this.URL + "todos")
                    .map((res:Response) => res.json())
                    .catch((error:any) => Observable.throw(error.json() || 'Server error'));
    }

    saveNewItem(item: string, date_due: string): Observable<any> {

        var itemdetails = {
            item: item,
            date_due: date_due
        }

        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });
        
        return this.http.post(this.URL + "todo", itemdetails, options)
            .catch((error:any) => Observable.throw(error || 'Server error'));
    }

    markItemAsDone(itemid: number){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.put(this.URL + "todo/" + itemid, options)
        .catch((error:any) => Observable.throw(error || 'Server error'));
    }

    deleteItem(itemid: number){
        let headers = new Headers({ 'Content-Type': 'application/json' });
        let options = new RequestOptions({ headers: headers });

        return this.http.delete(this.URL + "todo/" + itemid, options)
         .catch((error:any) => Observable.throw(error || 'Server error'));
    }
}