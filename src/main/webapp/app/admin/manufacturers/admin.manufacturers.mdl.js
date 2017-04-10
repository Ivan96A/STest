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
                url: 'manufacturers',
                controller: 'ManufacturersCtrl',
                templateUrl: 'app/admin/manufacturers/admin.manufacturers.view.html',
            })
            .state('main.admin.manufacturerAdd', {
                url: 'manufacturerAdd',
                controller: 'ManufacturerAddCtrl',
                templateUrl: 'app/admin/manufacturers/add/admin.manufacturer.add.view.html'
            })
            .state('main.admin.manufacturerEdit', {
                url: 'manufacturer/:manufacturerId',
                controller: 'ManufacturerEditCtrl',
                templateUrl: 'app/admin/manufacturers/edit/admin.manufacturer.edit.view.html'
            });
    }

})();

