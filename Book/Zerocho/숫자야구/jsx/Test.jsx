import React, { PureComponent } from 'react';

/*
  PureComponent는 shouldComponentUpdate에서 작성한 내용을 자동으로 적용해준다.
  그러나, object나 array같이 참조를 가지고 있으면 판단을 잘 하지 못한다.
  따라서, 새 object나 array를 만들어서 state를 변경해준다.
  array.push(1) // x
  array: [...this.state.array, 1] // o
*/

class Test extends PureComponent {
  state = {
    counter: 0,
    string: 'hello',
    number: 1,
    boolean: true,
    object: {},
    array: [],
  }

  onClick = () => {
    this.setState({
      array: [...this.state.array, 1],
    });
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