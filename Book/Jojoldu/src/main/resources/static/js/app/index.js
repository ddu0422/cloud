// index라는 변수의 속성으로 funtion을 추가한 이유
/*
  1. 브라우저의 스코프는 공용 공간으로 사용된다.
  2. 다른 init과 save funtion이 있다면 덮어씌인다.
  3. index 객체 안에서만 function이 유효하도록 만들어 다른 js와 겹칠 위험을 없앤다.
 */

const index = {
  init: function () {
    const _this = this;

    $('#btn-save').on('click', function () {
      _this.save();
    });
  },
  save: function () {
    const data = {
      title: $('#title').val(),
      author: $('#author').val(),
      content: $('#content').val(),
    };

    $.ajax({
      type: 'POST',
      url: '/api/v1/posts',
      dataType: 'json',
      contentType: 'application/json; charset=utf-8',
      data: JSON.stringify(data),
    }).done(function () {
      alert('글이 등록되었습니다.');
      window.location.href = '/';
    }).fail(function (error) {
      alert(JSON.stringify(error));
    })
  }
};

index.init();