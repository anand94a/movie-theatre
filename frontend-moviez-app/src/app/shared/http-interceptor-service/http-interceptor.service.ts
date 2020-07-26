import { HttpInterceptor, HttpRequest, HttpHandler, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../authentication-service/authentication.service';


@Injectable({
  providedIn: 'root'
})
export class HttpInterceptorService implements HttpInterceptor {

  constructor(private authenticationService: AuthenticationService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler):Observable<HttpEvent<any>> {
    if(this.authenticationService.isUserLoggedIn()){
      let token = this.authenticationService.getAuthenticationToken();

      request = request.clone({
        setHeaders : {
          Authorization : token
        }
      });

    }
    return next.handle(request);
  }
}
