import React from 'react';
import ReactDOM from 'react-dom';
import { hot } from 'react-hot-loader/root';
import Lotto from './component/Lotto';
import LottoHooks from './component/LottoHooks';

const Hot = hot(LottoHooks);

ReactDOM.render(<Hot />, document.querySelector('#root'));
