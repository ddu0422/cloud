# Learning Javascript 01장

## 시작하기

- css 파일을 불러온다.

```html
<link rel="stylesheet" href="main.css">
```

- javascript 파일을 불러온다.

```html
<script src="main.js"></script>
```

## 제이쿼리

```html
<script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
```

```javascript
$(document).ready(function() {
  'use strict'; // 자바스크립트 인터프리터에서 코드를 엄격하게 처리해라.
  console.log('main.js loaded');
});
```

## 단순한 그래픽 그리기

- HTML5 캔버스 사용
- ID는 한번만 사용되어야 한다.

```html
<canvas id="mainCanvas"></canvas>
```

- paper.js 사용해보기

```html
<script src="https://cdnjs.cloudflare.com/ajax/libs/paper.js/0.9.25/paper-full.min.js"></script>
```

```javascript
$(document).ready(function () {
  'use strict';

  paper.install(window);
  paper.setup(document.querySelector('#mainCanvas'));

  var c;
  for (var x = 25; x < 400; x+= 50) {
    for (var y = 26; y < 400; y+=50) {
      c = Shape.Circle(x, y, 20);
      c.fillColor = 'green';
    }
  }

  paper.view.draw();
});
```

## 사용자 입력 처리하기

- 네모칸 안을 마우스로 눌렀을 때, 원 생성

```javascript
$(document).ready(function () {
  'use strict';

  paper.install(window);
  paper.setup(document.querySelector('#mainCanvas'));

  var tool = new Tool();

  tool.onMouseDown = function (event) {
    var c = Shape.Circle(event.point.x, event.point.y, 20);
    c.fillColor = 'green';
  }

  paper.view.draw();
});

```

## Hello, World

```javascript
var c = Shape.Circle(200, 200, 50);
c.fillColor = 'black';
var text = new PointText(200, 200);
text.justification = 'center';
text.fillColor = 'white';
text.fontSize = 20;
text.content = 'hello world';
```