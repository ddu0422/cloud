const path = require('path');

module.exports = {
  name: 'wordrelay-setting',
  mode: 'development',
  devtool: 'eval',
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  entry: {
    app: ['./client'],
  },
  module: {
    rules: [{
      test: /\.jsx?/,
      loader: 'babel-loader',
      options: {
        presets: ['@babel/preset-env', '@babel/preset-react'],
        plugins: [
          '@babel/plugin-proposal-class-properties',
          'react-hot-loader/babel',
        ]
      },
    }],
  },
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'app.js',
    publicPath: '/dist/', // 경로를 /dist 로 설정, express.static(__dirname, 'dist')과 비슷
  },
};