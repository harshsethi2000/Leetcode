# Write your MySQL query statement below
select distinct a.id  from Weather a,Weather b where a.temperature > b.temperature AND DATEDIFF(a.Recorddate,b.RecordDate)=1;