'use strict';

angular.module('spring-boot-wsapp')
    .factory('HelloService', function ($rootScope) {
        var stompClient = null;
        return {

            connect: function () {
                var self = this;

                var socket = new SockJS('/hello');
                stompClient = Stomp.over(socket);
                stompClient.connect({}, function (frame) {

                    self.setConnected(true);
                    console.log('Connected: ' + frame);
                    stompClient.subscribe('/topic/hello', function (greeting) {
                        var response = document.getElementById('response');
                        var p = document.createElement('p');
                        p.style.wordWrap = 'break-word';
                        p.appendChild(document.createTextNode(JSON.parse(greeting.body).content));
                        response.appendChild(p);
                    });
                });
            },

            setConnected: function (connected) {
                document.getElementById('connect').disabled = connected;
                document.getElementById('disconnect').disabled = !connected;
                document.getElementById('conversationDiv').style.visibility = connected ? 'visible' : 'hidden';
                document.getElementById('response').innerHTML = '';
            },

            disconnect: function () {
                if (stompClient != null) {
                    stompClient.disconnect();
                    stompClient == null;

                }
                var self = this;
                self.setConnected(false);
            },
            sendName: function () {
                var name = document.getElementById('name').value;
                stompClient.send("/app/hello", {}, JSON.stringify({'name': name}));
            }

        };
    });
