-- 코드를 입력하세요
SELECT truncate(price, -4) as price_group, count(*) as products from product p
group by price_group
order by price_group asc


