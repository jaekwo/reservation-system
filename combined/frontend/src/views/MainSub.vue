<template>
  <h1>
    MainSub
    <div ></div>
    <router-link to="/InfoSub">메인서브</router-link>
  </h1>
</template>
<script>
export  default {
	name: 'MainSub',
  component:[],
  data() {
    return {
      accountList: "",
    };
  },
  methods: {
    get() {
      this.axios.get("/vue/accountList").then((response) => {
        this.accountList = response.data;
      });
    }
  },
  mounted() {
    this.get();
  }
};
</script>