import React, { memo, useState } from 'react';

/*
  왜 난 컴포넌트가 변할까...... 공부 더해서 나중에 다시 적용해보자.
 */
const TryHook = memo(({ tryInfo }) => {
  // props는 부모가 바꿔야한다. 자식은 바꾸면 안된다.
  // 따라서 바꾸고 싶으면 state에 넣어준다.
  const [result, setResult] = useState(tryInfo.result);

  const onClick = () => {
    setResult('1');
  }

  return (
    <li>
      <div>{tryInfo.try}</div>
      <div onClick={onClick}>{result}</div>
    </li>
  )
});

export default TryHook;