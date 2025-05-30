import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';
import { ServiceLocatorService } from '../service-locator.service';

@Component({
  selector: 'app-followup',
  templateUrl: './followup.component.html',
  styleUrls: ['./followup.component.css']
})
export class FollowupComponent extends BaseCtl {
  // errorMessageTitle: string = '';
  // errorMessagefullName: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.FOLLOWUP, locator, route);
  }

   onUpload(followupForm: FormData) {
    this.submit();
    console.log(this.form.data.id + '---- after submit');

  }
   
   validate() {
     return this.validateForm(this.form.data);
   }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.patient);
    flag = flag && validator.isNotNullObject(form.visitDate);
    flag = flag && validator.isNotNullObject(form.doctor);
    flag = flag && validator.isNotNullObject(form.fees);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.doctor = data.doctor;
    form.visitDate = data.visitDate;
    form.fees = data.fees;
    form.patient = data.patient;
  }

   parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

  // validateName(event: KeyboardEvent): void {
  //   const inputValue = (event.target as HTMLInputElement).value;
  //   const inputChar = event.key;
  //   const alphabetPattern = /^[a-zA-Z]*$/;  // Pattern to match only alphabetic characters

  //   if (!alphabetPattern.test(inputChar) && !['Backspace', 'Delete', 'Tab'].includes(inputChar)) {
  //     event.preventDefault();
  //     this.errorMessagefullName = 'Only alphabets are allowed.';
  //     return;
  //   }

  //  else if (inputValue.length < 3) {
  //     this.errorMessagefullName = 'fullName must be at least 3 characters long.';
  //   } else if (inputValue.length > 15) {
  //     this.errorMessagefullName = 'fullName must not exceed 15 characters.';
  //   } else {
  //     this.errorMessagefullName = '';  // Clear error message if valid
  //   }
  }

  // validateAlphabetInput(event) {
  //   const charCode = event.which || event.keyCode;
  //   const charStr = String.fromCharCode(charCode);

  //   // Regular expression to test if the character is a letter
  //   if (!/^[a-zA-Z]+$/.test(charStr)) {
  //     event.preventDefault();
  //   }
  // }


