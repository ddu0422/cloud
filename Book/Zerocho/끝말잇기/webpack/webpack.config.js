const path = require('path');

module.exports = {
  name: 'wordrelay-setting', // 아무 이름이나 상관 없다.
  mode: 'development', // 실 서비스: production
  devtool: 'eval', // 빠르게

  // 확장자를 entry에 계속 입력하지 않고 resolve를 설정하면 client.js / client.jsx를 찾아서 넣어준다.
  resolve: {
    extensions: ['.js', '.jsx'],
  },

  // 아래 두 개가 제일 중요
  entry: {
    app: ['./client'],
  }, // 입력

  // entry의 파일을 읽어서 module을 적용한다.
  module: {
    rules: [{
      // 규칙을 적용할 파일들을 정규표현식으로 작성
      test: /\.jsx?/,
      // 바벨을 적용한다.
      loader: 'babel-loader',
      // 어떤걸 이용?
      options: {
        presets: ['@babel/preset-env', '@babel/preset-react'],
        plugins: ['@babel/plugin-proposal-class-properties']
      },
    }],
  },

  output: {
    // 현재 폴더에 있는 dist [node를 공부해야한다.]
    path: path.join(__dirname, 'dist'), // /Users/leeduho/Develop/home/cloud/book/zerocho/끝말잇기/dist
    filename: 'app.js',
  }, // 출력 : wordchain.html의 webpack 경로
};