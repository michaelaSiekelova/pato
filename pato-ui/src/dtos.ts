export interface ProjectDtoApi {
    id:any;
    name : string;
    key : string;
    deadline : any;
  }
  
  export class ProjectDto implements ProjectDtoApi{
    constructor() {
    }
    id:any;
    deadline: any;
    key: any;
    name: any;
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
  }
  
  export class UserDto implements UserDtoApi{
    constructor() {
    }
    email: any;
    name: any;
  }
  
  export interface TicketDtoApi{
    id:any;
    key:string;
    name:string;
    type:string;
    createUser:string;
    assignee:string;
    createDate:Date;
    deadline:Date;
    projectName:string;
    projectId:number;
    description:string;
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
    projectName:any;
    projectId:any;
    description:any;
  }
  