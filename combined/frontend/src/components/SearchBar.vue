<template>
  <div class="search">
    <h2>Main</h2>
    <input type="text" placeholder="객실수 투숙객수">
    <br>
    <input type="text" id="search_box" v-model="keyword" v-on:input="suggestionList" placeholder="지역, 호텔 검색">
    <div div="autoComplate disabled">
        <div  id="suggestion_box" v-for="hotel in hotelList" v-bind:key="hotel">
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
            this.keyword = this.keyword.trim();
            if(this.keyword !== '') {
                this.axios.post("/vue/hotel/hotelList", this.keyword, {
                    headers: { "Content-Type": `application/json`}
                }).then(res => {
                    this.hotelList = res;
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