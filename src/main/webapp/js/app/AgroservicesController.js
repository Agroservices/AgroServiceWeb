(function () {
    var app = angular.module('AgroservicesControl', ['ngRoute','AgroservicesServices']);
        
    app.controller('agroservicescontroller', function ($scope,$location,AgroservicesRestAPI) {
        
        
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
        $scope.añoVencimiento;
        
        
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
            $scope.productosEnVenta = AgroservicesRestAPI.getProductosEnVentaConsulta().success(function(data, status,headers, config){
                //alert(angular.toJson(data));
                $scope.productosEnVenta = data;
                
            });
            
            
            
        };
        
        $scope.setProductoEnVentaSeleccionado = function(productoEnVenta){
            //alert(idProductoEnVenta);
            $scope.ProductoEnVenta = productoEnVenta;
            $scope.costoCompra = $scope.cantidadConsulta * $scope.ProductoEnVenta.precioPorKg;
            
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
               
        var productoSeleccionado = {};
        
        var precio = 0.0;
        var cantidad = 0.0;
        var descripcion = "";
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


