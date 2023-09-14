import { Component } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

   categories: any[] = [];

  constructor(private productService:ProductService){}

  ngOnInit() {
    this.productService.getAllCategories().subscribe(response=>{
      if(response.responcode == 0){
        if(response.data){
          for(let category of response.data){
            this.categories = response.data;
          }
        }
      }else{
        console.log('No Category Found');
      }
    });
  }

}
