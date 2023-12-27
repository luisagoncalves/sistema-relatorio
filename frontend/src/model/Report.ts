import { Attachment } from './Attachment';

export class Report {
  id: number | undefined;
  title?: string;
  description?: string;
  anexos?: Attachment[];
  createdAt?: Date;
  updatedAt?: Date;
}