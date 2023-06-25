# Casino
Ignacio Valdebenito Rodriguez

Analisis Utilizar una baraja de 52 cartas del naipe inglés. Las cartas tienen cuatro pintas: Corazón, Trébol, Diamante y Pica. El mazo debe contener 13 cartas por pinta (un total de 52 cartas). Asignar valores a las cartas: Jota, Quina y Kaiser tienen un valor de 10, mientras que el As tiene un valor de 11. Repartir las cartas iniciales al jugador y al crupier. Calcular los puntajes de las manos basados en las cartas recibidas. Permitir al jugador decidir si desea pedir otra carta o plantarse. Implementar la lógica del crupier para jugar su mano. Comparar los puntajes del jugador y el crupier para determinar el resultado al final del juego.

Analisis de los cambios tuve que hacer varios cambios ya que no me funciono el main en otro packete asique termino en el mismo que todas las clases tambien tuve que crear otra clase llamada blockjock(muy original el nombre) la cual de forma simplificada llama al dealer para poder jugar (el dealer es contra quien juegas, el es quien revuelve el mazo, entrega las cartas, y cuenta los puntajes)

el programa en terminos simples crea varias clases (carta,mazo,dealer,blockjock,jugador) sin contrar el main la clase carta crea "los objetos cartas" que tienen atributos pinta valor y simbolo la clase mazo crea un arraylist de cartas osea un mazo teniendo 52 cartas (son 13 cartas de cada pinta,valor,simbolo. corazon, diamante, trebol y pica resprectivamente) la calse jugador es donde se crea el jugador con sus atributos (nombre , puntaje y un arraylist de la mano que trendra al jugar) la calse dealer es la mas compleja ya que el pide el nombre al jugador , llena el mazo tambien lo revuelve y entrega 3 cartas al jugador y otras 3 a el. tambien el dealer al mustra las cartas, cuenta los puntos y decide el ganador y por ultimo la clase blockJock, es en donde se inicia el juego pidiendo el nombre del dealer ( debe tener nombre si es el que mas hace taria feo si no le ponemos nombre) y asi usa los metodos de la clase dealer para iniciar el juego.

//Bueno actualizacion del juego Black Jack, el dealer no tiene nombre y el ahora ya no pide el nombre al inicar el juego, ahora usa el nombre que dal al "entrar al casino" y puedes jugar hasta que se acabe el mazo o salir al terminar "la partida".

El juego de BullsEye

Hay una lista de caballos y una lista de jugadores en la carrera
El jugador principal tiene un nombre y una cantidad de dinero inicial
Los caballos y los jugadores se agregan a las respectivas listas
El jugador principal elige un caballo para la carrera
Luego, se muestra un menú para que el jugador apueste una cantidad de dinero
Se inicia la carrera y se generan tiempos aleatorios para los participantes
Después de la carrera, se muestra el resultado y se determina al ganador
Si el jugador principal gana, se le entrega un premio en función de la apuesta realizada
Si el jugador principal pierde, se muestra un mensaje de que ha perdido y se verifica si tiene suficiente dinero para seguir jugando
Si el jugador tiene suficiente dinero, se le pregunta si desea continuar jugando
Si el jugador decide seguir jugando, se inicia una nueva carrera
Si el jugador decide no continuar, el juego termina
