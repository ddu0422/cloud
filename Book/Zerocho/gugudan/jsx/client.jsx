import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
// import GuGuDan from './GuGuDan';
import GuGuDanHook from './GuGuDanHook';

const Hot = hot(GuGuDanHook);

ReactDOM.render(<Hot />, document.querySelector('#root'));