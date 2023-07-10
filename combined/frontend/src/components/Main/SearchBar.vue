<template>
  <div id="search">
    <input type="text" v-model="keyword" @change="setStateKeyword(keyword)" placeholder="지역, 호텔 검색">
    <div style="display:inline-block;">
      <Datepicker class="datepick"
              v-model              = "strDate"
              :enableTimePicker    = "false"
              :clearable           = "false"
              :monthChangeOnScroll = "false"
              autoApply></Datepicker>
    </div>
    <div style="display:inline-block;">
        <Datepicker class="datepick"
            v-model              = "endDate"
            :enableTimePicker    = "false"
            :clearable           = "false"
            :monthChangeOnScroll = "false"
            autoApply></Datepicker>
    </div>
    <button>검색</button>
  </div>
</template>

<script>
import Datepicker from 'vue3-datepicker';

export default {
  data: function() {
    return {
      keyword: this.$store.state.keyword,
      strDate: this.$store.state.strDate,
      endDate: this.$store.state.endDate
    }
  },
  components: { Datepicker: Datepicker },
  methods: {
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

<style>
</style>