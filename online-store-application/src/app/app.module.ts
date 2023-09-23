import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavigationBarComponent } from './components/shared/navigation-bar/navigation-bar.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { ContactUsComponent } from './components/contact-us/contact-us.component';
import { AboutUsComponent } from './components/about-us/about-us.component';
import { MyProductsComponent } from './components/my-products/my-products.component';
import { HttpClientModule } from '@angular/common/http';
import { CategoryProductsComponent } from './components/category-products/category-products.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { ToastrModule } from 'ngx-toastr';
import { SingleProductComponent } from './components/single-product/single-product.component';
import { UserRegisterationComponent } from './components/user-registeration/user-registeration.component'

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationBarComponent,
    FooterComponent,
    ContactUsComponent,
    AboutUsComponent,
    MyProductsComponent,
    CategoryProductsComponent,
    AddProductComponent,
    SingleProductComponent,
    UserRegisterationComponent
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    ToastrModule.forRoot({
      timeOut: 1000
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
