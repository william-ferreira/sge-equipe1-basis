import { Component } from '@angular/core';
import { AppComponent } from '../../app.component';
import { Authentication, User } from '@nuvem/angular-base';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
    selector: 'app-topbar',
    templateUrl: './app.topbar.component.html'
})
export class AppTopbarComponent {

    constructor(public app: AppComponent, public loginService: AuthenticationService) {
    }

}
