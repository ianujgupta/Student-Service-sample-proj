import { Component } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/Student';
import { StudentService } from '../services/StudentService';

@Component({
  selector: 'app-update-student',
  templateUrl: './update-student.component.html',
  styleUrls: ['./update-student.component.css']
})
export class UpdateStudentComponent {

  student: Student;
  id: number;

  constructor(private service:StudentService) { }

  updateStudent(form: any) {
    let data = form.value;
    let id = form.value;
    let name=data.name;
    let age= data.age;
    let address=data.adddress; 
    let phoneNumber=data.phoneNumber;
    this.student = new Student(name, age, address, phoneNumber);
    let successFun = (studentArg: Student) => {
      this.student = studentArg;
      alert("update successfully")
    };
    let errFun = err => {
      console.log("err in update student component " + err.message);
    }
    let observable:Observable<Student> =this.service.updateStudent(id);
    observable.subscribe(successFun, errFun);
  }
}
