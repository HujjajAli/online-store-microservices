import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { UtilApiService } from 'src/app/services/util-api.service';

@Component({
  selector: 'app-user-registeration',
  templateUrl: './user-registeration.component.html',
  styleUrls: ['./user-registeration.component.css']
})
export class UserRegisterationComponent {

  personalInfoForm = false;
  addressForm      = false;
  confirmationPage      = true;
  userRegistrationForm!: FormGroup;
  provinces:any[] = [];
  cities   :any[] = [];

  constructor(private fb:FormBuilder,private utilApiService:UtilApiService){}

  ngOnInit(){
    this.userRegistrationForm = this.fb.group({
      firstName: ['',Validators.required],
      lastName:  [''],
      email:['',[Validators.required,Validators.email]],
      contact:['',Validators.required],
      password:['',Validators.required],
      conPassword:['',Validators.required],
      userRole:[''],
      street:[''],
      province:['0',Validators.required],
      city:['0',Validators.required],
      country:['1'],
      postalCode:['0'],
    });

    this.utilApiService.getAllProvinces().subscribe(response=>{
      console.log('Province Api Call')
      console.log(response);
      if (response.responsecode == 0) {
        this.provinces = response.data;
      }
    });

  }

  personalInfoFormSubmit(){
     this.personalInfoForm = false;
     this.addressForm      = true;
  }

  addressFormBackSubmit(){
    this.personalInfoForm = true;
    this.addressForm      = false;
  }

  onProvinceChange(event:any){
    //console.log('province Change');
    const selectedProvince = event.target.value;
    //console.log('Selected Province: '+selectedProvince);
    this.utilApiService.getAllCitiesByProvince(selectedProvince).subscribe(response=>{
      console.log('Province Api Call')
      console.log(response);
      if (response.responsecode == 0) {
        this.cities = response.data;
      }
    });
  }

  onSubmit() {
    console.log('enter email submit')
  }

}
