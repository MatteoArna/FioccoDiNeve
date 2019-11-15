# Fiocco Di Neve
## Introduzione
---
### Informazioni sul progetto
- Matteo Arena
- Luca Muggiasca e Geo Petrini, <i>supervisori</i>
- SAM, Informatica, Modulo 306
- 06/09/2019 - 20/12/2019
### Abstract
Con questo progetto intendo sviluppare un programma (realizzato con Java) che si occuperà di generare un fiocco di neve partendo da un triangolo dove si possono fare dei tagli a proprio piacimento. Una volta che il fiocco sarà generato sarà disponibile il salvataggio dell'immagine in formati diversi.
### Scopo
Lo scopo finale è riuscire a gestire nella maniera più ottimale possibile un progetto in maniera autonoma.
## Analisi
---
### Analisi del dominio
Possibilmente il programma finale dovrebbe essere facilmente intuibile ed utilizzabile pure a persone inesperte di questo settore.
### Analisi e specifica dei requisiti
I requisiti sono elencati nella seguente tabella: 
[requisiti](requisiti.md)
### Use case
Le funzioni che il fiocco avrà saranno il salvataggio del triangolo iniziale (quello dal quale poi si ricava il fiocco di neve) e il fiocco effettivo. Oltre a questo i poligoni sul triangolo dovranno essere il più modificabili possibile.
### Pianificazione
[Gantt Iniziale](FioccoIniziale.pdf)<br>
[Gantt Finale] --> Coming soon
### Analisi dei mezzi
I mezzi disponibili per questo progetto sono:
<br>
- Computer Personale (Acer Aspire 5)
- JDK e JRE versione 12.0.2
- Server Infomaniak
## Progettazione
### Design dell’architettura del sistema

    Il triangolo verrà sempre centrato tramite l'utilizzo di una classe (TriangleModel) che in base alla dimensione del panel sarà sempre in grado di ritornare le dimensioni appropriate per il pannello corrente. Il salvataggio del triangolo viene fatto in un file csv che avrà nella posizione "a" la posizione X di un punto e nel "b" la Y (ovviamente riferiti al modello del triangolo).
### Design delle interfacce

[Pagina home](../Img/HomePage.jpg)
<br>[Pagina di salvataggio](../Img/menuSalvataggio.jpg)
<br>[Scheda Principale](../Img/SchedaPrincipale.jpg)
<br>[Sito Web](../Img/SitoWeb.jpg)

### Design procedurale

[Link JavaDoc del progetto]()

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
