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
        	if(!isInt(input)){
        		$scope.fibResult = '';
        		return;
        	}
        	
        	$http.post("api/fibonacci", input)
	        	.success(function(data, status, headers, config) {
	        		$scope.fibResult = data;
	        	}).error(function(data, status, headers, config) {
	        		$scope.status = status;
	        		$scope.fibResult = data.message || "Request failed";
        	});
        };
        function isInt(value) {
    	  return !isNaN(value) && 
    	         parseInt(Number(value)) == value && 
    	         !isNaN(parseInt(value, 10));
    	}
    });
