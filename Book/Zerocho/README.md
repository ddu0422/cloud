# 노트

## 구구단 Webpack 설정

1. npm init
  - name : gugudan
  - author : duho
  - license: MIT

2. react, react-dom 설치

```
npm i react react-dom
```

3. webpack 설치
```
npm i -D webpack
npm i -D webpack-cli
```

4. babel 설치

```text
npm i -D @babel/core
npm i -D @babel/preset-env
npm i -D @babel/preset-react
npm i -D babel-loader
npm i -D @babel/plugin-proposal-class-properties
```

5. GuGuDan.jsx 작성

```
~~~~~

module.exports = GuGudan
```

6. Client.jsx 작성

```javascript
const React = require('react');
const ReactDom = require('react-dom');
const GuGuDan = require('GuGuDan');

ReactDom.render(<GuGuDan />, document.querySelector('#root'))
```

7. webpack.config.js 설정

```javascript
const path = require('path');

module.exports = {
  name: 'gugudan-setting',
  mode: 'development',
  devtool: 'eval',
  resolve: {
    extentions: ['.jsx', '.js'],
  },
  entry: {
    app: ['./jsx/client'],
  },
  module: {
    rules: [{
      test: /\.jsx?/,
      loader: 'babel-loader',
      options: {
        presets: ['@babel/preset-env', '@babel/preset-react'],
        plugins: ['@babel/plugin-proposal-class-properties']
      },
    }],
  },
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'app.js',
  },
}
```

8. npx webpack
9. gugudan.html 실행

## Webpack Auto Reload

1. react-hot-loader / webpack-dev-server 설치

```
npm i -D react-hot-loader
npm i -D webpack-dev-server
```

2. webpack-dev-server 실행

- webpack-dev-server가 webpack.config.js를 읽어서 백에서 build해서 서버에서 유지한다.

```
package.json -> dev: "webpack-dev-server" 바꿈
npm run dev
-> Server가 뜸
```

3. dist 폴더 삭제 -> 경로 app.js로 변경
4. client.js 수정

```javascript
const { hot } = require('react-hot-loader/root');
const Hot = hot(WordRelay);
```

5. webpack.config.js -> rules: plugins 추가

```
react-hot-loader/babel
```

6. npm run dev