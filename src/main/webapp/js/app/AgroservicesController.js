(function () {
    var app = angular.module('AgroservicesControl', ['ngRoute','AgroservicesServices']);
        
    app.controller('agroservicescontroller', function ($scope,$location,$log,AgroservicesRestAPI) {
        
        
        $scope.idCampesino=0;
        $scope.productos = AgroservicesRestAPI.getProductosConsultaCompra().success(function(data, status,headers, config){
                $scope.productos = data;
                //alert(angular.toJson(data));
            });
            
        $scope.idProductoConsulta;
        $scope.cantidadConsulta;
        $scope.productosEnVenta;
        $scope.sumaId;
        $scope.ProductoEnVenta;
        $scope.costoCompra = 0;
        
        $scope.activadorBoton = false;
        
        //Variables que contiene la informacion de la tarjeta
        
        
        $scope.numeroTarjeta;
        $scope.codigoTarjeta;
        $scope.tipoTarjeta;
        $scope.anoVencimiento;
        $scope.informacionTarjeta;
        
        //Variables relacionadas con la compra
        
        $scope.idMinorista;
        $scope.nombreMinorista;
        $scope.tarjeta;
        $scope.cuentaDestino = "2789817823-bancolombia";
        $scope.descripcion;
        
        $scope.activadorConsultaCompra = true;
        $scope.activadorSeleccionCompra = false;
        $scope.activarCompra = false;
        
        //Vaariables del transportista
        $scope.idTransportista = 0;
        
        $scope.ventasPorCampesino = function (){
            $scope.ventas = AgroservicesRestAPI.getVentasByCampesino($scope.idCampesino).success(function(data,status,headers,config){
                $scope.ventas = data;
            });
        };
        
        $scope.totalVentas = function () {
            $scope.ventas = AgroservicesRestAPI.getVentas().success(function(data, status,headers, config){
                $scope.ventas = data;
            });
        };
        
        $scope.getProductos = function(){
          
          $scope.productos = AgroservicesRestAPI.getProductosConsultaCompra().success(function(data, status,headers, config){
                $scope.productos = data;
                //alert(angular.toJson(data));
            });
            
            
        };
        
        $scope.getProductosEnventa = function(){
            
            $scope.sumaId = $scope.idProductoConsulta.toString();
            $scope.sumaId = $scope.sumaId + "-" + $scope.cantidadConsulta;
            //alert($scope.sumaId);
            $scope.productosEnVenta = AgroservicesRestAPI.getProductosEnVentaConsulta($scope.sumaId).success(function(data, status,headers, config){
                //alert(angular.toJson(data));
                $scope.productosEnVenta = data;
                $scope.activadorSeleccionCompra = true;
                
                
            });
              
            
        };
        
        $scope.setProductoEnVentaSeleccionado = function(productoEnVenta){
            
            $scope.ProductoEnVenta = productoEnVenta;
            $scope.costoCompra = $scope.cantidadConsulta * $scope.ProductoEnVenta.precioPorKg;
            $scope.activarCompra = true;
        };

        
        $scope.obtenerMinorista = function(){
            
            AgroservicesRestAPI.getNombreMinorista($scope.idMinorista).success(                    
                    function(data,status,header,config){
                        
                        $scope.nombreMinorista = data.toString();
                        
                        alert("Bienvenido: "+$scope.nombreMinorista);
                        $scope.activadorConsultaCompra = false;
                        
                    }).error(function(data,status,header,config){
                        $log.log("Error obteniendo minorista.");
                        $log.log(data+" "+status);
                    });
                    
            
        };
        
        $scope.realizarCompra = function(){
            //{"numero":12345,"codigo":111,"mesVencimiento":2,"añoVencimiento":2016}
            
            
            
            $scope.transaccionBacaria;
            
            $scope.transaccion;
            
            $scope.activadorBoton = true;
            
            $scope.descripcion = "Compra cliente " + $scope.nombreMinorista + " de " + $scope.ProductoEnVenta.descripcion;
            
            AgroservicesRestAPI.validarInformacionTarjeta($scope.numeroTarjeta,$scope.codigoTarjeta,$scope.tipoTarjeta,$scope.nombreMinorista,$scope.cuentaDestino,$scope.descripcion,$scope.costoCompra).success(                    
                    function(data,status,header,config){
                        $log.log("Post Transaccion exitoso");
                        
                        $scope.transaccionBacaria = data;
                        $log.log($scope.transaccionBacaria);
                        
                        AgroservicesRestAPI.getTransaccion($scope.transaccionBacaria).success(function(data,status,header,config){
                           
                           $scope.transaccion = data;
                           $log.log($scope.transaccion);
                           
                        }).error(function(data,status,header,config){
                            
                            $log.log("Get transaccion fallida..");
                            
                        });
                        
                        
//                        AgroservicesRestAPI.agregarFactura($scope.transaccion,$scope.costoCompra*0.16,$scope.ProductoEnVenta.idProductosEnVenta,$scope.idMinorista,$scope.cantidadConsulta).success(function(data,status,header,config){
//                            $log.log("POST compra exitoso");
//                            alert("Transaccion Exitosa!!");
//                            $scope.activadorBoton = false;
//                        }).error(function(data,status,header,config){
//                            $log.log("Post COMPRA fail");
//                            $log.log(data+" "+status);
//                        });
                        
                    }).error(function(data,status,header,config){
                        alert("Datos de la tarjeta incorrectos...");
                        $log.log("Post Transaccion fail");
                        $log.log(data+" "+status);
                    });
                    
            
            
        };
               
        
        $scope.despachosPorRuta = function (ruta){
            $scope.despachos = AgroservicesRestAPI.getDspachosByRuta(ruta.idRutas).success(function(data,status,headers,config){
                $scope.despachos = data;
            });
        };
        
        $scope.rutasPorTransportista = function (){
            $scope.rutas = AgroservicesRestAPI.getRutasByTransportsta($scope.idTransportista).success(function(data,status,headers,config){
                $scope.rutas = data;
            });
        };
        
        $scope.todasRutas = function (){
            $scope.rutas = AgroservicesRestAPI.getRutas().success(function(data,status,headers,config){
                $scope.rutas = data;
            });
        };
        
        $scope.rutaSeleccionada = function (ruta){
            AgroservicesRestAPI.asignarRuta(ruta.idRutas).success(function(data,status,header,config){
                alert("Asignada a "+ruta.transportistas.nombres +" "+ruta.transportistas.apellidos);
            }).error(function(data,status,header,config){
                    $log.log(data+" "+status);
                    alert("No se pudo asignar la ruta");
                });
        };
        
        $scope.rutaDenegada = function (ruta){
            alert("Rechazada por "+ruta.rutas.transportistas.nombres +" "+ruta.rutas.transportistas.apellidos)
        }
        
    }
    );
    
    app.controller('fichaTecnicaCtrl',function($scope,$log,AgroservicesRestAPI){
        
        $scope.productos = [];
        
        $scope.productosPromise = AgroservicesRestAPI.getProductosConsultaCompra();
        
        $scope.productosPromise.then(
                function(response){                    
                    $scope.productos = response.data;
                    $log.log($scope.productos);
                },function(){
                    $log.log("No se logro acceder al API de productos");
                }
            );
               
        $scope.productoEnVenta = {};
        
        $scope.campesino = {};
        
        $scope.noHayProducto = false;

        $scope.producto = {};
        
        $scope.errorCrearProducto = false;
        
        $scope.errorCrearProductoEnVenta = false;
        
        $scope.exitoCrearProducto = false;
        
        $scope.exitoCrearProductoEnVenta = false;
        
        $scope.enviarProducto = function(){            
            $scope.errorCrearProducto = false;                    
            $scope.exitoCrearProducto = false;                               
            $log.log("Enviar Producto");
            $scope.productoPromise = AgroservicesRestAPI.postProducto($scope.producto)
                  .success(function(data,status,header,config){
                      $log.log("Post de Producto Exitoso");
                      $scope.exitoCrearProducto = true;
                      $scope.productosPromise = AgroservicesRestAPI.getProductosConsultaCompra();
        
                      $scope.productosPromise.then(
                              function(response){                    
                                  $scope.productos = response.data;
                                  $log.log($scope.productos);
                              },function(){
                                  $log.log("No se logro acceder al API de productos");
                              }
                                      );              
                  }).error(function(data,status,header,config){
                      $log.log("Post Producto Fail");
                      $scope.errorCrearProducto = true;
                  });
        };
        
        $scope.enviarProductoEnVenta = function(){            
            $scope.errorCrearProductoEnVenta = false;                        
            $scope.exitoCrearProductoEnVenta = false;              
            $scope.productoEnVenta.campesinos = {};
            var productoTemp = {};
            for(var i=0; i<$scope.productos.length;i++){         
                $log.log($scope.productos[i]);
                if($scope.productos[i].nombre===$scope.productoEnVenta.productos){
                    productoTemp = $scope.productos[i];
                }
            }
            $log.log(productoTemp);
            $scope.productoEnVenta.productos = productoTemp;
            //$scope.productoEnVenta = {};
            $log.log($scope.productoEnVenta);
            AgroservicesRestAPI.postProductosEnVenta($scope.productoEnVenta,$scope.campesino.idCampesino).success(                    
                    function(data,status,header,config){
                        $log.log("Post exitoso");
                        $scope.exitoCrearProductoEnVenta = true;
                    }).error(function(data,status,header,config){
                        $log.log("Post fail");
                        $log.log(data+" "+status);
                        $scope.errorCrearProductoEnVenta = true;
                    });
        };
        
    });
    
    app.controller('verFichaTecnicaCtrl',function($scope,$log,AgroservicesRestAPI){
        
        $scope.productosEnVenta = [];
        
        $scope.campesino = {};                
        
        $scope.productoEnVenta = {};
        
        $scope.consultarFichas = false;
                        
        $scope.buscarProductosEnVenta = function(){          
          $scope.consultarFichas = true;
          $scope.productoEnVentaPromise = AgroservicesRestAPI.getProductosEnVentaPorCampesino($scope.campesino.idCampesino)
                .success(function(data,status,header,config){
                    $log.log(data);
                    $scope.productosEnVenta = data;
                }).error(function(data,status,header,config){
                    $log.log(data);                    
                });          
        };
                        
    });    
    
    app.controller('productoCtrl',function($scope,$log,AgroservicesRestAPI){
        

        
    });
    
    app.controller('modificarFichaController',function($scope,$log,AgroservicesRestAPI){
        
        $scope.modIdCampesino;
        $scope.modproductosEnVenta = [];
        $scope.estado = false;
        
        $scope.productoModificar = {};
        
        
        
        $scope.buscarProductosEnVenta = function(){          
          $scope.modconsultarFichas = true;
          $scope.modproductoEnVentaPromise = AgroservicesRestAPI.getProductosEnVentaPorCampesino($scope.modIdCampesino)
                .success(function(data,status,header,config){
                    $log.log(data);
                    $scope.modproductosEnVenta = data;
                }).error(function(data,status,header,config){
                    $log.log(data);                    
                });          
        };
        
        $scope.productoModificarSeleccionado = function (modProductoModificar){
            
            
            $scope.productoModificar = modProductoModificar; 
            $log.log($scope.productoModificar);
            $scope.estado = true;
            
            
        };
        
        $scope.modificarFichaTecnica = function(){
            
            $log.log("entro a la funcion de modificacion");
            
            AgroservicesRestAPI.postModificarProductoEnVenta($scope.productoModificar).success(                    
                    function(data,status,header,config){
                        $log.log("Post exitoso");
                        alert("Modificación Exitosa..");
                        
                    }).error(function(data,status,header,config){
                        $log.log("Post fail");
                        $log.log(data+" "+status);
                        alert("Modificación Fallida..");
                        
                    });
                    
        };
        
        

        
    });
    
    
    
    app.config(function($routeProvider){
        $routeProvider
                .when('/campesinos',{
                    templateUrl : 'home-campesinos.html'
                })
                .when('/minoristas',{
                    templateUrl: 'home-minoristas.html'
                })
                .when('/fichatecnica',{
                    templateUrl: 'ficha-tecnica.html'
                })
                .when('/verfichastecnicas',{
                    templateUrl: 'ver-ficha-tecnica.html'
                })
                .when('/ventascampesinos',{
                    templateUrl: 'ventas-campesinos.html'
                })
                .when('/notificaciones',{
                    templateUrl: 'home-notificaciones.html'
                })
                .when('/modificarProducto',{
                    templateUrl: 'campesinos-modificar-ficha-tecnica.html'
                })
                .when('/confirmarRutas',{
                    templateUrl: 'confirmacion-rutas-transportistas.html'
                });
    });

    app.directive('menuCampesinos',function(){
       return{
          restrict:'E',
          templateUrl: 'directives/menu-campesinos.html'
       } ;
    });

    app.directive('formularioProductos',function(){
       return{
          restrict:'E',
          templateUrl: 'directives/formulario-productos.html'
       } ;
    });
    
    app.directive('menuNotificaciones',function(){
       return{
          restrict:'E',
          templateUrl: 'directives/menu-notificaciones.html'
       } ;
    });

})();


