import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import NumberBaseballHook from './jsx/NumberBaseballHook';
// import Test from './jsx/Test'

const Hot = hot(NumberBaseballHook);

ReactDOM.render(<Hot />, document.querySelector('#root'));