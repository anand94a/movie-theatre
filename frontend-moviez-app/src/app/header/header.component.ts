import { Component, OnInit} from '@angular/core';
import { AuthenticationService } from '../shared/authentication-service/authentication.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private auth: AuthenticationService,
    private router: Router) { }


  get isLoggedIn() {
     return this.auth.isUserLoggedIn(); 
  }
  get userName() { 
    return this.auth.getLoggedInUserName(); 
  }

  ngOnInit(): void {
  }

  logout() {
    this.auth.logout();
    this.router.navigate(['/home']);
  }

}
