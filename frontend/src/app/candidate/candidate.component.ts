import { Component, OnInit } from '@angular/core';
import { ApiService } from '../services/api.service';


@Component({
  selector: 'app-candidate',
  templateUrl: './candidate.component.html',
  styleUrls: ['./candidate.component.css']
})
export class CandidatesComponent implements OnInit {
  candidate: any;

  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    this.getCandidate();
  }

  getCandidate() : void {
    this.apiService.getCandidate().subscribe(
      (candidate) => {
        this.candidate = candidate;
      },
      (error) => {
        console.error('Error fetching candidates:', error);
      }
    );
  }
}
