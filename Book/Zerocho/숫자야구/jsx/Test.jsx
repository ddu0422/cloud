import React, { Component } from 'react';

class Test extends Component {
  state = {
    counter: 0,
  }

  shouldComponentUpdate(nextProps, nextState, nextContext) {
    return this.state.counter !== nextState.counter;
  }

  onClick = () => {
    this.setState({});
  }

  render() {
    console.log('렌더링', this.state);
    return (
      <>
        <div>
          <button onClick={this.onClick}>클릭</button>
        </div>
      </>
    )
  }
}

export default Test;