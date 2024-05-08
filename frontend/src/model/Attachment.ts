export class Attachment {
  id?: number
  description: string
  type: string
  fileBase64: string

  constructor(description: string, type: string, fileBase64: string){
    this.description = description;
    this.type = type;
    this.fileBase64 = fileBase64;
  }
}
