import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs/index';
import { HttpClient } from '@angular/common/http';
import { environment } from '../../../environments/environment';

import { Event } from './../pojo/event';


@Injectable({
  providedIn: 'root'
})
export class EventService {

  private urlRoot = environment.serverAddress;

  constructor(private http: HttpClient) {
  }

  private results = new BehaviorSubject<[Event]>(null);
  eventEntry = this.results.asObservable();

  // GET Events
  getData() {
    this.http
      .get<[Event]>(this.urlRoot + '/event/all')
      .subscribe(data => {
        this.results.next(data);
      }, err => {
        console.log('Something went wrong in Getting Data!');
    });
  }

  // POST Event

  postData(entry: Event) {
    this.http
      .post<[Event]>(this.urlRoot + 'event/create', entry)
      .subscribe(data => {
        this.results.next(data);
        console.log(data);
      }, err => {
        console.log('Something went wrong in Posting Data!');
    });
  }
}

