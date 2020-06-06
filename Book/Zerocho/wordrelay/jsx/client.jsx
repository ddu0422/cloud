import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import WordRelayHook from './WordRelayHook';

const Hot = hot(WordRelayHook);

ReactDOM.render(<Hot />, document.querySelector('#root'));