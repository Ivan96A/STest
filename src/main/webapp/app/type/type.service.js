(function () {
    'use strict';

    angular
        .module('main')
        .service('TypesService', function ($http) {

            var urlBase = '/type';

            this.getAll = function() {
                return $http.get(urlBase);
            };

            //this.getById = function(id) {
            //    return $http.get(urlBase + '/' + id)
            //};
            //
            //this.sentData = function(gameAndUserData) {
            //    return $http.post('/order', gameAndUserData);
            //}

        });
})();

