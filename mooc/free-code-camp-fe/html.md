# FreeCodeCamp 프론트엔드 HTML 강의 정리

## Form Tag
- Browser가 Server에 사용자의 입력값을 보냄.
```
<form action='/serverAddr'>
    <input type='text' placeholder='Text Before User Input' required>

    <label><input type='checkbox' name='personality' checked>LOVING</label>
    <label><input type='checkbox' name='personality'>LAZY</label>

    <label><input type='radio' name='indoor-outdoor' required>INDOOR</label>
    <lable><input type='radio' name='indoor-outdoor'>OUTDOOR</label>

    <button type='submit'>SUBMIT</button>
</form>
```

- 구성 elements
 1. button : action에 제출
 2. input : 사용자 입력값 받음.
   - checked : default 체킹
   - required : 입력안되있을시 submit불가, 경고문구 생성.
   - name : checkbox, radio의 같은 그룹군의 같은 name으로 묶인다
