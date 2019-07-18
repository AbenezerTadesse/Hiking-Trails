angular.module('app.services', []).factory('Trail', function($resource) {
  return $resource('/api/v1/trails/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
