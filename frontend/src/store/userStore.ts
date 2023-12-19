import { defineStore } from "pinia";
import { ref } from "vue";

export const useUserStore = defineStore('user', () => {
    const userSelected = ref('Not selected');

    return{
        userSelected
    }
})