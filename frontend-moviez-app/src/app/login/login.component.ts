import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, AbstractControl, ValidationErrors, ValidatorFn } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../shared/authentication-service/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  hide = true;
  loginFormGroup: FormGroup;
  usernameError: boolean;
  passwordError: boolean;
  errorCondition: boolean;
  errorMessage: String;

  constructor(private router: Router,
    private auth: AuthenticationService) { }

  ngOnInit(): void {
    this.initializeDataonLoginForm();
  }

  initializeDataonLoginForm() {
    this.loginFormGroup = new FormGroup({
      username: new FormControl('', Validators.required),
      password: new FormControl('',
        Validators.compose([Validators.required,
        this.patternValidator(/\d/, { hasNumber: true }),
        this.patternValidator(/[A-Z]/, { hasCapitalCase: true }),
        this.patternValidator(/[a-z]/, { hasSmallCase: true }),
        this.patternValidator(/[@#$\^%&]/, { hasSpecialCHaracters: true }),
        Validators.minLength(8)
        ]))
    });
  }

  errorCatch() {
    this.usernameError = this.loginFormGroup.hasError('username');
    this.passwordError = this.loginFormGroup.hasError('password');
  }

  patternValidator(regex: RegExp, error: ValidationErrors): ValidatorFn {
    return (control: AbstractControl): { [key: string]: any } => {
      if (!control.value) {
        return null;
      }

      const valid = regex.test(control.value);

      return valid ? null : error;
    };
  }

  login() {
    this.auth.authenticate(this.loginFormGroup.get('username').value,
      this.loginFormGroup.get('password').value).subscribe((result) => {
        this.router.navigate(['/movies/moviesList']);
      }, (reject) => {
        this.errorCondition = true;
        this.errorMessage = "You are not an Admin. Please enter the right credentials as an Admin !!"
        this.blanOutTheLoginForm();
      });
  }

  blanOutTheLoginForm() {
    this.loginFormGroup = new FormGroup({
      username: new FormControl(''),
      password: new FormControl('')
    });
  }

}
