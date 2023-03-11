-- 코드를 입력하세요
SELECT TITLE, 
        ub.BOARD_ID, 
        ur.REPLY_ID, 
        ur.WRITER_ID, 
        ur.CONTENTS, 
        DATE_FORMAT(ur.created_date,'%Y-%m-%d') as CREATED_DATE
         from used_goods_board ub, used_goods_reply ur
where DATE_FORMAT(ub.created_date,'%Y-%m') = '2022-10' and ub.board_id = ur.board_id
order by ur.created_date, ub.title