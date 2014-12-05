(function(){
    'use strict';

    /** Controllers */
    angular.module('prioTodo.controllers', ['prioTodo.services']).
        controller('TodoCtrl', function ($scope, $http, todoModel) {
            $scope.todoItems = todoModel.getTodoItems();
        });
}());
