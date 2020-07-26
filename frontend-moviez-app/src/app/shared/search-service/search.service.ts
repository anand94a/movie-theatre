import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Allotment } from 'src/app/movie-multiplex-allotment/model/allotment';
import { Multiplex } from 'src/app/multiplex/model/multiplex';

@Injectable({
  providedIn: 'root'
})
export class SearchService {

  constructor(private http: HttpClient) { }

  getAllotmentDetails(): Promise<Array<Allotment>> {
    return this.http.get("http://localhost:8765/search-service/search/allotment")
      .toPromise()
      .then(response => response as Allotment[])
      .catch(this.handleError);
  }

  getMultiplexDetails(): Promise<Array<Multiplex>> {
    return this.http.get("http://localhost:8765/search-service/search/multiplex")
      .toPromise()
      .then(response => response as Multiplex[])
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
