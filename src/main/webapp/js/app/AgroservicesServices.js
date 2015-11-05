(function () {
    var app = angular.module('AgroservicesServices', []);

    app.service('AgroservicesRestAPI', function ($http) {
        
        this.getVentas = function () {
            return $http.get('/rest/ventas/');
        };
        
        this.getVentasByCampesino = function (id) {
            return $http.get('/rest/ventas/'+id);
        };
        
        this.getProductosConsultaCompra = function(){
            return $http.get('/rest/productos/');
        };
        
        this.getProductosEnVentaConsulta = function(id){
            //alert(id);
            return $http.get('/rest/productosEnVenta/'+id);
        };
        

        this.validarInformacionTarjeta = function (numeroTar,codigoTar,mesTar,anoTar){
            
            var tarjeta = {"numero":numeroTar,"codigo":codigoTar,"mesVencimiento":mesTar,"anoVencimiento":anoTar};
            return $http({
                method: 'POST',
                url: '/rest/compras/tarjetaValidacion/',
                data: tarjeta
            });

        };
        
        this.agregarFactura = function (transaccion,impuestoFactura,idProductoEnVenta,idMinorista,cantidad){
            
            var factura = {"transaccionesBancarias":transaccion,"impuesto":impuestoFactura}
            return $http({
                method: 'POST',
                url: 'rest/compras/'+idMinorista+'/'+idProductoEnVenta+'/'+cantidad,
                data: factura
            });
            
        };
        
        this.getTarjeta = function (){
           return $http.get('/rest/compras/tarjetaValidacion/');
        };

        this.postProductosEnVenta = function(productoEnVenta,idCampesino){
            return $http.post('/rest/campesinos/'+idCampesino+'/productosEnVenta'
            ,productoEnVenta);
        };
        
        this.getProductosEnVentaPorCampesino = function(idCampesino){
            return $http.get('/rest/campesinos/'+idCampesino+'/productosEnVenta');
        };
        
        this.postProducto = function(producto){
          return $http.post('/rest/productos/',producto);  
        };
        
        this.getRutas = function () {
            return $http.get('/rest/despachos/');
        };
    }
    );

})();





