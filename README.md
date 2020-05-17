# SOPT_3
SOPT android part 3차 세미나  과제

## ScreenShots
<img width="250" src="https://user-images.githubusercontent.com/50590192/82148366-ab017980-988e-11ea-9ceb-5d3202067070.gif">

## Learned Points
* Request, Response에 따른 data class를 만들어주고 RequestToServer object에서 빌드한 후 RequestInterface를 묶어줌.
  - 빌드할 때 baseUrl을 넣고, interface에서 post/get REST API 요청 + request함수 정의
* setOnClickListener 호출 시 requestToServer로 정보 전달 -> enqueue(object : Callback<ResponseData>{})로 비동기 요청
* Open API 사용 시 query 요청을 하므로 request data class는 따로 필요하지 않음.
  - 발급받은 key를 values/strings.xml에 정의해주고 .gitignore에 추가
  - interface에서 request 함수의 파라미터로 쿼리와 헤더(authorization)를 설정
* JSON 데이터를 받을 때 보통 원하는 데이터 객체들이 담긴 배열이 포함된 객체를 받게 됨.<br/>
  이 때 원하는 형식의 data class를 정의해주고 이 data class를 리스트로 갖는 data class를 정의해서 받은 뒤,<br/>
  map을 이용해서 it으로 add해주면 됨.
