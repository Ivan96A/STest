/**
 * Created by Ivan on 03.04.2017.
 */

(function () {
    'use strict';

    angular
        .module('types', [
            'ui.router'
        ])
        .config(configure);

    configure.$inject = ['$stateProvider', '$urlRouterProvider'];
    function configure($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('main.admin.types', {
                url: 'types',
                controller: 'TypesCtrl',
                templateUrl: 'app/admin/types/admin.types.view.html',
            })
            .state('main.admin.typeAdd', {
                url: 'typeAdd',
                controller: 'TypeAddCtrl',
                templateUrl: 'app/admin/types/add/admin.type.add.view.html'
            });
    }

})();

