<template>
  <div id="app">
    <div>{{ message }}</div>
    <div id="nav">
      <router-link to="/">Home</router-link>
      <router-link to="/about">About</router-link>
      <MyHomeComponent></MyHomeComponent>
      <h1>{{ title}}</h1>
      <p>{{ count }}</p>
      <button @click="count ++">추가</button>
      <button @click="test">테스트</button>
      <Mystatus></Mystatus>
    </div>
  
  </div>
</template>

<script>
import MyHomeComponent from "./HomeComponent.vue"
import Mystatus from './StatusComponent'
import axios from "axios"



export default {
 
  components : {
    MyHomeComponent,
    Mystatus
  },
  data : function() {
    return {
      message : "",
      title: "안녕하세요",
      count: 1
    }
  },
  methods : {
    test(){
      axios
      .get("/")
      .then(res => {
        console.log(res)
      })
      .catch(err =>{
        console.log(err)
      })
      .then(() =>{

      })
    }
    // load: function() {
    //   axios.get("/data", {
    //     params: {
    //       msg: "Index..."
    //     },
    //     timeout: 1000
    //   })
    //   .then( res => {
    //     // console.log(res.data)
    //     this.message = res.data.message;
    //   })
    //   .catch(
       
    //   );
    // }
  },
  mounted : function() {
    this.load();
  }

}
</script>