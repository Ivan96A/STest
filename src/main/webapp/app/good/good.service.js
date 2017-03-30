/**
 * Created by Ivan on 29.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .service('GoodsService', function ($http) {

            var urlBase = '/good';

            this.getAll = function(goodName, typeId) {
                return $http.get(urlBase, {
                        params: {
                            goodName: goodName,
                            typeId: typeId
                        }
                    });
            };

            this.getById = function(id) {
                return $http.get(urlBase + '/' + id)
            };

            //this.sentData = function(gameAndUserData) {
            //    return $http.post('/order', gameAndUserData);
            //}

        });
})();