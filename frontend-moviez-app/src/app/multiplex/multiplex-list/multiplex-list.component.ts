import { Component, OnInit } from '@angular/core';
import { Multiplex } from '../model/multiplex';
import { MatTableDataSource } from '@angular/material/table';
import { MultiplexService } from 'src/app/shared/multiplex-service/multiplex.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-multiplex-list',
  templateUrl: './multiplex-list.component.html',
  styleUrls: ['./multiplex-list.component.css']
})
export class MultiplexListComponent implements OnInit {

  displayedColumns: string[] = ['Name', 'City',
                                'Number of Screens', 'Edit', 'Delete'];
  dataSource: any;

  constructor(private multiplexService: MultiplexService,
    private router: Router) { }

  ngOnInit(): void {
    this.loadData();
  }

  loadData() {
    this.multiplexService.getAllMultiplexDetails().then(
      moviesList => {
        this.dataSource = new MatTableDataSource<Multiplex>(moviesList);
      },
      err => {
        console.log(err);
      }
    );
  }

  editMovieDetails(multiplex: Multiplex) {
    this.router.navigate(['multiplex/edit/' + multiplex.multiplexId])
  }

  deleteMovieDetails(multiplex?: Multiplex) {
    const multiplexId = multiplex.multiplexId;
    this.multiplexService.deleteMultiplexById(multiplexId).then(
      response => {
        this.loadData();
      }
    );
    confirm("Are you sure you want to delete the record ? This operation cannot be undone");
  }

  
}