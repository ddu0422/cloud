const path = require('path');
const webpack = require('webpack');

module.exports = {
  name: 'gugudan-setting',
  mode: 'development',
  devtool: 'eval', // product 시 : hidden-source-map
  resolve: {
    extensions: ['.js', '.jsx'],
  },
  entry: {
    app: ['./jsx/Client'],
  },
  module: {
    rules: [{
      test: /\.jsx?/,
      loader: 'babel-loader',
      options: {
        presets: [
          ['@babel/preset-env', {
            targets: {
              browsers: ['> 5% in KR', 'last 2 chrome versions'],
            },
            debug: true,
          }],
          '@babel/preset-react'
        ],
        plugins: [],
      },
    }],
  },
  plugins: [
    new webpack.LoaderOptionsPlugin({ debug: true }),
  ],
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'app.js',
  },
}