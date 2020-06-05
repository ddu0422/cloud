// const path = require('path');
const webpack = require('webpack');

module.exports = {
  name: 'gugudan-setting',
  mode: 'development',
  devtool: 'eval',
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  entry: {
    app: ['./jsx/client'],
  },
  module: {
    rules: [{
      test: /\.jsx?/,
      loader: 'babel-loader',
      options: {
        presets: [
          ['@babel/preset-env', {
            targets: {
              browsers: ['> 5% in KR', 'last 2 chrome versions']
            },
          }],
          '@babel/preset-react'],
        plugins: ['@babel/plugin-proposal-class-properties'],
      },
    }],
  },
  plugins: [
    new webpack.LoaderOptionsPlugin({ debug: true }),
  ],
  output: {
    // path: path.join(__dirname, 'dist'),
    publicPath: '/dist/',
    filename: 'app.js',
  },
}