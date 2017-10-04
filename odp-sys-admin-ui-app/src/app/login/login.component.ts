import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { routerTransition } from '../router.animations';
import {LoginService} from './login.service';
import {UserCredentials} from './UserCredentials';
import {UserProfile} from './UserProfile';

@Component({
    selector: 'app-login',
    templateUrl: './login.component.html',
    styleUrls: ['./login.component.scss'],
    animations: [routerTransition()]
})
export class LoginComponent implements OnInit {

    userCredentials:UserCredentials=new UserCredentials();
    email:string;
    password:string;
    userProfile:UserProfile=new UserProfile();
    

    constructor(public router: Router,private loginservice:LoginService) {
    }

    ngOnInit() {

    }

    onLoggedin() {
        console.log("reached component");
        this.userCredentials.email=this.email;
        this.userCredentials.password=this.password;
        this.loginservice.authenticateUser(this.userCredentials)
        .subscribe(data=>{
            
            this.userProfile=<UserProfile>data;
            console.log("Data recieved when subscribed");
            console.log(data);
        
        
        });
        
        console.log("data in UserProfile Object "+this.userProfile.email)
        if(this.userProfile.email!=null){
            localStorage.setItem('isLoggedin', 'true');
            sessionStorage.setItem("userprofile",this.userProfile.email);
        }
    }

}