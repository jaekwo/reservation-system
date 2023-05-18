import { createWebHistory, createRouter } from 'vue-router';
import MainView from '../views/MainView';
import LoginView from '../views/LoginView';
import JoinView from '../views/JoinView';

const routes = [
    {
        path: '/',
        component: MainView,
    },
    {
        path: '/loginView',
        component: LoginView,
    },
    {
        path: '/joinView',
        component: JoinView,
    },
];

export const router = createRouter({
    history: createWebHistory(),
    routes,
});