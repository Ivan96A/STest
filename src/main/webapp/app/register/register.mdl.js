/**
 * Created by Ivan on 30.03.2017.
 */
(function () {
    'use strict';

    angular
        .module('register', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.register', {
                url: 'register',
                controller: 'RegisterCtrl',
                templateUrl: 'app/register/register.view.html'
            });
    }

})();