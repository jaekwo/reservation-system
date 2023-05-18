<template>
  <div>
    <h2 style="text-align: center;">Join</h2>
    <form id="joinForm" v-on:submit="joinAction">
        <p class="label">
            <label for="inputId">아이디 : </label>
            <input id="inputId" type="text" v-model="id">
        </p>
        <p class="label">
            <label for="inputPw">비밀번호 : </label>
            <input id="inputPw" type="password" v-model="pw">
        </p>
        <p class="label">
            <label for="inputPwChk">비밀번호 확인 : </label>
            <input id="inputPwChk" type="password" v-model="pwChk">
        </p>
        <p class="label">
            <label for="inputName">이름 : </label>
            <input id="inputName" type="text" v-model="name">
        </p>
        <p class="label">
            <label for="inputMobile">연락처 : </label>
            <input id="inputMobile" type="text" v-model="mobile" placeholder="01012341234">
        </p>
        <p class="label">
            <label for="inputBirth">생년월일 : </label>
            <input id="inputBirth" type="text" v-model="birthDay" placeholder="19900101">
        </p>
        <p class="label">
            <label for="inputMail">이메일 : </label>
            <input id="inputMail" type="text" v-model="mail">
            @
            <input type="text" id="inputDomain" v-model="domain">
            <select v-model="domain">
                <option value="">직접 입력</option>
                <option>naver.com</option>
                <option>gmail.com</option>
            </select>
        </p>
        <p class="label">
            <button type="submit">JOIN</button>
        </p>
    </form>
  </div>
</template>

<script>
export default {
    data: function() {
        return {
            id: '',
            pw: '',
            pwChk: '',
            name: '',
            mobile: '',
            birthDay: '',
            mail: '',
            domain: '',
            email: ''
        }
    },
    methods: {
        joinAction: function() {
            this.email = this.mail + '@' + this.domain;
            this.axios.post("/vue/account/joinAction", {
                id:this.id,
                pw:this.pw,
                name:this.name,
                mobile:this.mobile,
                birthDay:this.birthDay,
                email:this.email
            }).then(res => {
                console.log(res);
                this.$router.push('/loginView');
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