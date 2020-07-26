import { Injectable } from '@angular/core';
import { Allotment } from 'src/app/movie-multiplex-allotment/model/allotment';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AllotmentService {

  baseUrl = "http://localhost:8765/allotment-service/allot/";

  constructor(private http: HttpClient) { }

  saveAllotmentDetails(allotment: Allotment): Promise<Allotment> {
    return this.http.post(this.baseUrl+'add', allotment).toPromise()
      .then(response => response as Allotment);
  }

  getAllotmentDetails(multiplexName: String): Promise<Array<Allotment>> {
    return this.http.get(this.baseUrl+  `get/` + multiplexName)
      .toPromise()
      .then(response => response as Allotment[])
  }

  getScreenNumberForMultiplex(multiplexName: String): Promise<Array<Allotment>> {
    return this.http.get(this.baseUrl + 'getScreen/' + multiplexName)
      .toPromise()
      .then(response => response as Allotment[])
  }

}
