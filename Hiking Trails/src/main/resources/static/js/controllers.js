angular.module('app.controllers', []).controller('TrailListController', function($scope, $state, popupService, $window, Trail) {
  $scope.trails = Trail.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deleteTrail = function(trail) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      trail.$delete(function() {
        $scope.trails = Trail.query();
        $state.go('trails');
      });
    }
  };
}).controller('TrailViewController', function($scope, $stateParams, Trail) {
  $scope.trail = Trail.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('TrailCreateController', function($scope, $state, $stateParams, Trail) {
  $scope.trail = new Trail();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addTrail = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.trail.$save(function() {
      $state.go('trails'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('TrailEditController', function($scope, $state, $stateParams, Trail) {
  $scope.updateTrail = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.trail.$update(function() {
      $state.go('trails'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadTrail = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.trail = Trail.get({ id: $stateParams.id });
  };

  $scope.loadTrail(); // Load a shipwreck which can be edited on UI
});
