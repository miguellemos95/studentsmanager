import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { SortAlgorithm } from '../models/sortalgorithm';
import { SortStudentsResponse } from '../models/sortStudentResponse';
import { SortStudentsRequest } from '../models/sortStudentsRequest';

@Injectable({
  providedIn: 'root'
})
export class AlgorithmService {
  private apiServerUrl = environment.apibaseUrl;

  constructor(private http: HttpClient){}

  public applyAlgorithm(sortStudentsRequest: SortStudentsRequest): Observable<SortStudentsResponse> {
    return this.http.put<SortStudentsResponse>(`${this.apiServerUrl}/algorithm/sort`, sortStudentsRequest);
  }

  public getAlgorithms(): Observable<SortAlgorithm[]> {
    return this.http.get<SortAlgorithm[]>(`${this.apiServerUrl}/algorithm/all`);
  }
}
