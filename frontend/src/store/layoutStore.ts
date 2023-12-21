import { defineStore } from "pinia";
import { ref } from "vue";

export const useLayoutStore = defineStore('layout', () => {
    const openDrawer = ref(true);

    return{
        openDrawer
    }
})