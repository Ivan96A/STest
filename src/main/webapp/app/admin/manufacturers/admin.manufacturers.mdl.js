/**
 * Created by Ivan on 03.04.2017.
 */

(function () {
    'use strict';

    angular
        .module('manufacturers', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.admin.manufacturers', {
                url: 'admin.manufacturers',
                //controller: 'LoginCtrl',
                templateUrl: 'app/admin/manufacturers/admin.manufacturers.view.html',
            });
    }

})();

