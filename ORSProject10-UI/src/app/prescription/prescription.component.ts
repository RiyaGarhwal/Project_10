import { Component} from '@angular/core';
import { ServiceLocatorService } from '../service-locator.service';
import { BaseCtl } from '../base.component';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent extends BaseCtl {
  // errorMessageTitle: string = '';
  // errorMessagefullName: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.PRESCRIPTION, locator, route);
  }

   onUpload(prescriptionForm: FormData) {
    this.submit();
    console.log(this.form.data.id + '---- after submit');

  }
   
   validate() {
     return this.validateForm(this.form.data);
   }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.name);
    flag = flag && validator.isNotNullObject(form.date);
    flag = flag && validator.isNotNullObject(form.decease);
    flag = flag && validator.isNotNullObject(form.capacity);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.name = data.name;
    form.date = data.date;
    form.decease = data.decease;
    form.capacity = data.capacity;
  }

   parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

}
