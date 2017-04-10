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

            this.addGoodToOrder = function(sentData) {
                return $http.post('/order', sentData);
            };

            this.deleteGoodFromOrder = function(sentData) {
                return $http.post('/order/delete', sentData);
            }

            this.getGoodsByUsername = function (username) {
                return $http.get(urlBase + '/public/' + username);
            }

            this.saveGood = function(good, typeName, manufacturerName) {
                return $http.post(urlBase, good , {
                    params: {
                        typeName: typeName,
                        manufacturerName: manufacturerName
                    }
                });
            };

            this.update = function(good, typeName, manufacturerName) {
                return $http.post(urlBase + "/update", good, {
                    params: {
                        typeName: typeName,
                        manufacturerName: manufacturerName
                    }
                });
            }

            //this.sentData = function(gameAndUserData) {
            //    return $http.post('/order', gameAndUserData);
            //}

        });
})();