import { createApp } from 'vue';
import {router} from './routes/index';
import App from './App.vue';
import axios from 'axios';

axios.defaults.baseURL = "http://localhost:8080";
const app = createApp(App);
app.config.globalProperties.axios = axios;
app.use(router);
app.mount('#app');