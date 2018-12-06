public class BlockTrzeci {
    /*
-Zadanie 1. Napisz procedurę zwracającą poprzedzające przedmioty dla podanego przedmiotu w argumencie.
CREATE OR REPLACE PROCEDURE poprzedzajace_przedmioty(var_przedmiot in przedmiot.przedmiot%type)
is
CURSOR c1 is
select przedmiot
from przedmiot
where idprzedmiot =(select idpoprzednik
                    from przedmiotpoprzedzajacy
                    where idprzedmiot =(SELECT  idprzedmiot
                                        from przedmiot
                                        where przedmiot = var_przedmiot));

var_poprzedni przedmiot.przedmiot%type;
begin
open c1;
loop
fetch c1 into var_poprzedni;
EXIT when c1%NOTFOUND;
dbms_output.put_line('Przedmiot: ' || var_przedmiot || ' ,poprzedni przedmiot: ' || var_poprzedni );
end loop;
close c1;
end;
/
exec poprzedzajace_przedmioty('Matematyka dyskretna');


-- Zadanie 2. Stwórz mechanizm do logowania czasu dodawania nowych osób do bazy.
create table OsobaLog(
idOsobaLog integer PRIMARY KEY,
data date,
NAZWISKO VARCHAR2(20),
IMIE VARCHAR2(20),
action VARCHAR2(20)
);
/
CREATE SEQUENCE OsobaLogSEQ;
/
CREATE OR REPLACE TRIGGER TRIGGER_OSOBA_INSERT
AFTER INSERT ON OSOBA
FOR EACH ROW
BEGIN
IF INSERTING THEN
    INSERT INTO OsobaLog VALUES (OsobaLogSEQ.nextval, sysdate, 'INSERT', :new.NAZWISKO, :NEW.IMIE);
END IF;
END;
INSERT INTO osoba VALUES (32,'CZECH', 'DAG', '94/10/15', 3, 1);


--Zadanie 3 .Zablokuj możliwość dodawania do bazy osób z miasta Poznań

create or replace TRIGGER blokowanie_poznan_osoba
BEFORE INSERT or UPDATE of idmiasto
   ON osoba
   FOR EACH ROW
declare
miastoPoznan NUMBER;
BEGIn
miastopoznan := 1;
    IF :new.idmiasto = miastopoznan THEN
        raise_application_error(-20000, 'Niezgodność miasta, próba dodania studenta z miasta Poznań');
    END IF;
END;
/
INSERT INTO osoba VALUES (35,'Trala', 'Paula', '94/10/15', 3, 1);

--Zadanie 4. Widokiem zmaterializowanym pokaż nazwiska studentów i grupy do których uczęszczają.
CREATE MATERIALIZED VIEW pokaz_nazwiska_grupy
as
select o.nazwisko, g.idgrupa
from osoba o
join studentgrupa g
on
o.idosoba = g.idosoba
order BY idgrupa;

exec DBMS_SNAPSHOT.REFRESH('pokaz_nazwiska_grupy')



--Zadanie 6. Potrafisz stworzyć procedurę, która pokaże studentów z podanego w argumencie miasta?
-- 1 SPOSÓB
Create or REPLACE PROCEDURE miasto_student1 (var_miasto in miasto.idmiasto%type)
is
CURSOR c1 is
select NRINDEKSU
from student
where idosoba in (select idosoba
                from osoba
                where idmiasto =(SELECT idmiasto
                                FROM MIASTO
                                WHERE MIASTO = var_miasto));
var_indeks student.nrindeksu%type;
begin
open c1;
loop
	fetch c1 into var_indeks;
	EXIT when c1%NOTFOUND;
	dbms_output.put_line('Numer indeksu ' || var_indeks || ' studenta z miasta ' || var_miasto );
end loop;
close c1;
end;
exec MIASTO_STUDENT1('WARSZAWA');
/

-- 2 SPOSÓB
Create or REPLACE PROCEDURE miasto_student2 (var_miasto in miasto.idmiasto%type)
is
CURSOR c1 is
select S.NRINDEKSU
from student s
JOIN osoba o
    on o.idosoba = s.idosoba
JOIN miasto m
    on m.idmiasto = o.idmiasto
where m.miasto = var_miasto;
var_indeks student.nrindeksu%type;
begin
open c1;
loop
	fetch c1 into var_indeks;
	EXIT when c1%NOTFOUND;
	dbms_output.put_line('Numer indeksu ' || var_indeks || ' studenta z miasta ' || var_miasto );
end loop;
close c1;
end;
exec miasto_student2('WARSZAWA');


--Zadanie 7 .Napisz mechanizm uniemożliwiający dodanie innej oceny niż te z zakresu 2-5.

create or replace TRIGGER trigger_ocena_pomiedzy
before INSERT or UPDATE  of ocena
ON ocena
FOR EACH ROW

declare
var_min number := 2;
var_max number := 5;


BEGIN
if (:new.ocena not BETWEEN var_min and var_max) THEN
   raise_application_error(-20000, 'podana ocena jest poza zakresem 2-5');
end if;
end;
/


--Zadanie 8. Napisz funkcję pokazującą ilość studentów z podanego rocznika.
create or replace FUNCTION ilosc_studentow (var_rocznik in NUMBER)
return int is
wynik int;
begin
    SELECT COUNT(NRINDEKSU) INTO WYNIK
	FROM STUDENT
	WHERE EXTRACT( YEAR FROM DATAREKRUTACJI) = var_rocznik;
RETURN WYNIK;
END;
SELECT ilosc_studentow(2011) FROM DUAL;





     */
}
