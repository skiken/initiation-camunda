import {Component, Input, OnInit} from '@angular/core';
import {Employee} from '../employee';
import {EmployeeService} from '../employee.service';
import {ActivatedRoute, Router} from '@angular/router';
import {FormBuilder, FormGroup, Validators} from '@angular/forms';
import {first} from 'rxjs/operators';

@Component({
  selector: 'app-employee-details',
  templateUrl: './employee-details.component.html',
  styleUrls: ['./employee-details.component.css']
})
export class EmployeeDetailsComponent implements OnInit {
  editForm: FormGroup;
  employee: Employee;
  private id = window.localStorage.getItem('editUserId');

  // tslint:disable-next-line:max-line-length
  constructor(private formBuilder: FormBuilder, private router: Router , private employeeService: EmployeeService, private route: ActivatedRoute, ) { }

  ngOnInit() {
    this.editForm = this.formBuilder.group({
      id: [''],
      firstName: ['', Validators.required],
      lastName: ['', Validators.required],
      emailId: ['', Validators.required]
    });
    this.route.params.subscribe(res => {
      // console.log(res);
      this.employeeService.getEmployeeById(+res.id)
        .subscribe( data => {
          // console.log(data);
          this.editForm.setValue(data);
        });
    });
  }

  onSubmit() {

    this.employeeService.updateEmployee(this.id, this.editForm.value)
      .pipe(first())
      .subscribe(
        data => {
          if (data === 200) {
            alert('User updated successfully.');
            this.router.navigate(['list-user']);
          } else {
            alert(data);
          }
        },
        error => {
          alert(error);
        });
  }


}
