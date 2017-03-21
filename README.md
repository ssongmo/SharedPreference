### SharedPreference
##### 언제 사용하는가?

* 간단한 값 저장에 DB를 사용하기에는 복잡하기 때문에 SharedPreferences를 사용하면 적합하다.

- 보통 초기 설정값이나 자동로그인 여부 등 간단한 값을 저장하기 위해 사용한다.
- 어플리케이션에 파일 형태로 데이터를 저장한다.
=> data/data/패키지명/shared_prefs/SharedPreference이름.xml 위치에 저장
- 어플리케이션이 삭제되기 전까지 보존된다.

***소스 코드 참조**