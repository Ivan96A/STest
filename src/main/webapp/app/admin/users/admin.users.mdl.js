(function () {
    'use strict';

    angular
        .module('users', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.admin.users', {
                url: 'admin.users',
                //controller: 'LoginCtrl',
                templateUrl: 'app/admin/users/admin.users.view.html',
            });
    }

})();
