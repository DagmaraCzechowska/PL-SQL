public class BlockDrugi {
    /*
            --Zadanie 1. Utwórz tabelę Magazyn (id, nazwaProduktu, cenaZakupu)
    create table Magazyn (id integer PRIMARY KEY, nazwaProduktu VARCHAR2(20CHAR),cenaZakupu INTEGER);
/

        --Zad 2. Utwórz sekwencję na kolumnie id
    create SEQUENCE MagazynIdSEQ;
/
        --zad3. Utwórz procedurę, która umożliwi dodanie danych do magazynu(nazwa i cena w
            argumencie)
    create or REPLACE PROCEDURE dodawanieMagazyn(var_nazwa in magazyn.nazwaproduktu%type, var_cena in magazyn.cenazakupu%type)
    is
            BEGIN
    insert into Produkty values (MAGAZYNIDSEQ.nextval, var_nazwa, var_cena);
    end;
/
        -- Zadanie 4. Przygotuj tabelę logów, która będzie odkładała informację o każdym insercie i update z tabeli
    Magazyn wraz z datą.
    create table MagazynLog(idMagazynLog integer PRIMARY KEY, data date, action VARCHAR2(20));
/
    create SEQUENCE MagazynLogSEQ;
/
    create or replace TRIGGER trigger_mag_Update_insert
    AFTER UPDATE OR INSERT ON Magazyn
    FOR EACH ROW
            BEGIN
    IF INSERTING THEN
    insert into magazynlog values (MAGAZYNLOGSEQ.nextval, sysdate, 'INSERT', :new.NAZWAPRODUKTU);
    END IF;
    IF UPDATING THEN
    insert into magazynlog values (MAGAZYNLOGSEQ.nextval, sysdate, 'UPDATE', :new.NAZWAPRODUKTU);
    END IF;
    END;
/
        --Zadanie 5. Przygotuj inną tabelę logów, która będzie przechowywać wszystkie usuwane rekordy z tabeli
    create table MagazynLog2(idMagazynLog2 integer PRIMARY KEY, data date, action VARCHAR2(20));
/
    create SEQUENCE MagazynLog2SEQ;
/
    create or replace TRIGGER trigger_mag_delet
    AFTER DELETE ON magazyn
    FOR EACH ROW
            BEGIN
    IF DELETING THEN
    insert into magazynlog2 values (MAGAZYNLOG2SEQ.nextval, sysdate, 'DELETE', :old.NAZWAPRODUKTU);
    END IF;
    END;
/
        --Zadanie 6. Napisz funkcję zwracającą liczbę produktów, które zostały usunięte
    create or REPLACE FUNCTION stanUsunietych
    RETURN INT IS
    wynik int;
    BEGIN
    SELECT COUNT(ACTION) INTO wynik FROM MAGAZYNLOG2;
    RETURN wynik;
    EXCEPTION
    WHEN OTHERS THEN
    RETURN NULL;
    END;
/
*/
}

