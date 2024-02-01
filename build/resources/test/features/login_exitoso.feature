Feature: Login
  Scenario: logueo exitoso
    Given he user is on the page
    When el usuario ve los productos
      | people |
      | 2      |
    Then he user could see products
