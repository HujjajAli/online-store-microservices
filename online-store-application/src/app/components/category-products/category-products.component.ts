import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-category-products',
  templateUrl: './category-products.component.html',
  styleUrls: ['./category-products.component.css']
})
export class CategoryProductsComponent {

  categories: any[] = [];
  categoryName: string|undefined;

  constructor(private productService: ProductService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    let categoryId = this.route.snapshot.queryParamMap.get('categoryId');
    console.log('Category Id: ' + categoryId)
    this.productService.getAllCategoriesWithActiveClass(categoryId).subscribe(response => {
      if (response.responcode == 0) {
        this.categories = response.data;
        for(let category of this.categories){
          if(category.activeClass != null && category.activeClass === 'active'){
            this.categoryName = category.categoryName;
          }
        }
      } else {
        console.log('No Category Found');
      }
    });
  }

}
