/* 더 커스텀 프로젝트 테이블 생성 */
CREATE TABLE `custom_user` (
    `custom_user_seq`      int(11)      NOT NULL AUTO_INCREMENT COMMENT '시퀀스',
    `custom_user_name`     varchar(100) NOT NULL                COMMENT '유저 이름',
    `custom_user_nick`     VARCHAR(100)                         COMMENT '유저 닉네임',
    `custom_user_email`    VARCHAR(100)                         COMMENT '유저 메일',
    `custom_user_pswd`     VARCHAR(100) NOT NULL                COMMENT '유저 비밀번호',
    `custom_user_birth`    VARCHAR(10)                          COMMENT '유저 생년월일',
    `custom_user_phone`    VARCHAR(11)                          COMMENT '유저 휴대폰번호',
    `custom_user_address`  VARCHAR(100)                         COMMENT '유저 주소',
    `custom_user_auth`     VARCHAR(2)   NOT NULL                COMMENT '유저 권한',
    `custom_user_del_yn`   VARCHAR(2)   NOT NULL                COMMENT '유저 삭제여부',
    `custom_user_reg_date` datetime NOT NULL DEFAULT current_timestamp() COMMENT '유저 등록일',
    `custom_user_mod_date` datetime DEFAULT NULL COMMENT '유저 수정일',
    PRIMARY KEY (`custom_user_seq`)
) COMMENT '회원정보';

create table `general_board` (
	`board_seq` int(11) not null auto_increment comment '게시판 시퀀스',
	`board_title` varchar(1000) not null comment '게시판 제목',
	`board_text` varchar(100) comment '게시판 내용',
	`board_writer` varchar(100) comment '게시판 작성자',
	`board_reg_date` datetime not null default current_timestamp() comment '게시판 작성시간',
	`board_mod_date` datetime default null comment '게시판 수정시간',
	`board_img_path` varchar(100) comment '게시판 이미지',
	`board_del_yn` varchar(2) not null comment '게시판 삭제여부',
	primary key (`board_seq`)
) comment '부서정보';

/*테이블조회*/
show tables;

/*테이블 컬럼명 조회*/
show columns from general_board;

/*insert 테스트*/
insert into general_board (
	  board_seq
	, board_title
    , board_text
    , board_writer
    , board_reg_date
    , board_mod_date
    , board_img_path
    , board_del_yn
) values (
	          0
            , '안녕하세요'
            , null
            , null
            , NOW()
            , NULL
            , NULL
            , 0
);

/*general_board 조회*/
SELECT
	  board_seq
	, board_title
    , board_text
    , board_writer
    , board_reg_date
    , board_mod_date
    , board_img_path
    , board_del_yn
FROM
    general_board
WHERE
    board_del_yn = 0
ORDER BY
    board_seq desc;

/*상세 조회*/
select * from general_board where board_seq = 2;

/*업데이트*/
update general_board
set
	  board_mod_date = now()
	, board_title = '제목변경'
	, board_text = '내용변경'
	, board_writer = '글쓴이변경'
where
	board_seq = 2;

/*전체 조회*/
select * from general_board gb order by board_seq desc;