import React, { Component } from "react";

/*
  class의 경우
  1. constructor
  2. render
  3. ref
  4. componentDidMount
  (setState/prpos 바뀔때)
  5. shouldComponentUpdate(true)
  6. re-render
  7 componentDidUpate
  (부모가 나를 없앨 때)
  8. componentWillUnmount
*/

// Component로 쓸데없이 리렌더링이 일어나는 부분을 찾는다.
class RSP extends Component {
  state = {
    result: "",
    imgCoord: 0,
    score: 0,
  };

  // Component Life Cycle
  // Component가 첫 rendering 된 후
  componentDidMount() {
    console.log("did mount");
  }

  shouldComponentUpdate() {}

  // Component가 re-rendering 된 후
  componentDidUpdate() {}

  // Component가 제거되기 직전
  componentWillMount() {}

  render() {
    const { result, score, imgCoord } = this.state;

    return (
      <>
        <div
          id="computer"
          style={{
            background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${imgCoord} 0`,
          }}
        ></div>
        <div>
          <button
            id="rock"
            className="button"
            onClick={() => onClickBtn("rock")}
          >
            바위
          </button>
          <button
            id="scissors"
            className="button"
            onClick={() => onClickBtn("scissors")}
          >
            가위
          </button>
          <button
            id="paper"
            className="button"
            onClick={() => onClickBtn("papar")}
          >
            보
          </button>
        </div>
        <div>{result}</div>
        <div>현재 {score}점</div>
      </>
    );
  }
}

export default RSP;
