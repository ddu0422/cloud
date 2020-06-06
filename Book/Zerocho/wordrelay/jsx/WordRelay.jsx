import React, { Component, createRef } from 'react';

class WordRelay extends Component {
  state = {
    word: '이두호',
    value: '',
    result: '',
  }

  inputRef = createRef()

  onChangeInput = (e) => {
    this.setState({
      value: e.target.value,
    });
  }

  onSubmitForm = (e) => {
    e.preventDefault();

    const { word, value } = this.state;

    if (word[word.length - 1] === value[0]) {
      this.setState((prevState) => {
        return {
          word: prevState.value,
          value: '',
          result: '딩동댕',
        }
      });
    } else {
      this.setState({
        value: '',
        result: '땡',
      });
    }
    this.inputRef.current.focus();
  }

  render() {
    const { word, value, result } = this.state;

    return (
      <>
        <div>끝말잇기</div>
        <div>
          <div>{word}</div>
          <form onSubmit={this.onSubmitForm}>
            <label htmlFor="answer">입력: </label>
            <input
              ref={this.inputRef}
              type="text"
              id="answer"
              value={value || ''}
              onChange={this.onChangeInput}
            />
          </form>
          <div>{result}</div>
        </div>
      </>
    )
  }
}

export default WordRelay;