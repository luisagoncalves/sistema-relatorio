import { Attachment } from './Attachment';

export class Report {
  id: number;
  title: string;
  description: string;
  anexos?: Attachment[];
  createdAt: Date;
  updatedAt?: Date;

  constructor(id: number, title: string, description: string, createdAt: Date, anexos?: Attachment[], updatedAt?: Date) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.createdAt = createdAt;
    this.anexos = anexos;
    this.updatedAt = updatedAt;
  }
}