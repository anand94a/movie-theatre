import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddEditMovieComponent } from './movies/add-edit-movie/add-edit-movie.component';
import { MoviesListComponent } from './movies/movies-list/movies-list.component';
import { MoviesViewComponent } from './movies/movies-view/movies-view.component';
import { MultiplexViewComponent } from './multiplex/multiplex-view/multiplex-view.component';
import { AddEditMultiplexComponent } from './multiplex/add-edit-multiplex/add-edit-multiplex.component';
import { MultiplexListComponent } from './multiplex/multiplex-list/multiplex-list.component';

import { LoginComponent } from './login/login.component';
import { MovieMultiplexAllotmentComponent } from './movie-multiplex-allotment/movie-multiplex-allotment.component';
import { AuthGuardService } from './shared/auth-guard/auth-guard.service';
import { HomeComponent } from './home/home.component';
import { AllottedMoviesToMultiplexComponent } from './search-allotment/allotted-movies-to-multiplex.component';
import { SearchComponent } from './search-multiplex/search.component';


const routes: Routes = [
  { 
    path: "", redirectTo: "home", pathMatch: "full" 
  },
  {
    path: 'movies', component: MoviesViewComponent, children: [
      {
        path: 'addEditMovies', component: AddEditMovieComponent
      },
      {
        path: 'edit/:movieId', component: AddEditMovieComponent
      },
      {
        path: 'moviesList', component: MoviesListComponent
      }
    ], canActivate: [AuthGuardService]
  },
  {
    path: 'multiplex', component: MultiplexViewComponent, children: [
      {
        path: 'addEditMultiplex', component: AddEditMultiplexComponent
      },
      {
        path: 'edit/:multiplexId', component: AddEditMultiplexComponent
      },
      {
        path: 'multiplexList', component: MultiplexListComponent
      }
    ], canActivate: [AuthGuardService]
  },
  {
    path: 'allot', component: MovieMultiplexAllotmentComponent, canActivate: [AuthGuardService]
  },
  {
    path: 'login', component: LoginComponent
  },
  {
    path: 'home', component: HomeComponent, children:[
      {
        path: 'search/allotment', component: AllottedMoviesToMultiplexComponent
      },
      {
        path: 'search/multiplex', component: SearchComponent
      }
    ]
  },
  {
    path: 'logout', component: HomeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
