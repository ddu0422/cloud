import React, { useState, useRef } from 'react';

function createNumber() {
  return Math.ceil(Math.random() * 9);
}

const GuGuDanHook = () => {
  const [first, setFirst] = useState(createNumber());
  const [second, setSecond] = useState(createNumber());
  const [answer, setAnswer] = useState(``);
  const [message, setMessage] = useState(``);
  const inputRef = useRef(null);

  const onChange = (e) => {
    setAnswer(e.target.value);
  }

  const onSubmit = (e) => {
    e.preventDefault();

    const result = first * second;

    if (parseInt(answer) === result) {
      setFirst(createNumber());
      setSecond(createNumber());
      setAnswer(``);
      setMessage(`${result} !! 딩동댕`);
    } else {
      setAnswer(``);
      setMessage(`땡`);
    }
    inputRef.current.focus();
  }

  return (
    <>
      <div>구구단 게임</div>
      <div>문제: {first} * {second} 는?</div>
      <form onSubmit={onSubmit}>
        <label htmlFor="answer">입력: </label>
        <input ref={inputRef} type="number" value={answer || ''} onChange={onChange} id="answer" />
      </form>
      <div>{message}</div>
    </>
  );
}

export default GuGuDanHook;