import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import ResponseCheck from './jsx/ResponseCheck';
import ResponseCheckHook from './jsx/ResponseCheckHook';

const Hot = hot(ResponseCheckHook);

ReactDOM.render(<Hot />, document.querySelector('#root'));