import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-single-product',
  templateUrl: './single-product.component.html',
  styleUrls: ['./single-product.component.css']
})
export class SingleProductComponent {


  product!: any;

  constructor(private productService: ProductService, private route: ActivatedRoute) {

  }

  ngOnInit() {
    let productId = this.route.snapshot.queryParamMap.get('productId');
    this.productService.getAllProductByProductId(productId).subscribe((response)=>{

      if(response.responsecode == 0 && response.messages === 'Record Found'){
        this.product = response.data;
      }

    });
  }


}
