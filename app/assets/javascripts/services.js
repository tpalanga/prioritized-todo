(function(){
    'use strict';

    var todoServices = angular.module('prioTodo.services', ['ngResource']);

    todoServices.factory('Todo', ['$resource',
        function($resource){
            return $resource('/api/todos', {}, {
                query: {method:'GET', isArray:true}
            });
        }]);
}());
