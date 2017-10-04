import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {UserProfile} from './UserProfile';
import { HttpHeaders } from '@angular/common/http';
import {UserCredentials} from './UserCredentials';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
@Injectable()
export class LoginService {

  userProfile:UserProfile=new UserProfile();

  constructor(private http:HttpClient) { }
    

  authenticateUser(userCredentials:UserCredentials):Observable<UserProfile>{

    return this.http.post("http://localhost:8019/users/authenticate",userCredentials,{
      headers:new HttpHeaders().append("Content-Type", "application/json")
      .append("accept","application/json")
    }).map(data=><UserProfile>data);

  }

}
