import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { ActivatedRoute, NavigationEnd, Router } from '@angular/router';
import { filter,map } from 'rxjs'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Online-Store-Application';

  constructor(private router:Router,private route:ActivatedRoute,private titleService:Title){}

  ngOnInit():void{
    this.router.events
    .pipe(
      filter((event)=> event instanceof NavigationEnd),
      map(()=>{
        const child: ActivatedRoute | null = this.route.firstChild;
        let title = child && child.snapshot.data['title'];
        if (title) {
          return title;
        }
      })
    ).subscribe((title)=>{
      if (title) {
        this.titleService.setTitle(`${title}`);
      }
    })
  }

}
