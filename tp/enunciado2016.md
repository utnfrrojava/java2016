# UNIVERSIDAD TECNOLÓGICA NACIONAL

## FACULTAD REGIONAL ROSARIO

### *ASIGNATURA: "LENGUAJE DE PROGRAMACIÓN: JAVA"*

#### *TP1* - Curso Lectivo 2016

##### Equipo Docente
- Ing. Ricardo Tabacman
- Ing. Adrián Meca

##### ¿Qué se evalúa?
En función de los objetivos propuestos de la materia de **lenguaje de programación JAVA** se evaluará la **capacidad del alumno para aprender** y profundizar sus conocimientos en el lenguaje Java.

##### Operatoria

Se realizará en equipos de no más de 3 alumnos. En la solución se debe utilizar el concepto de programación en tres capas. El sistema contará de 2 etapas:

1. Aplicación de escritorio con almacenamiento de la información en base de datos.
2. Aplicación web con almacenamiento de la información en base de datos.

La aplicación deberá desarrollarse en equipos utilizando un repositorio git usando un servidor gratuito, por ejemplo github.com, gitlab.com o bitbucket.com. Las entregas se harán enviando el link al repositorio indicando el tag en el repositorio correspondiente a la entrega.

##### Fechas de Entrega

- Etapa 1: 21 de Octubre
- Etapa 2: 18 de Noviembre


##### Enunciado

Realizar el desarrollo del siguiente juego del tipo Turn Based Combat. El mismo abarcará la creación y modificación de personajes y jugada de partidas.

###### Los personajes tienen las siguientes características:
  * Un código que asigna el sistema.
  * Un nombre que no debe repetirse.
  * Atributos:
    * Vida.
    * Energía.
    * Defensa.
    * Evasión.
    * Puntos totales.

Durante la creación del personaje se entregarán 200 pts. El jugador deberá asignarlos como quiera a los atributos: vida, energía, defensa, evasión. Pudiendo quedar puntos sin asignar.

En la modificación se podrán modificar los puntos asignados a cada atributo.

El juego consiste en 2 personajes enfrentándose en un juego de turnos. Cada jugador tiene control sobre un personaje, alternarán en cada turno y podrá realizar una acción con su personaje: ataque o defensa.

###### Reglas:
  * Ataque:
    * Durante su turno un jugador puedo optar por atacar al oponente, el jugador debe ingresar la cantidad de puntos de energía que se utilizarán en el ataque. Los mismos deberán restarse de su personaje (no podrá exceder los que tiene) en cualquier caso.
    * Durante el ataque se evaluará primero la probabilidad de evasión del personaje atacado(ver abajo), si el personaje evade el ataque no recibirá daño alguno. Si en cambio el ataque no es evadido se restarán los puntos de energía utilizados en el ataque de la vida del atacado.

  * Defensa:
    * Los puntos de defensa no podrán exceder los 20 puntos.
    * Si el jugador opta por defender no podrá atacar en dicho turno, pero a cambio de ello el personaje recuperará un porcentaje de la energía y de la vida que tenía al comenzar el juego. Calculado de la siguiente forma:
      * energiaARecupearar = energiaOriginal *  defensa / 100
      * vidaARecuperar = vidaOriginal * defensa / 250
    * Los puntos de vida o energia recueperados se sumaran pero no podrán superar los valores originales del comienzo de la partida.

  * Evasión: Al crear el jugador se podrán asignar puntos de evasión. Siendo el máximo 80 puntos. Cuando el personaje recibe un ataque se calculará si puede evadir el ataque con un número aleatorio si se cumple la condición (numAleatorio*100)< puntosDeEvasion. En caso de evadir el ataque el personaje atacado no recibe daño, pero el atacante igualmente pierde los puntos de energía utilizados.

  * Ganador: El ganador será quien quite todos los puntos de vida del oponente primero. Al finalizar el combate el ganador recibirá como premio 10 puntos para su personaje que se sumarán a los puntos totales que ya tenía para así poder asignarlos luego en la modificación del personaje.

  * Recuperación: Además a cada jugador se le restaurarán los puntos de vida y energía que tenía antes del combate.

###### FAQ:
  1. **¿De qué modo afecta la defensa al ataque?**  
  **Respuesta**: Cuando un personaje defiende, se recupera su propia energía durante ese turno y el turno cambia al otro personaje. Es decir en un mismo turno no se puede defender y atacar, debe elegirse una de las dos acciones.

  2. **No comprendo el proceso de evasión, ¿cómo funciona?**
  **Respuesta**: La formula es (numAleatorio*100)<puntosDeEvasion. Donde el número aleatorio es generado entre 0 y 1. Durante cada ataque se genera un nuevo número aleatorio. De esta forma el numAleatorio*100 genera un valor entre 0 y 100 con una probabilidad uniforme en el intervalo. Ya que los puntos de evasión pueden ser entre 0 y 80 siempre habrá probabilidad de acertar el ataque, por ejemplo:
  
  *Ataque evadido*:
  
  * puntosDeEvasion: **70**.
  * numAleatorio generado en este ataque: **0.1589002**
  * cálculo: `numAleatorio*100`: **15.89002**
  * `(numAleatorio*100) < puntosDeEvasion -> 15.89002 < 70` es **verdadero**
  * Resultado: el personaje que recibe el ataque lo evade el ataque, y no se descuentan puntos de vida. Al personaje atacante igualmente se le descuentan los puntos de energia usados de su energía restante.
  
  
  *Ataque no evadido*:
  
  * puntosDeEvasion: **70**.
  * numAleatorio generado en este ataque: **0.8722452**
  * cálculo: `numAleatorio*100`: **87.22452**
  * `(numAleatorio*100) < puntosDeEvasion -> 87.22452 < 70` es **falso**
  * Resultado: el personaje que recibe el ataque no lo evade, y se descuenta de los puntos de vida del personaje que recibe los puntos de ataque. Al personaje atacante se le descuentan los puntos de energia usados de su energía restante.
