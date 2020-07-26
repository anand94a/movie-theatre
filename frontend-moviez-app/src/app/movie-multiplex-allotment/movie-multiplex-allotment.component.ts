import { Component, OnInit} from '@angular/core';
import { MoviesService } from '../shared/movies-service/movies.service';
import { MultiplexService } from '../shared/multiplex-service/multiplex.service';
import { Movies } from '../movies/model/movies';
import { Multiplex } from '../multiplex/model/multiplex';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Allotment } from './model/allotment';
import { AllotmentService } from '../shared/allotment-service/allotment.service';
import { Router } from '@angular/router';

export class Screens {
  value: number;
  viewValue: number;

  constructor(value?: number, viewValue?: number) {
    this.value = value;
    this.viewValue = viewValue;
  }
}

@Component({
  selector: 'app-movie-multiplex-allotment',
  templateUrl: './movie-multiplex-allotment.component.html',
  styleUrls: ['./movie-multiplex-allotment.component.css']
})
export class MovieMultiplexAllotmentComponent implements OnInit {

  setOfScreens = new Set();
  movies: Movies[];
  multiplex: Multiplex[];
  allotmentFormGroup: FormGroup;
  allotment: Allotment;
  city: String;
  movieMultiplex: Multiplex
  mulPlex: any;

  constructor(private moviesService: MoviesService,
    private multiplexService: MultiplexService,
    private allotmentService: AllotmentService,
    private router: Router) { }

  ngOnInit(): void {
    this.initializeDataOnFormFields();
    this.loadData();
  }

  initializeDataOnFormFields() {
    this.allotmentFormGroup = new FormGroup({
      multiplexId: new FormControl(''),
      movieName: new FormControl('', Validators.required),
      multiplexName: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      screenNumber: new FormControl('', Validators.required)
    });
  }


  loadData() {
    this.moviesService.getAllMoviesDetails().then(
      movieList => {
        this.movies = movieList;
      }, (error) => { }
    );

    this.multiplexService.getAllMultiplexDetails().then(
      multiplexList => {
        this.multiplex = multiplexList;
      }, (error) => { }
    )
  }

  submit() {
    this.allotment = new Allotment();
    this.allotment.movieName = this.allotmentFormGroup.get('movieName').value;
    this.allotment.multiplexName = this.allotmentFormGroup.get('multiplexName').value;
    this.allotment.city = this.allotmentFormGroup.get('city').value;
    this.allotment.screenNumber = parseInt(this.allotmentFormGroup.get('screenNumber').value);

    this.allotmentService.saveAllotmentDetails(this.allotment).then(
      response => { },
      error => {
        console.log(error)
      });

    this.router.navigate(['/home']);
  }

  cancel() {
    this.allotmentFormGroup.reset();
    this.router.navigate(['/home']);
  }

  fetchDetails(event: any) {
    this.allotmentService.getScreenNumberForMultiplex(event.source.value).then(
      response => {
        this.mulPlex = response
        this.movieMultiplex = this.mulPlex;
        this.city = this.movieMultiplex.city;
        for (let screen of this.movieMultiplex.setOfScreens) {
          this.setOfScreens.add(screen);
        }
      }
    ).catch(
      error => { }
    );
  }
}
