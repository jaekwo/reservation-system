<template>
  <div id="app">
    <header-bar></header-bar>
    <router-view />
  </div>
</template>

<script>
import HeaderBar from './components/HeaderBar.vue';

export default {
  components: {
    HeaderBar,
  }
}
</script>

<style>
</style>