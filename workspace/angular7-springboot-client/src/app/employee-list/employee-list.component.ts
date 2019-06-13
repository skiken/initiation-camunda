import { Component, OnInit } from '@angular/core';
import {EmployeeService} from '../employee.service';
import {Employee} from '../employee';
import {Observable} from 'rxjs';
import {Router} from '@angular/router';


@Component({
  selector: 'app-employee-list',
  templateUrl: './employee-list.component.html',
  styleUrls: ['./employee-list.component.css']
})
export class EmployeeListComponent implements OnInit {
  employees: Observable<Employee[]>;
  constructor(private router: Router, private employeservice: EmployeeService) { }

  ngOnInit() {
    this.reloadData();
  }

  deleteEmployee(id) {
    this.employeservice.deleteEmployeeById(id)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log('ERROR: ' + error));
  }

  update(employee: Employee): void {
    window.localStorage.removeItem('editUserId');
    window.localStorage.setItem('editUserId', employee.id.toString());
    this.router.navigate(['employee-details/' + employee.id]);
  }

  reloadData() {
    this.employees = this.employeservice.getEmployeeList();
  }
}
