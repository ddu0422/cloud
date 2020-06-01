const path = require('path');

module.exports = {
  name: 'gugudan-setting',
  mode: 'development', // product 시 : hidden-source-map
  devtool: 'eval',
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
        presets: ['@babel/preset-env', '@babel/preset-react'],
        plugins: []
      },
    }],
  },
  output: {
    path: path.join(__dirname, 'dist'),
    filename: 'app.js',
  },
}