import React, { PureComponent, createRef } from 'react';

function createNumber() {
  return Math.ceil(Math.random() * 9);
}

class Temp extends PureComponent {
  state = {
    first: createNumber(),
    second: createNumber(),
    answer: '',
    message: '',
  }

  onChange = (e) => {
    this.setState({
      answer: e.target.value,
    })
  }

  onSubmit = (e) => {
    e.preventDefault();

    const result = this.state.first * this.state.second;

    if (parseInt(this.state.answer) === result) {
      this.setState({
        first: createNumber(),
        second: createNumber(),
        answer: this.state.value,
        message: '딩동댕',
      });
    } else {
      this.setState({
        message: '땡',
      });
    }
    this.inputRef.current.focus();
  }

  inputRef = createRef();

  render() {
    return (
      <>
        <div>구구단 게임</div>
        <div>문제: {this.state.first} * {this.state.second} 는?</div>
        <form onSubmit={this.onSubmit}>
          <label htmlFor="answer">입력: </label>
          <input ref={this.inputRef} type="number" value={this.state.answer || ''} onChange={this.onChange} id="answer" />
        </form>
        <div>{this.state.message}</div>
      </>
    )
  }
}

export default Temp;