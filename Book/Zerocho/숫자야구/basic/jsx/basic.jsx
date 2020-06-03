import React, { Component } from 'react';

const Basic = () => {
  return (
    <>
      <div>Hello World!</div>
    </>
  )
}

// ECMAScript 2015
export const hello = 'hello'; // import { hello, bye }
export const bye = 'bye';

export default Basic; // import Basic; default는 한번만 사용 가능

// Common JS
// module.exports와는 다르지만 react 정도에선 같다고 생각한다.
// module.exports = { hello: 'a'}; 와 exports.hello = 'a' 는 동일

// babel이 import를 require로 바꿔준다.
// require는 Node에서 import는 React에서 사용한다.
// 단, babel이 import를 바꿔주므로 webpack.config.js 에선 const를 사용해야한다.