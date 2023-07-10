<template>
    <div>
<div class="protected" v-if="loginSuccess">
<h1>
<b-badge variant="success">보안 사이트에 대한 액세스가 허용되었습니다</b-badge>
</h1>
<h5>로그인 성공!</h5>
</div>
<div class="unprotected" v-else-if="loginError">
<h1>
<b-badge variant="danger">이 페이지에 대한 접근 권한이 없습니다.</b-badge>
</h1>
<h5>로그인 실패!</h5>
</div>
<div class="unprotected" v-else>
<h1>
<b-badge variant="info">로그인해주세요</b-badge>
</h1>
<h5>로그인 하지 않았습니다. 로그인을 해주세요</h5>
</div>
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
            loginSuccess: false,
            loginError: false
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
                    console.log(res.data.msg);
                    this.loginSuccess = true;
                    // this.$router.push('/');
                }
            }).catch(err => {
                console.log(err);
                this.loginError = true;
            })
        }   
    }
}
</script>

<style scoped>
.label {
    text-align: center;
}
</style>