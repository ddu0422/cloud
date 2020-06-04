import React, { PureComponent } from 'react';

class Try extends PureComponent {
  shouldComponentUpdate(nextProps, nextState, nextContext) {
    return true;
  }

  render() {
    const { tryInfo } = this.props;

    return (
      <li>
        <div>{tryInfo.try}</div>
        <div>{tryInfo.result}</div>
      </li>
    )
  }
}

export default Try;