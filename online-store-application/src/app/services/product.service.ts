import { Injectable } from '@angular/core';
import { ToastrService} from 'ngx-toastr';
import { HttpService } from './http.service';
import {HttpErrorResponse } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import {throwError } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProductService {

  constructor(private httpService:HttpService) { }

  public getAllCategories(){
    return this.httpService.get('http://localhost:8082/category');
  }

  public getAllCategoriesWithActiveClass(categoryId:any){
    return this.httpService.get('http://localhost:8082/category/activeClass/'+categoryId);
  }

  public getAllProducts(){
    return this.httpService.get('http://localhost:8082/product');
  }

  public getAllProductByProductId(productId:any){
    return this.httpService.get('http://localhost:8082/product/productId/'+productId);
  }

  public getAllProductsByCategory(categoryId:any){
    return this.httpService.get('http://localhost:8082/product/categoryId/'+categoryId);
  }

  public saveProduct(payload:any){
    return this.httpService.post('http://localhost:8082/product',payload).pipe(
      catchError(this.handleError)
    );
  }

   // Error handling function
   private handleError(error: HttpErrorResponse) {
    
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } 
    // Return an observable with a user-facing error message.
    return throwError(error.error);
  }
}
