// 파일을 쪼갤때 가져와야한다.
const React = require('react');
const { Component } = React;

class WordRelay extends Component {
  state = {
    text: 'Hello, webpack',
  };

  render() {
  return <h1>{this.state.text}</h1>
  }
}

// 파일을 쪼갤때 가져와야한다.
module.exports = WordRelay;