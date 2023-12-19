<template>
  <v-app-bar 
    flat 
    :elevation="2">
    <v-app-bar-nav-icon @click="openDrawer = !openDrawer" />
    <v-app-bar-title>App Bar</v-app-bar-title>

    <v-spacer />

    <span class="text-subtitle-2 mx-4">{{ userSelected }}</span>

    <v-menu 
      :close-on-content-click="false" 
      location="bottom">
      <template v-slot:activator="{ props: menu }">
        <v-tooltip :text="userSelected">
          <template v-slot:activator="{ props: tooltip }">
            <v-btn 
              v-bind="mergeProps(menu, tooltip)" 
              icon>
              <v-icon icon="mdi-account" />
            </v-btn>
          </template>
        </v-tooltip>
      </template>
      <v-list density="comfortable">
        <v-list-subheader>Change user</v-list-subheader>
        <v-switch 
          v-for="user in users" 
          :key="user.id" 
          :value="user"
          :label="user.role"
          :model-value="userSelected"
          :false-value="userSelected"
          hide-details
          density="compact"
          class="px-4"
          @click="getSelectedUser(user.role)"></v-switch>
      </v-list>
    </v-menu>
  </v-app-bar>
</template>

<script lang="ts" setup>
import { useLayoutStore } from '@/store/layoutStore';
import { useUserStore } from '@/store/userStore';

import { storeToRefs } from 'pinia';
import { onMounted } from 'vue';
import { reactive, mergeProps} from 'vue';

const layoutStore = useLayoutStore();
const { openDrawer } = storeToRefs(layoutStore);

const userStore = useUserStore();
const { userSelected } = storeToRefs(userStore);

const users = reactive([
  {
    id: 1,
    role: 'Manager'
  }, 
  {
    id: 2,
    role: 'Analyst'
  }
]);

const isThereUsers = () => {
  if (userSelected.value == "Not selected" && users.length > 0) {
    getSelectedUser(users[0].role);
  }
}

const getSelectedUser = (userRole: string) => {
  userSelected.value = userRole;
}

onMounted(() =>{
  isThereUsers()
})
</script>
