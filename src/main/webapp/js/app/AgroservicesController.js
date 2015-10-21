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
        
        //Variables que contiene la informacion de la tarjeta
        
        $scope.numeroTarjeta;
        $scope.codigoTarjeta;
        $scope.mesVencimiento;
        $scope.anoVencimiento;
        $scope.informacionTarjeta;
        
        $scope.tarjeta;
        
        
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
            $scope.sumaId = $scope.idProductoConsulta.toString() + "-" + $scope.cantidadConsulta;
            //alert($scope.sumaId);
            $scope.productosEnVenta = AgroservicesRestAPI.getProductosEnVentaConsulta($scope.sumaId).success(function(data, status,headers, config){
                //alert(angular.toJson(data));
                $scope.productosEnVenta = data;
                
                
            });
            
            
            
        };
        
        $scope.setProductoEnVentaSeleccionado = function(productoEnVenta){
            //alert(idProductoEnVenta);
            $scope.ProductoEnVenta = productoEnVenta;
            $scope.costoCompra = $scope.cantidadConsulta * $scope.ProductoEnVenta.precioPorKg;
            
        };

        
        $scope.realizarCompra = function(){
            //{"numero":12345,"codigo":111,"mesVencimiento":2,"añoVencimiento":2016}
            this.respuesta;
            
            $scope.informacionTarjeta = {numero:$scope.numeroTarjeta,codigo:$scope.codigoTarjeta,mesVencimiento:$scope.mesVencimiento,anoVencimiento:$scope.anoVencimiento}
            
//            $scope.informacionTarjeta = {numero:$scope.numeroTarjeta};
//            $scope.informacionTarjeta = {codigo:$scope.codigoTarjeta};
//            $scope.informacionTarjeta = {mesVencimiento:$scope.mesVencimiento};
//            $scope.informacionTarjeta = {añoVencimiento:$scope.anoVencimiento};

            $scope.tarjeta = AgroservicesRestAPI.getTarjeta().success(function(data, status,headers, config){
                $scope.tarjeta = data;
                alert(angular.toJson(data));
            });
            
            $log.log($scope.tarjeta);
            
            $scope.informacionTarjeta = {"numero":12345,"codigo":111,"mesVencimiento":2,"añoVencimiento":2016};
            AgroservicesRestAPI.validarInformacionTarjeta($scope.tarjeta).success(function(data, status,headers, config){
                alert("Informacion tarjeta correcta");
                //this.respuesta = data;
                alert(angular.toJson(data));
                
            }).error(function(data,status,header,config){
                        //$log.log("Post fail");
                        //$log.log(data+" "+status);
                    });
        };
        
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
        
        $scope.campesino = {idCampesino:123456789};
        
        $scope.enviarProductoEnVenta = function(){
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
                    }).error(function(data,status,header,config){
                        $log.log("Post fail");
                        $log.log(data+" "+status);
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
                });
    });

    app.directive('menuCampesinos',function(){
       return{
          restrict:'E',
          templateUrl: 'directives/menu-campesinos.html'
       } ;
    });

})();


