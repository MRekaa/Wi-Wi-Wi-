# Wi-Wi-Wi-
ProgTech - EY52H0, YC2F1U

# Rendszerterv
## 1. A rendszer célja
Az alkalmazás célja egy kerttervezó illetve karbantartó szimuláció, amelyben a felhasználók különböző növényeket telepíthetnek le a virtuális kertjükbe és vizygálhatják meg azoknak igényeit. A fő cél az, hogy az alkalmazás vonzó alternatívát nyújtson a kerttervezzők számára, segítve őket abban, hogy terveket tudjanak készíteni egyes munkáikhoz. 

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
Az alkalmazás indulását követően a felhasználónak meg kell adnia a tervezendő kert méretét méterben.
TODO

### 3.2 Üzleti folyamatok
TODO

## 4. Követelmények

### Funkcionális követelmények

| ID | Megnevezés                   | Leírás     |
|----|------------------------------|--------------------------------------------------------------------------------------|
| K1 | Kert méret magadás ablak     | A felhasználónak a tervezés előtt meg kell adnia a terület méretét.              |
| K2 | Tervezés                     | A felhasználó itt tudja megtervezni a kertet.                                    |
| K3 | Áttekintés                   | A fehasználó itt tudja a kész tervet megnézni, a növények igéneit átellenőrizni. |

### Nemfunkcionális követelmények
 ID | Megnevezés                             | Leírás                                                                                                              |
|----|----------------------------------------|---------------------------------------------------------------------------------------------------------------------|
| K4 | Átlátható, könnyen kezelhető felület   | A felületek felhasználó barátak, átláthatóak legyenek, intuitívak, illetve ne legyenek zsúfoltak.                 |
| K5 | Tervezési minták használata            | Az alkalmazás forráskódja tartalmazzon 3 tervezési mintát. Mi esetünkben ez a Prototype, a Visitor és a Decorator lesz. |

### Támogatott eszközök
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

### Vásárolt szoftverkomponensek, valamint esetleges külső rendszerek
Nincsenek.

### Hardver topológia
Olyan számítógép, amely Windows 10 vagy 11 operációs rendszerrel rendelkezik.

### Fizikai alrendszerek
Kliens gépek: A követelményeknek megfelelő, Windows 10 vagy 11 operációs rendszerrel rendelkező PC-k.
Szerver (Host) gép: Az adatbázis rendszer és a háttérfolyamatokat ellátó szolgáltatáshoz szükséges összetevők itt találhatóak. A kliens gép ezzel kommunikál.

### Fejlesztő eszközök
 - IntelliJ IDEA
 - XAMPP (MySQL)

## 8. Architekturális terv

### Adatbázis rendszer
- MySQL alapú adatbázis rendszer.

### A program elérése, kezelése
TODO

## 9. Adatbázis terv

## 10. Implementációs terv
A projektet két részből áll: frontend, backend. A frontend Java Swing segítségével készül, míg a backend Java keretrendszerben.
A program kódjában használt nyelv az angol.
A szerver és az adatbázist összekötő csomag felelős az adatbázis kezeléséért.
Mind a frontend, mind a backend fejlesztéséhez szükség van a IntelliJ környezet telepítésére és konfigurálására a szükséges eszközökkel és kiegészítőkkel
együtt.

## 11. Tesztterv
A tesztelések célja a rendszer és komponensei funkcionalitásának teljes vizsgálata,
ellenőrzése a rendszer által megvalósított üzleti szolgáltatások verifikálása.
A teszteléseket a fejlesztői csapat minden tagja elvégzi.
Egy teszt eredményeit a tagok dokumentálják külön unit teszt függvényekbe és metódusokba tárolja.

A tesztelés során a szoftver megfelelő működését vizsgáljuk. Amennyiben az elvártnak megfelelő eredményt kapunk, a teszt eset sikeresnek tekinthető, ellenkező esetben a hibát megpróbáljuk elhárítani, ha a teszt nem direkt nem sikerül.

### Tesztesetek
TODO

#### Tesztelés módja: Unit Teszt
 | Teszteset        | Elvárt eredmény                                                                                            | 
 |------------------|------------------------------------------------------------------------------------------------------------| 
 | Kertméret megadás| A felhasználó által megadott méretű lesz a kert.   	                                                 |
 | Növény elhelyezés| A felhasználó elhelyez egy adott növényt a kertbe.   		                                         |
 | Tét törlése	    | Ha a felhasználó a kuka szimbólumra húzz egy növényt, az törlődik.					 |
 | Mentés	    | A felhasználó a mentés gombbal el tudja menteni a megtervezett, kész kertjét.	                         |


## 12. Telepítési terv
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

## 13. Karbantartási terv
### 13.1 Hibajavítás
Figyelembe kell venni a felhasználók visszajelzéseit is.
Ha hibát talált, mielőbb orvosolni kell, lehet az:
*	Működéssel kapcsolatos
*	Kinézet, dizájnnal kapcsolatos
 ### 13.2Funkcionális bővítés 
 A felhasználói igényeknek megfelelően bővíteni kell a funkciókat/ adatbázist, akár co-op verziót kell hozzáadni.
