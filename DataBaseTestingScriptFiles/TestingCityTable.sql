
show tables;

select count(*) as NumberoFColumns from
Information_Schema.columns
where table_schema="world" and table_name="city";

Select table_Name from Information_Schema.tables
where table_schema="world" ;

select column_name as NumberoFColumns from
Information_Schema.columns
where table_schema="world" and table_name="city";

select Column_Name,Data_type,is_Nullable,character_maximum_length,numeric_precision,numeric_scale,column_key
from Information_Schema.columns
where table_schema="world" and table_name="city";

select *
from Information_Schema.columns
where table_schema="world" and table_name="city";

delimiter #
create procedure addcitytocityList(
in id int,
in name char(35),
in countrycode char(5),
in district char(20),
in population int)
begin
declare exit handler for 1062 select 'Duplicate Key error in the procedure' Message;
declare exit handler for sqlexception select 'some error occured in the procedure' Message;
insert into city values(id,name,countrycode,district,population);
end#



call addcitytocityList(5001,"Mysore","IND","Mysore",150000);


show procedure status where name='addcitytocityList';

delete from city where  id=5001;
select * from city where id=5001;

call addcitytocityList(5001,"Mysore","IND","Mysore",150000);
select * from city where id=5001;







