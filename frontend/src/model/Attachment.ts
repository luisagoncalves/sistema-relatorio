export class Attachment {
  description: string
  fileBase64: string

  constructor(description: string, fileBase64: string){
    this.description = description;
    this.fileBase64 = fileBase64;
  }
}
