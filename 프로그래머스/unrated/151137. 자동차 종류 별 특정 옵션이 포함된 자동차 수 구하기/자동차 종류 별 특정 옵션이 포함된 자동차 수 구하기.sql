-- 코드를 입력하세요
SELECT car_type, count(*) as cars from CAR_RENTAL_COMPANY_CAR c
where c.options like '%시트%'
group by car_type
order by car_type