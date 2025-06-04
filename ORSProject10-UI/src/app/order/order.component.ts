import { Component} from '@angular/core';
import { BaseCtl } from '../base.component';
import { ServiceLocatorService } from '../service-locator.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent extends BaseCtl {
  // errorMessageTitle: string = '';
  // errorMessagefullName: string = '';

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.ORDER, locator, route);
  }

   onUpload(orderForm: FormData) {
    this.submit();
    console.log(this.form.data.id + '---- after submit');

  }
   
   validate() {
     return this.validateForm(this.form.data);
   }

  validateForm(form) {
    let flag = true;
    let validator = this.serviceLocator.dataValidator;
    flag = flag && validator.isNotNullObject(form.productName);
    flag = flag && validator.isNotNullObject(form.orderDate);
    flag = flag && validator.isNotNullObject(form.customer);
    flag = flag && validator.isNotNullObject(form.quantity);

    return flag;
  }

  populateForm(form, data) {
    form.id = data.id;
    form.productName = data.productName;
    form.orderDate = data.orderDate;
    form.customer = data.customer;
    form.quantity = data.quantity;
  }

   parseDate(dateString: string): Date {
    if (dateString) {
      return new Date(dateString);
    }
    return null;
  }

}
