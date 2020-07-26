import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Allotment } from '../movie-multiplex-allotment/model/allotment';
import { SearchService } from '../shared/search-service/search.service';

@Component({
  selector: 'app-allotted-movies-to-multiplex',
  templateUrl: './allotted-movies-to-multiplex.component.html',
  styleUrls: ['./allotted-movies-to-multiplex.component.css']
})
export class AllottedMoviesToMultiplexComponent implements OnInit {
  displayedColumns: string[] = ['Movie Name', 'Multiplex Name', 'Screen Number', 'City'];
  dataSource: any;
  
  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
    this.searchService.getAllotmentDetails().then(
      allotmentList => {
        this.dataSource = new MatTableDataSource<Allotment>(allotmentList);
      },
      err => {
        console.log(err);
      }
    );
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }


}
