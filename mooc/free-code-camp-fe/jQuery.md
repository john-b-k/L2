# 기본 jQuery 를 이용한 HTML elements handling

## Complete code
```html
<head>
  <link rel='stylesheet' href='http://s.mlcdn.co/animate.css'>
</head>
<body>
  <script>
    $(document).ready(function() {
      $("#target1").css("color", "red");
      $("#target1").prop("disabled", true);
      $("#target4").remove();
      $("#target2").appendTo("#right-well");
      $("#target5").clone().appendTo("#left-well");
      $("#target1").parent().css("background-color", "red");
      $("#right-well").children().css("color", "orange");
      $("#left-well").children().css("color", "green");
      $(".target:nth-child(2)").addClass("animated bounce");
      $(".target:even").addClass("animated shake");
      $("body").addClass("animated fadeOut");
    });
  </script>

  <!-- Only change code above this line. -->

  <div class="container-fluid">
    <h3 class="text-primary text-center">jQuery Playground</h3>
    <div class="row">
      <div class="col-xs-6">
        <h4>#left-well</h4>
        <div class="well" id="left-well">
          <button class="btn btn-default target" id="target1">#target1</button>
          <button class="btn btn-default target" id="target2">#target2</button>
          <button class="btn btn-default target" id="target3">#target3</button>
        </div>
      </div>
      <div class="col-xs-6">
        <h4>#right-well</h4>
        <div class="well" id="right-well">
          <button class="btn btn-default target" id="target4">#target4</button>
          <button class="btn btn-default target" id="target5">#target5</button>
          <button class="btn btn-default target" id="target6">#target6</button>
        </div>
      </div>
    </div>
  </div>
</body>
```

## document ready event
- JS function 은 browser가 page load할때 실행된다.
- document ready event 함수로 제어하지 않으면 HTML이 render되기 전에 코드가 실행된다 -> bug 원인  
`$(document).ready(function(){ //todo });`

## 동적으로 HTML elements에 CSS style적용
- addClass() : class attr를 추가해서 , css에서 class selector(.)로 정의된 내용 적용되게함.  
<pre><code>
$('.well').addClass('animated shake');  
//animate.css
.shake{ //some style }
.animated{ //some style }
</code></pre>


- css() :  직접 HTML element의 css style 적용  
`$('#target')`.css('color,'red);


## HTML에 텍스트 삽입 (text() vs html())
- html() : 해당 element 시작 , 끝 tag사이에 삽입  
`$('h1').html('<em>jQuery play!</em>')`  :  HTML 코드로 적용됨 (em tag 해석됨)
- text() : __텍스트로__ 삽입.  
`$('h1').html('<em>jQuery play!</em>')`  : h1 제목으로 <em>jQuery play!</em>그대로 입력.


## HTML element  move & copy
- shell의 mv 와 cp 명령어와 같음  
1. mv : `$('#target1').appendTo('#left-well')`  `$('<p>Hi</p>').appendTO('#rigth-well')`  
2. cp : `$('#target2').clone().appendTo('#right-well');`


## HTML elements의 inherits property 이용
- `$('#left-well').parent().css('color','orange');`
- `$('#right-well').children().css('background-color','red');`
- `$('.col-xs-6 div .target:nth-child(3)').addClass('animated bounce');`  :  .target(들)의 __부모__ 의 3째 *자식*
