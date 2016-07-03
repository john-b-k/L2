# FreeCodeCamp Bootstrap 강의정리

## 최종결과 코드
```
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>
<link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet" type="text/css">
<style>
  h2 {
    font-family: Lobster, Monospace;
  }

  .thick-green-border {
    border-color: green;
    border-width: 10px;
    border-style: solid;
    border-radius: 50%;
  }
</style>

<div class="container-fluid">
  <div class="row">
    <div class="col-xs-8">
      <h2 class="text-primary text-center">CatPhotoApp</h2>
    </div>
    <div class="col-xs-4">
      <a href="#"><img class="img-responsive thick-green-border" src="https://bit.ly/fcc-relaxing-cat"></a>
    </div>
  </div>
  <img src="https://bit.ly/fcc-running-cats" class="img-responsive">
  <div class="row">
    <div class="col-xs-4">
      <button class="btn btn-block btn-primary"><i class="fa fa-thumbs-up"></i> Like</button>
    </div>
    <div class="col-xs-4">
      <button class="btn btn-block btn-info"><i class="fa fa-info-circle"></i> Info</button>
    </div>
    <div class="col-xs-4">
      <button class="btn btn-block btn-danger"><i class="fa fa-trash"></i> Delete</button>
    </div>
  </div>
  <p>Things cats <span class="text-danger">love:</span></p>
  <ul>
    <li>cat nip</li>
    <li>laser pointers</li>
    <li>lasagna</li>
  </ul>
  <p>Top 3 things cats hate:</p>
  <ol>
    <li>flea treatment</li>
    <li>thunder</li>
    <li>other cats</li>
  </ol>
  <form action="/submit-cat-photo">
    <div class="row">
      <div class="col-xs-6">
        <label><input type="radio" name="indoor-outdoor"> Indoor</label>
      </div>
      <div class="col-xs-6">
        <label><input type="radio" name="indoor-outdoor"> Outdoor</label>
      </div>
    </div>
    <div class="row">
      <div class="col-xs-4">
        <label><input type="checkbox" name="personality"> Loving</label>
      </div>
      <div class="col-xs-4">
        <label><input type="checkbox" name="personality"> Lazy</label>
      </div>
      <div class="col-xs-4">
        <label><input type="checkbox" name="personality"> Crazy</label>
      </div>
    </div>
    <div class='row'>
      <div class='col-xs-7'>
    <input type="text" class="form-control" placeholder="cat photo URL" required>
      </div>
      <div class='col-xs-5'>
    <button type="submit" class="btn btn-primary"><i class="fa fa-paper-plane"></i> Submit</button></div>
    </div>
  </form>
</div>
```

## bootstarp framework import
1. 직접 CSS JS 파일 등을 다운로드 해서 내 web project에 important
2. bootstrap CND : `<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>` 이용  
<br/>
참고 [link](http://bootstrapk.com/getting-started/)

## bootstrap의 반응형 elements(tag, class)
1. __.container-fluid__ : root div 태그로 활용. **전체 Contents 반응형** 적용  
ex : `<div class='container-fluid'>`
2. __.img-responsive__ : img 반응형 적용  
ex : `<img class='img-responsive'>`  
3. __.text-center__ : text 가운데 정렬  
ex : `<h2 class='text-center'>CENTER</h2>`
4. __.btn__ : bootstrap은 고유의 button UI 제공  
__.btn-block__  : button 화면 전체로 spread out 시킴(**block level button**)  
ex : `<button class="btn btn-block">Submit</button>`
5. __.btn-primary .btn-info .btn-danger__ : bootstrap은 고유의 button 종류 속성을 제공하고 색깔도 지정해서 제공.(pre-defined color)
ex : `<button class='btn btn-block btn-danger'>DELETE</button> //red delete 버튼`  

참고 - [link](http://getbootstrap.com/css/#buttons)

## bootstrap grid system
- Overview  
bootstrap 은 화면을 **12개 column** 으로 나눠서 반응형 design활용을 제공한다.  
적용시킬 tag들 위에 `<div class='row'>` (1개)와 `<div class='col-xs-3 col-md-7'>` (n<=12개) 을  **wrapping** 하여 활용.
- `div .col-xs-*` : '\*'는 12개 column 중에 몇 column을 차지할지 *element size* 설정.
- `div .row` 와 `div .col-xs-*` 을 이용하면 elements들을 __inline__ 으로 세팅할수 있다.  
ex : h2와 img를 inline 시킴
```
<div class="row">
    <div class="col-xs-8">
      <h2>CatPhotoApp</h2>
    </div>
    <div class="col-xs-4">
      <img src="https://bit.ly/fcc-relaxing-cat">
    </div>
</div>
```

- `<div class='well'>` : col의 depth를 시각적으로 보여줌.


참고 - [link](http://getbootstrap.com/css/#grid)

## FontAwesome  (awesome icon lib!)
- 시작  
  - CDN :
<script src="https://use.fontawesome.com/345c86fd0f.js"></script>
  - download and embed css`<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
`
  - bootstrap maxcdn : `<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css"/>`

- 활용  
```
<button class="btn btn-block btn-primary">
    <i class="fa fa-thumbs-up"></i> Like
</button>
```

활용 [link](http://fontawesome.io/icons/)
