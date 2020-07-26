import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  public username: String;
  private baseUrl = "http://localhost:8765/api";

  constructor(private http: HttpClient) { }

  authenticate(username: string, password: string) {
    this.username = username;
    let authToken = "Basic " + window.btoa(username + ":" + password);
    
    let headers = new HttpHeaders({
      Authorization: authToken
    });

    return this.http.get(this.baseUrl, 
    { headers, params: { username: username, password: password }, responseType: 'text' })
      .pipe(map((successData) => {
        localStorage.setItem("user", username);
        localStorage.setItem("token", authToken);
        return successData;
      }),
        map((failureData) => {
          return failureData;
        })
      );

  }

  getAuthenticationToken() {
    return localStorage.getItem("token");
  }


  isUserLoggedIn(): boolean {
    let user = localStorage.getItem('user');
    if (user == null)
      return false;
    else
      return true;
  }

  logout() {
    localStorage.removeItem('user');
    localStorage.removeItem('token');
  }

  getLoggedInUserName() {
    let user = localStorage.getItem('user')
    if (user === null) return ''
    return user
  }
}
