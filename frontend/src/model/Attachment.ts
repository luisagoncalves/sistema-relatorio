export class Attachment {
  id?: number
  type: string
  fileBase64: string

  constructor(type: string, fileBase64: string){
    this.type = type;
    this.fileBase64 = fileBase64;
  }
}
