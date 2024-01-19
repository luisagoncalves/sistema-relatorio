import { defineStore } from "pinia";
import { reactive, ref } from "vue";

export const useLayoutStore = defineStore('layout', () => {
    const openDrawer = ref(true);

    const snackbar = reactive({
        isActive: false,
        color: '',
        text: ''
    })

    const createSnackbar = (color: string, text: string) => {
        snackbar.isActive = true;
        snackbar.color = color;
        snackbar.text = text;
    }

    return{
        openDrawer,
        createSnackbar,
        snackbar
    }
})