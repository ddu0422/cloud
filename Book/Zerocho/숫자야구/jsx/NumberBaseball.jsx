import React, { Component } from 'react';

// 숫자 네 개를 겹치지 않고 랜덤하게 뽑는 함수
function getNumbers() {

}

class NumberBaseball extends Component {
  state = {
   result: '',
   value: '',
   answer: getNumbers(),
   tries: ['사과', '오렌지', '바나나'],
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
          {this.state.tries.map((v) => {
            return (
              <li>{v}</li>
            )
          })}
        </ul>
      </>
    )
  }
}

export default NumberBaseball;