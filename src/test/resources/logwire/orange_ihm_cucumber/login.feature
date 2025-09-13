Feature: Login

  Scenario Outline: Login with valid credentials
    Given je me connecte sur "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"
    When je saisis le username "<username>"
    And je saisis le password "<password>"
    And je valide
    Then je me redirige vers "<expectedurl>"

    Examples:
      | username           | password           | expectedurl                                                             |
      | Admin              | admin123           | https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index |
      | incorrect_username | admin123           | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login      |
      | Admin              | incorrect_password | https://opensource-demo.orangehrmlive.com/web/index.php/auth/login      |
