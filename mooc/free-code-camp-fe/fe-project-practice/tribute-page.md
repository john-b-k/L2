# Build a Tribute page

## Target
- make page like this [page](https://codepen.io/FreeCodeCamp/full/NNvBQW/)

## My Submittion
```html

<head>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
  <style>
  .content-container{
    font-family : Nimbus Sans;
  }
  </style>
</head>

<div class='container-fluid center-block'>

  <div class='row'>
    <div class=col-md-2>
    </div>
    <div class='jumbotron col-md-8'>
      <h1 class='text-center'>Dr. Norman Borlaug</h1>
      <h2 class='text-center'><i>The man who saved a billion lives</i></h2>
      <div class='thumbnail'>
        <img src='https://c2.staticflickr.com/4/3689/10613180113_fdf7bcd316_b.jpg' class='imge-responsive img-rounded center-block' alt='Normar Borlaug Img'>  
        <div class='caption text-center'>Dr. Norman Borlaug, second from left, trains biologists in Mexico on how to increase wheat yields - part of his life-long war on hunger.
        </div>
      </div>
      <div class='life-container'>
        <div class='row'>
          <div class="col-md-2">
          </div>
          <div class="col-md-8">
            <h2>Here's a time line of Dr. Borlaug's life:</h2>
            <ul>
              <li><b>1914</b> - Born in Cresco, Iowa</li>
              <li><b>1933</b> - Leaves his family's farm to attend the University of Minnesota, thanks to a Depression era program known as the "National Youth Administration"</li>
              <li><b>1935</b> - Has to stop school and save up more money. Works in the Civilian Conservation Corps, helping starving Americans. "I saw how food changed them", he said. "All of this left scars on me."</li>
              <li><b>1937</b> - Finishes university and takes a job in the US Forestry Service</li>
              <li><b>1938</b> - Marries wife of 69 years Margret Gibson. Gets laid off due to budget cuts. Inspired by Elvin Charles Stakman, he returns to school study under Stakman, who teaches him about breeding pest-resistent plants.</li>
              <li><b>1941</b> - Tries to enroll in the military after the Pearl Harbor attack, but is rejected. Instead, the military asked his lab to work on waterproof glue, DDT to control malaria, disenfectants, and other applied science.</li>
              <li><b>1942</b> - Receives a Ph.D. in Genetics and Plant Pathology</li>
              <li><b>1944</b> - Rejects a 100% salary increase from Dupont, leaves behind his pregnant wife, and flies to Mexico to head a new plant pathology program. Over the next 16 years, his team breeds 6,000 different strains of disease resistent wheat - including different varieties for each major climate on Earth.</li>
              <li><b>1945</b> - Discovers a way to grown wheat twice each season, doubling wheat yields</li>
              <li><b>1953</b> - crosses a short, sturdy dwarf breed of wheat with a high-yeidling American breed, creating a strain that responds well to fertalizer. It goes on to provide 95% of Mexico's wheat.</li>
              <li><b>1962</b> - Visits Delhi and brings his high-yielding strains of wheat to the Indian subcontinent in time to help mitigate mass starvation due to a rapidly expanding population</li>
              <li><b>1970</b> - receives the Nobel Peace Prize</li>
              <li><b>1983</b> - helps seven African countries dramatically increase their maize and sorghum yields</li>
              <li><b>1984</b> - becomes a distinguished professor at Texas A&M University</li>
              <li><b>2005</b> - states "we will have to double the world food supply by 2050." Argues that genetically modified crops are the only way we can meet the demand, as we run out of arable land. Says that GM crops are not inherently dangerous because "we've been genetically modifying plants and animals for a long time. Long before we called it science, people were selecting the best breeds."</li>
              <li><b>2009</b> - dies at the age of 95.</li>
            </ul>
            <blockquote>
              <p></p>
              <p>"Borlaug's life and achievement are testimony to the far-reaching contribution that one man's towering intellect, persistence and scientific vision can make to human peace and progress."
              </p>

              <footer>
                <cite>Indian Prime Minister Manmohan Singh</cite>
              </footer>
            </blockquote>
            <div class='more-info-container'>
              <h3>
                If you have time, you should read more about this incredible human being on his <a href='https://en.wikipedia.org/wiki/Norman_Borlaug' target='_blank'>Wikipedia entry</a>.
              </h3>
            </div>
           </div>
          <div class="col-md-2">
          </div>
        </div>
      </div>
    </div>
    <div class=col-md-2>
    </div>
  </div>     
</div>

```

## 관찰점

1. a tag 에 target="\_blank"
2. bootstrap에서 <\blockquote\>
3. .container for a responsive fixed width container.  Not Use <div class='container-fluid>


## Answer
```html
<head>
  <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css"/>
  <style>
  body {
    margin-top: 60px;
  }
  </style>
</head>

<div class="container">
  <div class="jumbotron">
    <div class="row">
      <div class="col-xs-12">
        <h1 class="text-center">Dr. Norman Borlaug</h1>
        <h2 class="text-center"><em>The man who saved a billion lives</em></h2>
        <div class="thumbnail"><image src="https://c2.staticflickr.com/4/3689/10613180113_fdf7bcd316_b.jpg">
          <div class="caption text-center">Dr. Norman Borlaug, second from left, trains biologists in Mexico on how to increase wheat yields - part of his life-long war on hunger.</div>
        </div>
        <div class="col-xs-12 col-sm-10 col-sm-offset-1 col-md-8 col-md-offset-2">
          <h3>Here's a time line of Dr. Borlaug's life:</h3>
          <ul>
            <li><strong>1914</strong> - Born in Cresco, Iowa</li>
            <li><strong>1933</strong> - Leaves his family's farm to attend the University of Minnesota, thanks to a Depression era program known as the "National Youth Administration"</li>
            <li><strong>1935</strong> - Has to stop school and save up more money. Works in the Civilian Conservation Corps, helping starving Americans. "I saw how food changed them", he said. "All of this left scars on me."</li>
            <li><strong>1937</strong> - Finishes university and takes a job in the US Forestry Service</li>        
            <li><strong>1938</strong> - Marries wife of 69 years Margret Gibson. Gets laid off due to budget cuts. Inspired by Elvin Charles Stakman, he returns to school study under Stakman, who teaches him about breeding pest-resistent plants.</li>        
            <li><strong>1941</strong> - Tries to enroll in the military after the Pearl Harbor attack, but is rejected. Instead, the military asked his lab to work on waterproof glue, DDT to control malaria, disenfectants, and other applied science.</li>      
            <li><strong>1942</strong> - Receives a Ph.D. in Genetics and Plant Pathology</li>        
            <li><strong>1944</strong> - Rejects a 100% salary increase from Dupont, leaves behind his pregnant wife, and flies to Mexico to head a new plant pathology program. Over the next 16 years, his team breeds 6,000 different strains of disease resistent wheat - including different varieties for each major climate on Earth.</li>
            <li><strong>1945</strong> - Discovers a way to grown wheat twice each season, doubling wheat yields</li>    
            <li><strong>1953</strong> - crosses a short, sturdy dwarf breed of wheat with a high-yeidling American breed, creating a strain that responds well to fertalizer. It goes on to provide 95% of Mexico's wheat.</li>        
            <li><strong>1962</strong> - Visits Delhi and brings his high-yielding strains of wheat to the Indian subcontinent in time to help mitigate mass starvation due to a rapidly expanding population</li>        
            <li><strong>1970</strong> - receives the Nobel Peace Prize</li>
            <li><strong>1983</strong> - helps seven African countries dramatically increase their maize and sorghum yields</li>
            <li><strong>1984</strong> - becomes a distinguished professor at Texas A&M University</li>
            <li><strong>2005</strong> - states "we will have to double the world food supply by 2050." Argues that genetically modified crops are the only way we can meet the demand, as we run out of arable land. Says that GM crops  are not inherently dangerous because "we've been genetically modifying plants and animals for a long time. Long before we called it science, people were selecting the best breeds."</li>
            <li><strong>2009</strong> - dies at the age of 95.</li>      
          </ul>
          <blockquote>
            <p>"Borlaug's life and achievement are testimony to the far-reaching contribution that one man's towering intellect, persistence and scientific vision can make to human peace and progress."</p>
            <footer><cite>Indian Prime Minister Manmohan Singh</cite></footer>
          </blockquote>
          <h3>If you have time, you should read more about this incredible human being on his <a href="https://en.wikipedia.org/wiki/Norman_Borlaug" target="_blank">Wikipedia entry</a>.</h3>
        </div>
      </div>
    </div>
  </div>
  <footer class="text-center">
    <hr>
    <p>Written and coded by <a href="https://www.freecodecamp.com/quincylarson" target="_blank">Quincy Larson</a>.</p>
  </footer>  
</div>  
```
