import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import NumberBaseballHook from './jsx/NumberBaseballHook';

const Hot = hot(NumberBaseballHook);

ReactDOM.render(<NumberBaseballHook />, document.querySelector('#root'));