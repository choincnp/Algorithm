-- 코드를 입력하세요
SELECT mcdp_cd as '진료과코드', count(mcdp_cd) as '5월예약건수' from appointment a
where date_format(a.apnt_ymd, '%Y-%m') = '2022-05'
group by mcdp_cd
order by count(mcdp_cd) , mcdp_cd

