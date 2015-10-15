(function () {
    var app = angular.module('AgroservicesServices', []);

    app.service('AgroservicesRestAPI', function ($http) {
        
        this.getVentas = function () {
            return $http.get('http://localhost:8080/agroservices28_09_15/rest/ventas/');
        };
        
        this.getVentasByCampesino = function (id) {
            return $http.get('http://localhost:8080/agroservices28_09_15/rest/ventas/'+id);
        };
    }
    );

})();





