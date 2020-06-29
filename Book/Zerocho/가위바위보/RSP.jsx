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

const computerChoice = (imgCoord) => {
  return Object.entries(rspCoords).find((v) => {
    return v[1] === imgCoord;
  })[0];
};

class RSP extends Component {
  state = {
    result: "",
    imgCoord: rspCoords.rock,
    score: 0,
  };

  interval;

  componentDidMount() {
    this.interval = setInterval(this.changeHand, 100);
  }

  componentDidUpdate() {}

  componentWillMount() {
    clearInterval(this.interval);
  }

  onClickBtn = (choice) => {
    const { imgCoord } = this.state;

    clearInterval(this.interval);
    const myScore = scores[choice];
    const computerScore = scores[computerChoice(imgCoord)];
    const diff = myScore - computerScore;

    if (diff === 0) {
      this.setState({
        result: "비겼습니다.",
      });
    } else if ([-1, 2].includes(diff)) {
      this.setState((prevState) => {
        return {
          result: "이겼습니다.",
          score: prevState.score + 1,
        };
      });
    } else {
      this.setState((prevState) => {
        return {
          result: "졌습니다.",
          score: prevState.score - 1,
        };
      });
    }
    setTimeout(() => {
      this.interval = setInterval(this.changeHand, 100);
    }, 2000);
  };

  changeHand = () => {
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
  };

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
            onClick={() => this.onClickBtn("paper")}
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
