(function () {
    var app = angular.module('AgroservicesServices', []);

    app.service('AgroservicesRestAPI', function ($http) {
        this.getVentas = function () {
            return $http.get('http://localhost:8080/agroservices28_09_15/rest/ventas/');
            /*return [
            {
                idVentas: 1,
                nombre: "Papa pastusa",
                cantidad: 25,
                pago: 20500
            },
            {
                idVentas: 2,
                nombre: "Tomate cherry",
                cantidad: 8,
                pago: 15360
            },
            {
                idVentas: 3,
                nombre: "Lechuga",
                cantidad: 20,
                pago: 10000

            },
            {
                idVentas: 4,
                nombre: "Frijoles rojos",
                cantidad: 33,
                pago: 33000

            }
            ];*/
        };
    }
    );

})();





