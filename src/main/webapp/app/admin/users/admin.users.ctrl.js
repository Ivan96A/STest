/**
 * Created by Ivan on 03.04.2017.
 */

(function () {
    'use strict';

    angular
        .module('main')
        .controller('UsersCtrl', UsersCtrl);

    function UsersCtrl($scope, $state, UserService, $location, ngDialog) {

        var sc = $scope;

        sc.getAllUsers = function () {

            function success(response) {
                sc.users = response.data;
            };

            function failed(response) {
                sc.users = response.data;
                console.log(response.status);
            };

            UserService.getAll().then(success, failed);
        };
    }
})();
