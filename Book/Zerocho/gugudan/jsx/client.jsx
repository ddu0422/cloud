import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import GuGuDan from './GuGuDan';

const Hot = hot(GuGuDan);

ReactDOM.render(<Hot />, document.querySelector('#root'));