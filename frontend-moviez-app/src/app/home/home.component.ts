import { Component, OnInit } from '@angular/core';
import { MatRadioChange } from '@angular/material/radio';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  movieOrMultiplex: string = "Movies";
  types: string[] = ['Movies', 'Multiplex'];


  constructor(private router: Router) { }

  ngOnInit(): void {

  }

  changeRoute(event:MatRadioChange){
    if(event.value == "Movies"){
      this.router.navigate(['/home/search/allotment'], { skipLocationChange: true });
    } else if(event.value == "Multiplex"){
      this.router.navigate(['home/search/multiplex'], { skipLocationChange: true });
    }
  }

}
