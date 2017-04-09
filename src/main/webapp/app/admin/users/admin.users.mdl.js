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
                url: 'users',
                controller: 'UsersCtrl',
                templateUrl: 'app/admin/users/admin.users.view.html'
            })
            .state('main.admin.usersEdit', {
                url: 'user/:userId',
                controller: 'UserEditCtrl',
                templateUrl: "app/admin/users/edit/user.edit.view.html"
            });
    }

})();
