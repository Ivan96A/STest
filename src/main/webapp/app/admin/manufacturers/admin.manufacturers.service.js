(function () {
    'use strict';

    angular
        .module('main')
        .service('ManufacturersService', function ($http) {

            var urlBase = '/manufacturer';

            this.getAll = function () {
                return $http.get(urlBase);
            };

            this.getOneByName = function(name) {
                return $http.get(urlBase + '/' + name);
            };

            this.save = function(manufacturer) {
                return $http.post(urlBase, manufacturer);
            };

            this.update = function(manufacturer) {
                return $http.post(urlBase + '/update', manufacturer);
            };

            this.getOneById = function(id) {
                return $http.get(urlBase + '/id/' + id);
            }

        });
})();


