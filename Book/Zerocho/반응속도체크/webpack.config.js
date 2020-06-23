const webpack = require('webpack');

module.exports = {
  name: 'component-setting',
  mode: 'development',
  devtool: 'eval',
  resolve: {
    extensions: ['.jsx', '.js'],
  },
  entry: {
    app: ['./client'],
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
        plugins: [
          '@babel/plugin-proposal-class-properties',
          'react-hot-loader/babel'
        ],
      },
    }],
  },
  plugins: [
    new webpack.LoaderOptionsPlugin({ debug: true }),
  ],
  output: {
    publicPath: '/dist/',
    filename: 'app.js',
  },
}