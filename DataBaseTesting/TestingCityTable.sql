
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


delimiter #
create procedure citydetails()
begin
select * from city;
end#



call citydetails;



delimiter #
create procedure citycountsbycountry(
in countryname char(3),
out citycount int,
out countrycount int)
begin
select count(*) into citycount from city where countrycode=countryname;
select count(*) into countrycount from country;
end#



CALL cityCountsByCountry('IND',@cityCount,@countryCount);
Select @cityCount, @countryCount;
Select count(*) from city where countryCode = 'IND'
Select count(*) from country




delimiter #
create procedure cityByCountry(
in countryname char(3)
)
begin
select * from city where countrycode=countryname;
end#

call cityByCountry('AFG');

select * from city where countryCode='AFG';




select * from city;

create trigger insertcity Before insert on employee
     for each row set new.city="Hyd"

insert into employee values(20,'Hemanth',22,1,"Bng");

select * from employee where id=20;




