'use strict';

/* Services */

//var memberServices = angular.module('memberServices', ['ngResource']);

angular.module('MemberService', ['ngResource'])
	.factory('Save', function($resource, member){
	  return $resource('http://localhost:8180/livesales/service/rest/member/', member, {
	    save: { method: 'POST', params: { } }
	  });
	});
/*
myApp
	.factory('MemberGet', function($resource, id){
	  return $resource('http://localhost:8180/livesales/service/rest/member/:memberId', { }, {
	    get: { method: 'GET', params: { memberId: id } }
	  });
	});
myApp
	.factory('MemberDelete', function($resource, id){
	  return $resource('http://localhost:8180/livesales/service/rest/member/:memberId', { }, {
	    remove: { method: 'DELETE', params: { memberId: id } }
	  });
	});
myApp
	.factory('MemberList', function($resource){
	  return $resource('http://localhost:8180/livesales/service/rest/member/', { }, {
	    query: { method: 'GET', params: { }, isArray: true }
	  });
	});
*/