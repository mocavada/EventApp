import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { HttpClient} from '@angular/common/http';

import { EventService } from './../service/event.service';
import { Event } from './../pojo/event';

@Component({
  selector: 'app-event-create',
  templateUrl: './event-create.component.html',
  styleUrls: ['./event-create.component.css']
})
export class EventCreateComponent implements OnInit {
  eventList: [Event];
  entryCreateForm: FormGroup;
  devjson;

  constructor(  private dService: EventService,
                private fb: FormBuilder,
                private http: HttpClient,
              ) { }

  ngOnInit() {
    this.dService.eventEntry.subscribe(data => {
      if (data != null) {
        this.eventList = data;
        console.log('load Data');
      }
    });
    this.dService.getData();
    console.log('load Page');
    //
    this.createForm();
  }

  onSubmit(f) {
    if (f.valid) {
      console.log('This form is good to go.');
    }
    console.log(f.value);
    this.devjson = f.value;
    this.dService.postData(f.value);
  }


  createForm() {
    this.entryCreateForm = this.fb.group({
      title: '',
      organizer: '',
      email: '',
      contact: '',
      dateStart: '2011-08-19T13:45:00',
      dateEnd: '2011-08-19T13:45:00',
    });
  }

}
