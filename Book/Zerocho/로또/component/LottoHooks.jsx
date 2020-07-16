import React, {
  useState,
  useRef,
  useEffect,
  useMemo,
  useCallback,
} from 'react';
import Ball from './Ball';

function getWinNumbers() {
  console.log('getNumbers');

  const candidate = Array(45)
    .fill()
    .map((v, i) => i + 1);
  const shuffle = [];

  while (candidate.length > 0) {
    shuffle.push(
      candidate.splice(Math.floor(Math.random() * candidate.length), 1)[0]
    );
  }

  const bonusNumber = shuffle[shuffle.length - 1];
  const winNumbers = shuffle.splice(0, 6).sort((p, c) => p - c);

  // rendering이 될 때마다, 해당 함수가 다시 호출되기 때문에 계속 실행된다.
  // return 값이 계속 바뀌지만 처음 return 한 결과값으로 숫자가 계속 추가된다.
  // 동작방식을 아직 알 수는 없다. 기억해 놓고 나중에 고민하자.
  // ---------------해결방안-------------------
  // useMemo를 이용한다. => 함수의 return 값을 기억한다. []의 들어간 값이 변화하지 않으면 재실행되지 않는다.
  // useCallback => 함수 자체를 기억한다. []의 들어간 값이 변화하지 않으면 항상 같은 값이다.
  // useCallback 필수 적용 : 자식 Component에 함수를 넘길 때

  return [...winNumbers, bonusNumber];
}

const LottoHooks = () => {
  const lottoNumbers = useMemo(() => getWinNumbers(), []);
  const [winNumbers, setWinNumbers] = useState(lottoNumbers);
  const [winBalls, setWinBalls] = useState([]);
  const [bonus, setBonus] = useState(null);
  const [redo, setRedo] = useState(false);
  const timeouts = useRef([]);

  useEffect(() => {
    console.log('useEffect');

    // timeouts가 바뀌는게 아님
    // list.add 와 동일
    for (let i = 0; i < winNumbers.length - 1; i++) {
      timeouts.current[i] = setTimeout(() => {
        setWinBalls((prevBalls) => [...prevBalls, winNumbers[i]]);
      }, (i + 1) * 1000);
    }
    timeouts.current[winNumbers.length - 1] = setTimeout(() => {
      setBonus(winNumbers[winNumbers.length - 1]);
      setRedo(true);
    }, winNumbers.length * 1000);

    return () => {
      timeouts.current.forEach((value) => {
        clearTimeout(value);
      });
    };
  }, [timeouts.current]); // 빈 배열일 경우 componentDidMount와 동일
  // 배열의 값이 있는 경우 componentDidMount + componentDidUpdate 둘 다 수행

  const onClickRedo = useCallback(() => {
    console.log('onClickRedo');
    console.log(winNumbers);
    setWinNumbers(getWinNumbers());
    setWinBalls([]);
    setBonus(null);
    setRedo(false);
    // new ArrayList<>();
    timeouts.current = [];
  }, winNumbers);

  return (
    <>
      <div>당첨 숫자</div>
      <div id="result">
        {winBalls.map((v) => (
          <Ball key={v} number={v} />
        ))}
      </div>
      <div>보너스!</div>
      <div>{bonus && <Ball number={bonus} />}</div>
      {redo && (
        <button type="button" onClick={onClickRedo}>
          한 번 더 !
        </button>
      )}
    </>
  );
};

export default LottoHooks;
