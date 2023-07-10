<template>
  <div class="search">
    <h2>Main</h2>
    <div>
        <span>객실 : </span>
        <button value="roomCntMinus" v-on:click="roomCntDown">-</button> {{ roomCnt }}
        <button value="roomCntPlus" v-on:click="roomCntUp">+</button>
    </div>
    <div>
        <span>인원 : </span>
        <button value="perCntMinus" v-on:click="perCntDown">-</button> {{ perCnt }}
        <button value="perCntPlus" v-on:click="perCntUp">+</button>
    </div>
    <div>
        <Datepicker
            v-model              = "strDate"
            :enableTimePicker    = "false"
            :clearable           = "false"
            :monthChangeOnScroll = "false"
            autoApply></Datepicker>
        <Datepicker
            v-model              = "endDate"
            :enableTimePicker    = "false"
            :clearable           = "false"
            :monthChangeOnScroll = "false"
            autoApply></Datepicker>
    </div>
    <div>
        <!-- <input type="text" id="search_input" v-model="keyword" v-on:input="suggestionList" placeholder="지역, 호텔 검색" autocomplete="off"> -->
        <input type="text" id="search_input" v-model="keyword" v-on:input="suggestionList" @change="setStateKeyword(keyword)" placeholder="지역, 호텔 검색" autocomplete="off">
        <div class="rel_search">
            <ul class="pop_rel_keywords" v-for="hotel in hotelList" v-bind:key="hotel.hotelCode"> 
                {{ hotel.name }}
            </ul>
        </div>
    </div>
    <button>검색</button>
  </div>
</template>

<script>
import Datepicker from 'vue3-datepicker';

export default {
    data: function() {
        return {
            keyword: '',
            hotelList: [],
            roomCnt: 1,
            perCnt: 1,
            strDate: new Date(),
            endDate: new Date(),
        }
    },
    components: { Datepicker: Datepicker },
    methods: {
        suggestionList() {
            var content = this.keyword.trim();
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
        },
        roomCntUp() {
            this.roomCnt++;
        },
        roomCntDown() {
            if(this.roomCnt !== 1) {
                this.roomCnt--;
            }
        },
        perCntUp() {
            this.perCnt++;
        },
        perCntDown() {
            if(this.perCnt !== 1) {
                this.perCnt--;
            }
        },
        // state
        setStateKeyword(value) {
            this.$store.commit("setKeyword", value);
        },
        setStateStrDate(value) {
            this.$store.commit("setStrDate", value);
        },
        setStateEndDate(value) {
            this.$store.commit("setEndDate", value);
        }
    },
    watch : {
        strDate(newValue, oldValue) {
            if(newValue > this.endDate) {
                alert("체크인 날짜를 확인해주세요.");
                this.strDate = oldValue;
            } else {
                this.strDate = newValue;
                this.setStateStrDate(this.strDate);
            }
        },
        endDate(newValue, oldValue) {
            if(newValue < this.strDate) {
                alert("체크아웃 날짜를 확인해주세요.");
                this.endDate = oldValue;
            } else {
                this.endDate = newValue;
                this.setStateEndDate(this.endDate);
            }
        }
    }
}
</script>

<style scoped>
.hide {
  display: none !important;	/* 사용자가 아무것도 입력하지 않았을 때 검색창을 숨기는 용도*/
}

.rel_search {
  display:flex;
  flex-direction:column;
  justify-content : space-around;
  border: 1px solid white;
  border-radius: 1px;
  width: 300px;
 
}

.pop_rel_keywords {
  list-style: none;
  margin-right: 30%;
  cursor: pointer;
}

.pop_rel_keywords > li {	/* JS에서 동적으로 li를 생성할 때 적용될 스타일*/
  line-height : 250%
}

#search_input {
    width: 300px;
}
</style>