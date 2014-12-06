(function(){
    'use strict';

    /** Controllers */
    angular.module('prioTodo.controllers', ['ngResource']).
        controller('TodoCtrl', function ($scope, $http, $resource) {

            $scope.getList = function() {
                $http({method: 'GET', url: '/list'})
                    .success(function(data) {
                        $scope.todoItems = data;
                    });
            };

            $scope.getListResource = function() {
                var TodoItems = $resource('/list');
                $scope.todoItems = TodoItems.query();
            };

            $scope.getList();
        });
}());
