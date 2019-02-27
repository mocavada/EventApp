import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { EventCreateComponent } from './event-create/ui/event-create.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { EventComponent } from './event/event.component';
import { HeaderComponent } from './header/header.component';
import { EventAllComponent } from './event-all/event-all.component';



@NgModule({
   declarations: [
      AppComponent,
      HeaderComponent,
      EventComponent,
      EventAllComponent,
      EventCreateComponent
   ],
   imports: [
      BrowserModule,
      AppRoutingModule,
      FormsModule,
      ReactiveFormsModule,
      HttpClientModule
   ],
   providers: [],
   bootstrap: [
      AppComponent
   ]
})
export class AppModule { }
