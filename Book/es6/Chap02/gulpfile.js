const gulp = require('gulp');
const babel = require('gulp-babel');

gulp.task('default', async function() {
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
