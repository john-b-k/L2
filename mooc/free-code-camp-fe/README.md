# FreeCodeCamp 의 Front-End 강의 정리

## 1. HTML
## 2. CSS
```
$(document).ready(function() {
    
  });function will run as soon as your browser has loaded your page.
if not this code  run before your HTML is rendered -> cause bug

$('.well').addClass('animated shake') to add the classes animated and shake

동적으로 css  적용가능



change the CSS of an HTML element directly  .css()
 $('#target1').css('color','red');

Disable an Element
$('button').prop('disabled',true);
attr() prop()

attribute properties 차이

text between start and end tags of element
.html()
$("h3").html("<em>jQuery Playground</em>");

text() 는 tag를 그대로 escape해서 보여줌 (not evaluate any HTML tags)


remove() entirely remove HTML element

move element to other element shell cmd mv
ex $("#target4").appendTo("#left-well");  $( "<p>Test</p>" ).appendTo( ".inner" );

shell cmd cp
$("#target2").clone().appendTo("#right-well");


elements의 inherits property 이용
$("#left-well").parent().css("background-color", "blue")
```
