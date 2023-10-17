import { Component, Input, OnInit } from '@angular/core';
import { TicketDto } from 'src/dtos';
import { GantChartRestService } from './gant-chart-rest.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-gant-chart',
  templateUrl: './gant-chart.component.html',
  styleUrls: ['./gant-chart.component.css'],
  template: `<ejs-gantt> </ejs-gantt>`
})
export class GantChartComponent implements OnInit {

    @Input() projectId: number= 0;
    public taskSettings: object | undefined;
    tickets: TicketDto[] = [];

    constructor(private ticketService: GantChartRestService,private router: Router) { }

    public ngOnInit(): void {
        this.ticketService.getTicketsForProject(this.projectId).subscribe((response: TicketDto[])=> {
            this.tickets = response; 
          })
        this.taskSettings = {
            id: 'key',
            name: 'name',
            startDate: 'startDate',
            endDate: 'endDate',
            duration: 'duration',
            progress: 'progress'
        };
    }

}
