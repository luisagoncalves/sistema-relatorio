import { defineStore } from "pinia";
import { ref } from "vue";

export const useReportStore = defineStore('report', () => {
  const isEditing = ref(false);
  return {
    isEditing
  }
})
