import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import Temp from './Temp';

const Hot = hot(Temp);

ReactDOM.render(<Hot />, document.querySelector('#root'));