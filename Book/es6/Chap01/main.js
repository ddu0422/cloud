$(document).ready(function () {
  'use strict';

  paper.install(window);
  paper.setup(document.querySelector('#mainCanvas'));

  var tool = new Tool();
  var c = Shape.Circle(200, 200, 50);
  var text = new PointText(200, 200);

  c.fillColor = 'black';
  text.justification = 'center';
  text.fillColor = 'white';
  text.fontSize = 20;
  text.content = 'hello world';

  tool.onMouseDown = function (event) {
    var c = Shape.Circle(event.point.x, event.point.y, 20);
    c.fillColor = 'green';
  }

  paper.view.draw();
});