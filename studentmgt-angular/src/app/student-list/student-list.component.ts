import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';
import { Student } from '../model/Student';
import { StudentService } from '../services/StudentService';

@Component({
  selector: 'app-student-list',
  templateUrl: './student-list.component.html',
  styleUrls: ['./student-list.component.css']
})
export class StudentListComponent {

  students:Student[];
  constructor(private service:StudentService,private router:Router) { 
    let observable:Observable<Student[]>=this.service.fetchAllStudent();
    observable.subscribe(
      studentArray=>{this.students=studentArray;},
      error=>console.log("In List Student"+ error.message)
    );
  }

  removeStudent(id: number) {
    let observable = this.service.removeStudentById(id);
    observable.subscribe(
      res =>   this.removeLocalElement(id),
      err =>console.log("inside remove, err is " + err.message)
    );
  }
  removeLocalElement(id:number): void {
    for (let i = 0; i < this.students.length; i++) {
      let student = this.students[i];
      if (student.id === id) {
        this.students.splice(i, 1);
      }
    }
  }

}
