# GASH Garage Shutter
------------
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/src/img/GASH.png)  

[TOC]

## Autori
* **Rino Di Paola**
* **Gianluca Grasso** 

## Tutorial casi d'uso

------------
### UC2 Inserimento nuovo tipo di porta per garage
Cliccando sul pulsante Nuovo Tipo di porta è possibile avviare il caso d'uso 2   
 
 Comparirà un popup di questo tipo in cui verrà richiesto il codice della nuova porta (Se già esiste una porta con quel codice il sistema segnalerà un errore)   

![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC2.PNG)  
  

![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC2_1.PNG)  

Verrà richiesto il codice del componente da inserire ( nel sistema sono già presenti COM001 COM002 COM003, è possibile inserirne altri effettuando un ordine al fornitore con il caso d'uso UC1 e segnalando l'arrivo con Arrivo Ordine UC12)  
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC2_2.PNG)    
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC2_3.PNG)    
  
Una volta completato l'inserimento verrà chiesto se inserirne un altro  
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC2_4.PNG)   

![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC2_5.PNG)  
  
Una volta confermata la vendita la gui si aggiornerà e mostrerà le informazione della porta inserita

### UC3 Nuova Vendita porta per garage
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3.PNG)  

Verranno richieste le porte da inserire in questa vendita, in questo caso è stata inserita la porta inserita nel tutorial precendente con codice "POR005".  
  
Nel sistema sono presenti di default due porte ("POR001" e "POR002") che possono essere modificate o eliminate tramite le estensioni del caso d'uso.  

![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_1.PNG) 
  
Se i mq disponibili di lamiera non saranno abbastanza per soddisfare la vendita il sistema segnalerà un errore.  
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_2.PNG)  
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_3.PNG)  

![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_4.PNG)   

![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_5.PNG)   
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_6.PNG)  

  
Infine verrà prodotto un file txt nella cartella Vendite che se non presente viene creata.  
![](https://bitbucket.org/GianlucaGrasso/gash-garageshutter-java/raw/51cbabdc11993c9d88d81b01c567194d4559ea36/GASH/tutorial_img/UC3_7.PNG) 



