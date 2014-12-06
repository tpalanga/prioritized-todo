(function(){
    'use strict';

    /** todoModel service */
    angular.module('prioTodo.services', []).service('todoModel', function () {
        var getTodoItems = function () {
            return [ {name: 'Name 1', value: 'value1'}, {name: 'Name 2', value: 'value2'},
                {name: 'Name 3', value: 'value3'} ];
        };
        return { getTodoItems: getTodoItems };
    });

}());
