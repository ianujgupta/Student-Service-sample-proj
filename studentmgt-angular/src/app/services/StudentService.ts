import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Student } from '../model/Student';

@Injectable()
export class StudentService{

    constructor(private http:HttpClient) {
    }
    addStudent(student:Student):Observable<Student>{
        let url="http://localhost:8080/students/add";
        let observable:Observable<Student>= this.http.post<Student>(url,student);
        console.log(" add student service")
        return observable;  
      }
    
      // getStudentById(studentId:number){
      //   let url="http://localhost:8080/students/get/"+studentId;
      //   let observable:Observable<Student>=this.http.get<Student>(url);
      //   console.log(" find student  Student Service")
      //   return observable;
      // }
    
      fetchAllStudent():Observable<Student[]>{
        let url="http://localhost:8080/students";
        let observable:Observable<Student[]>=this.http.get<Student[]>(url);
        console.log("inside SERVICE")
        return observable;
      }
    
      updateStudent(studentId:number){
        let url= "http://localhost:8080/students/update";
        let observable:Observable<Student>=this.http.put<Student>(url,studentId);
        return observable;
      }
    
      removeStudentById(id:number):Observable<void>{
          let url ="http://localhost:8080/students/deletebyid/"+id;
          let observable:Observable<void>=this.http.delete<void>(url);
          return observable;
      }  
}