import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { candidate } from './candidate';

@Injectable({
  providedIn: 'root'
})
export class CandidateService {
  private _url: string = "https://localhost:8080:"
  constructor(private http: HttpClient){
    getCandidate(): any {
      return this.http.get<candidate>(this._url + '1');
    }
  }

}
