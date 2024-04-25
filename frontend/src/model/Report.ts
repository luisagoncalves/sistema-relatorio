import { Attachment } from './Attachment';

export class Report {
  id: number | undefined;
  title?: string;
  description?: string;
  attachments?: Attachment[] = [];
}
