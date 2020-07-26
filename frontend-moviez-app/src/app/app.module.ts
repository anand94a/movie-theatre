import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatIconModule } from '@angular/material/icon';
import { MatTabsModule } from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatGridListModule } from '@angular/material/grid-list';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { MatSelectModule } from '@angular/material/select';
import { MatCardModule } from '@angular/material/card';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { MatRadioModule } from '@angular/material/radio';

import { ReactiveFormsModule, FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MoviesListComponent } from './movies/movies-list/movies-list.component';
import { AddEditMovieComponent } from './movies/add-edit-movie/add-edit-movie.component';
import { MoviesViewComponent } from './movies/movies-view/movies-view.component';
import { MultiplexListComponent } from './multiplex/multiplex-list/multiplex-list.component';
import { AddEditMultiplexComponent } from './multiplex/add-edit-multiplex/add-edit-multiplex.component';
import { MultiplexViewComponent } from './multiplex/multiplex-view/multiplex-view.component';
import { MovieMultiplexAllotmentComponent } from './movie-multiplex-allotment/movie-multiplex-allotment.component';

import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { HttpInterceptorService } from './shared/http-interceptor-service/http-interceptor.service';

import { HomeComponent } from './home/home.component';
import { SearchComponent } from './search-multiplex/search.component';
import { AllottedMoviesToMultiplexComponent } from './search-allotment/allotted-movies-to-multiplex.component';

@NgModule({
  declarations: [
    AppComponent,
    MoviesListComponent,
    AddEditMovieComponent,
    MoviesViewComponent,
    MultiplexListComponent,
    AddEditMultiplexComponent,
    MultiplexViewComponent,
    MovieMultiplexAllotmentComponent,
    SearchComponent,
    HeaderComponent,
    LoginComponent,
    AllottedMoviesToMultiplexComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    FormsModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatIconModule,
    MatTabsModule,
    MatToolbarModule,
    MatGridListModule,
    MatFormFieldModule,
    MatInputModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatSelectModule,
    MatCardModule,
    MatCheckboxModule,
    MatRadioModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
