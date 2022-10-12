import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Student } from '../models/student';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  private apiServerUrl = environment.apibaseUrl;

  constructor(private http: HttpClient){}

  public getStudents(): Observable<Student[]> {
    return this.http.get<Student[]>(`${this.apiServerUrl}/student/all`);
  }

  public postFile(fileToUpload): Observable<Student[]>{
    console.log(fileToUpload);
    const formData = new FormData();

    // Store form name as "file" with file data
    formData.append("file", fileToUpload, fileToUpload.name);
    console.log(formData);
    return this.http.post<Student[]>(`${this.apiServerUrl}/student/addAll`, formData);
  }
}
