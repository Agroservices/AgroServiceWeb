(function () {
    var app = angular.module('AgroservicesServices', []);

    app.service('AgroservicesRestAPI', function ($http) {
        
        this.getVentas = function () {
            return $http.get('/agroservices28_09_15/rest/ventas/');
        };
        
        this.getVentasByCampesino = function (id) {
            return $http.get('/agroservices28_09_15/rest/ventas/'+id);
        };
        
        this.getProductosConsultaCompra = function(){
            return $http.get('/agroservices28_09_15/rest/productos/');
        };
        
        this.getProductosEnVentaConsulta = function(id){
            //alert(id);
            return $http.get('/agroservices28_09_15/rest/productosEnVenta/'+id);
        };
        

        this.validarInformacionTarjeta = function (numeroTar,codigoTar,mesTar,anoTar){
            
            var tarjeta = {"numero":numeroTar,"codigo":codigoTar,"mesVencimiento":mesTar,"anoVencimiento":anoTar};
            return $http({
                method: 'POST',
                url: '/agroservices28_09_15/rest/compras/tarjetaValidacion/',
                data: tarjeta
            });

        };
        
        this.getTarjeta = function (){
           return $http.get('/agroservices28_09_15/rest/compras/tarjetaValidacion/');
        };

        this.postProductosEnVenta = function(productoEnVenta,idCampesino){
            return $http.post('/agroservices28_09_15/rest/campesinos/'+idCampesino+'/productosEnVenta'
            ,productoEnVenta);
        };
        

    }
    );

})();





