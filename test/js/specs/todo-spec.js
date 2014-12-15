describe("Todo controllers", function() {

    beforeEach(function(){
        this.addMatchers({
            toEqualData: function(expected) {
                return angular.equals(this.actual, expected);
            }
        });
    });

    beforeEach(module('prioTodo'));
    beforeEach(module('prioTodo.services'));


    describe('TodoCtrl', function(){
        var scope, ctrl, $httpBackend;
        var mockData = [
            {title: 'test item 1', category: {name: 'A'}, priority: 1},
            {title: 'test item 2', category: {name: 'A'}, priority: 2}
        ]

        beforeEach(inject(function(_$httpBackend_, $rootScope, $controller) {
            $httpBackend = _$httpBackend_;
            $httpBackend.expectGET('/api/todos').
                respond(mockData);

            scope = $rootScope.$new();
            ctrl = $controller('TodoCtrl', {$scope: scope});
        }));


        it('should create "Todo" model with 2 items fetched from xhr', function() {
            expect(scope.todoItems).toEqualData([]);
            $httpBackend.flush();

            expect(scope.todoItems).toEqualData(mockData);
        });

    });

});