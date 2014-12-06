(function(){
    'use strict';

    /** Controllers */
    angular.module('prioTodo.controllers', []).
        controller('TodoCtrl', function ($scope, $http) {

            $scope.getList = function() {
                $http({method: 'GET', url: '/list'})
                    .success(function(data) {
                        $scope.todoItems = data;
                    });
            };

            $scope.getList();
        });
}());
