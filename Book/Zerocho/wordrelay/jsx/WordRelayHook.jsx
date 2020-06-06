import React, { useState, useRef } from 'react';

const WordRelayHook = () => {
  const [word, setWord] = useState('이두호');
  const [value, setValue] = useState('');
  const [result, setResult] = useState('');
  const inputRef = useRef(null);

  const onChange = (e) => {
    setValue(e.target.value);
  }

  const onSubmit = (e) => {
    e.preventDefault();

    if (word[word.length - 1] === value[0]) {
      setWord(value);
      setValue('');
      setResult('딩동댕');
    } else {
      setValue('');
      setResult('땡');
    }
    inputRef.current.focus();
  }

  return (
    <>
      <div>끝말잇기</div>
      <div>
        <div>{word}</div>
        <form onSubmit={onSubmit}>
          <label htmlFor="answer">입력: </label>
          <input ref={inputRef} type="text" id="answer" value={value || ''} onChange={onChange} />
        </form>
        <div>{result}</div>
      </div>
    </>
  )
}

export default WordRelayHook;