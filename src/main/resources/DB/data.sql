---- ================ bookinfo
--INSERT INTO 책정보 (title, writer, genre, publisher, publication_date, poster, summary) VALUES
--('미드나잇 라이브러리', '매트 헤이그', '소설', '북플라자', '2020-07-15', '미드나잇라이브러리_포스터.jpg', '손에 잡히지 않는 비밀의 도서관, 미드나잇 라이브러리를 통해 여러 가지 이야기를 체험하게 되는 소녀, 노라. 인생의 선택과 후회, 우정과 사랑의 의미에 대한 이야기가 담겨져 있습니다.'),
--('호밀밭의 파수꾼', 'J.D. 샐린저', '소설', '사람과 사람', '1951-07-16', '호밀밭의파수꾼_포스터.jpg', '길에서 외로이 세상을 바라보며 고민하는 청년 홀덴 코필드의 이야기입니다. 청소년의 고민과 성장, 사회의 문제를 다루고 있으며, 혼자만의 호밀밭에서 세상에 대한 불만과 책임감을 느끼며 사회에 대한 편견과 상처를 품게 됩니다.'),
--('1984', '조지 오웰', '소설', '경성출판사', '1949-06-08', '1984_포스터.jpg', '인간의 자유와 권력, 사회주의의 한계에 대해 다루는 대표적인 소설입니다. 빅브라더라는 권력에 의해 감시되고 통제되는 사회의 모습을 그려내며, 인간의 존엄성과 자유를 갈망하는 주인공 윈스턴의 이야기가 펼쳐집니다.');
---- ================ user
--INSERT INTO 회원정보 (id, pw, name, confirm, like_idx) VALUES
--(123456, 'password123', '홍길동', 1, 1),
--(789012, 'pass789', '김철수', 0, 2),
--(345678, 'pass345', '이영희', 1, 3);
---- ================ subscribe
--INSERT INTO 구독 (start_date, end_date, confirm) VALUES
--('2023-05-01', '2023-06-01', 1),
--('2023-05-15', '2023-06-15', 0),
--('2023-06-01', '2023-07-01', 1);
---- ================ bookmark
--INSERT INTO 즐겨찾기 (member_idx, book_idx) VALUES
--(1, 1),
--(2, 3),
--(3, 2);
---- ================ feed 피드 랜덤으로 view에 띄워주기 "좋아요"
--INSERT INTO 좋아요 (member_idx, feed_idx) VALUES
--(1, 1),
--(2, 1),
--(1, 2),
--(3, 3);
---- ================ feed 피드 랜덤으로 view에    띄워주기 "좋아요"
--INSERT INTO 피드 (writer, title, content, create_date, views, likes, bookinfo_idx) VALUES
--('김작가', '책 리뷰', '이 책은 정말로 흥미진진한 이야기를 담고 있습니다. 꼭 읽어보세요!', '2023-05-01', 100, 10, 1),
--('이작가', '독서 일지', '오늘은 이 책을 읽으면서 많은 생각을 하게 되었습니다. 내용이 너무 좋아요!', '2023-05-05', 50, 5, 2),
--('박작가', '신작 소개', '안녕하세요! 저의 새로운 소설이 출간되었습니다. 많은 사랑 부탁드립니다.', '2023-05-10', 80, 8, 3);
---- ================ 리뷰
--INSERT INTO 리뷰 (feed_idx, writer_idx, content, create_date, bookinfo_idx) VALUES
--(1, 1, '이 책에 대한 리뷰입니다. 정말 재밌게 읽었습니다!', '2023-05-02', 1),
--(1, 2, '저도 이 책을 읽었는데 너무 좋았어요. 추천합니다!', '2023-05-03', 1),
--(2, 1, '오늘은 다른 책을 읽었습니다. 내용이 정말 신선했어요.', '2023-05-06', 2),
--(3, 3, '이 소설은 정말로 감동적이었습니다. 꼭 한 번 읽어보세요!', '2023-05-12', 3);
