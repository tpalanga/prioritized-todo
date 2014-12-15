(function(){
    'use strict';

    var todoControllers = angular.module('prioTodo.controllers', []);

    todoControllers.controller('TodoCtrl', ['$scope', 'Todo', function ($scope, Todo) {
            $scope.todoItems = Todo.query();
    }]);
}());
