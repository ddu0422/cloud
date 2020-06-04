import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import NumberBaseball from './jsx/NumberBaseball';
import NumberBaseballHook from './jsx/NumberBaseballHook';
import Test from './jsx/Test'

const Hot = hot(NumberBaseball);

ReactDOM.render(<Hot />, document.querySelector('#root'));