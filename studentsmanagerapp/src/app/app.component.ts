import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Student } from './models/student';
import { StudentService } from './services/student.service';
import { HttpErrorResponse } from '@angular/common/http';
import { AlgorithmService } from './services/algorithm.service';
import { SortStudentsRequest } from './models/sortStudentsRequest';
import { SortAlgorithm } from './models/sortalgorithm';
import { DomSanitizer } from '@angular/platform-browser';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, AfterViewInit {
  public displayedColumns: string[];
  public dataSource: any;
  public students: Student[] = [];
  public algorithms: SortAlgorithm[];
  public selectedAlgorithm: SortAlgorithm;
  public sortStudentsRequest: SortStudentsRequest;
  public timer: number = 0;
  public fileToUpload: File | null = null;
  public fileUrl;

  constructor(private studentService: StudentService, private algorithmService: AlgorithmService, private sanitizer: DomSanitizer){}

  ngOnInit() {
    this.getAlgorithms();
    this.displayedColumns = ['name', 'grade'];
    this.createStudentsFileExport();

    //this.dataSource = this.seedStudents();
  }

  createStudentsFileExport(){
    let data = "";
    for (var i = 0; i < this.students.length; i ++) {
      data += this.students[i].name + ";" + this.students[i].performance.grade + "\n";
    }

    const blob = new Blob([data], { type: 'application/octet-stream' });

    this.fileUrl = this.sanitizer.bypassSecurityTrustResourceUrl(window.URL.createObjectURL(blob));
  }

  handleFileInput(files: FileList) {
    this.fileToUpload = files.item(0);
    console.log(this.fileToUpload);
    this.studentService.postFile(this.fileToUpload).subscribe(
      (response: Student[]) => {
        this.students = response;
        this.dataSource = this.students;
        this.createStudentsFileExport();
        console.log(this.students);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  ngAfterViewInit() {
  }

  optionSelect(item){
    this.applyAlgorithm(item);
  }

  applyAlgorithm(item){
    console.log(this.sortStudentsRequest);

    this.sortStudentsRequest = { selectedAlgorithm: item, students: this.students };

    this.algorithmService.applyAlgorithm(this.sortStudentsRequest).subscribe(data=>{
      console.log(data);
      this.students = data.students;
      this.timer = data.timer;
      this.createStudentsFileExport();
    });
  }

  public getStudents(): void {
    this.studentService.getStudents().subscribe(
      (response: Student[]) => {
        this.students = response;
        console.log(this.students);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAlgorithms(): void {
    this.algorithmService.getAlgorithms().subscribe(
      (response: SortAlgorithm[]) => {
        this.algorithms = response;
        console.log(this.algorithms);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
