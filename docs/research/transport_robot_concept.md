# Warehouse Robotics

## Konzept

Um festzustellen, welche Roboter benötigt werden, ist es sinnvoll, sich zunächst Gedanken zu machen, 
welche Usecases abgedeckt werden müssen. Wir können feststellen, dass die folgenden Operationen 
innerhalb unseres Systems durchgeführt können werden müssen:
- Be- und Entladung von Lastwagen
- Transport der Waren und Produkte innerhalb der Facility
- Einlagerung und Auslagerung aus einem automatischen Warehousing System
- Umstellen der Waren z.B. von einem Tisch auf den Roboter, und umgekehrt.

Wir brauchen also, aus diesen UseCases abgeleitet:
- Verladeroboter
- Transportroboter
- Ein automatisches Logistiksystem

## Verladung
Wir brauchen eine Lösung, wie gelieferte Materialien aus Lastwagen entnommen werden können, 
und fertige Produkte verladen werden können. Das könnte so aussehen:

![stretch unloading something](./images/stretch-unloading.jpg)

[Boston Dynamics Stretch](https://bostondynamics.com/products/stretch/): 
Roboterarm auf fahrbarem Untersatz, der Packete mit seiner Greifvorrichtung nehmen kann.

- Kann Waren aus Lastwagen entladen oder in Lastwagen stapeln
- Das gleiche mit Regalen
- Optimal, um Produkte von den Produktionsflächen auf Roboter zu verladen 
(evtl. modifizierter Greifer notwendig)
- Preis: teuer (vermutlich)

## Transport

Die Waren müssen innerhalb der Anlage von einem Ort zum anderen kommen. Eine Flotte fahrbarer Roboter 
bietet hier mehr Flexibilität als ein Transportband und kann vom MES effizient gesteuert werden.
Beispielsweise:

![xmove product image](./images/ek-robots-xmove.webp)

[EK-Robots XMove 150](https://ek-robotics.com/en/transport-robots/x-move/): Transportroboter 
für den Halleneinsatz.
- 150kg Traglast sollten für unsere Zwecke ausreichen
- Ist durch die Ladefläche flexibel einsetzbar, und kann vom Stretch be- und entladen werden
- Ist mit 2m/s fix unterwegs
- MES kann sich um eine effiziente Steuerung kümmern

XMove ist eine Skalierbare Plattform, die Roboter gibt es auch in Varianten bis 2t Traglast. 
Das scheint aber für unseren UseCase Overkill.


