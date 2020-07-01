import React, { useState, useRef, useEffect } from 'react';

const rspCoords = {
  rock: '0px',
  scissors: '-142px',
  paper: '-284px',
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

const RSP = () => {
  const [result, setResult] = useState('');
  const [imgCoord, setImgCoord] = useState(rspCoords.rock);
  const [score, setScore] = useState(0);
  const interval = useRef(null);

  // 매번 clearInterval을 하기 때문에 새로 setTImeout을 하는 것과 동일하다.
  // componentDidMount, componentDidUpdate 역할 (1대1 대응은 아니다.)
  useEffect(() => {
    interval.current = setInterval(changeHand, 100);
    console.log('다시 실행');

    // componentWillUnmount 역할
    return () => {
      clearInterval(interval.current);
      console.log('종료');
    };
    // 바뀌는 state를 넣어줘야한다.
  }, [imgCoord]);

  const onClickBtn = (choice) => () => {
    clearInterval(interval.current);

    const myScore = scores[choice];
    const computerScore = scores[computerChoice(imgCoord)];
    const diff = myScore - computerScore;

    if (diff === 0) {
      setResult('비겼습니다.');
    } else if ([-1, 2].includes(diff)) {
      setResult('이겼습니다.');
      setScore((prevScore) => prevScore.score + 1);
    } else {
      setResult('졌습니다.');
      setScore((prevScore) => prevScore.score - 1);
    }
    setTimeout(() => {
      interval.current = setInterval(changeHand, 100);
    }, 2000);
  };

  const changeHand = () => {
    if (imgCoord === rspCoords.rock) {
      setImgCoord(rspCoords.scissors);
    } else if (imgCoord === rspCoords.scissors) {
      setImgCoord(rspCoords.paper);
    } else if (imgCoord === rspCoords.paper) {
      setImgCoord(rspCoords.rock);
    }
  };

  return (
    <>
      <div
        id="computer"
        style={{
          background: `url(https://en.pimg.jp/023/182/267/1/23182267.jpg) ${imgCoord} 0`,
        }}
      ></div>
      <div>
        <button id="rock" className="button" onClick={onClickBtn('rock')}>
          바위
        </button>
        <button
          id="scissors"
          className="button"
          onClick={onClickBtn('scissors')}
        >
          가위
        </button>
        <button id="paper" className="button" onClick={onClickBtn('paper')}>
          보
        </button>
      </div>
      <div>{result}</div>
      <div>현재 {score}점</div>
    </>
  );
};

export default RSP;
