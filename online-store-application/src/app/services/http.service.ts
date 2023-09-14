import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

//const baseUrl = 'http://localhost:9095/crud/api';


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  constructor(private http:HttpClient) { }

  get(url:string):Observable<any>{
   // const url = `${baseUrl}/${api}`;

    const headers = { 'Authorization': ''};

    console.log(url);
    return this.http.get(url,{headers});
  }

  post(url:string,data:any):Observable<any>{
    //const url = `${baseUrl}/${api}`;

    const headers = { 'Authorization': ''};

    console.log(url);
    return this.http.post(url,data,{headers});
  }
}