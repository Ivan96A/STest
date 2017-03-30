/**
 * Created by Ivan on 30.03.2017.
 */
(function() {
    'use strict';

    angular
        .module('main')
        .controller('RegisterCtrl', RegisterCtrl);

    function RegisterCtrl($scope, $state, crAcl, UserService, ngDialog) {
        var sc = $scope;

        sc.registerUser = function(user) {
            function success(response) {
                //console.log(response.status);
            }

            function failed(response) {
                //console.log(response.status);
            }

            UserService.create(user).then(success, failed);
        };


    }

})();