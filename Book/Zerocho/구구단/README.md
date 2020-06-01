# 구구단을 웹팩으로 만들어보자

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