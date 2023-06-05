# book
### login
jwt 토큰을 받아 로그인 처리
### signup
id, pw, name을 받아 member 테이블에 저장
### withdrawn
탈퇴시 withdrawn_member 테이블에 담고 14일이 지나면 데이터 삭제
### subscribe
subscribe, member 테이블에 0 : false, 1 : true로 저장
