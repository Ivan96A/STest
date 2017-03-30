(function () {
    'use strict';

    angular
        .module('login', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.login', {
                url: 'login',
                controller: 'LoginCtrl',
                templateUrl: 'app/login/login.view.html'
            });
    }

})();
