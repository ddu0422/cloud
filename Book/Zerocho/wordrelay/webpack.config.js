const webpack = require('webpack');

module.exports = {
  name: 'wordrelay-setting',
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
              browsers: [
                '> 5% in KR',
              ],
            },
          }],
          '@babel/preset-react',
        ],
        plugins: [
          'react-hot-loader/babel', 
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