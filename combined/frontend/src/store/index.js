import Vuex from 'vuex';

export default new Vuex.Store({
    // 공통으로 관리할 데이터
    state: {
        keyword: '',
        strDate: new Date(),
        endDate: new Date(),
    },
    // state를 변경할 때 사용하는 함수의 모음 (비동기에 대한 처리 담당 X)
    mutations: {
        setKeyword(state, value) {
            state.keyword = value;
            console.log(state.keyword);
        },
        setStrDate(state, value) {
            state.strDate = value;
            console.log(state.strDate);
        },
        setEndDate(state, value) {
            state.endDate = value;
            console.log(state.endDate);
        },
    },
    // 함수들의 모음 (비동기 처리 O)
    actions: {
        
    },
    // 추가 라이브러리 적용할 때 사용, 내용 커질 시 분리 용도
    modules: {

    }
})