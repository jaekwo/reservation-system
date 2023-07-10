<template>
  <div>
    <search-bar></search-bar>
    <hotel-center></hotel-center>
  </div>
</template>

<script>
import SearchBar from '../Main/SearchBar.vue';
import HotelCenter from './HotelCenter.vue';

export default {
    components: {
        SearchBar,
        HotelCenter,
    },
}
</script>

<style>

</style>