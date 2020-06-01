const React = require('react');
const { useState, useRef } = React;

// Hooks: 클래스 대신 함수처럼 사용
const GuGuDan = () => {
  const [first, setFirst] = useState(Math.ceil(Math.random() * 9));
  const [second, setSecond] = useState(Math.ceil(Math.random() * 9));
  const [value, setValue] = useState('');
  const [result, setResult] = useState('');
  const inputRef = useRef(null);

  const onChangeInput = (e) => {
    setValue(e.target.value)
  };

  const onSubmitForm = (e) => {
    e.preventDefault();

    if (parseInt(value) === first * second) {
      setResult('정답 ' + value);
      setFirst(Math.ceil(Math.random() * 9));
      setSecond(Math.ceil(Math.random() * 9));
      setValue('');
    } else {
      setResult('땡');
      setValue('');
    }
    inputRef.current.focus();
  }

  // state가 바뀌면 함수 전체가 재실행이 된다.
  console.log('렌더링');

  // react내부에선 html 속성으로 class, for을 사용할 수 없다
  // class -> className
  // for -> label
  return (
    <>
      <div>{first} * {second}는?</div>
      <form onSubmit={onSubmitForm}>
        <input ref={inputRef} type="number" value={value} onChange={onChangeInput} />
        <button>입력</button>
        <div>{result}</div>
      </form>
    </>
  )
}

module.exports = GuGuDan;