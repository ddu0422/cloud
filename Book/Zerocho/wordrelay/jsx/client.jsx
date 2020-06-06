import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
// import WordRelayHook from './WordRelayHook';
import WordRelay from './WordRelay';

const Hot = hot(WordRelay);

ReactDOM.render(<Hot />, document.querySelector('#root'));