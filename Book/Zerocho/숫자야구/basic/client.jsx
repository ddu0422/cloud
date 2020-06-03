import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import Basic from './jsx/basic';

const Hot = hot(Basic);

ReactDOM.render(<Basic />, document.querySelector('#root'));