angular.module('app.controllers', []).controller('TrailListController', function($scope, $state, popupService, $window, Trail) {
  $scope.trails = Trail.query(); //fetch all trails. Issues a GET to /api/vi/trails

  $scope.deleteTrail = function(trail) { // Delete a Trail. Issues a DELETE to /api/v1/trails/:id
    if (popupService.showPopup('Really delete this?')) {
      trail.$delete(function() {
        $scope.trails = Trail.query();
        $state.go('trails');
      });
    }
  };
}).controller('TrailViewController', function($scope, $stateParams, Trail) {
  $scope.trail = Trail.get({ id: $stateParams.id }); //Get a single trail.Issues a GET to /api/v1/trails/:id
}).controller('TrailCreateController', function($scope, $state, $stateParams, Trail) {
  $scope.trail = new Trail();  //create new trail instance. Properties will be set via ng-model on UI

  $scope.addTrail = function() { //create a new trail. Issues a POST to /api/v1/trails
    $scope.trail.$save(function() {
      $state.go('trails'); // on success go back to the list i.e. Trials state.
    });
  };
}).controller('TrailEditController', function($scope, $state, $stateParams, Trail) {
  $scope.updateTrail = function() { //Update the edited trail. Issues a PUT to /api/v1/trails/:id
    $scope.trail.$update(function() {
      $state.go('trails'); // on success go back to the list i.e. trails state.
    });
  };

  $scope.loadTrail = function() { //Issues a GET request to /api/v1/trails/:id to get a Trail to update
    $scope.trail = Trail.get({ id: $stateParams.id });
  };

  $scope.loadTrail(); // Load a trail which can be edited on UI
});
