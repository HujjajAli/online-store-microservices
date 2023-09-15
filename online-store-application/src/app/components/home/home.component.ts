import { Component } from '@angular/core';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

   categories: any[] = [];
   products: any[] = [];

  constructor(private productService:ProductService){}

  ngOnInit() {
    this.productService.getAllCategories().subscribe(response=>{
      if (response.responcode == 0) {
        this.categories = response.data;
      } else {
        console.log('No Category Found');
      }
    });

    this.productService.getAllProducts().subscribe(response=>{
      if (response.responcode == 0) {
        this.products = response.data;
      } else {
        console.log('No Category Found');
      }
    });
    

  }

}
