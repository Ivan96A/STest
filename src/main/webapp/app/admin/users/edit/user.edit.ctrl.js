/**
 * Created by Ivan on 04.04.2017.
 */
(function () {
    'use strict';

    angular
        .module('main')
        .controller('UserEditCtrl', UserEditCtrl);

    function UserEditCtrl($scope, $stateParams, UserService, $location, $rootScope, $state) {
        var sc = $scope;

        sc.userId = $stateParams.userId;

        sc.getUserById = function(id) {

            function success(response) {
                sc.user = response.data;
            }

            function failed(response) {
                sc.user = response.data;
            }

            UserService.getOne(id).then(success, failed);

        };

        sc.updateUser = function (user) {
            function success(response) {
                $state.go('main.admin.users');
            }
            function failed(response) {
            }
            UserService.update(user).then(success,failed);
        }

    }
})();