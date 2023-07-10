import { createWebHistory, createRouter } from 'vue-router';
import MainView from '../components/Main/MainView';
import LoginView from '../components/Account/LoginView';
import JoinView from '../components/Account/JoinView';
import HotelListView from '../components/Hotel/HotelListView';

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
    {
        path: '/hotelList',
        component: HotelListView,
    }
];

export const router = createRouter({
    history: createWebHistory(),
    routes,
});