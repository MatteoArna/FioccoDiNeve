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
[Diagramma di gantt finale](FioccoFinale.pdf) 

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

[Diagramma UML del progetto](../Img/UML.svg)


### Design dei dati e database

Per poter facilitare il più possibile la realizzazione del programma è stata sviluppata una classe chiamata [TriangleModel](../Other/TriangleModel.java) che permette di gestire dei punti su un triangolo. Oltre a fare questo la classe si occupa da sola di ridimensionare i punti in base alla grandezza della fienstra.

### Design delle interfacce

[Home Page](../Img/HomePage.jpg)<br>
[Save Page](../Img/MenuSalvataggio.jpg)<br>
[Main Page](../Img/SchedaPrincipale.jpg)<br>
[Web Site](../Img/SitoWeb.jpg)

Le interfaccie WEB sono state praticamente tutte modificate alla fine del progetto, per i seguenti motivi:<br>
- <b>Home Page</b>: La Home Page è scomparsa completamente siccome sarebbe risultata estremamente vuota, per oviare a questa mancanza i comandi che erano al suo interno (aprire un triangolo e la guida) sono stati inglobati nella pagina principale.
- <b>Save Page</b>: La pagina di salvataggio è cambiata abbastanza, infatti il triangolo è diventato grande il 50% della finestra e posizionato sulla sinistra, invece la scelta della directory è stata sostituita con quella di default di windows (in modo che sia più familiare per gli utenti e più facile da gestire).
- <b>Main Page</b>: La pagina principale è quella che è rimasta più fedele all'originale, a parte qualche bottone in più e la suddivisione delle opzioni tra sinistra, dove si trovando i comandi legati ai punti, e a destra, gli altri comandi. Oltre ciò il fiocco di neve non viene più generato in basso a destra perché risultava estremamente piccolo, ma invece su un'altra finestra.
- <b>Sito Web</b>: Il sito web è cambiato completamente, al posto di seguire il mio personale stile ho preferito prendere un template e modificarlo in modo da renderlo perfetto per me.

### Design procedurale
[Documentazione codice del progetto](http://samtinfo.ch/i17aremat/SnowFlake/Doc/)
## Implementazione

### Descrizione delle classi
 - <b>TriangleModel: </b> Questa classe è stata sviluppata per fare in modo che un triangolo tagliato può sempre essere ridisegnato in un altro pannello con dimensioni diverse e comunque mantenere sempre le stesse proporzioni (con anche i punti disegnati sopra). Per fare in modo che questo avvenga la classe richiederà sempre la dimensione del pannello corrente quando si interagisce con essa in modo da poter trasformare i punti aggiunti/rimossi nelle dimensioni del modello. Questa classe verrà poi richiamata da praticamente tute le altre all'interno del progetto, in questa maniera le varie classi possono condividersi il triangolo senza passarsi troppi argomenti ma semplicemente un oggetto TriangleModel.
 - <b>Preview</b>: Pannello che si occupa dio mostrare due tipi di preview durante il salvataggio, più specificatamente:
 1) <i>Salvataggio dei punti</i> quando verranno salvati i punti nel frame principale verrà affiancato un pannello contenente la preview del triangolo con i tagli.
 2) <i>Salvataggio del fiocco</i> quiando si salva l'immagine del fiocco di neve la preview cambierà e diventerà al posto del triangolo quella del fiocco di neve. Lo spazio occupato per entrambi sarà sempre lo stesso.
 - <b>TrianlgePanel</b>: Interagiscew con la classe TriangleModel, i listener per il mouse sono situati in questa classe, che poi passa i punti al TriangleModel e in caso di esportazione lo passa lui. In questa maniera la classe TriangleModel rimane estremamente pulita e facilmente riutilizzabile in altre classi completamente diverse.
 - <b>SaveFrame</b>: Frame di salvataggio, sia dei punti che del fiocco di neve (lo capisce grazie ad un valore booleano). In entrambi i casi però ci sarà diviso in due parti, a sinistra la preview di quello che si vuole salvare e a destra la scelta della directory e del nome del file.
 - <b>SnowFrame</b>: Frame contenente il fiocco di neve generato, la generazione avverrà tramite un metodo setter che si occuperà di prendere il triangleModel e poi lo ruoterà in modo da generarlo in maniera perfetta. Adottando questa maniera di generare il fiocco il programma si può permettere di generare il fiocco in live, ovvero mentre tagliamo il triangolo in automatico il fiocco viene rigenerato (grazie ad una interfaccia del TrianglePanel).
 - <b>TutorialFrame</b>: Frame che si occupa di dare una mini guida all'interno del programma all'utente, più specificatamente di ogni bottone che si visualizza a schermo e di ogni funzione. Questa guida è un poco meno completa di quella che si può trovare sul [sito ufficiale](http://www.samtinfo.ch/i17aremat/SnowFlake/).
 - <b>TriangleEditFrame</b>: Frame principale del programma, quello che parte quando si avvia. Ovviamente è anche quello che interagisce con tutte le altre classi a parte TriangleModel perché  con quello ci interagiscono tutte le altri classi.

## Test

### Protocollo di test

|Test Case      | TC-001                              |
|---------------|--------------------------------------|
|**Nome**       |Scaricare programma |
|**Riferimento**|REQ-001                               |
|**Descrizione**|Scaricare il programma dal sito ufficiale|
|**Prerequisiti**|Avere un sito web dal quale poterlo scaricare|
|**Procedura**     |Andare sul sito web, cliccare il tasto downlaod e vedere se funziona tutto|
|**Risultati attesi** |Il programma dovrebbe scaricarsi funzionare perfettamente|
|**Risultati**|Il programma non si scarica, da un errore riguardante i permessi |
|**Come è stato risolto**| RISOLVERE |

|Test Case      | TC-002                              |
|---------------|--------------------------------------|
|**Nome**       |Dimensione finestra|
|**Riferimento**|REQ-004                               |
|**Descrizione**|Provare a rimpicciolire la finestra, prima "manualmente" e poi provando a cambiare la risoluzione della finestra|
|**Prerequisiti**|Impostare dimensione minima|
|**Procedura**     |Fare partire il programma, rimpicciolire. Se non funziona andare nelle impostazioni di sistema, andare sotto risoluzione a abbassarla significatamente|
|**Risultati attesi** |Il programma dovrebbe rimanere con una dimensione minima di 1024x768|
|**Risultati**|Il programma rimane rispetta le aspettative e rimane di grandezza fissa, se si abbassa la risoluzione il programma sfora la grandezza dello schermo|
|**Come è stato risolto**| -|

|Test Case      | TC-003                              |
|---------------|--------------------------------------|
|**Nome**       |Reset dei punti|
|**Riferimento**|REQ-008                               |
|**Descrizione**|Fare il reset dei punti quando sono tanti e quando non ce ne sono|
|**Prerequisiti**|Avere i punti funzionanti e implementare il bottone reset|
|**Procedura**     |Fare partire il programma, aggiungere i punti, premere reset. Fatto questo premere reset anche senza punti.|
|**Risultati attesi** |Il programma dovrebbe rimuovere tutti i punti nel primo caso e nel secondo non dovrebbbe sollevare alcun errore|
|**Risultati**|Il programma rimane rispetta completamente le aspettative|
|**Come è stato risolto**| -|

|Test Case      | TC-004                              |
|---------------|--------------------------------------|
|**Nome**       |Spostamento dei punti|
|**Riferimento**|REQ-010                               |
|**Descrizione**|Aggiungere dei punti e muoverli|
|**Prerequisiti**|Avere i punti funzionanti|
|**Procedura**     |Fare partire il programma, aggiungere i punti, muoverne uno al di fuori dell'area prescelta.|
|**Risultati attesi** |I punti non dovrrebbero uscire dal pannello|
|**Risultati**|I punti escono dal pannello|
|**Come è stato risolto**| Questo punto non è stato risolto siccome se un utente aggiunge un punto al limite del pannello con lka visualizzazione a schermo intero quando rimpicciolisce la finestra i punti devono mantenere la stessa proporzione facendo uscire al di fuori del pannello i punti.|

### Mancanze/limitazioni conosciute

Le uniche due mancanze del programma sono il salvataggio in png e l'aggiunta di più poligoni e le motivazioni sono le seguenti:
per il primo non si è potuto salvare in svg data la complicatezza della classe che permette di salvare l'immagine. Per la seconda invece non si possono aggiungere più poligoni perché il programma non lo permette per come è statop pensato dall'inizio.

## Consuntivo

La pianificazione era sicuramente fatta in maniera estremamente sbagliata, in tempi erano irrelaistici per le consocenze che avevo. Oltre al tempo a disposizione ho dovuto sfruttare del tempon aggiuntivo, non solo a causa del ritardo ma soprattutto a causa che alcune lezioni sono saltate per altri impegni scolastici.

## Conclusioni

Grazie a questo progetto ho imparato pian piano a gestire un progetto al meglio. Sicuramente nel prossimo progetto avrò un comportamento molto più adeguato che mi permetterà di realizzare tutti e requisiti, un gantt realistico e una documentazione eccellente.

### Sviluppi futuri
  In futuro si possono aggiugnere i requisiti non ancoa sviluppati, sicuramente con una pulizia del codice.

### Considerazioni personali
  Con questo progetto, come detto nelle conclusioni, ho imparato a gestire al meglio un progetto, sia nella apte di progetazione che in quella di implemetnazione.

