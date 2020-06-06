import React, { PureComponent, createRef } from 'react';

function createNumber() {
  return Math.ceil(Math.random() * 9);
}

class GuGuDan extends PureComponent {
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

    const { first, second, answer } = this.state;
    const result = first * second;

    if (parseInt(answer) === result) {
      this.setState({
        first: createNumber(),
        second: createNumber(),
        answer: '',
        message: result + '!! 딩동댕',
      });
    } else {
      this.setState({
        answer: '',
        message: '땡',
      });
    }
    this.inputRef.current.focus();
  }

  inputRef = createRef();

  render() {
    const { first, second, answer, message } = this.state;

    return (
      <>
        <div>구구단 게임</div>
        <div>문제: {first} * {second} 는?</div>
        <form onSubmit={this.onSubmit}>
          <label htmlFor="answer">입력: </label>
          <input ref={this.inputRef} type="number" value={answer || ''} onChange={this.onChange} id="answer" />
        </form>
        <div>{message}</div>
      </>
    )
  }
}

export default GuGuDan;