import { Component ,Renderer2} from '@angular/core';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.css']
})
export class NavigationBarComponent {

  constructor(private renderer: Renderer2){}

 /* public OnMenuItemClick(e:any){
    console.log('Event Work');

    //const productElement = this.renderer.selectRootElement('#products');
    //const aboutElement = this.renderer.selectRootElement('#about');
    //const contactElement = this.renderer.selectRootElement('#contact');




    //const element = this.renderer.selectRootElement('#about');
    //this.renderer.addClass(aboutElement, 'active');
  }*/

}
