# Learning Javascript 02장

## 선행

- git 설치
- node 설치

## git start

- 해당 프로젝트에서 아래 명령을 실행

```
git init
```

## npm 패키지 관리

- 해당 프로젝트에서 아래 명령을 실행

```
npm init
```

## 빌드도구 : 걸프와 그런트

- gulp 설치

```
npm i -g gulp
npm i -D gulp
```

- gulpfile.js 작성

```javascript
const gulp = require('gulp');

gulp.task('default', function() {
  
});
```

- 해당 폴더에서 gulp 명령을 통해 동작되는지 확인

## 트랜스컴파일러

- .babelrc 작성
  - 이 프로젝트에만 es6를 es5로 변환

```javascript
{ "presets" : ["es2015"] }
```

## 바벨을 걸프와 함께 사용하기

```
npm i -D gulp-babel@7 babel-core babel-preset-env
```

- gulpfile.js 수정

```javascript
const gulp = require('gulp');
const babel = require('gulp-babel');

gulp.task('default', async function() {
  // eslint를 사용하려면 작성
  gulp.src(['es6/**/*.js', 'public/es6/**/*.js'])
      .pipe(eslint())
      .pipe(eslint.format());

  // node source
  // es6 폴더에 있는 js v파일을 dist로 컴파일
  gulp.src('es6/**/*.js')
      .pipe(babel())
      .pipe(gulp.dest('dist'));

  // browser source
  gulp.src('public/es6/**/*.js')
      .pipe(babel())
      .pipe(gulp.dest('public/dist'));
});
```

- es6 문법 작성
- es6 폴더 및 public/es6 폴더에 넣기

```javascript
'use strict';

const sentences = [
  { subject: 'Javascript', verb: 'is', object: 'great' },
  { subject: 'Elephants', verb: 'are', object: 'large' },
];

function say({ subject, verb, object }) {
  console.log(`${subject} ${verb} ${object}`);
}

for (let s of sentences) {
  say(s);
}
```

- gulp 명령어 실행
- dist 폴더 및 public/dist 폴더에서 es5로 바뀐 것 확인

## 린트

- 코드를 검토해서 자주 일어나는 실수를 알려준다.

```
npm i -g eslint
```

- eslint --init으로 사용할 수 있다.
- 난 아직 모르겠으니 아직 쓰지 않겠다.