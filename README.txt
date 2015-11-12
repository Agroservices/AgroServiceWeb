README

Instrucciones para el uso de la página Agroservices

1. En la parte superior de la página se encuentran unos tag con el contenido: campesinos, minoristas, notificaciones
	+ estos tag cargan las funcionalidades desarrolladas
	+ los tag campesinos, minoristas y notificaciones contiene las funcionalidades que se desarrollaron
	
2. Dar click en campesinos carga las funcionalidades para el campesino: Realizar Ficha Técnica, Ver fichas Técnicas, Ver ventas
	+ Realizar Ficha Técnica: Al dar click en este link aparecera un  formulario para ingresar los datos del producto a vender,
	  permitiendo ingresar la identificación del campesino y el tipo de producto.
	   - En caso que el tipo de producto que se vendera no se encuentre, se chequea el checkBoc con la pregunta "¿No encuentra su producto?"
	     y aparecerá al final de la página un formulario para ingresar el nuevo tipo de producto.
		 
	+ Ver fichas Técnicas: Mustra un listado de las fichas técnicas realizadas por el identificador de campesino especificado, por ejemplo: "123456789" o "987654321"
	+ Ver ventas: Permite ver las ventas realizadas con los productos en venta, ya sea para un campesino en especial o en general
	
3. Dar click en minoristas carga la funcionalidad de las compras
	+ Hay un menu desplegable en el cual se seleccionara el producto sobre el cual se consultaran los productos en venta
	+ Se debe ingresar la cantidad que se desea comprar y dar click en el botón consultar
	+ En la seccion inferior del formulario anterior se mostrará un listado con los productos en venta del producto seccionado que cumplan
	  con la cantidad especificada.
	  
	+ Al dar click en el producto desea de la lista, éste hará parte de la compra (solo es posible comprar un producto en venta a la vez)
	+ Se deben ingresar los datos de la tarjeta de credito con la cual se realizara la compra:
		- En la simulación de la transacción solo los números de tarjeta pares son aceptados
		- De igual forma los datos de mes/año de vencimiento de la fecha deben ser iguales o meyores al mes y año actuales
	+ Se oprime el botón "Comprar" y se realizará la operación de compra, realizandose primero una comprobación de los datos de la tarjeta
	  y de ser correctos el proceso de creación de factura iniciará
		- El proceso de compra toma unos instantes y al ser exitoso informará al usurio por medio de un pop-up.
		- en caso que los datos de la tarjeta no cumplan los parametros especificados anteriormente la operacion de compra no se realizará
		  y se informará al usuario por medio de un pop-up.
		- la compra realizada puede ser consultada inmediatamente en el apartado de campesinos en la sección "Ver ventas"
		
4. Dar click en notifiaciones carga la funcionalidad relacionada con las rutas asignadas a los transportistas:

	+ Dar click en confirmar rutas
	+ Ingresas el número de cedula del transportista
		- en caso que se quiera conocer las rutas para un transportista en especifíco
	+ Dar click en "consultar por cc" o "consultar todas las rutas"
	+ Las rutas correspondientes serán listadas
	+ Para cada ruta se ofrece la opción de ver los productos en venta que serán transportados en la ruta

5. Aplicacion movil

	+ A continuación se deja el link en el cual se podrá acceder al proyecto que contiene la aplicación movil:
		https://github.com/Agroservices/AgroservicesMovil.git