<template>
    <div>
        <h2 style="text-align: center;">Login</h2>
        <form id="loginForm" v-on:submit.prevent="loginAction">
            <p class="label">
                <label for="inputId">ID : </label>
                <input id="inputId" type="text" v-model="userId">
            </p>
            <p class="label">
                <label for="inputPw">PW : </label>
                <input id="inputPw" type="password" v-model="userPw">
            </p>
            <p class="label">
                <button type="submit">LOGIN</button>
            </p>
        </form>
    </div>
</template>

<script>
export default {
    data: function() {
        return {
            userId: '',
            userPw: '',
        }
    },
    methods: {
        loginAction: function() {
            this.axios.post("/vue/account/loginAction", {
                userId: this.userId,
                userPw: this.userPw
            }).then(res => {
                if(res.data === "checkAccount") {
                    alert("계정을 확인해주세요");
                } else if(res.data === "checkPw") {
                    alert("비밀번호를 확인해주세요");
                } else {
                    console.log(res);
                    this.$router.push('/');
                }
            }).catch(err => {
                console.log(err);
            })
        }   
    }
}
</script>

<style>
.label {
    text-align: center;
}
</style>