import React, { Component } from "react";

const rspCoords = {
  rock: "0px",
  scissors: "-142px",
  paper: "-284px",
};

const scores = {
  rock: 0,
  scissors: 1,
  paper: -1,
};

class RSP extends Component {
  state = {
    result: "",
    imgCoord: rspCoords.rock,
    score: 0,
  };

  interval;

  // 비동기 요청을 많이 한다.
  // component를 삭제해도 비동기 요청은 계속 된다.
  componentDidMount() {
    // 비동기안에서 바깥 함수를 참조하면 클로저 문제가 생긴다.
    // const { imgCoord } = this.state;

    this.interval = setInterval(() => {
      const { imgCoord } = this.state;

      if (imgCoord === rspCoords.rock) {
        this.setState({
          imgCoord: rspCoords.scissors,
        });
      } else if (imgCoord === rspCoords.scissors) {
        this.setState({
          imgCoord: rspCoords.paper,
        });
      } else if (imgCoord === rspCoords.paper) {
        this.setState({
          imgCoord: rspCoords.rock,
        });
      }
    }, 1000);
  }

  componentDidUpdate() {}

  // 비동기 요청 정리를 많이 한다.
  componentWillMount() {
    clearInterval(this.interval);
  }

  onClickBtn = (choice) => {};

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
            onClick={() => this.onClickBtn("rock")}
          >
            바위
          </button>
          <button
            id="scissors"
            className="button"
            onClick={() => this.onClickBtn("scissors")}
          >
            가위
          </button>
          <button
            id="paper"
            className="button"
            onClick={() => this.onClickBtn("papar")}
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
