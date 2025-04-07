# Rendszerterv
## 1. A rendszer célja
Az alkalmazás célja egy kerttervezó illetve karbantartó szimuláció, amelyben a felhasználók különböző növényeket telepíthetnek le a virtuális kertjükbe és vizSgálhatják meg azoknak igényeit. A fő cél az, hogy az alkalmazás vonzó alternatívát nyújtson a kerttervezzők számára, segítve őket abban, hogy terveket tudjanak készíteni egyes munkáikhoz. 

## 2. Projektterv

### 2.1 Projektszerepkörök, felelőségek:
  * Üzleti szereplő:
	  -   Megrendelő:
		  -  Virág Kertépítészet
     
### 2.2 Projektmunkások és felelőségek:
   * Frontend és backend:
     - Farkas Lajos
     - Mészáros Réka
   * Tesztelés:
     - Farkas Lajos
     - Mészáros Réka
     
### 2.3 Ütemterv:

|Funkció                  | Feladat                                | Prioritás | Becslés (nap) | Aktuális becslés (nap) | Eltelt idő (nap) | Becsült idő (nap)   |
|-------------------------|----------------------------------------|-----------|---------------|------------------------|------------------|---------------------|
|Rendszerterv             |Megírás                                 |         1 |             1 |                      1 |                0 |                   1 |
|Program                  |Prototípus elkészítése                  |         2 |             7 |                      7 |                0 |                   7 |
|Program                  |Tesztelés                               |         3 |             4 |                      4 |                0 |                   4 |

### 2.4 Mérföldkövek:
   *   04.10. Projekt elkezdése
   *   04.17. Alap prototípus elkészítése
   *   04.24. Végleges prototípus elkészítése
   *   04.28. Tesztelés
   *   ? Bemutatás és átadás

## 3. Üzleti folyamatok modellje
Az alkalmazás regisztráció vagy bejelentkezés nélkül használható. Minden felhasználó ugyanolyan jogkörrel rendelkezik.

### 3.1 Üzleti szereplők
Az alkalmazás elsődleges szereplői a következők:
-Felhasználó:
A felhasználó az alkalmazás egyetlen aktív szereplője, aki:
  - Megadja a tervezendő kert méretét.
  - Növényeket helyez el a kert különböző pontjaira.
  - Módosíthatja, áthelyezheti, vagy törölheti a növényeket.
  - Ellenőrizheti a növények igényeit.
  - Elmentheti a kész tervet.
  - Később újra betöltheti a mentett terveket.



### 3.2 Üzleti folyamatok
Az alkalmazás indulását követően a felhasználónak meg kell adnia a kert méretét a funkciók eléréséhez.
- Általános folyamatok:
  - Kertméret megadása a tervezés megkezdéséhez.
  - Mentett kertterv betöltése.
  - A terv mentése fájlba vagy adatbázisba.
  - A programból való kilépés.

- Tervezési folyamatok:
  - Növény kiválasztása és elhelyezése a kert megfelelő pontjára.
  - Növény elmozgatása a kerten belül.
  - Növény módosítása (pl. fajtaváltás, paraméterek).
  - Növény eltávolítása.

- Áttekintési folyamatok:
  - A kert teljes tervének megtekintése.
  - A növények egyedi igényeinek (fény-, víz-, talajigény) ellenőrzése.
  - A terv értékelése, esetleges módosítás visszalépéssel.




## 4. Követelmények

### 4.1 Funkcionális követelmények

| ID | Megnevezés                   | Leírás     |
|----|------------------------------|--------------------------------------------------------------------------------------|
| K1 | Kert méret magadás ablak     | A felhasználónak a tervezés előtt meg kell adnia a terület méretét.              |
| K2 | Tervezés                     | A felhasználó itt tudja megtervezni a kertet.                                    |
| K3 | Áttekintés                   | A fehasználó itt tudja a kész tervet megnézni, a növények igéneit átellenőrizni. |

### 4.2 Nemfunkcionális követelmények
 ID | Megnevezés                             | Leírás                                                                                                              |
|----|----------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| K4 | Átlátható, könnyen kezelhető felület   | A felületek felhasználó barátak, átláthatóak legyenek, intuitívak, illetve ne legyenek zsúfoltak.                 |
| K5 | Tervezési minták használata            | Az alkalmazás forráskódja tartalmazzon 3 tervezési mintát. Mi esetünkben ez a Prototype, a Visitor és a Decorator lesz. |

### 4.3 Támogatott eszközök
* Bármely Java alkalmazás futtatásra képes eszköz. Például számítógép, laptop, tablet. Főként Windows alapú rendszer.

## 5. Funkcionális terv

### 5.1 Rendszerszereplők
- Felhasználó
   - Kert méretet ad meg
   - Növényeket helyez el/töröl/módosít/mozgat
   - Menti a kész kertet
     
### 5.2 Menühierarchiák
- Kezdőlap (Új kert, Betöltés, Névjegy, Kilépés)
- Főoldal (Növény elhelyezése, Növény mozgatása, Növény törlése, Névjegy)
- Áttekintés (Mentés, Vissza lépés,Névjegy, Kilépés)

## 6. Fizikai környezet

### 6.1 Vásárolt szoftverkomponensek, valamint esetleges külső rendszerek
Nincsenek.

### 6.2 Hardver topológia
Olyan számítógép, amely Windows 10 vagy 11 operációs rendszerrel rendelkezik.

### 6.3 Fizikai alrendszerek
Kliens gépek: A követelményeknek megfelelő, Windows 10 vagy 11 operációs rendszerrel rendelkező PC-k.
Szerver (Host) gép: Az adatbázis rendszer és a háttérfolyamatokat ellátó szolgáltatáshoz szükséges összetevők itt találhatóak. A kliens gép ezzel kommunikál.

### 6.4 Fejlesztő eszközök
 - IntelliJ IDEA
 - XAMPP (MySQL)

## 7. Architekturális terv

### 7.1 Adatbázis rendszer
- MySQL alapú adatbázis rendszer.

### 7.2 A program elérése, kezelése
Az alkalmazás futtatható lokálisan egy Java-t támogató környezetben. A felhasználók az alábbi módon érhetik el és kezelhetik a programot:
- Elérés:
  - Az alkalmazás telepítése után a felhasználó egyszerűen elindíthatja a fő futtatható fájl (JAR) segítségével.
  - Nincs szükség internetkapcsolatra a működéshez, mivel a rendszer helyben fut.

-Kezelés:
  - A grafikus kezelőfelület (Java Swing) segítségével történik az interakció.
  - A menürendszer átlátható, a felhasználó egyszerűen navigálhat a különböző funkciók között (új kert, betöltés, tervezés, mentés, kilépés).
  - A háttérben futó backend komponens (Java backend + MySQL) végzi a mentést, betöltést és egyéb adatkezelési műveleteket.
  - A felhasználó által végrehajtott műveletek automatikusan mentésre kerülhetnek, illetve manuálisan is kezdeményezhetők.

## 8. Adatbázis terv
![AdatBTerv](github.com/MRekaa/Wi-Wi-Wi-/blob/main/Images/AdatBTerv.png)
## 9. Implementációs terv
A projektet két részből áll: frontend, backend. A frontend Java Swing segítségével készül, míg a backend Java keretrendszerben.
A program kódjában használt nyelv az angol.
A szerver és az adatbázist összekötő csomag felelős az adatbázis kezeléséért.
Mind a frontend, mind a backend fejlesztéséhez szükség van a IntelliJ környezet telepítésére és konfigurálására a szükséges eszközökkel és kiegészítőkkel
együtt.

## 10. Tesztterv
A tesztelések célja a rendszer és komponensei funkcionalitásának teljes vizsgálata,
ellenőrzése a rendszer által megvalósított üzleti szolgáltatások verifikálása.
A teszteléseket a fejlesztői csapat minden tagja elvégzi.
Egy teszt eredményeit a tagok dokumentálják külön unit teszt függvényekbe és metódusokba tárolja.

A tesztelés során a szoftver megfelelő működését vizsgáljuk. Amennyiben az elvártnak megfelelő eredményt kapunk, a teszt eset sikeresnek tekinthető, ellenkező esetben a hibát megpróbáljuk elhárítani, ha a teszt nem direkt nem sikerül.

### Tesztesetek

#### 10.1 Tesztelés módja: Unit Teszt
 | Teszteset        | Elvárt eredmény                                                                                            | 
 |------------------|------------------------------------------------------------------------------------------------------------| 
 | Kertméret megadás| A felhasználó által megadott méretű lesz a kert.   	                                                 |
 | Növény elhelyezés| A felhasználó elhelyez egy adott növényt a kertbe.   		                                         |
 | Tét törlése	    | Ha a felhasználó a kuka szimbólumra húzz egy növényt, az törlődik.					 |
 | Mentés	    | A felhasználó a mentés gombbal el tudja menteni a megtervezett, kész kertjét.	                         |


## 11. Telepítési terv
**Fizikai telepítési terv**:
 - A felhasználónak szüksége van egy működő számítógépre, amely rendelkezik internet hozzáféréssel.
 - A szoftverünk működéséhez szükség van egy szerverre. A szervernek kapcsolódni kell egy hálózathoz, hogy elérhető legyen.

**Szoftver telepítési terv**:
 - A felhasználónak szüksége van egy Windows 10 vagy 11 operációs rendszerre, amely támogatja a Java alkalmazásokat.
 - A szoftverünk futtatható Windows szerveren.
 - Szükség van adatbázis szerverre, MySQL:
   - Szükséges telepíteni az XAMPP nevű szoftvert.
   - Az adatbázis konfigurálása az XAMPP segítségével történik.
 - A backend és frontend konfigurálásához szükség van az  IntelliJ fejlesztői környezetre.
   -  Szükséges csomagok a Java.
 - A fejlesztők számára az alkalmazás szabadon konfigurálható, fejleszthető.
 - Abban az esetben, ha a szükséges beállítások megtörténtek, a felhasználók számára az alkalmazás futtatható

## 12. Karbantartási terv
### 12.1 Hibajavítás
Figyelembe kell venni a felhasználók visszajelzéseit is.
Ha hibát talált, mielőbb orvosolni kell, lehet az:
*	Működéssel kapcsolatos
*	Kinézet, dizájnnal kapcsolatos
 ### 12.2Funkcionális bővítés 
 A felhasználói igényeknek megfelelően bővíteni kell a funkciókat/ adatbázist, akár co-op verziót kell hozzáadni.
