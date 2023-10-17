import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserDto } from 'src/dtos';
import { UserDetailService } from './user-detail.service';

@Component({
  selector: 'app-user-detail',
  templateUrl: './user-detail.component.html',
  styleUrls: ['./user-detail.component.css']
})
export class UserDetailComponent implements OnInit {

  userId:number;
  user: UserDto = new UserDto();
  

  constructor(private router: Router, private userService: UserDetailService) {
    this.userId = Number(this.router.getCurrentNavigation()?.extras.state);
   }

  ngOnInit(): void {
    if (this.userId==undefined || Number.isNaN(this.userId)){
      this.userService.getCurrentUser().subscribe((response: UserDto)=> {
        this.user = response; 
      })
    }else {
      this.userService.getUserById(this.userId).subscribe((response: UserDto)=> {
        this.user = response; 
      })
    }
  }

  backToOverview(): void{
    this.router.navigateByUrl("/Users");
  }

}
