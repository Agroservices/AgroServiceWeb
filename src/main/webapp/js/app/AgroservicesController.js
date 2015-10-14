(function () {
    var app = angular.module('AgroservicesControl', ['ngRoute','AgroservicesServices']);
        
    app.controller('agroservicescontroller', function ($scope,$location,AgroservicesRestAPI) {
        
        //$scope.ventas=AgroservicesRestAPI.getVentas();
        $scope.ventas = AgroservicesRestAPI.getVentas().success(function(data, status,headers, config){
            $scope.ventas = data;
        });
        $scope.ventaSeleccionada={};
        
        $scope.setVentaSeleccionada = function (venta){
            $scope.ventaSeleccionada=venta;
        };

    }
    );

})();


