'use strict';

angular.module('fibserverApp')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
