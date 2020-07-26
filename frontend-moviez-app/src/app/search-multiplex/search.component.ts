import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { Multiplex } from '../multiplex/model/multiplex';
import { SearchService } from '../shared/search-service/search.service';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit {
  displayedColumns: string[] = ['Name', 'City',
  'Number of Screens'];
  dataSource: any;

  constructor(private searchService: SearchService) { }

  ngOnInit(): void {
    this.searchService.getMultiplexDetails().then(
      multiplexList => {
        this.dataSource = new MatTableDataSource<Multiplex>(multiplexList);
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
