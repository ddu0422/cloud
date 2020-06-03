import React, { Component } from 'react';
import Try from './Try';

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
          {this.state.tries.map((v, i) => {
            return (
              <Try key={v.fruit + v.taste} v={v} i={i} />
            );
          })}
        </ul>
      </>
    )
  }
}

export default NumberBaseball;