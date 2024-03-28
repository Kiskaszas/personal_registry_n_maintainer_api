# Getting Started
Personal Registry & Maintainer API Dokumentáció
Bevezetés
A Personal Registry & Maintainer API egy olyan alkalmazásprogramozási felület (API), amely lehetővé teszi személyek adatainak nyilvántartását és kezelését. Az alkalmazás lehetővé teszi új személyek hozzáadását, meglévők módosítását, törlését, valamint azokhoz kapcsolódó címek és elérhetőségek kezelését.

Technológia
Az alkalmazás a következő technológiai összetevőket használja:

Programozási nyelv: Java
Keretrendszer: Spring Boot
Adatbázis-kezelő rendszer: MySQL
Objektum-relációs leképzés: Hibernate
Build eszköz: Maven
Felhasználói szerepkörök
Az alkalmazásnak két fő felhasználói szerepköre van:

Adminisztrátor: Az adminisztrátor jogosultságokkal rendelkező felhasználó. Feladata az alkalmazás teljes körű kezelése, új felhasználók hozzáadása, módosítása, törlése.
Felhasználó: Az alkalmazás által kezelt személyek közötti navigáció, adatok lekérdezése és módosítása.
Funkciók
Az alkalmazás az alábbi funkciókat kínálja:

Személyek kezelése:

Új személy hozzáadása: Felhasználói adatok (pl. név, születési dátum) rögzítése az adatbázisban.
Személy adatainak módosítása: Meglévő személy adatainak frissítése vagy módosítása.
Személy törlése: Személy és az összes kapcsolódó adat (cím, elérhetőség) törlése az adatbázisból.
Személyek listázása: Az összes személy adatainak lekérdezése és listázása.
Címek kezelése:

Cím hozzáadása: Személyhez tartozó új cím rögzítése az adatbázisban.
Cím módosítása: Meglévő cím adatainak frissítése vagy módosítása.
Cím törlése: Adott cím törlése az adatbázisból.
Elérhetőségek kezelése:

Elérhetőség hozzáadása: Személyhez tartozó új elérhetőség rögzítése az adatbázisban.
Elérhetőség módosítása: Meglévő elérhetőség adatainak frissítése vagy módosítása.
Elérhetőség törlése: Adott elérhetőség törlése az adatbázisból.
Végpontok
Az alkalmazás különböző végpontokat biztosít a kliensek számára az adatok manipulálásához. Például:

GET /api/persons: Az összes személy lekérdezése.
POST /api/persons: Új személy hozzáadása.
PUT /api/persons/{id}: Személy adatainak frissítése.
DELETE /api/persons/{id}: Személy törlése.
Biztonság
Az alkalmazás biztonsági szempontból védi az adatokhoz való hozzáférést. Például:

Felhasználói hitelesítés és azonosítás.
Jogosultságkezelés a végpontokhoz való hozzáférés szabályozásához.
Adatbázis tranzakciók kezelése az adatintegritás biztosításához.
Tesztelés
Az alkalmazás teljes funkcionalitását különféle tesztekkel ellenőrizzük, ideértve az egységteszteket, integrációs teszteket és végpontteszteket is.

Telepítés és konfiguráció
Az alkalmazás telepítése és konfigurálása részletesen le van írva a telepítési dokumentációban.

Hibakezelés
Az alkalmazás hibái és kivételei kezelésre kerülnek, és azokkal kapcsolatos információkat naplózzuk a hibakeresés és a fejlesztés támogatása érdekében.

Továbbfejlesztési lehetőségek
Az alkalmazás továbbfejlesztésének lehetséges irányai közé tartoznak:

További funkciók hozzáadása, például keresési és szűrési lehetőségek.
Grafikus felhasználói felület (GUI) készítése az alkalmazáshoz.
Teljesítményoptimalizálás és skálázhatóság növelése nagyobb terhelés esetén.
Kapcsolat
Az alkalmazás fejlesztői elérhetőségei:

Email: example@example.com
Telefon: +1234567890
Weboldal: www.example.com