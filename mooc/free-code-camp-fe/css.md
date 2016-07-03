# FreeCodeCamp 프론트엔드 CSS 강의 정리

## margin & padding & border
- margin : border와 밖 영역의 공간
- padding: 내부 elements와 border 사이 공간
- border : 경계

## CSS inheirachy & override
- Browser는 CSS의 아래 영역을 우선.
  아래 코드는 빨간색 HI.
```
<style>
.text-pink{
  color: pink;
}
.text-red{
  color: red;
}
</style>
<body>
  <h1 class='text-pink text-red'>HI</h1>
</body>
```

- override
 1. !important (다른 CSS lib와 충돌할때 사용) `.text-red { color: red !important }`
 2. inline `<h1 style='color: red'>`
 3. class보다는 id가 우선 적용
 4. 같은 class이면 CSS파일 아래쪽이 적용

## RGB
 - #000000 == #000 == rgb(0,0,0) == black

## Font 추가
```
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<style>
  h2 {
    font-family: Lobster, Monospace;
  }
</style>
```
