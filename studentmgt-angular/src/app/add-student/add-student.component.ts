import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/Student';
import { StudentService } from '../services/StudentService';

@Component({
  selector: 'app-add-student',
  templateUrl: './add-student.component.html',
  styleUrls: ['./add-student.component.css']
})
export class AddStudentComponent implements OnInit {
  student: any;

  constructor(private service:StudentService) { }


    addStudent(form: any) {
      let data = form.value;
      let name=data.name;
      let age=data.age;
      let address=data.address;
      let phoneNumber=data.phoneNumber;
      this.student = new Student(name, age, address, phoneNumber);
      let successFun = (studentArg: Student) =>this.student = studentArg;
      let errFun = err =>console.log("err in addtestcomponent " + err.message);
      let observable: Observable<Student> = this.service.addStudent(this.student);
      observable.subscribe(successFun, errFun);
    }

  ngOnInit(): void {
  }

}
