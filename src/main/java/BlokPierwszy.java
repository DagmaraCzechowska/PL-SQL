public class BlokPierwszy {
    /*
    -- Zadanie 1. Pokaż wszystkich pracowników z ich miejscami pracy
    create or REPLACE PROCEDURE zad_pierwsze
            is
    CURSOR c1 is
    select  p.nazwisko, z.adres
    from pracownicy p
    join zespoly z
    on p.id_zesp = z.id_zesp;
    var_nazwisko pracownicy.nazwisko%TYPE;
    var_adres zespoly.adres%TYPE;
    BEGIN
    OPEN c1;
    LOOP
    FETCH c1 INTO var_nazwisko, var_adres;
    EXIT WHEN c1%NOTFOUND;
	dbms_output.put_line(var_nazwisko ||', '|| var_adres);
    end LOOP;
    CLOSE c1;
    END;

-- Zadanie 2. Policz ile zarabiają pracownicy pracujący na Piotrowie w przeciągu kwartału
    CREATE OR REPLACE PROCEDURE zad_drugie
            is
    CURSOR c1 is
    select p.nazwisko, (p.placa_pod + nvl(p.placa_dod, 0)) * 3 as "placa_kwartal"
    from pracownicy p
    join zespoly z
            on
    p.id_zesp = z.id_zesp
    where z.adres = 'PIOTROWO 3A';

    var_nazwisko pracownicy.nazwisko%type;
    var_placa_kwartal pracownicy.placa_pod%type;

    BEGIN
    open c1;
    loop
    fetch c1 into var_nazwisko, var_placa_kwartal;
    EXIT when c1%NOTFOUND;
	dbms_output.put_line(var_nazwisko || ' - ' || var_placa_kwartal);
    end loop;
    close c1;
    END;

--Zadanie 3. Pokaż wszystkich podwładnych dla nazwiska podanego w argumencie procedury.
    CREATE OR REPLACE PROCEDURE zad_trzecie(var_szuk_nazwisko in pracownicy.nazwisko%TYPE)
    IS
    CURSOR c1 is
    select nazwisko
    from pracownicy
    where id_szefa = ( select id_prac
    FROM pracownicy
    where nazwisko = var_szuk_nazwisko );
    var_nazwisko pracownicy.nazwisko%type;

    BEGIN
    OPEN c1;
    LOOP
    FETCH c1 into var_nazwisko;
    EXIT WHEN c1%NOTFOUND;
	dbms_output.put_line(var_nazwisko);
    end loop;
    CLOSE c1;
    END;

--Zadanie 4. Pokaż ile miesięcy musi pracować podany jako argument pracownik, by odłożyć
10 000, zakładając, że może co miesiąc odkładać 20% swojej całkowitej pensji

    CREATE OR REPLACE PROCEDURE zad_czwarte(var_szuk_nazwisko in pracownicy.nazwisko%TYPE)
    is
    CURSOR c1 is

    SELECT ROUND(10000/((placa_pod + nvl(placa_dod, 0)) * 0.2)) AS "liczba_miesiecy"
    from pracownicy
    where nazwisko = var_szuk_nazwisko;
    var_liczba_mies NUMBER;

    BEGIN
    OPEN c1;
    LOOP
    FETCH c1 into var_liczba_mies;
    exit when c1%NOTFOUND;
	dbms_output.put_line(var_liczba_mies);
    end loop;
    CLOSE c1;
    end;

--Zadanie 5. Przygotuj opis w poniższym schemacie(gdzie X,Y,Z,ZZ to dane z tabel),
    uwzględniając etat podany w argumencie oraz fakt, że nie zarabia podstawy więcej niż
    podamy w kolejnym argumencie procedury
    a. Pracownik X zarabia Y i pracuje w Z od dnia ZZ

    CREATE OR REPLACE PROCEDURE zad_piate(var_szuk_etat in pracownicy.etat%type, var_szuk_placapod in pracownicy.placa_pod%type )
    is
    CURSOR c1 is
    select p.nazwisko,p.placa_pod, z.adres, p.zatrudniony
    from pracownicy p
    join zespoly z
    on p.id_zesp=z.id_zesp
    where p.etat = var_szuk_etat AND p.placa_pod < var_szuk_placapod ;

    var_placapod pracownicy.placa_pod%type;
    var_nazwisko pracownicy.nazwisko%type;
    var_adres zespoly.adres%type;
    var_zatrudniony pracownicy.zatrudniony%type;
    BEGIN
    Open c1;
    Loop
    FETCH c1 into var_nazwisko,var_placapod,var_adres,var_zatrudniony ;
    exit when c1%NOTFOUND;
	dbms_output.put_line(var_nazwisko|| ' - ' ||var_placapod || ' - ' ||var_adres  || ' - ' ||var_zatrudniony);
    end loop;
    close c1;
    end;

--Zadanie 6. Pokaż używając pętli w jaki sposób będą się przedstawiały oszczędności pracowników
    na etacie podanym w argumencie, w czasie podanym w argumencie, wiedząc, że
    pracownik może odłożyć 10% swojej pensji.
    Czyli wywołujemy procedurę Oblicz(‘adiunkt’, 10) to w efekcie otrzymamy wynik
    a. Pracownik X w miesiącu Y odłożył Z i w sumie ma oszczędności ZZ

    CREATE OR REPLACE PROCEDURE zad_szoste(var_szuk_etat in pracownicy.etat%type, var_LICZBA_MIES in NUMBER )
    IS
    CURSOR c1 IS
    SELECT NAZWISKO, ((PLACA_POD + NVL(PLACA_DOD,0)) *0.1)
    from pracownicy
    where etat= var_szuk_etat;

    var_nazwisko pracownicy.nazwisko%type;
    var_sum number;

    BEGIN
    OPEN c1;
    loop
    fetch c1 into var_nazwisko, var_sum;
    exit when c1%NOTFOUND;
	dbms_output.put_line('Pracownik '||var_nazwisko||' w miesiacu ' ||var_LICZBA_MIES || ' oszczędzil ' || var_sum ||' i w sumie ma oszczednosci '
            ||var_sum * var_LICZBA_MIES );
    end loop;
    close c1;
    END;
   */

}

