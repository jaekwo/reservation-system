<template>
    <div class="wrap">
        <div class='sideBox'>
          <div>
              호텔 등급
          </div>
          <div class="star-ratings">
              <div class="star-rating space-x-4 mx-auto">
                  <input type="radio" id="5-stars" name="grade" value="5" v-model="grade" @change="getHotelList"/>
                  <label for="5-stars" class="star pr-4">★</label>
                  <input type="radio" id="4-stars" name="grade" value="4" v-model="grade" @change="getHotelList"/>
                  <label for="4-stars" class="star">★</label>
                  <input type="radio" id="3-stars" name="grade" value="3" v-model="grade" @change="getHotelList"/>
                  <label for="3-stars" class="star">★</label>
                  <input type="radio" id="2-stars" name="grade" value="2" v-model="grade" @change="getHotelList"/>
                  <label for="2-stars" class="star">★</label>
                  <input type="radio" id="1-star" name="grade" value="1" v-model="grade" @change="getHotelList"/>
                  <label for="1-star" class="star">★</label>
                </div>
            </div>
        </div>
        <div>
            <div class="hotelBox" v-for="hotel in hotelList" v-bind:key="hotel.hotelCode">
                {{ hotel.name }}    {{ hotel.grade }}
                <br>
                {{ hotel.address }}
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data: function() {
      return {
        keyword: '',
        grade: '',
        hotelList: []
      }
    },
    methods: {
      getHotelList() {
        const axiosConfig = {
             headers:{
                'Content-Type': 'application/json',
            }
        }
        this.axios.post("/vue/hotel/searchHotel", {
          keyword:this.keyword,
          grade:this.grade
        }, axiosConfig)
          .then(res => {
              this.hotelList = res.data;
              console.log(res);
          }).catch(err => {
            console.log(err);
          })
      }
    },
    mounted() {
      this.getHotelList();
    }
}
</script>

<style scoped>
.wrap {
    display: flex;
}
.hotelBox {
    width: 500px;
    border-style: solid;
    border-width: thin;
}
.sideBox {
    width: 200px;
    height: 600px;
    border-style: groove;
}

.star-ratings-fill {
  color: #fff58c;
  padding: 0;
  position: absolute;
  z-index: 1;
  display: flex;
  top: 0;
  left: 0;
  overflow: hidden;
  -webkit-text-fill-color: gold;
}
 
.star-ratings-base {
  z-index: 0;
  padding: 0;
}

.star-rating {
  display: flex;
  flex-direction: row-reverse;
  font-size: 1.5rem;
  line-height: 1.5rem;
  justify-content: space-around;
  padding: 0 0.2em;
  text-align: center;
  width: 5em;
}
 
.star-rating input {
  display: none;
}
 
.star-rating label {
  -webkit-text-fill-color: transparent; /* Will override color (regardless of order) */
  -webkit-text-stroke-width: 1.3px;
  -webkit-text-stroke-color: #2b2a29;
  cursor: pointer;
}
 
.star-rating :checked ~ label {
  -webkit-text-fill-color: gold;
}
 
.star-rating label:hover,
.star-rating label:hover ~ label {
  -webkit-text-fill-color: #fff58c;
}
</style>