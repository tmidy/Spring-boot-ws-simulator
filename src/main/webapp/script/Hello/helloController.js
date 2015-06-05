angular.module('spring-boot-wsapp')
    .controller('HelloController', function ($scope, HelloService) {
        $scope.userName = "";
        $scope.connect = function () {
            HelloService.connect();
        }
        $scope.sendName = function () {
            HelloService.sendName();
        }
        $scope.disconnect = function () {
            HelloService.disconnect();
        }
    });
