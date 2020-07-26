import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MoviesService } from 'src/app/shared/movies-service/movies.service';
import { Movies } from '../model/movies';

@Component({
  selector: 'app-add-edit-movie',
  templateUrl: './add-edit-movie.component.html',
  styleUrls: ['./add-edit-movie.component.css']
})
export class AddEditMovieComponent implements OnInit {

  movieFormGroup: FormGroup;
  movie: Movies;
  movieItemsForPatch: any;
  movieId: String;
  
  constructor(private moviesService: MoviesService,
    private router: Router,
    private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    this.initializeDataOnFormFields();
    
    this.activatedRoute.paramMap.subscribe(params => {
      const movieId = params.get('movieId');
      if (movieId) {
        this.getMovieById(movieId);
        this.movieId = movieId;
      }
    })
  }

  getMovieById(movieId: String) {
    this.moviesService.getMovieById(movieId).then(
      response => {
        this.movieItemsForPatch = response;
        this.movie = this.movieItemsForPatch;
        this.patchMovieDetailsOnTheForm(this.movie);
      }
    );
  }

  initializeDataOnFormFields() {
    this.movieFormGroup = new FormGroup({
      movieName: new FormControl('', Validators.required),
      movieCategory: new FormControl('', Validators.required),
      producer: new FormControl('', Validators.required),
      director: new FormControl('', Validators.required),
      releaseDate: new FormControl('', Validators.required)
    });
  }

  patchMovieDetailsOnTheForm(movies: Movies) {
    this.movieFormGroup.setValue({
      movieName: movies.movieName,
      movieCategory: movies.movieCategory,
      producer: movies.producer,
      director: movies.director,
      releaseDate: movies.releaseDate
    })
  }

  saveMovie() {
    this.movie = new Movies();
    this.movie.movieName = this.movieFormGroup.get('movieName').value;
    this.movie.movieCategory = this.movieFormGroup.get('movieCategory').value;
    this.movie.producer = this.movieFormGroup.get('producer').value;
    this.movie.director = this.movieFormGroup.get('director').value;
    this.movie.releaseDate = this.movieFormGroup.get('releaseDate').value

    if (this.movieId == null) {
      this.moviesService.saveMovieDetails(this.movie)
        .then(
          response => {
            console.log('Logged')
          },
          error => {
            console.log(error)
          });

      alert("Data has been added");

    }
    else {
      this.moviesService.updateMovieDetails(this.movieId, this.movie)
        .then(
          response => {
            console.log('Updated')
          },
          error => {
            console.log(error)
          });
      alert("Data has been edited");
    }

    this.router.navigate(['movies/moviesList']);
  }

  clearData() {
    this.movieFormGroup.reset();
    this.initializeDataOnFormFields();
  }

  cancel() {
    this.movieFormGroup.reset();
    this.router.navigate(['movies/moviesList']);
  }

}
