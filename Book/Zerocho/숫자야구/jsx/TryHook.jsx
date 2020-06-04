import React, { memo } from 'react';

/*
  왜 난 컴포넌트가 변할까...... 공부 더해서 나중에 다시 적용해보자.
 */
const TryHook = memo(({ tryInfo }) => {
  return (
    <li>
      <div>{tryInfo.try}</div>
      <div>{tryInfo.result}</div>
    </li>
  )
});

export default TryHook;