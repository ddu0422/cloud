# 노트

## React Project

1. npm init

- name : gugudan
- author : duho
- license: MIT

2. plugin 설치

```script
npm i react react-dom
npm i -D webpack
npm i -D webpack-cli
npm i -D @babel/core
npm i -D @babel/preset-env
npm i -D @babel/preset-react
npm i -D babel-loader
npm i -D webpack-dev-server
npm i -D react-hot-loader
// class에서 state 사용시 설치
npm i -D @babel/plugin-proposal-class-properties
```

3. webpack.config.js 설정

```javascript
const webpack = require("webpack");

module.exports = {
  name: "component-setting",
  mode: "development",
  devtool: "eval",
  resolve: {
    extensions: [".jsx", ".js"],
  },
  entry: {
    app: ["./client"],
  },
  module: {
    rules: [
      {
        test: /\.jsx?/,
        loader: "babel-loader",
        options: {
          presets: [
            [
              "@babel/preset-env",
              {
                targets: {
                  browsers: ["> 5% in KR", "last 2 chrome versions"],
                },
              },
            ],
            "@babel/preset-react",
          ],
          plugins: [
            "@babel/plugin-proposal-class-properties",
            "react-hot-loader/babel",
          ],
        },
      },
    ],
  },
  plugins: [new webpack.LoaderOptionsPlugin({ debug: true })],
  output: {
    publicPath: "/dist/",
    filename: "app.js",
  },
};
```

```javascript
// webpack-dev-server가 webpack.config.js를 읽어서 백에서 build해서 서버에서 유지한다.
package.json -> dev: "webpack-dev-server"로 바꿈
npm run dev
-> Server가 뜸
```

4. client.js

```jsx
const { hot } = require('react-hot-loader/root');
const Component require('./jsx/Component');
const Hot = hot(Component);

ReactDOM.render(<Hot />, document.querySelector('#root'));
```

5. npm run dev

## Componet Exports

1. module.exports

```jsx
module.exports = Component;
```

2. export default

```jsx
// export default는 하나만 존재할 수 있다.
export default Component;
export const hello = "hello";
// import { hello } from ... 으로 사용할 수 있다.
```

## import vs require

- babel이 import를 require로 바꿔준다.
- require는 Node에서 import는 React에서 사용하자.
- 단, babel이 import를 바꿔주므로 webpack.config.js 에선 const를 사용해야한다.
