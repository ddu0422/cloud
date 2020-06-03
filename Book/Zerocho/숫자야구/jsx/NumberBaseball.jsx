import React, { Component } from 'react';

// 숫자 네 개를 겹치지 않고 랜덤하게 뽑는 함수
function getNumbers() {

}

class NumberBaseball extends Component {
  state = {
    result: '',
    value: '',
    answer: getNumbers(),
    tries: [
      { fruit: '사과', taste: '맛있다' },
      { fruit: '귤', taste: '내놔라' },
      { fruit: '바나나', taste: '먹어라' },
    ],
  };

  onSubmitForm = () => {

  };

  onChangeInput = () => {

  };

  render() {
    return (
      <>
        <h1>{this.state.result}</h1>
        <form onSubmit={this.onSubmitForm}>
          <input maxLength={4} value={this.state.value} onChange={this.onChangeInput} />
        </form>
        <div>시도: {this.state.tries.length}</div>
        <ul>
          {/*
             i를 사용하여 key를 사용하지 말자
             react에서 key를 기준으로 element를 추가하너가 수정, 삭제를 판단하기 때문에 배열의 순서가 바뀌면 문제가 생긴다.
             배열에 id를 넣는다??
           */}
          {this.state.tries.map((v, i) => <li key={i}><b>{v.fruit}</b> - {v.taste}</li>)}
        </ul>
      </>
    )
  }
}

export default NumberBaseball;