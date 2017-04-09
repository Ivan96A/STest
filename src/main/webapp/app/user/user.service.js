/**
 * Created by Ivan on 30.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .service('UserService', function ($http) {

            this.create = function (user) {
                return $http.post('user/public/register', user);
            };

            this.getAll = function () {
                return $http.get('/user');
            }

            this.getOne = function(id) {
                return $http.get('/user/' + id);
            }

            this.update = function(user) {
                return $http.post('user/', user);
            }

        });

})();