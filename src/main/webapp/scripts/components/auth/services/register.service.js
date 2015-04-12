'use strict';

angular.module('fibserverApp')
    .factory('Register', function ($resource) {
        return $resource('api/register', {}, {
        });
    });


