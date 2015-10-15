(function () {
    var app = angular.module('AgroservicesControl', ['ngRoute','AgroservicesServices']);
        
    app.controller('agroservicescontroller', function ($scope,$location,AgroservicesRestAPI) {
        
        
        $scope.idCampesino=0;
        
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
    }
    );

})();


