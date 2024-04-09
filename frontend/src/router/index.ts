// Composables
import { createRouter, createWebHistory } from 'vue-router'
import ReportListView from '@/views/ReportListView.vue';
import ReportFormView from "@/views/ReportFormView.vue";
import HomeView from "@/views/HomeView.vue";

const routes = [
  {
    path: '/',
    redirect: '/home',
    component: () => import('@/layouts/default/Default.vue'),
    children: [
      {
        path: '/home',
        name: 'HomeView',
        component: HomeView
      },
      {
        path: '/reports',
        name: 'ReportListView',
        component: ReportListView
      },
      {
        path: '/form/:id',
        name: 'ReportFormView',
        component: ReportFormView
      },
    ],
  },
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
