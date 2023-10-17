import { LoginOptions } from "angular-oauth2-oidc";

export interface ProjectDtoApi {
    id:any;
    name : string;
    shortcut : string;
    deadline : Date;
    createUser: String;
    createDate: Date;
  }
  
  export class ProjectDto implements ProjectDtoApi{
    constructor() {
    }
    id:any;
    deadline: any;
    shortcut: any;
    name: any;
    createUser: any;
    createDate: any;
  }

  export interface ProjectLightDtoApi {
    id:any;
    name : string;
  }
  
  export class ProjectLightDto implements ProjectLightDtoApi{
    constructor() {
    }
    id:any;
    name: any;
  }
  
  export interface UserDtoApi {
    email: string;
    name: string;
    id: number;
    admin:boolean;
  }
  
  export class UserDto implements UserDtoApi{
    constructor() {
    }
    email: any;
    name: any;
    id: any;
    admin:any;
  }

  export interface UserPostDtoApi {
    email: string;
    name: string;
    password: string;
  }
  
  export class UserPostDto implements UserPostDtoApi{
    constructor() {
    }
    email: any;
    name: any;
    password: any;
  }

  export interface UserForChoosePostDtoApi {
    email: string;
    name: string;
    projectId: number;
    ticketId: number;
  }
  
  export class UserForChoosePostDto implements UserForChoosePostDtoApi{
    constructor() {
    }
    email: any;
    name: any;
    projectId: any;
    ticketId: any;
  }
  
  export interface TicketDtoApi{
    id:number;
    key:string;
    name:string;
    type:string;
    createUser:string;
    assignee:string;
    createDate:Date;
    deadline:Date;
    startDate:Date;
    endDate:Date;
    progress:number;
    projectShortcut:string;
    projectId:number;
    description:string;
    state:string;
    duration:number;
    projectDeadline:Date;
  }
  
  export class TicketDto implements TicketDtoApi{
    constructor() {
    }
    id:any;
    key:any;
    name:any;
    type:any;
    createUser:any;
    assignee:any;
    createDate:any;
    deadline:any;
    projectShortcut:any;
    projectId:any;
    description:any;
    state: any;
    startDate:any;
    endDate:any;
    progress:any;
    duration:any;
    projectDeadline:any;
  }

  export interface TicketChartDtoApi{
    id:number;
    key:string;
    name:string;
    assignee:string;
    startDate:Date;
    endDate:Date;
    duration:number;
    progress:number;
  }
  
  export class TicketChartDto implements TicketChartDtoApi{
    constructor() {
    }
    id:any;
    key:any;
    name:any;
    assignee:any;
    endDate:any;
    startDate:any;
    duration:any;
    progress:any;
  }

  export interface TicketPostDtoApi{
    name:string;
    type:string;
    deadline:Date;
    projectId:number;
    description:string;
  }

  export class TicketPostDto implements TicketPostDtoApi{
    constructor() {}
    id:any;
    name:any;
    type:any;
    deadline:any;
    projectId:any;
    description:any;
  }

  export interface ProjectForSelectApi{
    id: number;
    shortcut: string;
  }

  export class ProjectForSelect implements ProjectForSelectApi{
    id: any;
    shortcut: any;
  }
  
  export interface AttributeDtoApi{
    name: String;
    type: String;
    id:number;
    projectId: number;
  }

  export class AttributeDto implements AttributeDtoApi{
    name:any;
    type: any;
    id: any;
    projectId:any;
  }

  export interface AttributeValueDtoApi{
    stringValue: String;
    ticketId: number;
    boolValue: boolean;
    numberValue: number;
    dateValue: Date;
    type: String;
    attributeId: number;
    id: number;
  }

  export class AttributeValueDto implements AttributeValueDtoApi{
    stringValue: any;
    ticketId: any;
    boolValue: any;
    dateValue: any;
    numberValue: any;
    type: any;
    attributeId: any;
    id: any;
  }

  export interface TaskDtoApi{
    done: boolean;
    description: string;
    ticketId:number;
    id:number;
  }

  export class TaskDto implements TaskDtoApi{
    done: any;
    description: any;
    ticketId:any;
    id:any;
  }

  export interface DateAndIdApi{
    date: Date;
    id: number;

  }

  export class DateAndId implements DateAndIdApi{
    date: any;
    id:any;
    constructor(id:number, date:Date){
      this.date=date;
      this.id=id;
    }
  }

