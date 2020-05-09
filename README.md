# sg-url-verification

## 주요 기능
* URL 정보 추출
* Selenium을 활용한 웹페이지 ScreenShot 다운로드 (모바일용)
* Message 내용에서 URL 값 후보 추출

## Version
* Spring Boot : 2.2.6.RELEASE
* Selenium : 3.141.59
* Guava : 29.0-jre

## 사전 설정
1. Chrome 설치  
해당 Project는 Chrome 브라우저를 사용  
Chrome이 설치 되어 있지 않은 경우 설치 필요

2. chromedriver 다운로드  
설치 되어 있는 Chrome 버전에 맞는 chromedriver 다운로드 후 압축 해제  
https://chromedriver.chromium.org/downloads

3. application.properties 수정  
Path : /sg-url-verification/src/main/resources/application.properties  
수정 : webdriver.chrome.driver.path (chromedriver.exe 경로)

## 테스트
* URL 정보 및 ScreenShot 다운로드 (URL이 웹페이지인 경우만 자동 다운로드)  
URL : http://localhost:8080  
* Message 내용에서 URL 값 후보 추출  
URL : http://localhost:8080/eduction

## ScreenShot
![K-001](https://user-images.githubusercontent.com/49360550/81473790-123e7e80-923c-11ea-9dc0-2b6f63d42875.jpg)

![K-002](https://user-images.githubusercontent.com/49360550/81473796-22565e00-923c-11ea-834a-d217902c3878.jpg)

![K-003](https://user-images.githubusercontent.com/49360550/81473803-284c3f00-923c-11ea-9e6c-d37e00c9bafa.jpg)
