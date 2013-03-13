LAUREL - Herramienta para el Control de Items
======

Objetivo:
Diseñar un modelo de objetos que permita soportar la funcionalidad básica de una herramienta para el control de ítems (pedidos de cambios y requerimientos) de un proyecto de software.

Introducción:
El propósito de esta herramienta es el de ser utilizada en proyectos de desarrollo de software para formalizar la manera en la que se informan y manipulan los diferentes ítems que se van creado a lo largo de la vida de un proyecto. Ejemplos de estas herramientas son: Bugzilla, Jira y Mantis Bug Tracker.
Los ítems se clasifican utilizando un “tipo” (reporte de bug, ampliación, mejora, nuevo requerimiento, etc.) para poder asignarle el equipo correcto. Por ejemplo, en caso de ser un reporte de bug, seguramente se deberá asignar un equipo que haya participado en el proceso de desarrollo. Los “tipos” son dinámicos, en otras palabras, la herramienta debe permitir la creación de nuevos tipos de requerimientos. Estos tipos varían de proyecto en proyecto.
El ciclo de vida de un ítem está determinado por la secuencia de “estados” por los que puede pasar, por ejemplo, Creado, Análisis, En Desarrollo, Testing, Evaluación Usuario, Aceptado. Los estados deben ser configurados por el líder de proyecto teniendo en cuenta los diferentes tipos de ítems y los canales más eficientes para su resolución.
De cada tipo de ítem se conocen las posibles secuencias que puede seguir un ítem clasificado con este tipo. Por ejemplo el siguiente gráfico describe las posibles secuencias de estados que puede seguir un ítem clasificado como “reporte de bug”.

* Creado --> Desarrollo -->Validacion --> Terminado
* Validacion --> Desarrollo

Teniendo en cuenta la figura anterior, cabe destacar que no todos los ítems clasificados con el tipo “reporte de bug” necesariamente recorrerán la misma secuencia de estados. El camino que “realice” cada ítem estará definido en última instancia por el responsable del ítem.
De cada ítem, se conoce su prioridad, su tipo, su estado actual, y la secuencia de estados por la que pasó. El conjunto de posibles estados a los que puede pasar un ítem en un momento dado depende del tipo de ítem y del estado actual.

Cuando un ítem pasa por un estado, se le debe asignar un responsable. Puede ocurrir que el responsable de un ítem en un estado sea reasignado, con lo cual otro miembro del proyecto deberá ocupar su puesto. Es necesario, luego, poder conocer quien fue el responsable de un ítem en un estado dada una fecha. Los responsables de los ítems siempre serán miembros del proyecto.

Funcionalidad mínima a ser entregada
  1. Alta de usuarios en el sistema.
  2. Alta de tipos de ítems.
  3. Alta de ítems.
  4. Alta de estados del workflow.
  5. Visualización de estado actual e histórico de un ítem.
  6. Permitir que un ítem cambie de estado.
