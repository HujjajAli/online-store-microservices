import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

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

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavigationBarComponent,
    FooterComponent,
    ContactUsComponent,
    AboutUsComponent,
    MyProductsComponent,
    CategoryProductsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
