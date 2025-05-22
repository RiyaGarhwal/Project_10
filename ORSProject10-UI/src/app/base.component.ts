import { OnInit } from '@angular/core';
import { ServiceLocatorService } from './service-locator.service';
import { ActivatedRoute } from '@angular/router';

export class BaseCtl implements OnInit {

  public api = {
    endpoint: null,
    get: null,
    save: null,
    search: null,
    delete: null,
    deleteMany: null,
    preload: null,
    report: null,
    address: null
  };

  public form: any = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: {},
    searchMessage: null,
    list: [],
    pageNo: 0
  };

  nextList = 0;

  constructor(public endpoint, public serviceLocator: ServiceLocatorService, public route: ActivatedRoute) {
    this.initApi(endpoint);
    this.serviceLocator.getPathVariable(route, (params) => {
      this.form.data.id = params['id'];
      console.log('I GOT ID', this.form.data.id);
    });
  }

  ngOnInit() {
    this.preload();
    if (this.form.data.id && this.form.data.id > 0) {
      this.display();
    }
  }

  initApi(ep) {
    this.api.endpoint = ep;
    this.api.get = ep + "/get";
    this.api.save = ep + "/save";
    this.api.search = ep + "/search";
    this.api.delete = ep + "/delete";
    this.api.deleteMany = ep + "/deleteMany";
    this.api.preload = ep + "/preload";
    this.api.report = ep + "/report";
    this.api.address = ep + "/address";
    console.log('API', this.api);
  }

  preload() {
    this.serviceLocator.httpService.get(this.api.preload, (res) => {
      if (res.success) {
        this.form.preload = res.result;
      } else {
        this.form.error = true;
        this.form.message = res.result.message;
      }
    });
  }

  validate() {
    return this.validateForm(this.form.data);
  }

  validateForm(form) { }

  search() {
    this.serviceLocator.httpService.post(`${this.api.search}/${this.form.pageNo}`, this.form.searchParams, (res) => {
      if (res.success) {
        this.form.list = res.result.data;
        this.nextList = res.result.nextList;
        if (this.form.list.length === 0) {
          this.form.message = 'No record found';
          this.form.error = true;
        }
      } else {
        this.form.error = false;
        this.form.message = res.result.message;
      }
    });
  }

  searchOperation(operation: string) {
    this.serviceLocator.httpService.post(`${this.api.search}/${this.form.pageNo}`, this.form.searchParams, (res) => {
      if (operation === 'next' || operation === 'previous') {
        this.nextList = res.result.nextList;
        this.form.message = null;
        this.form.error = false;
      }

      if (res.success) {
        this.form.list = res.result.data;
        if (this.form.list.length === 0) {
          this.form.message = 'No record found';
          this.form.error = true;
        }
      } else {
        this.form.error = false;
        this.form.message = res.result.message;
      }
    });
  }

  display() {
    this.serviceLocator.httpService.get(`${this.api.get}/${this.form.data.id}`, (res) => {
      if (res.success) {
        this.populateForm(this.form.data, res.result.data);
      } else {
        this.form.error = true;
        this.form.message = res.result.message;
      }
    });
  }

  populateForm(form, data) {
    form.id = data.id;
  }

  submit() {
    this.serviceLocator.httpService.post(this.api.save, this.form.data, (res) => {
      this.form.message = '';
      this.form.inputerror = {};

      if (res.success) {
        this.form.message = 'Data is saved';
        this.form.data.id = res.result.data.id;
      } else {
        this.form.error = true;
        this.form.message = res.result.message;
        if (res.result.inputerror) {
          this.form.inputerror = res.result.inputerror;
        }
      }
    });
  }

  delete(id, callback?) {
    this.serviceLocator.httpService.get(`${this.api.delete}/${id}`, (res) => {
      if (res.success) {
        this.form.message = 'Data is deleted';
        if (callback) {
          callback();
        }
      } else {
        this.form.error = true;
        this.form.message = res.result.message;
      }
    });
  }

  deleteMany(id, callback?) {
    this.serviceLocator.httpService.post(`${this.api.deleteMany}/${id}`, this.form.data, (res) => {
      if (res.success) {
        this.form.message = 'Data is deleted';
        if (callback) {
          this.form.list = res.result.data;
        }
      } else {
        this.form.error = true;
        this.form.message = res.result.message;
      }
    });
  }

  generateReport() {
    this.serviceLocator.httpService.get(this.api.report, (res) => {
      if (res.success) {
        alert('Report Generated Successfully');
      } else {
        alert('Failed to Generate Report');
      }
    });
  }

  forward(page) {
    this.serviceLocator.forward(page);
  }
}
