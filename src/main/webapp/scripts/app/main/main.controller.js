'use strict';

angular.module('fibserverApp')
    .controller('MainController', function ($http, $scope, Principal, FibService) {
        Principal.identity().then(function(account) {
            $scope.account = account;
            $scope.isAuthenticated = Principal.isAuthenticated
        });
        
        $scope.onChangeInput = function () {
        	var input = $scope.number;
        	
        	$scope.fibResult = [];
        	$http.post("api/fibonacci", input[0])
	        	.success(function(data, status, headers, config) {
	        		$scope.fibResult = data;
	        	}).error(function(data, status, headers, config) {
	        		$scope.status = status;
	        		alert('error '+ data + status + headers + config);
        	});
//        	FibService.findAll(input).then(function (data) {
//        		$scope.fibResult = 9;
//            });

        };
        
    });
