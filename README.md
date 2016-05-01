# Práctica para el Exámen

Cree un branch en este repositorio

RECOPE está preocupado por saber si el suministro de gasolina estimado para un mes cumple con la demanda de combustibles, por esto acudieron a usted para realizar un pequeño simulador que solo contemple Automóviles, Motos y Buses como vehículos en circulación.

Un vehículo posee los siguientes atributos 
 * Placa
 * Cantidad de llantas
 * Cantidad de pasajeros
 * Peso

Cada vehículo tiene una fórmula de calcular su gasto de combustible, ésta se describe a continuación.

 * Automóvil:  Si la placa termina en 0 entonces gasta la cantidad de llantas multiplicado por 2 veces el peso, sino gasta la cantidad de llantas multiplicado por 3 veces el peso
 * Moto: La cantidad de llantas multiplicado por el peso menos el último numero de la placa
 * Bus: La cantidad del llantas multiplicado por el 5 veces el peso menos por la cantidad de pasajeros dividido entre 10

Todos los vehículos visitan una gasolinera para comprar gasolina equivalente al gasto que realizan, todas las gasolineras compran gasolina a RECOPE, por esto aunque hayan muchas gasolineras el flujo de gasolina es centralizado por RECOPE.

RECOPE quiere saber cuantas veces puede ir un vehículo a las gasolineras antes de que se acabe el combustible.

Todo vehículo visita la siguiente gasolinera, de forma que se recorra las gasolineras en orden de aparición y se repiten tantas veces sea necesario para cubrir con la demanda de vehículos. Una vez el último vehículo haya consumido gasolina se acaba un ciclo y se vuelve a iniciar con el primer vehículo y la primera gasolinera.

#Objetivo:

Cree una interfaz en la que los usuarios puedan ingresar:
 * Los datos de los automóviles.
 * La cantidad de gasolina disponible.
 * La cantidad de gasolineras que deseen

El usuario también puede correr la simulación y ver los resultados.

Debe validar que la cantidad de llantas, la cantidad de pasajeros y el peso son valores numéricos y la placa tiene este formato: dos letras (AU, MO, BU) y 4 números como por ejemplo
 * AU2122
 * MO4321   
 * BU7246

En caso de algún error debe mostrar un mensaje en la interfaz indicando el error.
El sistema debe poder ser capaz de guardar los vehículos actuales en algún formato visto en clase (solo uno).
