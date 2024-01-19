export class Attachment {
  id: number | undefined
  description: string
  reportId: number

  constructor(id: number, description: string, reportId: number){
    this.id = id;
    this.description = description;
    this.reportId = reportId;
  }
}