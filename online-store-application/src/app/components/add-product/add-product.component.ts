import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ToastrService} from 'ngx-toastr';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent {

  productForm!: FormGroup;
  selectedFile: File | null = null;
  productReuest!: any;

  constructor(private fb:FormBuilder,private toastrService:ToastrService,private productService:ProductService){}

  ngOnInit() {
    this.productForm = this.fb.group({
      productName:  ['',Validators.required],
      unitPrice:    [0,Validators.required],
      quantity:     [0,Validators.required],
      categoryId:   ['0',Validators.required],
      productImage: [null,Validators.required],
      productDescription: ['']
    });
  }

  onFileChange(event: any) {

    const file = event.target.files[0];
    if (file) {
      console.log('file selected success')
      this.selectedFile = file;
    }
  }


  onSubmit() {
    if (this.productForm != undefined && this.productForm.valid) {

      
      

      //console.log(this.selectedFile);
      if (this.selectedFile) {
        // Read the file as a Data URL
        const reader = new FileReader()
        reader.onloadend = () => {
          this.productReuest = {productName:this.productForm.value['productName'],
          unitPrice:this.productForm.value['unitPrice'],quantity:this.productForm.value['quantity'],
          categoryId:this.productForm.value['categoryId'],productDescription:this.productForm.value['productDescription'],productImage:reader.result}
          console.log(this.productReuest)
          this.productService.saveProduct(this.productReuest).subscribe((response:any)=>{
            console.log(response)
            this.toastrService.success(response.messages,'Status',{ timeOut: 3000})
          }, (error) => {
            console.error('Error fetching products:', error);
            if(error.messages === 'Validation Error'){
              let errorArray = Object.entries(error.data);
              let count = errorArray.length + 3;
              errorArray.forEach(element => {
                this.toastrService.warning(''+element[1],''+''+element[0],{ timeOut: (count * 1000)});
                count = count - 1;
              });
              this.toastrService.warning(error.messages,'Status',{ timeOut: ((errorArray.length + 4) * 1000)});
            }else{
              this.toastrService.warning(error.messages,'Status',{timeOut:5000});
            }
          });

        };
        reader.readAsDataURL(this.selectedFile);
      }

      //this.toastrService.warning('Product Saved Successfully!','Status',{ timeOut: 3000})
    }
  }

}
