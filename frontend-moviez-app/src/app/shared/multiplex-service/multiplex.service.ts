import { Injectable } from '@angular/core';
import { Multiplex } from 'src/app/multiplex/model/multiplex';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MultiplexService {

  baseUrl = 'http://localhost:8765/multiplex-service/multiplex/';

  constructor(private http: HttpClient) { }

  getAllMultiplexDetails(): Promise<Array<Multiplex>> {
    return this.http.get(this.baseUrl + 'getall')
      .toPromise()
      .then(response => response as Multiplex[])
      .catch(this.handleError);
  }

  saveMultiplexDetails(multiplex: Multiplex): Promise<Multiplex> {
    return this.http.post(this.baseUrl + 'create', multiplex).toPromise()
      .then(response => response as Multiplex);
  }

  updateMultiplexDetails(multiplexId: String, multiplex: Multiplex): Promise<Multiplex> {

    return this.http.put(this.baseUrl + 'update/' + multiplexId, multiplex).toPromise()
      .then(response => response as Multiplex);
  }

  getMultiplexById(multiplexId: String) {
    return this.http.get(this.baseUrl + multiplexId)
      .toPromise()
      .then(response => response as Multiplex)
      .catch(this.handleError);
  }

  deleteMultiplexById(multiplexId: String) {
    return this.http.delete(this.baseUrl + 'delete/' + multiplexId)
      .toPromise()
      .then(response => response as Multiplex)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}
