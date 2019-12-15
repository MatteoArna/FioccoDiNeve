1. [Introduzione](#introduzione)

  - [Informazioni sul progetto](#informazioni-sul-progetto)

  - [Abstract](#abstract)

  - [Scopo](#scopo)

1. [Analisi](#analisi)

  - [Analisi del dominio](#analisi-del-dominio)
  
  - [Analisi dei mezzi](#analisi-dei-mezzi)

  - [Analisi e specifica dei requisiti](#analisi-e-specifica-dei-requisiti)

  - [Use case](#use-case)

  - [Pianificazione](#pianificazione)

1. [Progettazione](#progettazione)

  - [Design dell’architettura del sistema](#design-dell’architettura-del-sistema)

  - [Design dei dati e database](#design-dei-dati-e-database)

1. [Implementazione](#implementazione)

1. [Test](#test)

  - [Protocollo di test](#protocollo-di-test)

  - [Risultati test](#risultati-test)

  - [Mancanze/limitazioni conosciute](#mancanze/limitazioni-conosciute)

1. [Consuntivo](#consuntivo)

1. [Conclusioni](#conclusioni)

  - [Sviluppi futuri](#sviluppi-futuri)

  - [Considerazioni personali](#considerazioni-personali)

1. [Sitografia](#sitografia)

1. [Allegati](#allegati)


## Introduzione

### Informazioni sul progetto

Progetto progettato e implementato interamente da Matteo Arena, allievo della SAM sezione Informatica per il modulo 306. <br>
Data di inizio progetto: 2019.09.06
Data di fine porogetto: 2019.12.20

### Abstract

  Il progetto Snow Flake Generator vuole essere un applicativo che genera dei fiocchi di neve 
  nella maniera più facile e intuitivo possibile. Oltre ciò dispone anche di una documentazione
  completa per fare in modo che gli utenti possano sfruttarla al meglio.

### Scopo

  Lo scopo è imparare a gestire al meglio un progetto. 


## Analisi

### Analisi del dominio

Il prodotto potrà essere utilizzato da qualsiasi tipo di utente, con a disposizione un computer.
Attualmente non ci sono molti generatori di fiocchi di neve e, quei pochi che ci sono si trovano
online e molto spesso per questa causa vengono dimenticati i loro nomi. Per oviare a questo problema svilupperò un programma che permetterà a chiunque, grazie alla sua semplicità, di generare il suo personale fiocco di neve e poterlo condividere facilmente.

### Analisi e specifica dei requisiti

  [Lista di requisiti](requisiti.md)

### Use case

L'utente potrà tagliare il suo triangolo e generarlo, il triangolo potrà essere sempre salvato per condividerlo o riaprirlo in futuro.

### Pianificazione

[Diagramma di gantt iniziale](FioccoIniziale.pdf)<br>
[Diagramma di gantt finale]() disponibile a fine progetto 

### Analisi dei mezzi

- Computer con Windows 10 (12.2019)
- Java 1.12
- NetBeans 8.2
- Apache Batik (libreria per java)
- Server di hosting infomaniak
- HTML, CSS e JavaScript

Il profotto potrà essere eseguito su qualsiasi macchina con un sistema operativo, infatti è stata
progettata per essere eseguita Computer con Windows, MacOs e Linux. La richiesta hardware del programma è estremamente bassa, grazie a questo può contare sul fatto di essere eseguita su praticamente qualsiasi computer. <br>
Durante lo sviluppo del programma verrà utilizzato un PC Acer Aspire 5 con hardware di gamma medio-alta, più precisamente un intel i7 di settima generazione, scheda grafica nvidia geforce 940mx e 16GB di RAM.
## Progettazione

Il software sarà sviluppato in maniera che il triangolo da tagliare sarà sempre al centro. oltre ciò saranno disponibili i seguenti bottoni:<br>

| Nome | Componente | utilizzo|
|---|-----|---|
|Add e Cut| Switch|Scelta tra aggiunta o rimozione di un punto, quando uno è abilitato l'altro si disabilita in automatico. Quando ci si trova sopra a un punto esso cambierà colore per dare la conferma all'utente che si trova al di sopra|
|Reset|Bottone| Eliminazione di tutti i punti inseriti|
|Back|Bottone|Eliminazione dell'ultimo punto inserito|
|Preview| Checkbox| Visualizzazione del triangolo tagliato, prima di generare il fiocco.
|Create snapshot|Bottone|Salvataggio dei punti del triangolo|
|Open snapshot|Bottone|Apertura dei punti salvati in precedenza con il bottone Create Snapshot|
|Generate|Bottone|Generazione del fiocco di neve, in un pannello piccolo in basso a destra oppure in un altra finestra|
|Save|Bottone|Salvataggio del fiocco generato come immagine SVG o PNG (in dimensioni aatuali, 500px x 500px o 100px x 1000px)

### Design dell’architettura del sistema

[Diagramma UML](Img/UML.png)
<img href="Img/UML.png">


### Design dei dati e database

Descrizione delle strutture di dati utilizzate dal programma in base
agli attributi e le relazioni degli oggetti in uso.

### Schema E-R, schema logico e descrizione.

Se il diagramma E-R viene modificato, sulla doc dovrà apparire l’ultima
versione, mentre le vecchie saranno sui diari.

### Design delle interfacce

Descrizione delle interfacce interne ed esterne del sistema e
dell’interfaccia utente. La progettazione delle interfacce è basata
sulle informazioni ricavate durante la fase di analisi e realizzata
tramite mockups.

### Design procedurale

Descrive i concetti dettagliati dell’architettura/sviluppo utilizzando
ad esempio:

-   Diagrammi di flusso e Nassi.

-   Tabelle.

-   Classi e metodi.

-   Tabelle di routing

-   Diritti di accesso a condivisioni …

Questi documenti permetteranno di rappresentare i dettagli procedurali
per la realizzazione del prodotto.

## Implementazione

In questo capitolo dovrà essere mostrato come è stato realizzato il
lavoro. Questa parte può differenziarsi dalla progettazione in quanto il
risultato ottenuto non per forza può essere come era stato progettato.

Sulla base di queste informazioni il lavoro svolto dovrà essere
riproducibile.

In questa parte è richiesto l’inserimento di codice sorgente/print
screen di maschere solamente per quei passaggi particolarmente
significativi e/o critici.

Inoltre dovranno essere descritte eventuali varianti di soluzione o
scelte di prodotti con motivazione delle scelte.

Non deve apparire nessuna forma di guida d’uso di librerie o di
componenti utilizzati. Eventualmente questa va allegata.

Per eventuali dettagli si possono inserire riferimenti ai diari.

## Test

### Protocollo di test

Definire in modo accurato tutti i test che devono essere realizzati per
garantire l’adempimento delle richieste formulate nei requisiti. I test
fungono da garanzia di qualità del prodotto. Ogni test deve essere
ripetibile alle stesse condizioni.


|Test Case      | TC-001                               |
|---------------|--------------------------------------|
|**Nome**       |Import a card, but not shown with the GUI |
|**Riferimento**|REQ-012                               |
|**Descrizione**|Import a card with KIC, KID and KIK keys with no obfuscation, but not shown with the GUI |
|**Prerequisiti**|Store on local PC: Profile\_1.2.001.xml (appendix n\_n) and Cards\_1.2.001.txt (appendix n\_n) |
|**Procedura**     | - Go to “Cards manager” menu, in main page click “Import Profiles” link, Select the “1.2.001.xml” file, Import the Profile - Go to “Cards manager” menu, in main page click “Import Cards” link, Select the “1.2.001.txt” file, Delete the cards, Select the “1.2.001.txt” file, Import the cards |
|**Risultati attesi** |Keys visible in the DB (OtaCardKey) but not visible in the GUI (Card details) |


### Risultati test

Tabella riassuntiva in cui si inseriscono i test riusciti e non del
prodotto finale. Se un test non riesce e viene corretto l’errore, questo
dovrà risultare nel documento finale come riuscito (la procedura della
correzione apparirà nel diario), altrimenti dovrà essere descritto
l’errore con eventuali ipotesi di correzione.

### Mancanze/limitazioni conosciute

Descrizione con motivazione di eventuali elementi mancanti o non
completamente implementati, al di fuori dei test case. Non devono essere
riportati gli errori e i problemi riscontrati e poi risolti durante il
progetto.

## Consuntivo

Consuntivo del tempo di lavoro effettivo e considerazioni riguardo le
differenze rispetto alla pianificazione (cap 1.7) (ad esempio Gannt
consuntivo).

## Conclusioni

Quali sono le implicazioni della mia soluzione? Che impatto avrà?
Cambierà il mondo? È un successo importante? È solo un’aggiunta
marginale o è semplicemente servita per scoprire che questo percorso è
stato una perdita di tempo? I risultati ottenuti sono generali,
facilmente generalizzabili o sono specifici di un caso particolare? ecc

### Sviluppi futuri
  Migliorie o estensioni che possono essere sviluppate sul prodotto.

### Considerazioni personali
  Cosa ho imparato in questo progetto? ecc

## Bibliografia

### Bibliografia per articoli di riviste
1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo dell’articolo (tra virgolette),

3.  Titolo della rivista (in italico),

4.  Anno e numero

5.  Pagina iniziale dell’articolo,

### Bibliografia per libri


1.  Cognome e nome (o iniziali) dell’autore o degli autori, o nome
    dell’organizzazione,

2.  Titolo del libro (in italico),

3.  ev. Numero di edizione,

4.  Nome dell’editore,

5.  Anno di pubblicazione,

6.  ISBN.

### Sitografia

1.  URL del sito (se troppo lungo solo dominio, evt completo nel
    diario),

2.  Eventuale titolo della pagina (in italico),

3.  Data di consultazione (GG-MM-AAAA).

**Esempio:**

-   http://standards.ieee.org/guides/style/section7.html, *IEEE
    Standards Style Manual*, 07-06-2008.

## Allegati

Elenco degli allegati, esempio:

-   Diari di lavoro

-   Codici sorgente/documentazione macchine virtuali

-   Istruzioni di installazione del prodotto (con credenziali
    di accesso) e/o di eventuali prodotti terzi

-   Documentazione di prodotti di terzi

-   Eventuali guide utente / Manuali di utilizzo

-   Mandato e/o Qdc

-   Prodotto

-   …
