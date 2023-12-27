import { defineStore } from "pinia";
import { ref } from "vue";
import { Report } from '@/model/Report'

export const useReportStore = defineStore('report', () => {

  const reportDefault = ref<Report>({
    id: undefined,
    title: '',
    description: '',
    attachments: [],
    createdAt: undefined,
    updatedAt: undefined
  })

  return {
    reportDefault
  }
})