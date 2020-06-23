import React, { Component } from 'react';

class ResponseCheck extends Component {
  state = {
    state: 'waiting',
    message: '클릭해서 시작하세요.',
    result: [],
  };

  onClickScreen = () => {

  }

  render() {
    return (
      <>
        {/* if문, for문을 사용할 수 있지만 가독성이 좋지 않아 다른 방법을 사용한다. */}
        <div
          id="screen"
          className={this.state.state}
        >
          {this.state.message}
        </div>
        {/* 조건문 : 조건부 연산자(삼항 연산자)를 사용한다. */}
        {/* {this.state.result.length === 0
          ? null
          : <div>평균시간: {this.state.result.reduce((a, c) => a + c) / this.state.result.length} ms</div>
        } */}
        {/* 혹은 부울 연산자를 사용한다. */}
        {this.state.result.length !== 0 
        && <div>평균시간: {this.state.result.reduce((a, c) => a + c) / this.state.result.length} ms</div>}
      </>
    );
  }
}

export default ResponseCheck;