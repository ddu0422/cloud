const React = require('react');
const { Component } = React;
const { useState, useRef } = React;

const WordRelay = () => {
  const [word, setWord] = useState('제로초');
  const [value, setValue] = useState('')
  const [result, setResult] = useState('')
  const inputRef = useRef(null);

  const onSubmitForm = (e) => {
    e.preventDefault();
    if (word[word.length - 1] === value[0]) {
      setResult('딩동댕');
      setWord(value);
      setValue('');
    } else {
      setResult('땡');
      setValue('');
    }
    inputRef.current.focus();
  }

  const onChangeInput = (e) => {
    setValue(e.target.value)
  }

  return (
    <>
      <div>{word}</div>
      <form onSubmit={onSubmitForm}>
        <label htmlFor="wordInput"></label>
        <input id="wordInput" ref={inputRef} value={value} onChange={onChangeInput} />
        <button className="클래스입니다.">입력!</button>
      </form>
      <div>{result}</div>
    </>
  )
}

module.exports = WordRelay;