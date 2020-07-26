import { Component, OnInit } from '@angular/core';
import { Movies } from '../model/movies';
import { MatTableDataSource } from '@angular/material/table';
import { MoviesService } from 'src/app/shared/movies-service/movies.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-movies-list',
  templateUrl: './movies-list.component.html',
  styleUrls: ['./movies-list.component.css']
})
export class MoviesListComponent implements OnInit {
  displayedColumns: string[] = ['Name', 'Category', 'Producer', 'Director',
    'ReleaseDate', 'Edit', 'Delete'];
  dataSource: any;

  constructor(private moviesService: MoviesService,
    private router: Router) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.moviesService.getAllMoviesDetails().then(
      moviesList => {
        this.dataSource = new MatTableDataSource<Movies>(moviesList);
      },
      err => {
        console.log(err);
      }
    );
  }

  editMovieDetails(movie: Movies) {
    this.router.navigate(['movies/edit/' + movie.movieId])
  }

  deleteMovieDetails(movie?: Movies) {
    const movieId = movie.movieId;
    this.moviesService.deleteMovieById(movieId).then(
      response => {
        this.loadData();
      }
    );
    alert("Are you sure you want to delete the record ? This operation cannot be undone");
  }

  
}

