import { Component } from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-lead',
  templateUrl: './lead.component.html',
  styleUrls: ['./lead.component.css']
})
export class LeadComponent extends BaseCtl {
  // errorMessageTitle: string = '';
  // errorMessagefullName: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.LEAD, locator, route);
  }

   onUpload(leadForm: FormData) {
    this.submit();
    console.log(this.form.data.id + '---- after submit');

  }
   
   validate() {
     return this.validateForm(this.form.data);
   }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.contactName);
    flag = flag && validator.isNotNullObject(form.date);
    flag = flag && validator.isNotNullObject(form.status);
    flag = flag && validator.isNotNullObject(form.mobile);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.contactName = data.contactName;
    form.date = data.date;
    form.status = data.status;
    form.mobile = data.mobile;
  }

   parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

}
