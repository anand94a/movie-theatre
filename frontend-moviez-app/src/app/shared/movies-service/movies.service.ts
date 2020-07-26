import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Movies } from 'src/app/movies/model/movies';
import { AuthenticationService } from '../authentication-service/authentication.service';

@Injectable({
  providedIn: 'root'
})
export class MoviesService {

  private baseUrl = "http://localhost:8765/movies-service/movies/";

  constructor(private http: HttpClient,
    private auth: AuthenticationService) { }

  getAllMoviesDetails(): Promise<Array<Movies>> {
    return this.http.get(this.baseUrl)
      .toPromise()
      .then(response => response as Movies[])
      .catch(this.handleError);
  }

  saveMovieDetails(movie: Movies): Promise<Movies> {
    return this.http.post(this.baseUrl + 'create', movie).toPromise()
      .then(response => response as Movies);
  }

  updateMovieDetails(movieId: String, movie: Movies): Promise<Movies> {
    return this.http.put(this.baseUrl + 'update/' + movieId, movie).toPromise()
      .then(response => response as Movies);
  }

  getMovieById(movieId: String) {
    return this.http.get(this.baseUrl + movieId)
      .toPromise()
      .then(response => response as Movies)
      .catch(this.handleError);
  }

  deleteMovieById(movieId: String) {
    return this.http.delete(this.baseUrl + 'delete/' + movieId)
      .toPromise()
      .then(response => response as Movies)
      .catch(this.handleError);
  }

  private handleError(error: any): Promise<Array<any>> {
    console.error('An error occurred', error);
    return Promise.reject(error.message || error);
  }
}

