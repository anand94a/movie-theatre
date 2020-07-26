import { Component, OnInit } from '@angular/core';
import { Multiplex } from '../model/multiplex';
import { FormGroup, Validators, FormControl } from '@angular/forms';
import { MultiplexService } from 'src/app/shared/multiplex-service/multiplex.service';
import { Router, ActivatedRoute } from '@angular/router';

export class Screens {
  value: number;
  viewValue: number;

  constructor(value?:number, viewValue?:number){
    this.value = value;
    this.viewValue = viewValue;
  }
}

@Component({
  selector: 'app-add-edit-multiplex',
  templateUrl: './add-edit-multiplex.component.html',
  styleUrls: ['./add-edit-multiplex.component.css']
})
export class AddEditMultiplexComponent implements OnInit {

  multiplexFormGroup: FormGroup;
  multiplex: Multiplex;
  multiplexItemsForPatch: any;
  multiplexId: String;

  screens: Screens[] = [
    {value: 1, viewValue: 1},
    {value: 2, viewValue: 2},
    {value: 3, viewValue: 3},
    {value: 4, viewValue: 4},
    {value: 5, viewValue: 5},
    {value: 6, viewValue: 6},
    {value: 7, viewValue: 7},
  ];

  constructor(private multiplexService: MultiplexService,
              private router: Router,
              private activatedRoute: ActivatedRoute) {}

  ngOnInit(): void {

    this.initializeDataOnFormFields();
    
    this.activatedRoute.paramMap.subscribe(params => {
      const multiplexId = params.get('multiplexId');
      if (multiplexId) {
        this.getMultiplexById(multiplexId);
        this.multiplexId = multiplexId;
      }
    })
  }

  getMultiplexById(multiplexId: String) {
    this.multiplexService.getMultiplexById(multiplexId).then(
      response => {
        this.multiplexItemsForPatch = response;
        this.multiplex = this.multiplexItemsForPatch;
        this.patchMultiplexDetailsOnTheForm(this.multiplex);
      }
    );
  }

  initializeDataOnFormFields() {
    this.multiplexFormGroup = new FormGroup({
      multiplexName: new FormControl('', Validators.required),
      city: new FormControl('', Validators.required),
      numberOfScreens: new FormControl(this.screens[0], Validators.required)
    });
  }

  patchMultiplexDetailsOnTheForm(multiplex: Multiplex) {
    this.multiplexFormGroup.setValue({
      multiplexName: multiplex.multiplexName,
      city: multiplex.city,
      numberOfScreens: multiplex.numberOfScreens
    })
  }

  saveMovie() {
    this.multiplex = new Multiplex();
    this.multiplex.multiplexName = this.multiplexFormGroup.get('multiplexName').value;
    this.multiplex.city = this.multiplexFormGroup.get('city').value;
    this.multiplex.numberOfScreens = parseInt(this.multiplexFormGroup.get('numberOfScreens').value);

    if (this.multiplexId == null) {
      this.multiplexService.saveMultiplexDetails(this.multiplex)
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
      this.multiplexService.updateMultiplexDetails(this.multiplexId, this.multiplex)
        .then(
          response => {
            console.log('Updated')
          },
          error => {
            console.log(error)
          });
      alert("Data has been edited");
    }

    this.router.navigate(['multiplex/multiplexList']);
  }

  clearData() {
    this.multiplexFormGroup.reset();
    this.initializeDataOnFormFields();
  }

  cancel() {
    this.multiplexFormGroup.reset();
    this.router.navigate(['multiplex/multiplexList']);
  }

}
