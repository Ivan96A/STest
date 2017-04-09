(function () {
    'use strict';

    angular
        .module('main')
        .service('TypesService', function ($http) {

            var urlBase = '/type';

            this.getAll = function() {
                return $http.get(urlBase);
            };

            this.getOneByName = function(name) {
                return $http.get(urlBase + '/' + name);
            };

            this.save = function(type) {
                return $http.post(urlBase, type);
            }
        });
})();

