<template>
  <div class="search">
    <h2>Main</h2>
    <input type="text" placeholder="객실수 투숙객수">
    <br>
    <input type="text" id="search_box" v-model="keyword" v-on:input="suggestionList" placeholder="지역, 호텔 검색" autocomplete="off">
    <div>
        <div v-for="hotel in hotelList" v-bind:key="hotel.hotelCode">
            {{ hotel.name }}
        </div>
    </div>
    <br>
    <input type="text" placeholder="체크인">
    <input type="text" placeholder="체크아웃">
    <br>
    <button>검색</button>
  </div>
</template>

<script>
export default {
    data: function() {
        return {
            keyword: '',
            hotelList: [],
        }
    },
    methods: {
        suggestionList() {
            var content = this.keyword.trim();
            if(this.keyword !== '') {
                const axiosConfig = {
                    headers:{
                        'Content-Type': 'application/json',
                    }
                }
                this.axios.post("/vue/hotel/hotelList", content, axiosConfig)
                .then(res => {
                    this.hotelList = res.data;
                    console.log(res);
                }).catch(err => {
                    console.log(err);
                });
            }
        }
    }
}
</script>

<style>
.search{
  text-align: center;
}
</style>