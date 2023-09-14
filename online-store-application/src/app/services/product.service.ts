import { Injectable } from '@angular/core';
import { HttpService } from './http.service';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpService:HttpService) { }

  public getAllCategories(){
    return this.httpService.get('http://localhost:8082/category')
  }

  public getAllCategoriesWithActiveClass(categoryId:any){
    return this.httpService.get('http://localhost:8082/category/activeClass/'+categoryId)
  }
}
